package creacion.factory;

import java.util.ArrayList;
import java.util.List;

public abstract class ProcesadorDocumentos {

    // Método abstracto para crear un OrdenadorDocumentos
    protected abstract OrdenadorDocumentos crearOrdenador(boolean ascendente);

    // Método concreto para procesar documentos
    public Documento[] procesar(boolean ascendente) {
        // Crear una lista de 10 documentos con datos ficticios
        List<Documento> documentos = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            documentos.add(new Documento("Documento" + i, ".txt", i * 10, 10 - i));
        }

        // Convertir la lista a un arreglo
        Documento[] documentosArray = documentos.toArray(new Documento[0]);

        // Obtener el ordenador y ordenar los documentos
        OrdenadorDocumentos ordenador = crearOrdenador(ascendente);
        return ordenador.ordenar(documentosArray);
    }
}