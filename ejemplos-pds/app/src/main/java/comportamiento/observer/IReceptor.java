package comportamiento.observer;

import estructura.adapter.nuevo.IUsuario;

public interface IReceptor {
    void registrarIngreso(IUsuario agregado);
    void registrarEliminacion(IUsuario eliminado);
}
