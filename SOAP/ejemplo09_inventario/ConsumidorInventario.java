package cliente;

import servicio.Producto;
import servicio.InventarioService;

import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import java.net.URL;
import java.util.List;

// Cliente que consume el servicio SOAP de inventario
public class ConsumidorInventario {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:8080/soap/inventario?wsdl");

        QName qname = new QName("http://servicio/", "InventarioServiceImplService");
        Service servicio = Service.create(url, qname);

        InventarioService inventario = servicio.getPort(InventarioService.class);

        inventario.agregar("Notebook HP", 10, 520000);
        inventario.agregar("Mouse inalámbrico", 3, 8500);
        inventario.agregar("Teclado mecánico", 2, 45000);

        List<Producto> todos = inventario.listar();
        System.out.println("Inventario completo:");
        for (Producto p : todos) {
            System.out.println(p.getNombre() + " (" + p.getStock() + " unid)");
        }

        List<Producto> escasos = inventario.productosBajoStock(5);
        System.out.println("Productos con stock bajo:");
        for (Producto p : escasos) {
            System.out.println(p.getNombre() + ": " + p.getStock());
        }
    }
}
