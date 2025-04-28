package comportamiento.chainOfResponsibility;

public final class GestorValidadores {
    private ValidadorTicket actual = null;

    public void push(ValidadorTicket nuevo) {
        if(actual != null)
            nuevo.setNext(actual);

        actual = nuevo;
    }

    public EstadoTicket ejecutarValidaciones(Ticket ticket) {
        if(actual == null) {
            return EstadoTicket.APROBADO;
        }

        return actual.validarCadena(ticket);
    }
}
