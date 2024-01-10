package server_ad;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	ServerSocket server;
	Socket socket;
	DataInputStream netIn;
	DataOutputStream netOut;
	InputStream is;

	public Server() throws IOException {
		// TODO Auto-generated constructor stub
		System.out.println("Server is run successfully...");
		server = new ServerSocket(2222);
		socket = server.accept();
		netIn = new DataInputStream(socket.getInputStream());
		netOut = new DataOutputStream(socket.getOutputStream());
		netOut.writeUTF("Hello Client ...");
		netOut.flush();
	}

	void copyFile(String path) throws IOException {
		File file = new File(path);
		long size = file.length();
		netOut.writeLong(size);
		netOut.flush();
		is = new BufferedInputStream(new FileInputStream(file));
		int data;
		byte[] bytes = new byte[1024 * 1024];
		while ((data = is.read(bytes)) != -1) {
			netOut.write(bytes, 0, data);
		}
		netIn.close();
		netOut.close();
		is.close();
	}

	public static void main(String[] args) throws IOException {
		String path = "E:\\styleAdmin.css";
		new Server().copyFile(path);
	}
}
