package client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

public class Client {
    private Socket socket;
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private BufferedReader reader;
    private OutputStream outputStream;

    public Client() throws UnknownHostException, IOException {
        socket = new Socket("localhost", 4789);
        dataInputStream = new DataInputStream(socket.getInputStream());
        dataOutputStream = new DataOutputStream(socket.getOutputStream());
    }

    public void receiveGreetingFromServer() throws IOException {
        String greeting = dataInputStream.readUTF();
        System.out.println(greeting);
    }

    public void login() throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Dang nhap");
        System.out.println("Nhap ten dang nhap va mat khau theo cu phap login_userName_password");
        System.out.println("          VD: login nhad123 123456789");
        String command = reader.readLine();
        StringTokenizer tokenizer = new StringTokenizer(command);
        String command_Login = tokenizer.nextToken();
        String name_Account = tokenizer.nextToken();
        String password_Account = tokenizer.nextToken();
        dataOutputStream.writeUTF(name_Account);
        dataOutputStream.writeUTF(password_Account);
        dataOutputStream.flush();
        String notify = dataInputStream.readUTF();
        System.out.println(notify);
    }

    public static void main(String[] args) throws UnknownHostException, IOException {
        Client client = new Client();
        client.receiveGreetingFromServer();
        client.login();
    }
}

