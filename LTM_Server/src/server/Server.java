package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	private ServerSocket serverSocket;
	private Socket socket;
	public Server() throws IOException {
		serverSocket = new ServerSocket(4789);
		System.out.println("Server is running.....");
		while (true) {
			socket = serverSocket.accept();
			new Server_Process(this.socket).start();
			System.out.println(socket.getInetAddress() + " is connecting server");
		}
	}
	public static void main(String[] args) throws IOException {
		new Server();
	}

}
