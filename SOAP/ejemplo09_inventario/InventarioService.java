package servicio;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.List;

// Interfaz para gestión de productos
@WebService
public interface InventarioService {

    @WebMethod
    public Producto agregar(String nombre, int stock, double precio);

    @WebMethod
    public boolean eliminar(int id);

    @WebMethod
    public List<Producto> listar();

    @WebMethod
    public Producto buscarPorId(int id);

    @WebMethod
    public List<Producto> productosBajoStock(int umbral);
}
