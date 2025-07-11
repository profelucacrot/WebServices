package servicio;

import jakarta.jws.WebService;
import java.util.Random;

// Implementación que genera valores aleatorios simulando datos reales
@WebService(endpointInterface = "servicio.ClimaService")
public class ClimaServiceImpl implements ClimaService {

    private String[] condiciones = {"Soleado", "Nublado", "Lluvioso", "Tormenta", "Ventoso"};

    @Override
    public Clima obtenerClima(String ciudad) {
        Random rnd = new Random(ciudad.hashCode());

        double temp = 5 + rnd.nextDouble() * 30; // Temperatura entre 5 y 35 °C
        int humedad = 30 + rnd.nextInt(70);      // Humedad entre 30% y 100%
        String estado = condiciones[rnd.nextInt(condiciones.length)];

        return new Clima(ciudad, Math.round(temp * 10) / 10.0, humedad, estado);
    }
}
