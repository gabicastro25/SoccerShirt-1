import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.stream.Collectors;

public class CadastrarLigaServlet extends HttpServlet {
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
            StringBuilder sb = new StringBuilder(requestData);
            pw.println(requestData);
            int begin=requestData.indexOf('=');
            int end= requestData.indexOf('&');
            String nome= requestData.substring(begin+1, end);
            sb.setCharAt(begin,' ');
            requestData= sb.toString();
            begin=requestData.indexOf('=');
            sb.setCharAt(end,' ');
            requestData= sb.toString();
            end=requestData.indexOf('&');
            String pais= requestData.substring(begin+1, end);
            pw.println(nome);
            pw.println(pais);
            pw.println(requestData);
            Liga liga= new Liga();
            liga.setNome(nome);
            liga.setPaisOrigem(pais);
            LigaDAO bd= new LigaDAO();
            bd.adiciona(liga);
          //PrintWriter
      }
}
