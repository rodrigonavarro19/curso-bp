package creacion.factory.antiguedad;

import creacion.factory.OrdenadorDocumentos;
import creacion.factory.ProcesadorDocumentos;

public class ProcesadorPorAntiguedad extends ProcesadorDocumentos {

    @Override
    protected OrdenadorDocumentos crearOrdenador(boolean ascendente) {
        return new OrdenadorPorAntiguedad(ascendente);
    }
}