package servicio;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.List;

// Interfaz para la gestión de contactos
@WebService
public interface AgendaService {

    @WebMethod
    public Contacto agregar(String nombre, String email, String telefono);

    @WebMethod
    public List<Contacto> listar();

    @WebMethod
    public boolean eliminar(int id);

    @WebMethod
    public List<Contacto> buscarPorNombre(String nombreParcial);
}
