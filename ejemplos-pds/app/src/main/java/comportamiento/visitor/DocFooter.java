package comportamiento.visitor;

public class DocFooter implements DocComponent {
    private String texto;
    private int numPaginas;

    public DocFooter(String texto, int numPaginas) {
        this.texto = texto;
        this.numPaginas = numPaginas;
    }

    public String getTexto() {
        return texto;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    @Override
    public String accept(DocVisitor visitor) {
        return visitor.visit(this);
    }
}
