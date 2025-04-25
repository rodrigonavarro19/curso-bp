package estructura.adapter.nuevo;

import java.util.ArrayList;
import java.util.List;

class RepositorioUsuariosImpl implements IRepositorioUsuarios {
    private List<IUsuario> usuarios;

    public RepositorioUsuariosImpl() {
        usuarios = new ArrayList<>();    
    }

    @Override
    public void agregar(IUsuario usuario) {
        usuarios.add(usuario);
    }

    @Override
    public void eliminar(String rut) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getRut().equals(rut)) {
                usuarios.remove(i);
                break;
            }
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
