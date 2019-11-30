package edu.ssafy.chap17;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class SimpleChatServer {
	private ArrayList<ChatService> room = new ArrayList<>(25);
	
	public synchronized void addClient(ChatService client) {
		room.add(client);
	}
	
	public synchronized void removeClient(ChatService client) {
		room.remove(client);
	}
	
	public synchronized void broadcast(String msg) throws IOException {
		for (ChatService client : room) {
			client.sendMessage(msg);
		}
	}
	
	public static void main(String[] args) {
		SimpleChatServer server = new SimpleChatServer();
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(6543);
			while (true) {
				System.out.println("Client 대기중...");
				Socket s = ss.accept();
				System.out.println(s.getInetAddress());
				//Thread
				ChatService client = new ChatService(s, server);
				client.start();
				server.addClient(client);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(ss != null) {
				try {
					ss.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

class ChatService extends Thread{
	private Socket socket;
	private DataInputStream dis;
	private DataOutputStream dos;
	private SimpleChatServer server;
	
	public ChatService(Socket socket, SimpleChatServer server) {
		this.socket = socket;
		this.server = server;
	}
	
	public void sendMessage(String msg) throws IOException {
		if(dos != null) {
			dos.writeUTF(msg);
		}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			boolean flag = true;
			while (flag) {
				String data = dis.readUTF();
				if(data == null || data.equals("exit")) {
					flag = false;
				}
				server.broadcast(data);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			server.removeClient(this);
			
			try {
				if(dis != null)dis.close();
				if(dos != null)dos.close();
				if(socket != null)socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}