package estructura.adapter.legacy;

public class BDLegacy {
    public static RepositorioUsuarios crearRepositorio() {
        RepositorioUsuarios repositorio = new RepositorioUsuarios();

        repositorio.agregar(new Usuario("1", "Usuario 1", 30, "Admin"));
        repositorio.agregar(new Usuario("2", "Usuario 2", 25, "User"));
        
        return repositorio;
    }
}
