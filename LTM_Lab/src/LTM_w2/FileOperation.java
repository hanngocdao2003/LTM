package LTM_w2;

import java.io.File;

public class FileOperation {
    // tìm và hiển thị đường dẫn đầy đủ file trong thư mục path có phần mở rộng quy định bởi ext1, ext2,…, extn
    void findAll(String path, String... exts) {
        File file = new File(path);
        File[] listFile = file.listFiles();
        for (File f : listFile) {
            for (String ext : exts) {
                if (f.getAbsolutePath().endsWith("." + ext) && f.isFile()) {
                    System.out.println(f.getAbsolutePath());
                }
            }
        }
    }

    //tìm và xóa tất cả các file trong thư mục path có phần mở rộng quy định bởi ext1, ext2,…, extn
    void deleteAll(String path, String... exts) {
        File file = new File(path);
        File[] listFile = file.listFiles();
        for (File f : listFile) {
            for (String ext : exts) {
                if (f.getAbsolutePath().endsWith("." + ext) && f.isFile()) {
                    f.delete();
                    System.out.println("Done");

                }
            }
        }

    }

    public static void main(String[] args) {
        FileOperation file = new FileOperation();
        //file.findAll("E:\\THUMUC1", "docx", "txt");
        file.deleteAll("E:\\THUMUC1", "docx", "txt");
    }

}