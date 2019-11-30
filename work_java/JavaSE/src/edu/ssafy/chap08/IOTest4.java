package edu.ssafy.chap08;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOTest4 {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("data.d");
		DataOutputStream dos = new DataOutputStream(fos);
		dos.writeInt(33);
		dos.writeFloat(99.9f);
		dos.writeUTF("test");
		dos.flush();
		dos.close();
		
		DataInputStream dis = new DataInputStream(new FileInputStream("data.d"));
		int i = dis.readInt();
		float f = dis.readFloat();
		
		System.out.println(i+","+f+","+dis.readUTF());
	}
}
