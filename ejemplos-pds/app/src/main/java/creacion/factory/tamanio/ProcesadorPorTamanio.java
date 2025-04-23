package creacion.factory.tamanio;

import creacion.factory.OrdenadorDocumentos;
import creacion.factory.ProcesadorDocumentos;

public class ProcesadorPorTamanio extends ProcesadorDocumentos {

    @Override
    protected OrdenadorDocumentos crearOrdenador(boolean ascendente) {
        return new OrdenadorPorTamanio(ascendente);
    }
}