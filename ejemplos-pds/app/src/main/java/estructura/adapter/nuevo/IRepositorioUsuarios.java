package estructura.adapter.nuevo;

import java.util.List;

public interface IRepositorioUsuarios {
    void agregar(IUsuario usuario);
    void eliminar(String rut);
    IUsuario obtener(String rut);
    List<IUsuario> obtenerTodos();
    List<IUsuario> obtenerPorPerfil(Perfil perfil);
}