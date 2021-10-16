import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.stream.Collectors;
public class ExcluirLigaServlet extends HttpServlet {
  //@Consumes(MediaType.APPLICATION_JSON)
      public  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            response.setContentType("text/html");
            PrintWriter pw=response.getWriter();//get the stream to write the data
            String requestData = request.getReader().lines().collect(Collectors.joining());
            String[] parts = requestData.split("/");
            int id=Integer.parseInt(parts[0]);
            pw.println(id);
            pw.println(requestData);
            LigaDAO bd= new LigaDAO();
            bd.removerLiga(id);
      }
}
