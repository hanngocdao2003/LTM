package copyFile_Folder;

import java.io.*;

public class CopyFile {

//	Viết CT copy/move file dùng byte array kết hợp với BIS, BOS: 
//	boolean fileCopy(String sFile, String destFile, boolean moved);

	void fileCopy(String sFile, String destFile, boolean moved) throws IOException {
		File source = new File(sFile);
		File dest = new File(destFile);
		// write data
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destFile));

		// read data
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sFile));

		byte[] bytes = new byte[1024 * 1024];
		int data;
		while ((data = bis.read(bytes)) != -1) {
			bos.write(bytes, 0, data);
		}

		if (moved) {
			if (source.delete()) {
				System.out.println("File is copied successfully and Source file deleted...");
			} else {
				System.out.println("Unable to move file...");
			}
		}
		System.out.println("File is copied successfully...");

	}

	public static void main(String[] args) throws IOException {
		String s = "E:\\THUMUC1\\hjhj.docx";
		String d = "E:\\THUMUC1\\hjhj_cp.docx";
		new CopyFile().fileCopy(s, d, false);
	}
}
