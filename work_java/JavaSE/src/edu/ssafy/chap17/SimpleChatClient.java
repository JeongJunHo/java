package edu.ssafy.chap17;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class SimpleChatClient {
	private JScrollPane jsp;
	private JList<String> list;
	private JTextField tf;
	private JButton sendButton;
	private JButton closeButton;
	private JFrame f;
	private DefaultListModel<String> model;
	private DataOutputStream dos;
	private DataInputStream dis;
	
	private String name;
	
	SimpleChatClient(){
		createGUI();
		setEvent();
	}
	
	private void setEvent() {
		// TODO Auto-generated method stub
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				System.exit(0);
			}
		});
		
		tf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyPressed(e);
				if (e.getKeyCode()==KeyEvent.VK_ENTER) {
					String message = name + " : " +tf.getText();
					try {
						dos.writeUTF(message);
						tf.setText("");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            }
			}
		});
		
		sendButton.addActionListener(e -> {
			String message = name + " : " +tf.getText();
			try {
				dos.writeUTF(message);
				tf.setText("");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		closeButton.addActionListener(e -> {
			try {
				dos.writeUTF(name + " out");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.exit(0);
		});
	}

	private void createGUI() {
		// TODO Auto-generated method stub
		f = new JFrame();
		f.setTitle("MyFirst Swing");
		f.setSize(400,400);
		sendButton = new JButton("전송");
		closeButton = new JButton("종료");
		tf = new JTextField();
		tf.setColumns(20);
		JPanel p = new JPanel();
		p.add(tf);
		p.add(sendButton);
		p.add(closeButton);
		jsp = new JScrollPane();
		jsp.setBounds(400, 400, 400, 400);
		list = new JList<String>();
		model = new DefaultListModel<>();
		list.setModel(model);
		jsp.setViewportView(list);
		f.add(jsp, BorderLayout.CENTER);
		f.add(p,BorderLayout.SOUTH);
		f.setLocation(500, 500);
		
		f.setVisible(true);
	}

	private void connect(String ip, int port, String name) {
		this.name = name;
		try {
			Socket socket = new Socket(ip, port);
			OutputStream os = socket.getOutputStream();
			InputStream is = socket.getInputStream();
			dos = new DataOutputStream(os);
			dis = new DataInputStream(is);
			new ChatClient().start();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new SimpleChatClient().connect("192.168.23.233",6543,"정준호");
	}
	
	class ChatClient extends Thread {
		@Override
		public void run() {
			super.run();
			
			try {
				String tmp = null;
				while((tmp = dis.readUTF()) != null) {
					model.addElement(tmp);
				}
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

