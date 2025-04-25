package estructura.adapter.nuevo;

import java.util.List;

import estructura.adapter.legacy.BDLegacy;
import estructura.adapter.legacy.Usuario;

public class BDNueva {
    private static void migrarDatosAntiguos(IRepositorioUsuarios destino) {
        List<Usuario> antiguos = BDLegacy.crearRepositorio().obtenerTodos();

        for (Usuario usuario : antiguos) {
            IUsuario usuarioAdaptado = new UsuarioAdaptado(usuario);
            destino.agregar(usuarioAdaptado);
        }
    }

    public static IRepositorioUsuarios crearRepositorio() {
        IRepositorioUsuarios repositorio = new RepositorioUsuariosImpl();
        repositorio.agregar(new UsuarioImpl("3", "Usuario 3", 30, Perfil.USUARIO));
        repositorio.agregar(new UsuarioImpl("4", "Usuario 4", 25, Perfil.INVITADO));

        migrarDatosAntiguos(repositorio);        
        return repositorio;
    }
}
