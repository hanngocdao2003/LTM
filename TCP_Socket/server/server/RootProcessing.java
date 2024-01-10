package server;

import java.io.*;
import java.net.Socket;
import java.sql.SQLException;

public class RootProcessing extends Thread {
	Socket socket;
	DataOutputStream dos;
	DataInputStream dis;
	BufferedReader bufferedReader; // doc dl tu console
	Dao dao;
	InputStream is;

	public RootProcessing(Socket socket) throws IOException {
		this.socket = socket;
		dos = new DataOutputStream(socket.getOutputStream());
		dis = new DataInputStream(socket.getInputStream());
	}

	public void helloClient() throws IOException {
		dos.writeUTF("Hello user..");
		dos.flush();

	}

	public void checkLogin() throws IOException, ClassNotFoundException, SQLException {
		String username = dis.readUTF();
		String password = dis.readUTF();

		dao = new Dao();
		if (dao.checkAccount(username, password)) {
			dos.writeUTF("Login successfully..");
		} else {
			dos.writeUTF("Login unsuccessfully..");
		}
		dos.flush();
	}

	@Override
	public void run() {
		try {
			helloClient();
			checkLogin();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
