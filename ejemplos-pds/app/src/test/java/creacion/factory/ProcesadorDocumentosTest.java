package creacion.factory;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

import creacion.factory.antiguedad.ProcesadorPorAntiguedad;
import creacion.factory.tamanio.ProcesadorPorTamanio;

public class ProcesadorDocumentosTest {

    @Test
    public void testProcesadorPorTamanioDescendente() {
        // Crear instancia de ProcesadorPorTamanio
        ProcesadorDocumentos procesador = new ProcesadorPorTamanio();

        // Procesar documentos en orden descendente
        Documento[] resultado = procesador.procesar(false);

        // Verificar el orden esperado por nombre
        String[] nombresEsperados = {
            "Documento10", "Documento9", "Documento8", "Documento7", "Documento6",
            "Documento5", "Documento4", "Documento3", "Documento2", "Documento1"
        };
        String[] nombresResultado = new String[resultado.length];
        for (int i = 0; i < resultado.length; i++) {
            nombresResultado[i] = resultado[i].getNombre();
        }

        assertArrayEquals(nombresEsperados, nombresResultado);
    }

    @Test
    public void testProcesadorPorAntiguedadDescendente() {
        // Crear instancia de ProcesadorPorAntiguedad
        ProcesadorDocumentos procesador = new ProcesadorPorAntiguedad();

        // Procesar documentos en orden descendente
        Documento[] resultado = procesador.procesar(false);

        // Verificar el orden esperado por nombre
        String[] nombresEsperados = {
            "Documento1", "Documento2", "Documento3", "Documento4", "Documento5",
            "Documento6", "Documento7", "Documento8", "Documento9", "Documento10"
        };
        String[] nombresResultado = new String[resultado.length];
        for (int i = 0; i < resultado.length; i++) {
            nombresResultado[i] = resultado[i].getNombre();
        }

        assertArrayEquals(nombresEsperados, nombresResultado);
    }
}