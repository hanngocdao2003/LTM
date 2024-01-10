package example;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileRWEx {

	static void writeToFile(String path) throws IOException {
		FileWriter fw = new FileWriter(path);
		String content = "Hello World!";
		fw.write(content);
		fw.close();
		System.out.println("Done..");
	}

	static void readFromFile(String path) throws IOException {
		FileReader fr = new FileReader(path);
		int data;
		while ((data = fr.read()) != -1) {
			System.out.print((char) data);
		}
		fr.close();
	}
	
	public static void main(String[] args) throws IOException {
		String path = "E:\\THUMUC1\\RWEx.txt";
		writeToFile(path);
		readFromFile(path);
	}
}
