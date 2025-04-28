package estructura;

import estructura.adapter.nuevo.IUsuario;
import estructura.adapter.nuevo.Perfil;

// Clase mock para simular IUsuario
public class MockUsuario implements IUsuario {
    private final String rut;
    private final String nombre;
    private final int edad;
    private final Perfil perfil;

    public MockUsuario(String rut, String nombre, int edad, Perfil perfil) {
        this.rut = rut;
        this.nombre = nombre;
        this.edad = edad;
        this.perfil = perfil;
    }

    @Override
    public String getRut() {
        return rut;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public int getEdad() {
        return edad;
    }

    @Override
    public Perfil getPerfil() {
        return perfil;
    }
}