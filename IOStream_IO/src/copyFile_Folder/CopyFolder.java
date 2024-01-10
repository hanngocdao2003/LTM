package copyFile_Folder;
import java.io.*;

public class CopyFolder {
    void folderCopy(String sFolder, String destFolder, boolean moved) throws IOException {
        File source = new File(sFolder);
        
        if (source.isDirectory()) {
            // Tạo thư mục đích nếu nó không tồn tại
            new File(destFolder).mkdirs();

            for (File file : source.listFiles()) {
                if (file.isDirectory()) {
                    folderCopy(file.getAbsolutePath(), destFolder + "\\" + file.getName(), moved);
                } else {
                    try (
                        InputStream bis = new BufferedInputStream(new FileInputStream(file));
                        OutputStream bos = new BufferedOutputStream(new FileOutputStream(destFolder + "\\" + file.getName()))
                    ) {
                        byte[] buffer = new byte[(int) file.length()];
                        bis.read(buffer);
                        bos.write(buffer);
                    }
                }
            }
        }

        if (moved) {
            source.delete();
            System.out.println("Delete");
        } else {
            System.out.println("Copy");
        }
    }

    public static void main(String[] args) throws IOException {
        new CopyFolder().folderCopy("E:\\120da96f06cadefff69652", "E:\\120da96f06cadefff69652xxx", false);
    }
}