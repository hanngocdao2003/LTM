package RAF;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentGroup {
	private static final int SIZE = 500;
    public void writeStudentForFile(String sourcePath, List<Student> list) throws IOException {
    	RandomAccessFile randomAccessFile = new RandomAccessFile(sourcePath, "rw");
		for (int i = 0; i < list.size(); i++) {
			randomAccessFile.writeInt(list.get(i).getId());
			randomAccessFile.writeUTF(list.get(i).getName());;
			randomAccessFile.writeDouble(list.get(i).getGpa());
			randomAccessFile.seek((i+1)*SIZE);

		}
		randomAccessFile.close();
		System.out.println("Down Success...");
		
	}
    public static Student readStudentFromFile(String sourcePath, int position) {
        try (RandomAccessFile raf = new RandomAccessFile(sourcePath, "r")) {
            long offset = position * SIZE; // Tính toán vị trí của sinh viên trong file
            if (offset < raf.length()) {
                raf.seek(offset);
                int studentId = raf.readInt();
                String studentName = raf.readUTF();
                double studentGPA = raf.readDouble();

                return new Student(studentId, studentName, studentGPA);
            } else {
                System.out.println("Position exceeds the number of records in the file.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



    public static void main(String[] args) throws IOException {
        // Đọc thông tin của sinh viên ở vị trí 2 và hiển thị trên console
        int positionToRead = 1;
        Student student = readStudentFromFile("E:\\LapTrinhMang\\rootTest\\fileInput.txt", positionToRead);
        
        if (student != null) {
            System.out.println("Student at position " + positionToRead + ": " + student);
        }
//    	Student student1 = new Student(1, "XXXXXX", 8.5);
//    	Student student2 = new Student(2, "YYYYYY", 9.0);
//    	Student student3 = new Student(3, "ZZZZZZ", 7.5);
//    	List<Student> list = new ArrayList<Student>();
//    	list.add(student1);
//    	list.add(student2);
//    	list.add(student3);
//    	new StudentGroup().writeStudentForFile("E:\\LapTrinhMang\\rootTest\\fileInput.txt", list);
    }
}
