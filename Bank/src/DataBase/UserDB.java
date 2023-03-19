package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;


public class UserDB {
	static String username, password;
	public static boolean validCredentials(String username,String password) {
		Connection conn = Database.getConnection();
		PreparedStatement pStmt;
		UserDB.username = username;
		UserDB.password = password;
		try {
			pStmt = conn.prepareStatement("select * from user where username = ? and password = ?");
			pStmt.setString(1, username);
			pStmt.setString(2, password);
			ResultSet res = pStmt.executeQuery();
			if (res.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public LinkedList<String> getDetails() {
		Connection conn = Database.getConnection();
		LinkedList<String> details = new LinkedList<String>();
		PreparedStatement pStmt;
		try {
			pStmt = conn.prepareStatement("select * from user where username = ? and password = ?");
			pStmt.setString(1, username);
			pStmt.setString(2, password);
			ResultSet res = pStmt.executeQuery();
			if (res.next()) {
				details.add(res.getString("name"));
				details.add(Double.toString(res.getDouble("balance")));
				details.add(res.getString("username"));
				System.out.println(details.get(1));
				return details;
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return details;
	}
	public static String deposit(double deposite) {
		PreparedStatement pStmt;
		Connection conn = Database.getConnection();
		try {
			System.out.println(conn.getAutoCommit());
			pStmt = conn.prepareStatement("update user set balance = ? where username = ?");
			pStmt.setDouble(1, deposite);
			pStmt.setString(2, username);
			pStmt.executeUpdate();
			pStmt = conn.prepareStatement("commit");
			pStmt.execute();
			return Double.toString(deposite);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	public static void main(String[] args) {
		deposit(0);
	}
}
