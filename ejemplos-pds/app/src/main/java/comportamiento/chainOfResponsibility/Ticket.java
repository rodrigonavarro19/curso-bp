package comportamiento.chainOfResponsibility;

import java.util.Date;

public class Ticket {
    private int id;
    private Date fecha;
    private String requirente;
    private String mensaje;
    private int urgencia;
    private String sistemaOrigen;

    public Ticket(int id, Date fecha, String requirente, String mensaje, int urgencia, String sistemaOrigen) {
        this.id = id;
        this.fecha = fecha;
        this.requirente = requirente;
        this.mensaje = mensaje;
        this.urgencia = urgencia;
        this.sistemaOrigen = sistemaOrigen;
    }

    public int getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getRequirente() {
        return requirente;
    }
    
    public String getMensaje() {
        return mensaje;
    }

    public int getUrgencia() {
        return urgencia;
    }
    public String getSistemaOrigen() {
        return sistemaOrigen;
    }    
}
