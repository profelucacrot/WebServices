package servicio;

import java.util.List;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

// Interfaz que define las operaciones disponibles vía SOAP
@WebService
public interface UsuarioService {

    @WebMethod
    public Usuario crear(Usuario u);

    @WebMethod
    public Usuario obtener(int id);

    @WebMethod
    public List<Usuario> listar();

    @WebMethod
    public Usuario actualizar(Usuario u);

    @WebMethod
    public boolean eliminar(int id);
}
