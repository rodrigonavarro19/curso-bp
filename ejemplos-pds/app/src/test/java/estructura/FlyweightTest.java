package estructura;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openjdk.jol.info.GraphLayout;

import estructura.flyweight.Localidad;
import estructura.flyweight.LocalidadFactory;
import estructura.flyweight.SolicitudServicio;

public class FlyweightTest {
    public static void main(String[] args) {
        List<SolicitudServicio> solicitudes1 = new ArrayList<>();
        int seed = new Random().nextInt(1000);
        Random rand = new Random(seed);

        for (int i = 0; i < seed; i++) {
            int id = rand.nextInt(10) + 1;
            Localidad localidad = new Localidad(id, "Localidad " + id);
            SolicitudServicio solicitud = new SolicitudServicio(i, "Solicitud " + i, localidad);
            solicitudes1.add(solicitud);
        }

        System.out.println("Tamaño de la lista sin Flyweight: " + (GraphLayout.parseInstance(solicitudes1).totalSize() / 1024000d) + " MB");

        List<SolicitudServicio> solicitudes2 = new ArrayList<>();
        rand = new Random(seed);

        for (int i = 0; i < seed; i++) {
            int id = rand.nextInt(10) + 1;
            Localidad localidad = LocalidadFactory.obtenerLocalidad(id);
            SolicitudServicio solicitud = new SolicitudServicio(i, "Solicitud " + i, localidad);
            solicitudes2.add(solicitud);
        }

        System.out.println("Tamaño de la lista con Flyweight: " + (GraphLayout.parseInstance(solicitudes2).totalSize() / 1024000d) + " MB");
    }
}
