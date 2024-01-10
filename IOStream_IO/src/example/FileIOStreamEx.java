package example;

import java.io.*;

public class FileIOStreamEx {
	static void readFromFile(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		int data;
		while ((data = fis.read()) != -1) {
			System.out.print((char) data);
		}
		fis.close();
	}

	static void writeToFile(String path) throws IOException {
		FileOutputStream fos = new FileOutputStream(path);
		String content = "Hello world!";
		byte[] bytes = content.getBytes();
		fos.write(bytes);
		fos.close();
		System.out.println("Done..");
	}

	public static void main(String[] args) throws IOException {
		String path = "E:\\THUMUC1\\IOExample.txt";
		writeToFile(path);
		readFromFile(path);
	}
}
