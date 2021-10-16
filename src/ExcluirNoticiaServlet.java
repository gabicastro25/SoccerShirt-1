import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.stream.Collectors;

public class ExcluirNoticiaServlet extends HttpServlet {
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
            String[] parts = requestData.split("/");
            /*int id=-1;
            char[] ch = requestData.toCharArray();
            for(int i=0; i<requestData.length(); i++){
              if(!(ch[i]>='1' && ch[i]<='9')) continue;
              StringBuilder sb=new StringBuilder();
              while(ch[i]>='1' && ch[i]<='9' && i<requestData.length()){
                sb.append(ch[i]); ++i;
              }
              String number= sb.toString();
              id=Integer.parseInt(number);
            }
            pw.println(id);*/
            int id=Integer.parseInt(parts[0]);
            pw.println(id);
            pw.println(requestData);
            NoticiaDAO bd= new NoticiaDAO();
            bd.removerNoticia(id);
          //PrintWriter
      }
}
