package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRootProcessing extends Remote{
	public boolean checkLogin(String username, String password) throws RemoteException;
}
