import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.stream.Collectors;

public class CadastrarTimeServlet extends HttpServlet {
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
            pw.println(requestData);
            int begin=requestData.indexOf('=');
            int end= requestData.indexOf('&');
            String nome= requestData.substring(begin+1, end);
            pw.println(nome);
            Time time= new Time();
            time.setNome(nome);
            TimeDAO bd= new TimeDAO();
            bd.adiciona(time);
          //PrintWriter
      }
}
