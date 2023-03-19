package DataBase;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminDB {
	private static Connection connection;
	private static Statement stmt;
	static {
		connection = Database.getConnection();
	}
	public static boolean validCredentials(String username, String password) {
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
	public static void insertForm(String name,String dob, String username, String password, String add, long mobile, long id) {
		PreparedStatement pStmt = null;
		try {
			pStmt = connection.prepareStatement("insert into user values(?,?,?,?,?,?,?,?,?)");
			pStmt.setString(1, name);
			pStmt.setString(2, dob);
			pStmt.setString(3, username);
			pStmt.setString(4, password);
			pStmt.setString(5, add);
			pStmt.setLong(6, mobile);
			pStmt.setLong(7, id);
			pStmt.setLong(9, 0);
			stmt = connection.createStatement();
			ResultSet rs= stmt.executeQuery("select accno from user where accno = (select max(accno) from user)");
			rs.next();
			long accno = rs.getLong(1)+1;
			pStmt.setLong(8, accno);
			System.out.println(accno);
			pStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block

			long accno = 62309905330l;
			try {
				pStmt.setLong(8, accno);
				pStmt.executeUpdate();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.out.println(accno);
			System.out.println("done");
		}
	}

}
