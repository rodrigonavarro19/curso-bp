package estructura.flyweight;

import java.util.HashMap;
import java.util.Map;

public class LocalidadFactory {
    private static Map<Integer, Localidad> cache = new HashMap<>();

    public static Localidad obtenerLocalidad(int id) {
        if(cache.containsKey(id)) {
            return cache.get(id);
        } else {
            Localidad nuevaLocalidad = new Localidad(id, "Localidad " + id);
            cache.put(id, nuevaLocalidad);
            
            return nuevaLocalidad;
        }
    }
}
