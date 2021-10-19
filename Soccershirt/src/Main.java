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
import  java.util.*;
public class Main {
    public static void print(String s){
        System.out.print(s);
    }
    public static void main(String[] args) {
        Scanner leitor= new Scanner(System.in);
        print("Digite a operação desejada: (Cadastrar: 1, Remover: 2)");
        int opc= leitor.nextInt();
        if(opc==1){
          print("\nDigite a entidade desejada: (Noticia: 1, Time: 2, Liga: 3, Marca: 4)");
          int ent= leitor.nextInt();
          leitor.nextLine();
          if(ent==1){
            print("\nDigite o titulo: ");
            String titulo= leitor.nextLine();
            print("\nDigite o subtitulo: ");
            String subtitulo= leitor.nextLine();
            print("\nDigite o texto: ");
            String texto= leitor.nextLine();
            Noticia noticia = new Noticia(titulo, subtitulo, texto);
            NoticiaDAO bd = new NoticiaDAO();
            bd.adiciona(noticia);
          }
          else if(ent==2){
            print("\nDigite o nome: ");
            String nome= leitor.nextLine();
            Time time = new Time();
            time.setNome(nome);
            TimeDAO bd = new TimeDAO();
            bd.adiciona(time);
          }
          else if(ent==3){
            print("\nDigite o nome: ");
            String nome= leitor.nextLine();
            print("\nDigite o pais de origem: ");
            String pais= leitor.nextLine();
            Liga liga = new Liga();
            liga.setNome(nome);
            liga.setPaisOrigem(pais);
            LigaDAO bd = new LigaDAO();
            bd.adiciona(liga);
          }
          else if(ent==4){
            print("\nDigite o nome: ");
            String nome= leitor.nextLine();
            //print("\nDigite : ")
            //String subtitulo= leitor.nextLine();
            Marca marca = new Marca();
            marca.setNome(nome);
            MarcaDAO bd = new MarcaDAO();
            bd.adiciona(marca);
          }
        }
        else if(opc==2){
          print("\nDigite a entidade desejada: (Noticia: 1, Time: 2, Liga: 3, Marca: 4)");
          int ent= leitor.nextInt();
          leitor.nextLine();
          if(ent==1){
            print("\nDigite o id da noticia a ser excluida: ");
            int id= leitor.nextInt();
            NoticiaDAO bd= new NoticiaDAO();
            bd.removerNoticia(id);
          }
          else if(ent==2){
            print("\nDigite o id do time a ser excluido: ");
            int id= leitor.nextInt();
            TimeDAO bd= new TimeDAO();
            bd.removerTime(id);
          }
          else if(ent==3){
            print("\nDigite o id da liga a ser excluida: ");
            int id= leitor.nextInt();
            LigaDAO bd= new LigaDAO();
            bd.removerLiga(id);
          }
          else if(ent==4){
            print("\nDigite o id da marca a ser excluida: ");
            int id= leitor.nextInt();
            MarcaDAO marca= new MarcaDAO();
            marca.removerMarca(id);
          }
        }
        leitor.close();
    }
  }
