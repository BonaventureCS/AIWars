package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) {
		
		DatabaseAccess dba = new DatabaseAccess();
		try {
			dba.OpenDatabase("accounts.db");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResultSet rs = dba.Read("Select * from accounts");
		
		try {
			while (rs.next()) {
				System.out.println("Hello " + rs.getString("firstname"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
