package comportamiento.chainOfResponsibility;

public class ValidadorPalabrasClave extends ValidadorTicket {
    private final String[] palabras;

    public ValidadorPalabrasClave(String[] palabras) {
        this.palabras = palabras;
    }

    @Override
    public EstadoTicket validar(Ticket ticket) {
        for (String palabra : palabras) {
            if (ticket.getMensaje().contains(palabra)) {
                return EstadoTicket.APROBADO;
            }
        }
        
        return EstadoTicket.RECHAZADO;
    }

}
