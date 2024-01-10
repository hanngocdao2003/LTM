package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.StringTokenizer;

import server.IRootProcessing;

public class User {
	void run() throws NotBoundException, IOException {
		Registry re = LocateRegistry.getRegistry("localhost", 2222);
		IRootProcessing iroot = (IRootProcessing) re.lookup("login");

		System.out.println("Bạn muốn làm gì?");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String processing = reader.readLine();
			if (processing.equalsIgnoreCase("quit")) {
				break;
			} else {
				StringTokenizer tokenizer = new StringTokenizer(processing);
				String com = tokenizer.nextToken();
				String username = tokenizer.nextToken();
				String password = tokenizer.nextToken();
				if (com.equalsIgnoreCase("login")) {
					System.out.println(iroot.checkLogin(username, password));
				}
			}
		}
	}

	public static void main(String[] args) throws NotBoundException, IOException {
		new User().run();
	}
}
