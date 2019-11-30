package edu.ssafy.chap10;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTest {
	ServerSocket ss;
	public void go() throws ClassNotFoundException {
		InputStream is = null;
		OutputStream os = null;
		Socket cSock = null;
		try {
			ss = new ServerSocket(7000);
			while(true) {
				System.out.println("한조 대기중");
				cSock = ss.accept();
				is = cSock.getInputStream();
				os = cSock.getOutputStream();
				/*
				BufferedReader br = new BufferedReader(new InputStreamReader(is));
				String readLine = br.readLine();
				System.out.println(readLine);
				
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
				bw.write(readLine + "이 전송완료되었습니다.\n");
				bw.flush();
				*/
				
				ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(is));
				Message msg = (Message) ois.readObject();
				while(msg != null) {
					System.out.println(msg.toString());
					msg = (Message) ois.readObject();
				}
			}
		} catch (IOException e) {
			// TODO: handle exception
			System.out.println("연결 실패");
		}finally {
			try {
				if(is!=null)is.close();
				if(os!=null)os.close();
				if(cSock!=null)cSock.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("소켓닫기 실패");
			}
			
		}
	}
	
	public static void main(String[] args) {
		try {
			new ServerTest().go();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
