package client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

public class Client {

	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;
	BufferedReader bufferedReader;
	InputStream is;

	public Client() throws UnknownHostException, IOException {
		socket = new Socket("localhost", 2222);
		dos = new DataOutputStream(socket.getOutputStream());
		dis = new DataInputStream(socket.getInputStream());
	}

	public void receipt() throws IOException {
		System.out.println(dis.readUTF());
	}

	public void login() throws IOException {
		bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String command = bufferedReader.readLine();
		StringTokenizer tokenizer = new StringTokenizer(command);
		String login = tokenizer.nextToken();
		String username = tokenizer.nextToken();
		String password = tokenizer.nextToken();

		dos.writeUTF(username);
		dos.writeUTF(password);

		dos.flush();

		String notification = dis.readUTF();
		System.out.println(notification);
	}

	public static void main(String[] args) throws UnknownHostException, IOException {
		Client c = new Client();
		c.receipt();
		c.login();
	}
}
