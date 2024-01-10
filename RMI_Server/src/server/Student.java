package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Student  {
	private int id;
	private String name;

	public Student(int id, String name) throws RemoteException {
		super();
		this.id = id;
		this.name = name;
	}

	public Student() throws RemoteException {
		super();
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

}
