package creacion.builder.xml;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import creacion.builder.WorkflowOutput;
import creacion.builder.WorkflowOutputBuilder;

public class XmlWorkflowOutputBuilder implements WorkflowOutputBuilder {
    private WorkflowData workflowData;

    public XmlWorkflowOutputBuilder() {
        reset();
    }

    @Override
    public WorkflowOutputBuilder reset() {
        // Reiniciar el objeto WorkflowData
        this.workflowData = new WorkflowData();
        return this;
    }

    @Override
    public WorkflowOutputBuilder setId(int id) {
        this.workflowData.id = id;
        return this;
    }

    @Override
    public WorkflowOutputBuilder setNombre(String nombre) {
        this.workflowData.nombre = nombre;
        return this;
    }

    @Override
    public WorkflowOutputBuilder setPadre(int idSuper) {
        this.workflowData.padre = idSuper;
        return this;
    }

    @Override
    public WorkflowOutputBuilder addEntrada(int idEntrada) {
        this.workflowData.entradas.add(idEntrada);
        return this;
    }

    @Override
    public WorkflowOutputBuilder addSalida(int idSalida) {
        this.workflowData.salidas.add(idSalida);
        return this;
    }

    @Override
    public WorkflowOutput build() {
        // Retornar una instancia de XmlWorkflowOutput con los datos configurados
        return new XmlWorkflowOutput(this.workflowData);
    }

    @JsonRootName("Workflow")
    @JsonPropertyOrder({ "id", "nombre", "padre", "entradas", "salidas" })
    private static class WorkflowData {
        @JsonProperty("Id")
        public int id;

        @JsonProperty("Nombre")
        public String nombre;

        @JsonProperty("Padre")
        public int padre;

        @JsonProperty("Entradas")
        public List<Integer> entradas = new ArrayList<>();

        @JsonProperty("Salidas")
        public List<Integer> salidas = new ArrayList<>();
    }
}