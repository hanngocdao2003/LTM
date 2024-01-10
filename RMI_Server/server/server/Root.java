package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Root {
	public Root() throws RemoteException {
		// TODO Auto-generated constructor stub
		Registry re = LocateRegistry.createRegistry(2222);
		RootProcessing root = new RootProcessing();
		re.rebind("login", root);
		System.out.println("Connecting...");
	}

	public static void main(String[] args) throws RemoteException {
		new Root();
	}
}
