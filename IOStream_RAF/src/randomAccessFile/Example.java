package randomAccessFile;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Example {
	static void readAndWriteData(String path) throws IOException {
		// create RandomAccessFile (read, write)
		RandomAccessFile rafile = new RandomAccessFile(path, "rw");

		// write data to file
		rafile.writeBytes("Hello, It's rosally");

		// move cursor to position 7 and read 5 byte
		rafile.seek(7);
		byte[] buffer = new byte[5];
		rafile.read(buffer);

		// print data is read
		System.out.println("Read: " + new String(buffer));

		// close file
		rafile.close();

	}

	static void readAndWriteByUTF(String path) throws IOException {
		RandomAccessFile rafile = new RandomAccessFile(path, "rw");

		rafile.writeUTF("Hello guys, I'm rosally");

		rafile.seek(0);

		String s = rafile.readUTF();

		System.out.println(s);

		rafile.close();
	}

	static void readAndWriteByExamination(String path) throws IOException {
		RandomAccessFile rafile = new RandomAccessFile(path, "rw");

		rafile.writeBytes("Hey guys, I'm rosally");

		rafile.seek(0);

		int byteRead;

		while ((byteRead = rafile.read()) != -1) {
			System.out.print((char) byteRead);
		}

		rafile.close();
	}

	static void readAndWritePrimeData(String path) throws IOException {
		RandomAccessFile rafile = new RandomAccessFile(path, "rw");

		// write prime data to fie
		rafile.writeInt(21130345);
		rafile.writeDouble(3.14);

		// move cursor to first
		rafile.seek(0);

		// read prime data to file
		int intValue = rafile.readInt();
		double dbValue = rafile.readDouble();

		// print data is read
		System.out.println("Int value: " + intValue);
		System.out.println("Double value: " + dbValue);

		rafile.close();

	}

	public static void main(String[] args) throws IOException {
		String path1 = "E:\\THUMUC1\\RAFile.txt";
		readAndWriteData(path1);

		String path2 = "E:\\THUMUC1\\RAFilePrimeData.txt";
		readAndWritePrimeData(path2);

		String path3 = "E:\\THUMUC1\\RAFileUTF.txt";
		readAndWriteByUTF(path3);
		
		String path4 = "E:\\THUMUC1\\RAFileExamination.txt";
		readAndWriteByExamination(path4);
	}
}
