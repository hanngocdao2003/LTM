package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.StringTokenizer;

import server.IServerProccessing;
import server.Student;

public class Client {
	public Client() throws RemoteException {
		// TODO Auto-generated constructor stub
		Registry re = LocateRegistry.getRegistry("localhost", 2222);
		try {
			IServerProccessing iser = (IServerProccessing) re.lookup("id");
			while (true) {
				System.out.println("Input your information: ");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String cmd = br.readLine();
				if (cmd.equalsIgnoreCase("quit")) {
					break;
				}
				else if (cmd.equalsIgnoreCase("login")) {
					System.out.println("Username And Password: ");
					BufferedReader login = new BufferedReader(new InputStreamReader(System.in));
					String info = login.readLine();
					StringTokenizer tokenizer = new StringTokenizer(info);
					String name = tokenizer.nextToken();
					String pass = tokenizer.nextToken();

					if (iser.login(name, pass)) {
						System.out.println("login successfully..");
					} else {
						System.out.println("wrong name or pass..");
					}
				} else if (cmd.equalsIgnoreCase("findid")) {
					System.out.println("Your ID: ");
					BufferedReader login = new BufferedReader(new InputStreamReader(System.in));
					int info = login.read();

					if (iser.findbyId(info)) {
						System.out.println(new Student());
					} else {
						System.out.println("wrong id..");
					}
				}
			}
		} catch (AccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws RemoteException {
		new Client();
	}
}