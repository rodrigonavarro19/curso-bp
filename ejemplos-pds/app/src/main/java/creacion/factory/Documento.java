package creacion.factory;

public class Documento {
    private String nombre;
    private String extension;
    private int tamanio;
    private int antiguedad;

    // Constructor
    public Documento(String nombre, String extension, int tamanio, int antiguedad) {
        this.nombre = nombre;
        this.extension = extension;
        this.tamanio = tamanio;
        this.antiguedad = antiguedad;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getExtension() {
        return extension;
    }

    public int getTamanio() {
        return tamanio;
    }

    public int getAntiguedad() {
        return antiguedad;
    }
}
