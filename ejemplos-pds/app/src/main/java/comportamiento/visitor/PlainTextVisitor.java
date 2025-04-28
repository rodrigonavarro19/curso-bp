package comportamiento.visitor;

public class PlainTextVisitor implements DocVisitor {
    @Override
    public String visit(DocHeader header) {
        return "\"" + header.getTitulo() + "\"\n ----------- \n" + header.getAutor() + "\n";
    }

    @Override
    public String visit(DocBody body) {
        return "\n <<<<<<<<<<<<<< \n" + body.getContenido() + "\n >>>>>>>>>>>>>> \n\n";
    }

    @Override
    public String visit(DocFooter footer) {
        return footer.getTexto() + " - num. págs.: " + footer.getNumPaginas() + "\n -------------";
    }
}
