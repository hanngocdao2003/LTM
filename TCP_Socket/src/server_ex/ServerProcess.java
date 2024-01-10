package server_ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerProcess extends Thread {
	Socket socket;
	BufferedReader netIn;
	PrintWriter netOut;

	public ServerProcess(Socket socket) {
		super();
		this.socket = socket;
		try {
			netIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			netOut = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		netOut.println("Hello Client");
		netOut.flush();
		while (true) {
			String command;
			try {
				command = netIn.readLine();
				if (command.equalsIgnoreCase("Quit")) {
					netOut.println("Bye Client");
					netOut.flush();
					netIn.close();
					netOut.close();
					break;
				} else {
					netOut.println("Server response: " + command + " echo");
					netOut.flush();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
