package creacion.builder.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import creacion.builder.WorkflowOutput;
import creacion.builder.WorkflowOutputBuilder;

public class JsonWorkflowOutputBuilder implements WorkflowOutputBuilder {
    private final ObjectMapper mapper;
    private ObjectNode rootNode;

    public JsonWorkflowOutputBuilder() {
        this.mapper = new ObjectMapper();
        reset();
    }

    @Override
    public WorkflowOutputBuilder reset() {
        // Reiniciar el objeto JSON
        this.rootNode = mapper.createObjectNode();
        this.rootNode.putArray("entradas");
        this.rootNode.putArray("salidas");
        return this;
    }

    @Override
    public WorkflowOutputBuilder setId(int id) {
        this.rootNode.put("id", id);
        return this;
    }

    @Override
    public WorkflowOutputBuilder setNombre(String nombre) {
        this.rootNode.put("nombre", nombre);
        return this;
    }

    @Override
    public WorkflowOutputBuilder setPadre(int idSuper) {
        this.rootNode.put("padre", idSuper);
        return this;
    }

    @Override
    public WorkflowOutputBuilder addEntrada(int idEntrada) {
        ArrayNode entradas = (ArrayNode) this.rootNode.get("entradas");
        entradas.add(idEntrada);
        return this;
    }

    @Override
    public WorkflowOutputBuilder addSalida(int idSalida) {
        ArrayNode salidas = (ArrayNode) this.rootNode.get("salidas");
        salidas.add(idSalida);
        return this;
    }

    @Override
    public WorkflowOutput build() {
        // Convertir el ObjectNode a una instancia de WorkflowDataJson
        WorkflowDataJson workflowData = mapper.convertValue(this.rootNode, WorkflowDataJson.class);
        return new JsonWorkflowOutput(workflowData);
    }

    @JsonPropertyOrder({ "id", "nombre", "padre", "entradas", "salidas" })
    private static class WorkflowDataJson {
        @JsonProperty("id")
        public int id;

        @JsonProperty("nombre")
        public String nombre;

        @JsonProperty("padre")
        public int padre;

        @JsonProperty("entradas")
        public int[] entradas;

        @JsonProperty("salidas")
        public int[] salidas;
    }
}