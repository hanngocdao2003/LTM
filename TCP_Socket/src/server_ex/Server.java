package server_ex;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	static void interact() throws IOException {
		ServerSocket serverSocket = new ServerSocket(2222);
		System.out.println("waiting for client ...");
		while (true) {
			Socket socket = serverSocket.accept();
			new ServerProcess(socket).start();
			System.out.println("Client " + socket.getInetAddress() + " connected");
		}
	}

	public static void main(String[] args) throws IOException {
		interact();
	}
}
