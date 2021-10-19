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
public class Liga{

    // atributos
      private int id;
      private String nome;
      private String simbolo;
      private String paisOrigem;

    // métodos get e set
    public String getNome() {
      return this.nome;
    }
    public void setNome(String novo) {
      this.nome = novo;
    }
    public void setId(int id){
      this.id=id;
    }
    public int getId(){
      return this.id;
    }
    public void setSimbolo(String novo) {
      this.simbolo = novo;
    }
    public String getSimbolo() {
      return this.simbolo;
    }
    public void setPaisOrigem(String novo) {
      this.paisOrigem = novo;
    }
    public String getPaisOrigem() {
      return this.paisOrigem;
    }
}
