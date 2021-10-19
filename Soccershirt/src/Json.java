public class Json{
  public String enviaNoticia(Noticia noticia){
    String strJson = "{'id' : '" + Integer.toString(noticia.getId()) + "', 'titulo' : '" + noticia.getTitulo() + "', 'subtitulo' : '" + noticia.getSubtitulo() + "', 'texto' : '" + noticia.getTexto() + "', 'hora' : '" + noticia.getHora().toString() +"', 'date' : '" + noticia.getDate().toString() + "' }";
    return strJson;
  }
}
