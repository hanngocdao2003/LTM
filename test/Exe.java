package test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.List;

public class Exe {
	//Copy không dùng vòng lặp
	private void copyFile(String sourcePath, String targetPath, boolean move) throws IOException {
		File fileSource = new File(sourcePath);
		File fileTarget = new File(targetPath);
		byte[] buffer = new byte[(int) fileSource.length()];
		InputStream inputStream = new BufferedInputStream(new FileInputStream(fileSource));
		OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(fileTarget));
		inputStream.read(buffer);
		outputStream.write(buffer);
		if (move == true) {
			fileSource.delete();
			inputStream.close();
			outputStream.close();
			System.out.println("Move success...");
		} else {
			inputStream.close();
			outputStream.close();
			System.out.println("Copy success...");

		}

	}
	//Copy dùng vòng lặp
	private void copyFile1(String sourcePath, String targetPath, boolean move) throws IOException {
		InputStream inputStream = new BufferedInputStream(new FileInputStream(sourcePath));
		OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(targetPath));
		int data;
		while ((data = inputStream.read()) != -1) {
			outputStream.write(data);
		}
		if (move == true) {
			File fileSource = new File(sourcePath);
			fileSource.delete();
			inputStream.close();
			outputStream.close();
			System.out.println("Move success...");
		} else {
			inputStream.close();
			outputStream.close();
			System.out.println("Copy success...");

		}

	}
	//Copy File sử dụng RAF
	public void writeFile(String sourcePath, String targetPath) throws IOException {
		File file = new File(sourcePath);
		RandomAccessFile soureFile = new RandomAccessFile(sourcePath, "r");
		RandomAccessFile targetFilde = new RandomAccessFile(targetPath, "rw");
		byte[] buffer = new byte[(int) file.length()];
		soureFile.readFully(buffer);
		targetFilde.write(buffer);
		soureFile.close();
		targetFilde.close();
		System.out.println("Copy success...");
	}
	//Viết data vào file sử dụng RAF
	public void readDataForFile(String sourcePath, List<Student> list) throws IOException {
		RandomAccessFile randomAccessFile = new RandomAccessFile(sourcePath, "rw");
		for (Student student : list) {
			randomAccessFile.seek(0);
			System.out.println(randomAccessFile.getFilePointer());
			randomAccessFile.writeLong(randomAccessFile.getFilePointer());
			randomAccessFile.writeUTF(student.getName());
			randomAccessFile.writeInt(student.getAge());
			randomAccessFile.writeUTF(student.getSchool());
			randomAccessFile.writeDouble(student.getMask());

		}
		randomAccessFile.close();
		System.out.println("Down Success...");
	}
	//Load File lên console (chưa làm)
	public void loadDataUptoConsole(String sourcePath) throws IOException {
		RandomAccessFile accessFile = new RandomAccessFile(sourcePath, "r");

	}
	//Chia file với kích thước cho sẵn
	public void splitFile(String sourcePath, String folder, long size) throws IOException {
		File file = new File(sourcePath);
		int numFile = (int) (file.length() / size);
		long sizeFileLast = file.length() - numFile * size;
		InputStream inputStream = new BufferedInputStream(new FileInputStream(sourcePath));
		for (int i = 1; i <= numFile; i++) {
			File files = new File(folder + "\\fileSplit" + i + ".txt");
			files.createNewFile();
			OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(files));
			for (int j = 0; j < size; j++) {
				outputStream.write(j);

			}
			outputStream.close();

		}
		if (sizeFileLast > 0) {
			File files = new File(folder + "\\fileSplitLast.txt");
			files.createNewFile();
			OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(files));
			for (int j = 0; j < sizeFileLast; j++) {
				outputStream.write(j);

			}
			outputStream.close();
		}
		inputStream.close();
		System.out.println("Split File Success...");

	}
	//Chia file với số lượng cho sẵn
	public void splitFile2(String sourcePath, String folder, int numFile) throws IOException {
		File file = new File(sourcePath);
		File file2 = new File(folder);
		file2.mkdirs();
		int sizeFile = (int) (file.length() / numFile);
		InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
		for (int i = 0; i < numFile; i++) {
			File files = new File(folder + "\\fileSplit" + i + ".txt");
			files.createNewFile();
			OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(files));
			for (int j = 0; j < sizeFile; j++) {
				outputStream.write(j);
			}
			outputStream.close();
		}
		inputStream.close();
		System.out.println("Split File success...");
	}
	//Gộp các file trong folder lại thành 1 file
	public void joinFile(String pathfolder, String targetPath) throws IOException {
		File folder = new File(pathfolder);
		File target = new File(targetPath);
		OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(target));
		for(File file : folder.listFiles()) {
			InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
			int data;
			while ((data = inputStream.read()) != -1) {
				outputStream.write(data);
			}
			inputStream.close();
		}
		outputStream.close();
		System.out.println("Join File Success....");
	}
	
	public static void main(String[] args) throws IOException {
//		new Exe().writeFile("E:\\LapTrinhMang\\rootTest\\TextFolder\\ĐỒ ÁN MÔN HỆ QUẢN TRỊ CƠ SỞ DỮ LIỆU.docx",
//				"E:\\LapTrinhMang\\rootTest\\TextFolder\\fileCopy.docx");
//		Student student1 = new Student("Nguyen Van A", 18, "Ba Gia", 8.5);
//		Student student2 = new Student("Tran Thi B", 18, "Vo Nguyen Giap", 9.0);
//		Student student3 = new Student("Banh Thi Huc", 19, "Hong Bang", 7.2);
//		List<Student> list = new ArrayList<Student>();
//		list.add(student1);
//		list.add(student2);
//		list.add(student3);
//		new Exe().readDataForFile("E:\\LapTrinhMang\\rootTest\\TextFolder\\downStudent1.txt", list);
//		new Exe().splitFile2("E:\\LapTrinhMang\\rootTest\\fileEnd.pdf", "E:\\LapTrinhMang\\rootTest\\FolderSplit", 12);
		new Exe().joinFile("E:\\LapTrinhMang\\rootTest\\FolderSplit", "E:\\LapTrinhMang\\rootTest\\FolderSplit\\FileJoin.txt");
	}

}
