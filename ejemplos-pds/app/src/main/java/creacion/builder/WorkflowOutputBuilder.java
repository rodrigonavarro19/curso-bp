package creacion.builder;

public interface WorkflowOutputBuilder {
    WorkflowOutputBuilder reset();
    WorkflowOutputBuilder setId(int id);
    WorkflowOutputBuilder setNombre(String nombre);
    WorkflowOutputBuilder setPadre(int idSuper);
    WorkflowOutputBuilder addEntrada(int idEntrada);
    WorkflowOutputBuilder addSalida(int idSalida);
    WorkflowOutput build();
}
