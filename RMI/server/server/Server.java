package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
	public Server() throws RemoteException {
		// TODO Auto-generated constructor stub
		Registry re = LocateRegistry.createRegistry(2222);
		ServerProccessing sp = new ServerProccessing();
		re.rebind("id", sp);
		System.out.println("Server running...");
	}

	public static void main(String[] args) throws RemoteException {
		new Server();
	}
}
