package test;

public class Student {
	String name;
	int age;
	String school;
	double mask;
	
	public Student(String name, int age, String school, double mask) {
		this.name = name;
		this.age = age;
		this.school = school;
		this.mask = mask;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public double getMask() {
		return mask;
	}
	public void setMask(double mask) {
		this.mask = mask;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", school=" + school + ", mask=" + mask + "]";
	}
	
	

}
