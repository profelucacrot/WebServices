package servicio;

import jakarta.jws.WebService;
import java.util.HashMap;
import java.util.Map;

// Servicio que contiene tasas fijas para convertir entre divisas
@WebService(endpointInterface = "servicio.ConversorService")
public class ConversorServiceImpl implements ConversorService {

    private Map<String, Double> tasas = new HashMap<>();

    public ConversorServiceImpl() {
        // Tasas fijas respecto al dólar (USD)
        tasas.put("USD", 1.0);
        tasas.put("EUR", 0.92);
        tasas.put("CLP", 910.0);
        tasas.put("JPY", 157.0);
        tasas.put("BTC", 1.0 / 64000.0); // Tasa simulada
    }

    @Override
    public double convertir(String desde, String hacia, double monto) throws IllegalArgumentException {
        if (!tasas.containsKey(desde) || !tasas.containsKey(hacia)) {
            throw new IllegalArgumentException("Moneda no soportada.");
        }

        double tasaDesdeUSD = tasas.get(desde);
        double tasaHaciaUSD = tasas.get(hacia);

        double montoEnUSD = monto / tasaDesdeUSD;
        return montoEnUSD * tasaHaciaUSD;
    }
}
