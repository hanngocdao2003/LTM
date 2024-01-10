package LTM_More;

import java.io.*;

public class FileOperationFILECLASS {
// cau2
	// dan link day du cua file/folder
	static boolean findFirst(String path, String pattern) {
		File file = new File(path);
		File[] listFile = file.listFiles();
		boolean result = false;
		for (File f : listFile) {
			if ((f.isDirectory() || f.isFile()) && f.getAbsolutePath().contains(pattern)) {
				System.out.println(f.getAbsolutePath());
				result = true;
			}
		}
		return result;
	}

// cau3
	// hiển thị cấu trúc cây của thư mục
	static void dirTree(String path) {
		File file = new File(path);
		File[] listFile = file.listFiles();
		if (file.isFile()) {
			System.out.println(" " + "|" + " +" + file.getName());
		} else {
			if (file.isDirectory()) {
				for (File f : listFile) {
					System.out.println("-" + f.getName());
					dirTree(f.getAbsolutePath());
				}
			}
		}
	}

// cau4
	// hàm tính và hiển thị dung lượng theo cấu trúc cây thư mục
	static void dirStat(String path) {
		File file = new File(path);
		File[] listFile = file.listFiles();
		if (file.isFile()) {
			System.out.println(" " + "|" + " +" + file.getName() + " size: " + file.length() + " bytes");
		} else {
			if (file.isDirectory()) {
				for (File f : listFile) {
					System.out.println("-" + f.getName() + " size: " + f.length() + " bytes");
					dirTree(f.getAbsolutePath());
				}
			}
		}
	}

	public static void main(String[] args) {
		String path1 = "C:\\Users\\ADMIN\\OneDrive - Centrix Media Corporation\\Desktop\\Năm 1";
		String path2 = "D:\\SQL\\Data";
		String path3 = "E:\\THUMUC1";
		String pattern = "Chương";
		// System.out.println(findFirst(path1, pattern));
		// dirTree(path2);
		// dirStat(path3);
	}
}
