package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {
	Connection conn = null;

	public Dao() throws ClassNotFoundException, SQLException {
		String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
		String url = "jdbc:ucanaccess://E:\\LapTrinhMang\\Login.accdb";
		Class.forName(driver);
		conn = DriverManager.getConnection(url);
		System.out.println("Connecting Success....");
	}

	public void getLogin() throws SQLException {
		String sql = "select * from Login";
		PreparedStatement statement = conn.prepareStatement(sql);
		ResultSet result = statement.executeQuery();
		while (result.next()) {
			System.out.print(result.getInt(1) + " - ");
			System.out.print(result.getString(2) + " - ");
			System.out.println(result.getString(3));
		}
	}
	public boolean checkloginAccount(String username, String password) throws SQLException {
		String sql = "select * from Login where name_Account = ? and password = ?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, username);
		statement.setString(2, password);
		ResultSet result = statement.executeQuery();
		if(result.next()) {
			return true;
		}else {
			return false;
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		new Dao().getLogin();
//		System.out.println(new Dao().checkloginAccount("nhad123", "123456789"));
	}

}
