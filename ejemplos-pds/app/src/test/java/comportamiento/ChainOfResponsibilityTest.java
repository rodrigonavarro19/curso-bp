package comportamiento;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import comportamiento.chainOfResponsibility.EstadoTicket;
import comportamiento.chainOfResponsibility.GestorValidadores;
import comportamiento.chainOfResponsibility.Ticket;
import comportamiento.chainOfResponsibility.ValidadorPalabrasClave;
import comportamiento.chainOfResponsibility.ValidadorUrgencia;

public class ChainOfResponsibilityTest {
    @Test
    public void testUsoTickets() throws Exception {
        GestorValidadores gestor = new GestorValidadores();
        
        gestor.push(new ValidadorUrgencia());
        gestor.push(new ValidadorPalabrasClave(new String[] { "palabra 1", "palabra 2" }));

        Ticket ticket1 = new Ticket(
            0, new Date(), "requirente 1", 
            "este ticket se aprobará palabra 1", 2, "sistema 1");

        Ticket ticket2 = new Ticket(
            1, new Date(), "requirente 2", 
            "este ticket se rechazará", 20, "sistema 2");

        Ticket ticket3 = new Ticket(
            2, new Date(), "requirente 3", 
            "este ticket se rechazará palabra 2", 6, "sistema 2");

        assertEquals(gestor.ejecutarValidaciones(ticket1), EstadoTicket.APROBADO);
        assertEquals(gestor.ejecutarValidaciones(ticket2), EstadoTicket.RECHAZADO);
        assertEquals(gestor.ejecutarValidaciones(ticket3), EstadoTicket.RECHAZADO);
    }
}
