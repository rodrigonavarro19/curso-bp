package creacion.factory.tamanio;

import java.util.Arrays;

import creacion.factory.Documento;
import creacion.factory.OrdenadorDocumentos;

class OrdenadorPorTamanio implements OrdenadorDocumentos {

    private boolean ascendente;

    public OrdenadorPorTamanio(boolean ascendente) {
        this.ascendente = ascendente;
    }

    @Override
    public Documento[] ordenar(Documento[] documentos) {
        Arrays.sort(documentos, (d1, d2) -> {
            int comparacion = Integer.compare(d1.getTamanio(), d2.getTamanio());
            return ascendente ? comparacion : -comparacion;
        });
        return documentos;
    }
}