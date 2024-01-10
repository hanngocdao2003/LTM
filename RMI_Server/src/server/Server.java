package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	public static void main(String[] args) throws RemoteException {
		Registry reg = LocateRegistry.createRegistry(2222);
		
		Student s1 = new Student(21130345, "Dao Ngoc Han");
		Student s2 = new Student(21130328, "Nguyen Hoang Anh Duong");

	}
}
