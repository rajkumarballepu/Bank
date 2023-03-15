package Admin;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DataBase.Database;

public class AdminDB {

	public static boolean validCredentials(String username, String password) {
		 Connection connection = Database.getConnection();
		 Statement stmt;
		try {
			stmt = connection.createStatement();
			ResultSet rs= stmt.executeQuery("select * from admin where name= \'"+username+"\'");
			while(rs.next()) {
				if (rs.getNString("name").equals(username) && rs.getNString("password").equals(password)) {
					System.out.println("Login success...");
					return true;
				}
			}
			return false;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		validCredentials("rajkumarballepu", "madhavi");
		
	}

}
