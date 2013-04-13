package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqliteTest
{
  public static void main(String[] args) throws ClassNotFoundException
  {
    // load the sqlite-JDBC driver using the current class loader
    Class.forName("org.sqlite.JDBC");

    Connection connection = null;
    try
    {
      // create a database connection
      connection = DriverManager.getConnection("jdbc:sqlite:accounts.db");
      Statement statement = connection.createStatement();
      statement.setQueryTimeout(30);  // set timeout to 30 sec.

      
      statement.executeUpdate("create table accounts (id integer, firstname string, lastname string, email string, password string)");
      statement.executeUpdate("insert into accounts values(1, 'Brandon', 'Kowalski', 'brandonkowalski@kwall.org', 'hsakdjhaskdhk')");
      ResultSet rs = statement.executeQuery("select * from accounts");
      while(rs.next())
      {
        // read the result set
        System.out.println("name = " + rs.getString("firstname"));
        System.out.println("id = " + rs.getInt("id"));
      }
    }
    catch(SQLException e)
    {
      // if the error message is "out of memory", 
      // it probably means no database file is found
      System.err.println(e.getMessage());
    }
    finally
    {
      try
      {
        if(connection != null)
          connection.close();
      }
      catch(SQLException e)
      {
        // connection close failed.
        System.err.println(e);
      }
    }
  }
}