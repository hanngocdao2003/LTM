package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Dao {
	Connection con = null;

	public Dao() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated constructor stub
		String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
		String url = "jdbc:ucanaccess://A:\\workspace_all_tools\\DatabaseStudent.accdb";
		Class.forName(driver);
		con = DriverManager.getConnection(url);
		System.out.println("Connect successfully...");
	}

	public boolean checkLogin(String username, String password) throws SQLException {
		String query = "select username, password from user where username = ? and password = ?";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1, username);
		preparedStatement.setString(2, password);

		ResultSet rs = preparedStatement.executeQuery();
		if (rs.next()) {
			return true;
		}
		return false;
	}

	public void getScore(String username) throws SQLException {
		String query = "select user.fullname, subject.subject, subject.score from user inner join subject on user.id = subject.idUser where user.username = ?";
		PreparedStatement preparedStatement = con.prepareStatement(query);
		preparedStatement.setString(1, username);

		ResultSet rs = preparedStatement.executeQuery();
		while (rs.next()) {
			String fullname = rs.getString("fullname");
			String sub = rs.getString("subject");
			//int numOfCredit = rs.getInt("numOfCredit");
			double score = rs.getDouble("score");

			System.out.println(fullname + "\n" + sub + "\t" + "\t" + score);

		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// System.out.println(new Dao().checkLogin("handao2003", "han123"));
		new Dao().getScore("handao2003");
	}
}