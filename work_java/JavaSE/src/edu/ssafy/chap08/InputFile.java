package edu.ssafy.chap08;

import java.io.*;

class InputFile {
	FileReader fis;

	public InputFile(String filename) throws FileNotFoundException {
		fis = new FileReader("data.txt");
	}

	void readLine() throws IOException {
		String s;
		BufferedReader buf = new BufferedReader(fis);
		while ((s = buf.readLine()) != null)
			System.out.println(s);

	}

	public static void main(String[] a) {
		InputFile inputFile;

		try {
			inputFile = new InputFile("data.txt");
			inputFile.readLine();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Program End...");
	}
}
