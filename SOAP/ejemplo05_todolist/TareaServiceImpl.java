package servicio;

import java.util.*;
import jakarta.jws.WebService;

// Implementación que guarda tareas en memoria
@WebService(endpointInterface = "servicio.TareaService")
public class TareaServiceImpl implements TareaService {

    private Map<Integer, Tarea> tareas = new HashMap<>();
    private int idActual = 1;

    @Override
    public Tarea agregar(String descripcion) {
        Tarea t = new Tarea(idActual++, descripcion, false);
        tareas.put(t.getId(), t);
        return t;
    }

    @Override
    public boolean eliminar(int id) {
        return tareas.remove(id) != null;
    }

    @Override
    public List<Tarea> listar() {
        return new ArrayList<>(tareas.values());
    }

    @Override
    public boolean marcarCompletada(int id) {
        Tarea t = tareas.get(id);
        if (t != null && !t.isCompletado()) {
            t.setCompletado(true);
            return true;
        }
        return false;
    }
}
