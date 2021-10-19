public class Json{
  public String enviaNoticia(Noticia noticia){
    char aspas = '"';
    String strJson = "{" + aspas + "id" + aspas + ":" + aspas + Integer.toString(noticia.getId()) + aspas + ", " + aspas + "titulo" + aspas + " : " + aspas + noticia.getTitulo() + aspas + ", " + aspas + "subtitulo" +aspas+" : " + aspas + noticia.getSubtitulo() + aspas + ", " + aspas + "texto" + aspas + " : " + aspas + noticia.getTexto() + aspas + ", " + aspas + "hora" + aspas + ":" + aspas + noticia.getHora().toString() + aspas + "," + aspas + "date" + aspas + ":" + aspas + noticia.getDate().toString() + aspas + "}";
    /*String strJson = "{'id' : '" + Integer.toString(noticia.getId()) + "', 'titulo' : '" + noticia.getTitulo() + "', 'subtitulo' : '" + noticia.getSubtitulo() + "', 'texto' : '" + noticia.getTexto() + "', 'hora' : '" + noticia.getHora().toString() +"', 'date' : '" + noticia.getDate().toString() + "' }";*/
    return strJson;
  }
}
