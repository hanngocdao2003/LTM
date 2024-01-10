package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface IServerProccessing extends Remote {
	boolean login(String name, String pass) throws RemoteException;

	boolean findbyId(int id) throws RemoteException;
}
