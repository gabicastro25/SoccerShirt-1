import java.util.Calendar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;
public class JDBCInsere {

      /*public static void main(String[] args) throws SQLException {
        try {
             Connection con = new ConnectionFactory().getConnection();
             // cria um preparedStatement
             String sql = "insert into administrador" +
                     " (senha,username)" +
                     " values (?,?)";
             PreparedStatement stmt = con.prepareStatement(sql);

             // preenche os valores
             //stmt.setLong(1, 1);
             //stmt.setString(2, "contato@caelum.com.br");
             //stmt.setString(3, "R. Vergueiro 3185 cj57");
             //stmt.setString(4, "Gabi olocoooooooo");
             //stmt.setDate(5, new java.sql.Date(
            //         Calendar.getInstance().getTimeInMillis()));
            stmt.setInt(1, 3);
            stmt.setString(2, "Maurício");
             // executa
             stmt.execute();
             stmt.close();

             System.out.println("Gravado!");

             con.close();
       // faz um monte de operações.
       // que podem lançar exceptions runtime e SQLException
     } catch(SQLException e) {
       System.out.println(e);
     } /*finally {
              con.close();
      }*/
    //}
  }
