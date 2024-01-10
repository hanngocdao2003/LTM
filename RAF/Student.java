package RAF;

public class Student {
	int id;
	String name;
	double gpa;
	public Student(int id, String name, double gpa) {
		super();
		this.id = id;
		this.name = name;
		this.gpa = gpa;
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
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gpa=" + gpa + "]";
	}
	

}
