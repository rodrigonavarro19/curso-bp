package estructura.adapter.nuevo;

class UsuarioImpl implements IUsuario {    
    private String rut;
    private String nombre;
    private int edad;
    private Perfil perfil;

    public UsuarioImpl(String rut, String nombre, int edad, Perfil perfil) {
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
