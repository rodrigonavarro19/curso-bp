package estructura;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

import estructura.adapter.nuevo.BDNueva;
import estructura.adapter.nuevo.IRepositorioUsuarios;
import estructura.adapter.nuevo.IUsuario;
import estructura.adapter.nuevo.Perfil;
import estructura.proxy.LoggerUsuarios;

// Clase de prueba
public class LoggerUsuariosTest {

    @Test
    public void testLoggerUsuarios() {
        // Crear instancia de LoggerUsuarios
        LoggerUsuarios logger = new LoggerUsuarios();

        // Obtener el repositorio desde BDNueva
        IRepositorioUsuarios repositorioBase = BDNueva.crearRepositorio();

        // Inicializar el repositorio con el proxy
        IRepositorioUsuarios repositorio = logger.inicializar(repositorioBase);

        // Crear mocks de usuarios
        IUsuario usuario1 = new MockUsuario("1", "Usuario 1", 20, Perfil.ADMIN);
        IUsuario usuario2 = new MockUsuario("2", "Usuario 2", 22, Perfil.USUARIO);

        // Realizar operaciones con el repositorio
        repositorio.agregar(usuario1);
        repositorio.agregar(usuario2);
        repositorio.eliminar("1");

        // Obtener el stack de mensajes generados
        String[] mensajes = logger.flush();

        // Validar que los mensajes sean correctos
        String[] mensajesEsperados = {
            "Se agregó el usuario: 1",
            "Se agregó el usuario: 2",
            "Se eliminó el usuario: 1"
        };
        
        assertArrayEquals(mensajesEsperados, mensajes);
    }
}