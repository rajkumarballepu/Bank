package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;


public class UserDB {
	static LinkedList<String> details = new LinkedList<String>();
	public static boolean validCredentials(String username,String password) {
		Connection conn = Database.getConnection();
		PreparedStatement pStmt;
		try {
			pStmt = conn.prepareStatement("select * from user where username = ? and password = ?");
			pStmt.setString(1, username);
			pStmt.setString(2, password);
			ResultSet res = pStmt.executeQuery();
			if (res.next()) {
				details.add(res.getString("name"));
				details.add(Long.valueOf(res.getLong("balance")).toString());
				System.out.println("Login success");
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public static LinkedList<String> getDetails() {
		return details;
	}
	public static void main(String[] args) {
		validCredentials("brajumar20", "madhavi");
	}
}
