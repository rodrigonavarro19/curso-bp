package comportamiento.visitor;

public class DocBody implements DocComponent {
    private String contenido;

    public DocBody(String contenido) {
        this.contenido = contenido;
    }

    public String getContenido() {
        return contenido;
    }

    @Override
    public String accept(DocVisitor visitor) {
        return visitor.visit(this);
    }

}
