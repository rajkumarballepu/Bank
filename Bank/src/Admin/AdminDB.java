package Admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DataBase.Database;

public class AdminDB {

	public static void validCredentials(String username, String password) {
		 Connection connection = Database.getConnection();
		 Statement stmt;
		try {
			stmt = connection.createStatement();
			ResultSet rs= stmt.executeQuery("select * from admin where name= \'"+username+"\'");
			rs.next();
			System.out.println(rs.getString("password"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
			
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
