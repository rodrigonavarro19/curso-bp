package comportamiento;

import comportamiento.visitor.DocBody;
import comportamiento.visitor.DocFooter;
import comportamiento.visitor.DocGenerator;
import comportamiento.visitor.DocHeader;
import comportamiento.visitor.HTMLVisitor;
import comportamiento.visitor.PlainTextVisitor;

public class VisitorTest {

    public static void main(String[] args) {
        DocHeader header = new DocHeader("Título del Documento", "Autor del Documento");
        DocBody body = new DocBody("Contenido del documento...");
        DocFooter footer = new DocFooter("Texto del pie de página", 5);
        DocGenerator docGenerator = new DocGenerator(header, body, footer);

        PlainTextVisitor plainTextVisitor = new PlainTextVisitor();
        docGenerator.setVisitor(plainTextVisitor);
        System.out.println("Texto plano:\n" + docGenerator.generate());

        System.out.println();

        HTMLVisitor htmlVisitor = new HTMLVisitor();
        docGenerator.setVisitor(htmlVisitor);
        System.out.println("HTML:\n" + docGenerator.generate());
    }
}
