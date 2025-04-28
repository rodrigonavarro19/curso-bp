package comportamiento.visitor;

public interface DocVisitor {
    String visit(DocHeader header);
    String visit(DocBody body);
    String visit(DocFooter footer);
}
