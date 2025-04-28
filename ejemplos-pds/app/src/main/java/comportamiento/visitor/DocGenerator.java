package comportamiento.visitor;

public class DocGenerator {
    private DocHeader header;
    private DocBody body;
    private DocFooter footer;
    private DocVisitor visitor;

    public DocGenerator(DocHeader header, DocBody body, DocFooter footer) {
        this.header = header;
        this.body = body;
        this.footer = footer;
    }

    public void setVisitor(DocVisitor visitor) {
        this.visitor = visitor;
    }

    public String generate() {
        if(visitor == null)
            return "Visitor no configurado.";

        StringBuilder sb = new StringBuilder();

        sb.append(header.accept(visitor));
        sb.append(body.accept(visitor));
        sb.append(footer.accept(visitor));
        
        return sb.toString();
    }
}
