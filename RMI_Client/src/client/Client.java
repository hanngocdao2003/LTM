package client;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import server.IStudent;

public class Client {
	public static void main(String[] args) throws RemoteException, NotBoundException {
		Registry reg = LocateRegistry.getRegistry("127.0.0.1", 2222);
		Remote is1 = reg.lookup("s1");
		IStudent s1 = (IStudent) is1;
		Remote is2 = reg.lookup("s2");
		IStudent s2 = (IStudent) is2;
		
		Remote is = reg.lookup("s");
		IStudent s = (IStudent) is;
		
		System.out.println(s1.getInformation());
		System.out.println(s2.getInformation());
		
		System.out.println(s.findByName("Han"));
	}
}
