package cliente;

import servicio.Usuario;
import servicio.UsuarioService;

import java.net.URL;
import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;

// Cliente simple para probar el servicio desde una aplicación Java
public class ConsumidorUsuario {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:8080/soap/usuarios?wsdl");

        QName qname = new QName("http://servicio/", "UsuarioServiceImplService");
        Service servicio = Service.create(url, qname);

        UsuarioService cliente = servicio.getPort(UsuarioService.class);

        // Crear un usuario
        Usuario nuevo = new Usuario();
        nuevo.setNombre("Luis");
        nuevo.setEmail("luis@example.com");

        Usuario creado = cliente.crear(nuevo);
        System.out.println("Creado: " + creado.getId());

        // Obtener
        Usuario obtenido = cliente.obtener(creado.getId());
        System.out.println("Obtenido: " + obtenido.getNombre());

        // Actualizar
        obtenido.setNombre("Luis Cabrera");
        cliente.actualizar(obtenido);

        // Listar
        for (Usuario u : cliente.listar()) {
            System.out.println(u.getId() + ": " + u.getNombre() + " - " + u.getEmail());
        }

        // Eliminar
        cliente.eliminar(obtenido.getId());
    }
}
