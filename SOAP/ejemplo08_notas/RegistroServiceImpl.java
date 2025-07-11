package servicio;

import jakarta.jws.WebService;
import java.util.*;

// Implementación de lógica académica
@WebService(endpointInterface = "servicio.RegistroService")
public class RegistroServiceImpl implements RegistroService {

    private List<Asignatura> asignaturas = new ArrayList<>();

    @Override
    public boolean registrar(String nombre, double nota) {
        if (nota < 1.0 || nota > 7.0) {
            return false; // Nota fuera de rango
        }
        asignaturas.add(new Asignatura(nombre, nota));
        return true;
    }

    @Override
    public List<Asignatura> listar() {
        return new ArrayList<>(asignaturas);
    }

    @Override
    public double promedio() {
        if (asignaturas.isEmpty()) return 0.0;
        double suma = 0;
        for (Asignatura a : asignaturas) {
            suma += a.getNota();
        }
        return Math.round((suma / asignaturas.size()) * 100) / 100.0;
    }
}
