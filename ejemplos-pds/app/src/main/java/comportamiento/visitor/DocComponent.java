package comportamiento.visitor;

public interface DocComponent {
    String accept(DocVisitor visitor);
}
