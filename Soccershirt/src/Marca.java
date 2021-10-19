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
public class Marca{
	// atributos
      private int id;
      private String nome;
      private String logo; ///////////*************************************************************************

    // métodos get e set
    public String getNome() {
      return this.nome;
    }
    public void setId(int id){
      this.id=id;
    }
    public void setNome(String novo) {
      this.nome = novo;
    }
    public void setLogo(String novo) {
      this.logo = novo;
    }
    public String getLogo() {
      return this.logo;
    }
    public int getId(){
      return this.id;
    }

}
