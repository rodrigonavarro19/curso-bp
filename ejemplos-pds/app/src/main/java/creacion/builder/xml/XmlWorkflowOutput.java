package creacion.builder.xml;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import creacion.builder.WorkflowOutput;

class XmlWorkflowOutput implements WorkflowOutput {
    private final Object data;

    public XmlWorkflowOutput(Object data) {
        this.data = data;
    }

    @Override
    public String generarSalida() {
        try {
            // Convertir el objeto a un string XML
            XmlMapper xmlMapper = new XmlMapper();
            return xmlMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
        } catch (Exception e) {
            throw new RuntimeException("Error al generar la salida XML", e);
        }
    }
}