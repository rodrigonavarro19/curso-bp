package comportamiento.visitor;

public class HTMLVisitor implements DocVisitor {
    @Override
    public String visit(DocHeader header) {
        return 
            "<h1>" + header.getTitulo() + "</h1>\n" +
            "<p>Autor: " + header.getAutor() + "</p>\n";
    }

    @Override
    public String visit(DocBody body) {
        return "<div>" + body.getContenido() + "</div>\n";
    }

    @Override
    public String visit(DocFooter footer) {
        return "<footer>" + footer.getTexto() + " - num. págs.: " + footer.getNumPaginas() + "</footer>\n";
    }

}
