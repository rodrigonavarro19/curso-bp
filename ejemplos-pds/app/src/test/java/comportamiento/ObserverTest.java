package comportamiento;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

import comportamiento.observer.LoggerObserver;
import comportamiento.observer.RepositorioObserver;
import estructura.MockUsuario;
import estructura.adapter.nuevo.IUsuario;
import estructura.adapter.nuevo.Perfil;

public class ObserverTest {
    @Test
    public void testLoggerObserver() {  
        LoggerObserver logger = new LoggerObserver();
        RepositorioObserver repo = new RepositorioObserver();
        repo.registrarReceptor(logger);        

        IUsuario usuario1 = new MockUsuario("1", "Usuario 1", 20, Perfil.ADMIN);
        IUsuario usuario2 = new MockUsuario("2", "Usuario 2", 22, Perfil.USUARIO);

        repo.agregar(usuario1);
        repo.agregar(usuario2);
        repo.eliminar("1");

        String[] mensajes = logger.flush();

        String[] mensajesEsperados = {
            "Se agregó el usuario: 1",
            "Se agregó el usuario: 2",
            "Se eliminó el usuario: 1"
        };

        assertArrayEquals(mensajesEsperados, mensajes);
    }
}
