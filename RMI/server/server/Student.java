package server;

import java.io.Serializable;

public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String account;
	private String password;
	private double avg_Score;

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

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getAvg_Score() {
		return avg_Score;
	}

	public void setAvg_Score(double avg_Score) {
		this.avg_Score = avg_Score;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getId() + "\t" + getName() + "\t" + getAvg_Score();
	}

}
