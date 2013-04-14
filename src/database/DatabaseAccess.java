package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DatabaseAccess {

	private Connection connection;

	public DatabaseAccess() {

	}

	public boolean OpenDatabase() {

		this.connection = null;
		String url = "jdbc:mysql://localhost:3306/AIWars";
		String user = "root";
		String password = "sbucs";

		try {

			// create a database connection
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB
			connection = DriverManager.getConnection(url, user, password);

		} catch (SQLException e) {
			// if the error message is "out of memory",
			// it probably means no database file is found
			System.err.println(e.getMessage());
			return false;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;

	}

	public boolean CreateTable(String createQuery) {
		Statement statement;
		try {
			statement = connection.createStatement();
			statement.setQueryTimeout(30);
			statement.executeUpdate(createQuery);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean Write(String baseQuery, List<String> values) {
		try {

			PreparedStatement prep = connection.prepareStatement(baseQuery);

			for (int i = 0; i < values.size(); i++) {
				prep.setString(i + 1, values.get(i));
			}
			prep.addBatch();

			connection.setAutoCommit(false);
			prep.executeBatch();
			connection.setAutoCommit(true);

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}

	public ResultSet Read(String baseQuery, List<?> values, int mode) {
		ResultSet rs;
		try {

			PreparedStatement prep = connection.prepareStatement(baseQuery);

			if (mode == 0) {
				for (int i = 0; i < values.size(); i++) {
					prep.setString(i + 1, (String) values.get(i));
				}
			}
			else if (mode == 1) {
				for (int i = 0; i < values.size(); i++) {
					prep.setInt(i + 1, (Integer) values.get(i));
				}
			}

			rs = prep.executeQuery();

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
