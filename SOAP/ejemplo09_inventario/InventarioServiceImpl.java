package servicio;

import jakarta.jws.WebService;
import java.util.*;

// Implementación de inventario
@WebService(endpointInterface = "servicio.InventarioService")
public class InventarioServiceImpl implements InventarioService {

    private Map<Integer, Producto> productos = new HashMap<>();
    private int idActual = 1;

    @Override
    public Producto agregar(String nombre, int stock, double precio) {
        Producto p = new Producto(idActual++, nombre, stock, precio);
        productos.put(p.getId(), p);
        return p;
    }

    @Override
    public boolean eliminar(int id) {
        return productos.remove(id) != null;
    }

    @Override
    public List<Producto> listar() {
        return new ArrayList<>(productos.values());
    }

    @Override
    public Producto buscarPorId(int id) {
        return productos.get(id);
    }

    @Override
    public List<Producto> productosBajoStock(int umbral) {
        List<Producto> resultado = new ArrayList<>();
        for (Producto p : productos.values()) {
            if (p.getStock() < umbral) {
                resultado.add(p);
            }
        }
        return resultado;
    }
}
