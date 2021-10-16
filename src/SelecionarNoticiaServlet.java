import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;

public class SelecionarNoticiaServlet extends HttpServlet {
  //@Consumes(MediaType.APPLICATION_JSON)
      public  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html");
            PrintWriter pw=response.getWriter();//get the stream to write the data
            String requestData = request.getReader().lines().collect(Collectors.joining());
            int id= Integer.parseInt(requestData);
            NoticiaDAO bd= new NoticiaDAO();
            Noticia noticia=bd.getNoticia(id);
            /*String strJson = "{'id' : '" + Integer.toString(noticia.getId()) + "', 'titulo' : '" + noticia.getTitulo() + "', 'subtitulo' : '" + noticia.getSubtitulo() + "', 'texto' : '" + noticia.getTexto() + "', 'hora' : '" + noticia.getHora().toString() +"', 'date' : '" + noticia.getDate().toString() + "' }";*/
            /*char[] vec= new char[ans.length()];
            vec=ans.toCharArray();
            for(int i=0; i<ans.length(); i++){
              if(vec[i]=='='){
                vec[i]=':';
              }
            }
            ans= vec.toString();*/
            //pw.print(strJson);
            Json js= new Json();
            pw.print(js.enviaNoticia(noticia));
          //PrintWriter
      }
}
