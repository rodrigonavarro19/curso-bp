package creacion.factory.antiguedad;

import java.util.Arrays;

import creacion.factory.Documento;
import creacion.factory.OrdenadorDocumentos;

class OrdenadorPorAntiguedad implements OrdenadorDocumentos {

    private boolean ascendente;

    public OrdenadorPorAntiguedad(boolean ascendente) {
        this.ascendente = ascendente;
    }

    @Override
    public Documento[] ordenar(Documento[] documentos) {
        Arrays.sort(documentos, (d1, d2) -> {
            int comparacion = Integer.compare(d1.getAntiguedad(), d2.getAntiguedad());
            return ascendente ? comparacion : -comparacion;
        });
        return documentos;
    }
}