package client_ad;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	Socket socket;
	DataInputStream netIn;
	DataOutputStream netOut;
	OutputStream os;

	public Client() throws UnknownHostException, IOException {
		// TODO Auto-generated constructor stub
		socket = new Socket("localhost", 2222);
		netIn = new DataInputStream(socket.getInputStream());
		netOut = new DataOutputStream(socket.getOutputStream());
		String cmt = netIn.readUTF();
		System.out.println(cmt);
	}

	void copyFile(String path) throws IOException {
		File file = new File(path);
		long size = netIn.readLong();
		os = new BufferedOutputStream(new FileOutputStream(file));
		byte[] bytes = new byte[1024 * 1024];
		int data;
		int b = 0;
		while (b < size) {
			data = netIn.read(bytes);
			os.write(bytes, 0, data);
			b += data;

		}
		System.out.println("Success..");
		netIn.close();
		netOut.close();
		os.close();
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		String path = "E:\\styleAdmin_copy.css";
		new Client().copyFile(path);
	}
}
