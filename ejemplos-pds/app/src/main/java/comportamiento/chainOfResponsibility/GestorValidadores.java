package comportamiento.chainOfResponsibility;

public final class GestorValidadores {
    private ValidadorTicket actual = null;

    public void push(ValidadorTicket nuevo) {
        if(actual != null)
            nuevo.setNext(actual);

        actual = nuevo;
    }

    /**
     * Ejecuta las validaciones aplicables a un ticket entregado como parámetros, aplicando los validadores que hayan sido agregados a través del método push(ValidadorTicket).
     *
     * @param ticket Ticket sobre el cual se aplicarán validaciones.
     */
    public EstadoTicket ejecutarValidaciones(Ticket ticket) {
        if(actual == null) {
            return EstadoTicket.APROBADO;
        }

        return actual.validarCadena(ticket);
    }
}
