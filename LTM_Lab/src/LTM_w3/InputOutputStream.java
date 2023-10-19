package LTM_w3;

import java.io.*;

public class InputOutputStream {
	boolean copyFile(String sFile, String destFile, boolean moved) throws IOException {
		InputStream is = new BufferedInputStream(new FileInputStream(sFile));
		OutputStream os = new BufferedOutputStream(new FileOutputStream(destFile));
		int data;
		while ((data = is.read()) != -1) {
			os.write(data);
		}
		is.close();
		os.close();
		if (moved) {
			File file = new File(sFile);
			if (file.delete()) {
				return true;
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		String sFile = "C:\\Users\\ADMIN\\OneDrive - Centrix Media Corporation\\Documents\\ENGLISH\\SO SÁNH HƠN, SO SÁNH NHẤT.docx";
		String destFile = "E:\\THUMUC1\\hjhj.docx";
		InputOutputStream file = new InputOutputStream();
		file.copyFile(sFile, destFile, false);
	}

}