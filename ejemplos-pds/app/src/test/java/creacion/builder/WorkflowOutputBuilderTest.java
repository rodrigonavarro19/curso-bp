package creacion.builder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import creacion.builder.json.JsonWorkflowOutputBuilder;
import creacion.builder.xml.XmlWorkflowOutputBuilder;

public class WorkflowOutputBuilderTest {

    @Test
    public void testJsonWorkflowOutputBuilder() throws Exception {
        // Crear instancia de JsonWorkflowOutputBuilder
        WorkflowOutputBuilder builder = new JsonWorkflowOutputBuilder();

        // Configurar el objeto usando el builder
        WorkflowOutput output = builder
            .reset()
            .setId(1)
            .setNombre("Workflow de ejemplo")
            .setPadre(0)
            .addEntrada(101)
            .addEntrada(102)
            .addSalida(201)
            .addSalida(202)
            .build();

        // Validar el contenido generado
        String expectedJson = """
        {
          "id" : 1,
          "nombre" : "Workflow de ejemplo",
          "padre" : 0,
          "entradas" : [ 101, 102 ],
          "salidas" : [ 201, 202 ]
        }
        """;

        // Usar ObjectMapper para comparar estructuralmente
        ObjectMapper mapper = new ObjectMapper();
        assertEquals(
            mapper.readTree(expectedJson),
            mapper.readTree(output.generarSalida())
        );
    }

    @Test
    public void testXmlWorkflowOutputBuilder() throws Exception {
        // Crear instancia de XmlWorkflowOutputBuilder
        WorkflowOutputBuilder builder = new XmlWorkflowOutputBuilder();

        // Configurar el objeto usando el builder
        WorkflowOutput output = builder
            .reset()
            .setId(1)
            .setNombre("Workflow de ejemplo")
            .setPadre(0)
            .addEntrada(101)
            .addEntrada(102)
            .addSalida(201)
            .addSalida(202)
            .build();

        // Validar el contenido generado
        String expectedXml = """
        <Workflow>
          <Id>1</Id>
          <Nombre>Workflow de ejemplo</Nombre>
          <Padre>0</Padre>
          <Entradas>
            <Entradas>101</Entradas>
            <Entradas>102</Entradas>
          </Entradas>
          <Salidas>
            <Salidas>201</Salidas>
            <Salidas>202</Salidas>
          </Salidas>
        </Workflow>
        """;

        // Usar XmlMapper para comparar estructuralmente
        com.fasterxml.jackson.dataformat.xml.XmlMapper xmlMapper = new com.fasterxml.jackson.dataformat.xml.XmlMapper();
        assertEquals(
            xmlMapper.readTree(expectedXml),
            xmlMapper.readTree(output.generarSalida())
        );
    }
}