package cau13_LoadStudent;

import java.util.ArrayList;

public class Student {
	private int id;
	private String name;
	private ArrayList<Subject> listSubjects;

	public Student(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		listSubjects = new ArrayList<Subject>();
	}

	void add(Subject s) {
		listSubjects.add(s);
	}

	void remove(Subject s) {
		listSubjects.remove(s);
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

	public ArrayList<Subject> getListSubjects() {
		return listSubjects;
	}

	public void setListSubjects(ArrayList<Subject> listSubjects) {
		this.listSubjects = listSubjects;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ID: " + id + "\n" + "Name: " + name + "\n" + listSubjects + "\n";
	}
}
