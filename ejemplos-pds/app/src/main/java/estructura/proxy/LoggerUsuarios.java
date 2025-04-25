package estructura.proxy;

import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

import estructura.adapter.nuevo.IRepositorioUsuarios;

public class LoggerUsuarios {
    private IRepositorioUsuarios repo;
    private List<String> colaMensajes = new ArrayList<>();

    public IRepositorioUsuarios inicializar(IRepositorioUsuarios base) {
        return (IRepositorioUsuarios) Proxy.newProxyInstance(
            this.getClass().getClassLoader(),
            new Class[] { IRepositorioUsuarios.class },
            new RepositorioHandler(base, this)
        );
    }

    public void registrar(String mensaje) {
        colaMensajes.add(mensaje);
    }

    public String[] flush() {
        String[] res = colaMensajes.toArray(new String[0]);
        colaMensajes.clear();

        return res;
    }
}
