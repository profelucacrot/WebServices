package servicio;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.List;

// Servicio para registrar asignaturas y calcular promedio
@WebService
public interface RegistroService {

    @WebMethod
    public boolean registrar(String nombre, double nota);

    @WebMethod
    public List<Asignatura> listar();

    @WebMethod
    public double promedio();
}
