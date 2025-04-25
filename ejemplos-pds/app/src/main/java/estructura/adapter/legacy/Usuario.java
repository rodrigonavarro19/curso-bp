package estructura.adapter.legacy;

public class Usuario {
    private String rut;
    private String nombre;
    private int edad;
    private String perfil;

    public Usuario(String rut, String nombre, int edad, String perfil) {
        this.rut = rut;
        this.nombre = nombre;
        this.edad = edad;
        this.perfil = perfil;
    }

    public String getRut() {
        return rut;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getPerfil() {
        return perfil;
    }
}
