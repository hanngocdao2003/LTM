package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Root {
	ServerSocket serverSocket;
	Socket socket;

	public Root() throws IOException {
		serverSocket = new ServerSocket(2222);
		System.out.println("Server running...");
		while (true) {
			socket = serverSocket.accept();
			new RootProcessing(socket).start();
			System.out.println(socket.getInetAddress() + " connecting...");

		}
	}

	public static void main(String[] args) throws IOException {
		new Root();
	}

}
