package server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.sql.SQLException;

public class Server_Process extends Thread {
	private Socket socket;
	private DataInputStream inputStream;
	private DataOutputStream outputStream;
	private BufferedReader reader;
	private InputStream stream;
	private Dao dao;

	public Server_Process(Socket socket) throws IOException {
		this.socket = socket;
		inputStream = new DataInputStream(socket.getInputStream());
		outputStream = new DataOutputStream(socket.getOutputStream());
	}

	public void getGreetingForClient() throws IOException, SQLException, ClassNotFoundException {
		outputStream.writeUTF("Hello Client ! Client connected with Server success");
		outputStream.flush();
	}

	public void clientLogin() throws IOException, ClassNotFoundException, SQLException {
		String name_acc = inputStream.readUTF();
		String pass_acc = inputStream.readUTF();
		dao = new Dao();
		if(dao.checkloginAccount(name_acc, pass_acc) == true) {
			outputStream.writeUTF("Login success...");
			outputStream.flush();
		}else {
			outputStream.writeUTF("nameAcount or password incorrect....");
			outputStream.flush();
		}
//		System.out.println(name_acc);
//		System.out.println(pass_acc);
	}

	@Override
	public void run() {
		try {
			getGreetingForClient();
			clientLogin();
		} catch (IOException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// Đóng tài nguyên khi kết thúc luồng
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
