package database;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Test {

	public static void main(String[] args) throws SQLException {
		
		ResultSet rs = UserAccess.Login("brandonkowalski@kwall.org", "brandon"); 
		
		boolean logged = false;
		while (rs.next()) {
			System.out.println(rs.getString("firstname") + " " + rs.getString("lastname"));
			logged = true;
		}
		
		if (logged) {
			System.out.println("Logged in");
		}
		else {
			System.out.println("Invalid email or pass");
		}
		
		
		
	}

}
