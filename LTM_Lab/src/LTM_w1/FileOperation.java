package LTM_w1;

import java.io.*;

public class FileOperation {
    boolean createFile(String path) throws IOException {
        File file = new File(path);
        if (file.createNewFile()) {
            System.out.println("File created");
            return true;
        } else {
            System.out.println("File already exists");
            return false;
        }
    }

    boolean createDir(String path) throws IOException {
        File file = new File(path);
        if (file.mkdirs()) {
            System.out.println("Directory created");
            return true;
        } else {
            System.out.println("Directory already exists");
            return false;
        }
    }

    boolean delete(String path) {
        File file = new File(path);
        if (file.isFile()) {
            file.delete();
            return true;
        } else if (file.isDirectory()) {
            File[] listDir = file.listFiles();
            if (listDir != null) {
                for (File dir : listDir) {
                    delete(dir.getAbsolutePath());
                }
            }
            file.delete();
            return true;
        }
        return false;
    }
    boolean delete(String path, boolean sure){
        if(!sure){
            delete(path);
            return true;
        }else{
            File file = new File(path);
            File[] listFile = file.listFiles();
            for(File f: listFile){
                if (f.isFile()){
                    f.delete();
                    return true;
                }
                delete(f.getAbsolutePath(), sure);
            }
        }
        return false;
    }


    public static void main(String[] args) throws IOException {
        FileOperation file = new FileOperation();
      /*  file.createDir("E:\\THUMUC1");
        file.createDir("E:\\THUMUC1\\Thumuc2");
        file.createDir("E:\\THUMUC1\\Thumuc2\\file1.png");
        file.createDir("E:\\THUMUC1\\Thumuc2\\file2.txt");
        file.createFile("E:\\THUMUC1\\file1.txt");
        file.createFile("E:\\THUMUC1\\file2.txt");
        file.createFile("E:\\THUMUC1\\file2.txt");
        file.createFile("E:\\THUMUC1\\Thumuc2\\file2.txt\\file1.txt");*/

        // System.out.println(file.delete("E:\\THUMUC1"));
        // System.out.println(file.delete("E:\\THUMUC1", true));
        //System.out.println(file.delete("E:\\THUMUC1", false));

    }
}
