package comportamiento.chainOfResponsibility;

public class ValidadorUrgencia extends ValidadorTicket {

    @Override
    public EstadoTicket validar(Ticket ticket) {
        if (ticket.getUrgencia() < 3) {
            return EstadoTicket.APROBADO;
        } 
        else if(ticket.getUrgencia() < 5) {
            return EstadoTicket.EN_ESPERA;
        }
        else {
            return EstadoTicket.RECHAZADO;
        }
    }
}
