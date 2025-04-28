package comportamiento.chainOfResponsibility;

public abstract class ValidadorTicket {
    protected ValidadorTicket next;
    
    public void setNext(ValidadorTicket next) {
        this.next = next;
    }

    public final EstadoTicket validarCadena(Ticket ticket) {
        EstadoTicket resultado = validar(ticket);

        if (resultado == EstadoTicket.APROBADO && next != null) {
            return next.validarCadena(ticket);
        }

        return resultado;
    }

    protected abstract EstadoTicket validar(Ticket ticket);
}
