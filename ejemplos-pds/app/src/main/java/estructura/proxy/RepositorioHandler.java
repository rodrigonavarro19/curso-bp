package estructura.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import estructura.adapter.nuevo.IRepositorioUsuarios;
import estructura.adapter.nuevo.IUsuario;

class RepositorioHandler implements InvocationHandler {
    private LoggerUsuarios logger;
    private IRepositorioUsuarios repo;

    public RepositorioHandler(IRepositorioUsuarios repo, LoggerUsuarios logger) {
        this.logger = logger;
        this.repo = repo;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(method.getName().equals("agregar")) {
            IUsuario user = (IUsuario) args[0];
            String mensaje = "Se agregó el usuario: " + user.getRut();
            logger.registrar(mensaje);            
        }
        else if(method.getName().equals("eliminar")) {
            String id = (String) args[0];
            String mensaje = "Se eliminó el usuario: " + id;
            logger.registrar(mensaje);
        }

        return method.invoke(repo, args);
    }

}
