package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseAccess {

	private Connection connection;

	public DatabaseAccess() {
	}

	public boolean OpenDatabase(String dbName) throws ClassNotFoundException {
		//Class.forName("org.sqlite.JDBC");

		this.connection = null;
		try {
			// create a database connection
			connection = DriverManager.getConnection("jdbc:sqlite:" + dbName);

		} catch (SQLException e) {
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());
			return false;
		}

		return true;

	}

	public boolean Write(String dbTable, String values) {
		try {
			Statement statement = this.connection.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.

			statement.executeUpdate("insert into" + dbTable + "values("
					+ values + ")");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}

	public ResultSet Read(String query) {
		ResultSet rs;
		try {
			Statement statement = this.connection.createStatement();
			statement.setQueryTimeout(30); // set timeout to 30 sec.

			rs = statement.executeQuery(query);

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return null;
		}
		return rs;
	}

	public void Close() throws SQLException {
		this.connection.close();
	}

}
