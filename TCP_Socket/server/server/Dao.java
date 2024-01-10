package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {
	Connection con = null;

	public Dao() throws ClassNotFoundException, SQLException {
		String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
		String url = "jdbc:ucanaccess://A:\\workspace_all_tools\\Login.accdb";
		Class.forName(driver);
		con = DriverManager.getConnection(url);
		System.out.println("Connect successfully..");
	}

	public boolean checkAccount(String username, String password) throws SQLException {
		String query = "select * from User where Account = ? and Password = ?";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, password);

		ResultSet rs = preparedStatement.executeQuery();

		if (rs.next()) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		System.out.println(new Dao().checkAccount("han", "han123"));
	}

}
