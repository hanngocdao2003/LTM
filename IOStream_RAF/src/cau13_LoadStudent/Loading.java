package cau13_LoadStudent;

import java.io.*;
import java.util.ArrayList;

public class Loading {
	static ArrayList<Student> listStudents;
	RandomAccessFile raf;
	final int STUDENT_RECORD_SIZE = 2000;

	public Loading(String path) throws FileNotFoundException {
		super();
		listStudents = new ArrayList<Student>();
		raf = new RandomAccessFile(path, "rw");
	}

	Student readStudent(int pos) throws IOException {
		raf.seek(pos * STUDENT_RECORD_SIZE);
		DataInputStream dis = new DataInputStream(new FileInputStream(raf.getFD()));

		int id = dis.readInt();
		String name = dis.readUTF();

		int numSubs = dis.readInt();
		ArrayList<Subject> subs = new ArrayList<Subject>();

		for (int i = 0; i < numSubs; i++) {
			int subId = dis.readInt();
			String subName = dis.readUTF();
			int numOfCredit = dis.readInt();
			double score = dis.readDouble();

			subs.add(new Subject(subId, subName, numOfCredit, score));
		}

		Student stu = new Student(id, name);
		stu.setListSubjects(subs);

		return stu;
	}

	void writeStudent(Student s, int pos) throws IOException {
		raf.seek(pos * STUDENT_RECORD_SIZE);
		DataOutputStream dos = new DataOutputStream(new FileOutputStream(raf.getFD()));

		dos.writeInt(s.getId());
		dos.writeUTF(s.getName());

		ArrayList<Subject> subs = new ArrayList<Subject>();
		dos.writeInt(subs.size());

		for (Subject subject : subs) {
			dos.writeInt(subject.getId());
			dos.writeUTF(subject.getName());
			dos.writeInt(subject.getNumOfCredit());
			dos.writeDouble(subject.getScore());
		}
	}

	void close() throws IOException {
		raf.close();
	}

	static void run() {
		try {
			Loading load = new Loading("E:\\THUMUC1\\student.txt");

			Student s1 = new Student(21130345, "Dao Ngoc Han");
			Subject s1_1 = new Subject(1, "Lap trinh mang", 4, 8.0);
			Subject s1_2 = new Subject(2, "Lap trinh web", 4, 9.0);
			Subject s1_3 = new Subject(3, "Nhap mon tri tue nhan tao", 4, 8.0);
			Subject s1_4 = new Subject(4, "He quan tri co so du lieu", 3, 8.5);

			s1.add(s1_1);
			s1.add(s1_2);
			s1.add(s1_3);
			s1.add(s1_4);

			load.writeStudent(s1, 0);

			Student read = load.readStudent(0);
			if (read != null) {
				System.out.println(read);
			} else {
				System.out.println("Student not found..");
			}

			load.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static void informStudent() {
		// student 1
		Subject s1_1 = new Subject(1, "Lap trinh mang", 4, 8.0);
		Subject s1_2 = new Subject(2, "Lap trinh web", 4, 9.0);
		Subject s1_3 = new Subject(3, "Nhap mon tri tue nhan tao", 4, 8.0);
		Subject s1_4 = new Subject(4, "He quan tri co so du lieu", 3, 8.5);

		Student s1 = new Student(21130345, "Dao Ngoc Han");
		s1.add(s1_1);
		s1.add(s1_2);
		s1.add(s1_3);
		s1.add(s1_4);
		System.out.println(s1);

		// student 2
		Subject s2_1 = new Subject(1, "Lap trinh mang", 4, 8.0);
		Subject s2_2 = new Subject(2, "Lap trinh web", 4, 9.0);
		Subject s2_3 = new Subject(3, "Nhap mon tri tue nhan tao", 4, 8.0);
		Subject s2_4 = new Subject(4, "He quan tri co so du lieu", 3, 8.5);

		Student s2 = new Student(21130328, "Nguyen Hoang Anh Duong");
		s2.add(s2_1);
		s2.add(s2_2);
		s2.add(s2_3);
		s2.add(s2_4);
		System.out.println(s2);

		// student 3
		Subject s3_1 = new Subject(1, "Lap trinh mang", 4, 8.0);
		Subject s3_2 = new Subject(2, "Lap trinh web", 4, 9.0);
		Subject s3_3 = new Subject(3, "Nhap mon tri tue nhan tao", 4, 8.0);
		Subject s3_4 = new Subject(4, "He quan tri co so du lieu", 3, 8.5);

		Student s3 = new Student(21130335, "Le Thi Hanh Duyen");
		s3.add(s3_1);
		s3.add(s3_2);
		s3.add(s3_3);
		s3.add(s3_4);
		System.out.println(s3);

		// student 4
		Subject s4_1 = new Subject(1, "Lap trinh mang", 4, 8.0);
		Subject s4_2 = new Subject(2, "Lap trinh web", 4, 9.0);
		Subject s4_3 = new Subject(3, "Nhap mon tri tue nhan tao", 4, 8.0);
		Subject s4_4 = new Subject(4, "He quan tri co so du lieu", 3, 8.5);

		Student s4 = new Student(21130320, "Le Anh Duc");
		s4.add(s4_1);
		s4.add(s4_2);
		s4.add(s4_3);
		s4.add(s4_4);
		System.out.println(s4);

		// student 5
		Subject s5_1 = new Subject(1, "Lap trinh mang", 4, 8.0);
		Subject s5_2 = new Subject(2, "Lap trinh web", 4, 9.0);
		Subject s5_3 = new Subject(3, "Nhap mon tri tue nhan tao", 4, 8.0);
		Subject s5_4 = new Subject(4, "He quan tri co so du lieu", 3, 8.5);

		Student s5 = new Student(21130291, "Nguyen Thanh Binh");
		s5.add(s5_1);
		s5.add(s5_2);
		s5.add(s5_3);
		s5.add(s5_4);
		System.out.println(s5);

		listStudents.add(s1);
		listStudents.add(s2);
		listStudents.add(s3);
		listStudents.add(s4);
		listStudents.add(s5);

	}

	public static void main(String[] args) {
		run();

	}
}
