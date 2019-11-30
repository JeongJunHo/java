package com.ssafy.hw;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

public class ProductServer {
	public static void main(String[] args) {
		ServerSocket sSocket = null;
		Socket accept = null;
		ObjectInputStream ois = null;
		BufferedWriter bw = null;
		try {
			sSocket = new ServerSocket(7000);
			
			while(true) {
				System.out.println("서버 대기...");
				accept = sSocket.accept();
				InputStream is = accept.getInputStream();
				OutputStream os = accept.getOutputStream();
				ois = new ObjectInputStream(new BufferedInputStream(is));
				bw = new BufferedWriter(new OutputStreamWriter(os));
				
				List<Product> list = (List<Product>) ois.readObject();
				for (Product product : list) {
					System.out.println(product);
				}
				
				bw.write(list.size() + "\n");
				bw.flush();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(sSocket!=null)sSocket.close();
				if(accept!=null)accept.close();
				if(ois!=null)ois.close();
				if(bw!=null)bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
