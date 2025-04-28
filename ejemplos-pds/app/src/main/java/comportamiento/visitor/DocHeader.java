package comportamiento.visitor;

public class DocHeader implements DocComponent {
    private String titulo;
    private String autor;

    public DocHeader(String titulo, String autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public String accept(DocVisitor visitor) {
        return visitor.visit(this);
    }
}
