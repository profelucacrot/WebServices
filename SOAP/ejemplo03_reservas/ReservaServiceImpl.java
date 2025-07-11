package servicio;

import java.util.*;
import jakarta.jws.WebService;

// Implementación con validación de solapamientos
@WebService(endpointInterface = "servicio.ReservaService")
public class ReservaServiceImpl implements ReservaService {

    private Map<Integer, Reserva> reservas = new HashMap<>();
    private int idActual = 1;

    @Override
    public Reserva crear(Reserva r) {
        // Verifica disponibilidad antes de guardar
        for (Reserva existente : reservas.values()) {
            if (r.getNombreSala().equalsIgnoreCase(existente.getNombreSala()) &&
                r.getFecha().equals(existente.getFecha()) &&
                solapan(r.getHoraInicio(), r.getHoraFin(), existente.getHoraInicio(), existente.getHoraFin())) {
                return null; // Ya hay reserva en ese rango
            }
        }

        r.setId(idActual++);
        reservas.put(r.getId(), r);
        return r;
    }

    private boolean solapan(int inicio1, int fin1, int inicio2, int fin2) {
        return inicio1 < fin2 && inicio2 < fin1;
    }

    @Override
    public List<Reserva> listar() {
        return new ArrayList<>(reservas.values());
    }

    @Override
    public boolean eliminar(int id) {
        return reservas.remove(id) != null;
    }
}
