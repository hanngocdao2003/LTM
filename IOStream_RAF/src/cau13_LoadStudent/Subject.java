package cau13_LoadStudent;

public class Subject {
	private int id;
	private String name;
	private int numOfCredit;
	private double score;

	public Subject(int id, String name, int numOfCredit, double score) {
		super();
		this.id = id;
		this.name = name;
		this.numOfCredit = numOfCredit;
		this.score = score;
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

	public int getNumOfCredit() {
		return numOfCredit;
	}

	public void setNumOfCredit(int numOfCredit) {
		this.numOfCredit = numOfCredit;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ID: " + id + "\t" + "Name: " + name + "\t" +"Number Of Credits: "+ numOfCredit + "\t" + "Score: " + score + "\n";
	}
}
