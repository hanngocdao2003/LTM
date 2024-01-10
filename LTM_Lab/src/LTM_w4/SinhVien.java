package LTM_w4;

import java.io.*;
import java.util.ArrayList;

public class SinhVien {
	private int id;
	private String name;
	private ArrayList<MonHoc> listMH;

	public SinhVien(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		listMH = new ArrayList<MonHoc>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	void add(MonHoc m) {
		listMH.add(m);
	}

	void remove(MonHoc m) {
		listMH.remove(m);
	}

	public ArrayList<MonHoc> getListMH() {
		return listMH;
	}

	public void setListMH(ArrayList<MonHoc> listMH) {
		this.listMH = listMH;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getId() + "\t" + getName() + "\n" + "Danh sach mon hoc: \n" + getListMH();
	}

	
}
