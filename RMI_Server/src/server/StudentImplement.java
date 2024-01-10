package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class StudentImplement extends UnicastRemoteObject implements IStudent {

	protected StudentImplement() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
		list = new ArrayList<Student>();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Student> list;

	@Override
	public String getInformation() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Student> findByName(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
