import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.stream.Collectors;

public class CadastrarNoticiaServlet extends HttpServlet {
  //@Consumes(MediaType.APPLICATION_JSON)
      public  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html");
            PrintWriter pw=response.getWriter();//get the stream to write the data
            //writing html in the stream=
            /*if ("POST".equalsIgnoreCase(request.getMethod()))
            {
                test = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
            }*/
            String requestData = request.getReader().lines().collect(Collectors.joining());
            String[] words= {"titulo","subtitulo","conteudo"};
            String[] ans= new String[3];
            int cont=0;
            for(String x: words){
              int idx= requestData.indexOf(x);
              int end= requestData.indexOf("&");
              StringBuilder sb= new StringBuilder(requestData);
              sb.setCharAt(end, '*');
              requestData= sb.toString();
              char[] ch = new char[requestData.length()];
              for (int i = 0; i < requestData.length(); i++) {
                ch[i] = requestData.charAt(i);
              }
              String aux= new String();
              while(ch[idx]!='=') ++idx;
              for(int i=idx+1; i<end; i++){
                aux+=ch[i];
              }
              ans[cont]=aux.toString();
              ++cont;
            }
            pw.println(requestData);
            for(String x: ans){
              pw.println(x);
            }
          String titulo = ans[0];
          String subtitulo = ans[1];
          String conteudo = ans[2];
          pw.println(""+titulo+" "+subtitulo+" "+conteudo);
          pw.close();//closing the stream
          Noticia noticia= new Noticia(titulo, subtitulo, conteudo);
          NoticiaDAO bd= new NoticiaDAO();
          bd.adiciona(noticia);

          //PrintWriter
      }
}
