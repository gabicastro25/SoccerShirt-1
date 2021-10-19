import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.*;
public class ConnectionFactory {

  public static Connection getConnection() {
  try {
      Class.forName("com.mysql.jdbc.Driver");
      return DriverManager.getConnection(
        "jdbc:mysql://localhost/soccershirt", "root", "soccer");
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
  }
