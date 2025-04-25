package estructura.flyweight;

public class SolicitudServicio {
    private int id;
    private String descripcion;
    private Localidad localidad;

    public SolicitudServicio(int id, String descripcion, Localidad localidad) {
        this.id = id;
        this.descripcion = descripcion;
        this.localidad = localidad;
    }
    
    public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Localidad getLocalidad() {
        return localidad;
    }
}
