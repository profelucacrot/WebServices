package servicio;

import java.util.List;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

// Interfaz que define las operaciones sobre las tareas
@WebService
public interface TareaService {

    @WebMethod
    public Tarea agregar(String descripcion);

    @WebMethod
    public boolean eliminar(int id);

    @WebMethod
    public List<Tarea> listar();

    @WebMethod
    public boolean marcarCompletada(int id);
}
