package estructura.adapter.legacy;

import java.util.ArrayList;
import java.util.List;

public class RepositorioUsuarios {
    private List<Usuario> usuarios;

    public RepositorioUsuarios() {
        usuarios = new ArrayList<>();    
    }

    public void agregar(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void eliminar(String rut) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getRut().equals(rut)) {
                usuarios.remove(i);
                break;
            }
        }
    }

    public Usuario obtener(String rut) {
        for (Usuario usuario : usuarios) {
            if (usuario.getRut().equals(rut)) {
                return usuario;
            }
        }
        return null;
    }

    public List<Usuario> obtenerTodos() {
        return new ArrayList<>(usuarios);
    }
}
