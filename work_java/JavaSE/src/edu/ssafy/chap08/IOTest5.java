package edu.ssafy.chap08;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class IOTest5 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("data.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		멋진승우 a = new 멋진승우();
		a.age = 100;
		a.name = "승우";
		ArrayList<멋진승우> list = new ArrayList();
		list.add(a);
		list.add(a);
		list.add(a);
		list.add(a);
		list.add(a);
		
		oos.writeObject(list);
		oos.flush();
		oos.close();
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.ser"));
		ArrayList<멋진승우> b = (ArrayList<멋진승우>) ois.readObject();
		
		System.out.println(b.toString());
	}
}
