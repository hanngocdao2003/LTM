package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

public class ServerProccessing extends UnicastRemoteObject implements IServerProccessing {

	protected ServerProccessing() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public boolean login(String name, String pass) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			Dao dao = new Dao();
			if (dao.login(name, pass)) {
				return true;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean findbyId(int id) throws RemoteException {
		// TODO Auto-generated method stub
		try {
			Dao dao = new Dao();
			if (dao.findById(id)) {
				return true;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
