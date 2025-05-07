package comportamiento.observer;

import java.util.ArrayList;
import java.util.List;

import estructura.adapter.nuevo.IRepositorioUsuarios;
import estructura.adapter.nuevo.IUsuario;
import estructura.adapter.nuevo.Perfil;

/** @todo Extraer superclase para evita duplicidad con RepositorioUsuariosImpl.
 */
public class RepositorioObserver implements IRepositorioUsuarios {
    private List<IUsuario> usuarios;
    private List<IReceptor> receptores;

    public RepositorioObserver() {
        usuarios = new ArrayList<>(); 
        receptores = new ArrayList<>();   
    }

    public void registrarReceptor(IReceptor receptor) {
        receptores.add(receptor);
    }

    public void quitarReceptor(IReceptor receptor) {
        receptores.remove(receptor);
    }

    @Override
    public void agregar(IUsuario usuario) {
        usuarios.add(usuario);

        for (IReceptor receptor : receptores)
            receptor.registrarIngreso(usuario);
    }

    @Override
    public void eliminar(String rut) {
        IUsuario eliminado = null;

        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getRut().equals(rut)) {
                eliminado = usuarios.get(i);
                usuarios.remove(i);
                break;
            }
        }

        if(eliminado != null) {
            for (IReceptor receptor : receptores)
                receptor.registrarEliminacion(eliminado);
        }
    }

    @Override
    public IUsuario obtener(String rut) {
        for (IUsuario usuario : usuarios) {
            if (usuario.getRut().equals(rut)) {
                return usuario;
            }
        }
        return null;
    }

    @Override
    public List<IUsuario> obtenerTodos() {
        return new ArrayList<>(usuarios);
    }

    @Override
    public List<IUsuario> obtenerPorPerfil(Perfil perfil) {
        List<IUsuario> usuariosPorPerfil = new ArrayList<>();

        for (IUsuario usuario : usuarios) {
            if (usuario.getPerfil().equals(perfil)) {
                usuariosPorPerfil.add(usuario);
            }
        }
        return usuariosPorPerfil;
    }
}
