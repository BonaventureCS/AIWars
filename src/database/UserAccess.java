package database;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Formatter;

public class UserAccess {

	public static boolean Create(String email, String password, String firstname, String lastname) {
		DatabaseAccess dba = new DatabaseAccess();
		String pass = encryptPassword(password);
		dba.OpenDatabase();
		
		String baseQuery = "insert into users (email, password, firstname, lastname) values (?, ?, ?, ?);";
		ArrayList<String> values = new ArrayList<String>();
		
		values.add(email);
		values.add(pass);
		values.add(firstname);
		values.add(lastname);
		
		return dba.Write(baseQuery, values);

	}
	
	public static ResultSet Login(String email, String password) {
		DatabaseAccess dba = new DatabaseAccess();
		String pass = encryptPassword(password);
		dba.OpenDatabase();
		
		String baseQuery = "select * from users where email = ? and password = ?;";
		ArrayList<String> values = new ArrayList<String>();
		
		values.add(email);
		values.add(pass);

		
		return dba.Read(baseQuery, values, 0);
	}
	
	public static ResultSet GrabMedals(int playerID) throws SQLException {
		DatabaseAccess dba = new DatabaseAccess();
		dba.OpenDatabase();
		
		String baseQuery = "select * from medals, usersXmedals where pid = ? and mid = medID;";
		ArrayList<Integer> values = new ArrayList<Integer>();
		
		values.add(playerID);
		
		return dba.Read(baseQuery, values, 1);


	}
	
	public static ResultSet LoadBots(int playerID) {
		DatabaseAccess dba = new DatabaseAccess();
		dba.OpenDatabase();
		
		String baseQuery = "select * from ai, games where ownerID = ? and gid = gameID;";
		ArrayList<Integer> values = new ArrayList<Integer>();
		
		values.add(playerID);
		
		ResultSet rs = dba.Read(baseQuery, values, 1);

		return rs;
	}

	private static String encryptPassword(String password) {
		String sha1 = "";
		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(password.getBytes("UTF-8"));
			sha1 = byteToHex(crypt.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return sha1;
	}

	private static String byteToHex(final byte[] hash) {
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02x", b);
		}
		String result = formatter.toString();
		formatter.close();
		return result;
	}

}
