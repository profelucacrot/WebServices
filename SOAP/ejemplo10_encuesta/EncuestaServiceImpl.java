package servicio;

import jakarta.jws.WebService;
import java.util.*;

// Implementación del servicio de encuesta
@WebService(endpointInterface = "servicio.EncuestaService")
public class EncuestaServiceImpl implements EncuestaService {

    private Map<Integer, ResultadoPregunta> preguntas = new HashMap<>();

    @Override
    public boolean responder(int numeroPregunta, int valor) {
        if (valor < 1 || valor > 5) return false;

        ResultadoPregunta rp = preguntas.get(numeroPregunta);
        if (rp == null) {
            rp = new ResultadoPregunta(numeroPregunta);
            preguntas.put(numeroPregunta, rp);
        }
        rp.agregarRespuesta(valor);
        return true;
    }

    @Override
    public List<ResultadoPregunta> obtenerResultados() {
        return new ArrayList<>(preguntas.values());
    }

    @Override
    public double promedioPregunta(int numeroPregunta) {
        ResultadoPregunta rp = preguntas.get(numeroPregunta);
        if (rp == null) return 0.0;
        return rp.promedio();
    }
}
