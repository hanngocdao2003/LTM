package LTM_More;

import java.io.*;

public class FileOperationIO {
//cau7
	// copy/move file dùng byte array kết hợp với BIS, BOS
	static boolean fileCopy(String sourceFile, String destFile, boolean moved) throws IOException {
		InputStream is = new BufferedInputStream(new FileInputStream(sourceFile));
		OutputStream os = new BufferedOutputStream(new FileOutputStream(destFile));
		int data = is.read();
		while (data != -1) {
			os.write(data);
		}
		is.close();
		os.close();
		if (moved) {
			File file = new File(sourceFile);
			if (file.delete())
				return true;
			return false;
		}
		return true;
	}

//cau8
	// copy/move folder dùng byte array kết hợp với BIS, BOS
	boolean folderCopy(String sourceFolder, String destFolder, boolean moved) {

		return false;
	}

	public static void main(String[] args) throws IOException {
		String sFile = "E:\\THUMUC1\\hjhj.docx";
		String dFile = "E:\\THUMUC1\\th.docx";
		System.out.println(fileCopy(sFile, dFile, false));
	}
}
