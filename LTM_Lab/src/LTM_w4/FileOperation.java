package LTM_w4;

import java.io.*;
import java.util.ArrayList;

public class FileOperation {

	public static void main(String[] args) throws IOException {
		MonHoc m1 = new MonHoc(101, "Thiết kế hướng đối tượng", 4);
		MonHoc m2 = new MonHoc(102, "Lập trình mạng", 4);
		MonHoc m3 = new MonHoc(103, "Lập trình web", 4);
		MonHoc m4 = new MonHoc(104, "Hệ quản trị cơ sở dữ liệu", 3);
		MonHoc m5 = new MonHoc(105, "Nhập môn trí tuệ nhân tạo", 4);

		SinhVien sv1 = new SinhVien(21130345, "Đào Ngọc Hân");
		SinhVien sv2 = new SinhVien(21130335, "Lê Thị Hạnh Duyên");
		SinhVien sv3 = new SinhVien(21130328, "Nguyễn Hoàng Ánh Dương");

		sv1.add(m1);
		sv1.add(m2);
		sv1.add(m3);
		sv1.add(m4);
		sv1.add(m5);

		sv2.add(m1);
		sv2.add(m2);
		sv2.add(m3);
		sv2.add(m4);
		sv2.add(m5);

		sv3.add(m1);
		sv3.add(m2);
		sv3.add(m3);
		sv3.add(m4);
		sv3.add(m5);

		System.out.println(sv1);
		System.out.println(sv2);
		System.out.println(sv3);

		FileOperation file = new FileOperation();
		ArrayList<SinhVien> listSV = new ArrayList<SinhVien>();
		listSV.add(sv1);
		listSV.add(sv2);
		listSV.add(sv3);
		String path = "E:\\THUMUC1\\th04.txt";
		file.save(path, listSV);
//		System.out.println(file.load(path));

	}

	void save(String path, ArrayList<SinhVien> listSV) throws IOException {
		DataOutputStream os = new DataOutputStream(new FileOutputStream(path));
		for (SinhVien sv : listSV) {
			os.writeInt(sv.getId());
			os.writeUTF(sv.getName());
			for (MonHoc m : sv.getListMH()) {
				os.writeUTF(m.toString());
			}
		}
		os.close();
	}

//	SinhVien readFileSV(DataInputStream is) throws IOException {
//		int id = is.readInt();
//		String name = is.readUTF();
//		SinhVien sv = new SinhVien(id, name);
//		return sv;
//	}
//
//	MonHoc readFileMH(DataInputStream is) throws IOException {
//		int id = is.readInt();
//		String name = is.readUTF();
//		int sotinchi = is.readInt();
//		MonHoc mh = new MonHoc(id, name, sotinchi);
//		return mh;
//	}
//
//	ArrayList<SinhVien> load(String path) throws IOException {
//		ArrayList<SinhVien> loadedListSV = new ArrayList<SinhVien>();
//		DataInputStream is = new DataInputStream(new FileInputStream(path));
//		while (is.available() > 0) {
//			SinhVien sv = readFileSV(is);
//			loadedListSV.add(sv);
//			while (true) {
//				MonHoc mh = readFileMH(is);
//				sv.add(mh);
//			}
//
//		}
//		is.close();
//		
//		return loadedListSV;
//	}

}
