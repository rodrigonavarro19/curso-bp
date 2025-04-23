package creacion.builder.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import creacion.builder.WorkflowOutput;

class JsonWorkflowOutput implements WorkflowOutput {
    private final Object data;

    public JsonWorkflowOutput(Object data) {
        this.data = data;
    }

    @Override
    public String generarSalida() {
        try {
            // Convertir el objeto a un string JSON
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
        } catch (Exception e) {
            throw new RuntimeException("Error al generar la salida JSON", e);
        }
    }
}