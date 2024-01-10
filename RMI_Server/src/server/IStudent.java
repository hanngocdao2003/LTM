package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IStudent extends Remote{
	String getInformation() throws RemoteException;
	ArrayList<Student> findByName(String name) throws RemoteException;
}
