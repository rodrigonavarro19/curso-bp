package comportamiento.observer;

import java.util.ArrayList;
import java.util.List;

import estructura.adapter.nuevo.IUsuario;

// TODO: extraer superclase para evita duplicidad con LoggerUsuarios
public class LoggerObserver implements IReceptor {
    private List<String> colaMensajes = new ArrayList<>();

    @Override
    public void registrarIngreso(IUsuario agregado) {
        colaMensajes.add("Se agregó el usuario: " + agregado.getRut());
    }

    @Override
    public void registrarEliminacion(IUsuario eliminado) {
        colaMensajes.add("Se eliminó el usuario: " + eliminado.getRut());
    }

    public String[] flush() {
        String[] res = colaMensajes.toArray(new String[0]);
        colaMensajes.clear();

        return res;
    }
}
