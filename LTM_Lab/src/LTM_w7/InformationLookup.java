package LTM_w7;

import java.util.ArrayList;

public class InformationLookup implements ILookup{
	private ArrayList<Student> listStu;

	public InformationLookup() {
		listStu = new ArrayList<Student>();
	}

	public ArrayList<Student> getListStu() {
		return listStu;
	}

	public void setListStu(ArrayList<Student> listStu) {
		this.listStu = listStu;
	}

	void remove(Student s) {
		listStu.remove(s);
	}

	void add(Student s) {
		listStu.add(s);
	}

	@Override
	public void findByName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findByAge(int age) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void findByScore(float score) {
		// TODO Auto-generated method stub
		
	}

}
