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
		String url = "jdbc:ucanaccess://A:\\workspace_all_tools\\Login.accdb";
		Class.forName(driver);
		con = DriverManager.getConnection(url);
		System.out.println("Connection is successful..");
	}

	public boolean login(String name, String pass) {
		String sql = "select * from User where Account = ? and Password = ?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, pass);

			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public boolean findById(int id) {
		String sql = "select * from Information where ID = ?";
		try {
			PreparedStatement preparedStatement;
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				Student st = new Student();
				st.setId(rs.getInt(1));
				st.setName(rs.getNString(2));
				st.setAvg_Score(rs.getDouble(3));
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

//	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		System.out.println(new Dao().login("han", "han123"));
//	}
}
