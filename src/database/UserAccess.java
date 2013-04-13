package database;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
		
		return dba.Write("users", baseQuery, values);

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
