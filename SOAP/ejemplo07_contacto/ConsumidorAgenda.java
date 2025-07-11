package cliente;

import servicio.AgendaService;
import servicio.Contacto;

import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import java.net.URL;
import java.util.List;

public class ConsumidorAgenda {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:8080/soap/agenda?wsdl");

        QName qname = new QName("http://servicio/", "AgendaServiceImplService");
        Service servicio = Service.create(url, qname);

        AgendaService agenda = servicio.getPort(AgendaService.class);

        agenda.agregar("Luis Cabrera", "luis@ubb.cl", "+56912345678");
        agenda.agregar("María Tapia", "maria.tapia@correo.cl", "+56987654321");

        List<Contacto> lista = agenda.listar();
        for (Contacto c : lista) {
            System.out.println(c.getId() + ": " + c.getNombre() + " (" + c.getEmail() + ")");
        }

        List<Contacto> buscados = agenda.buscarPorNombre("Luis");
        System.out.println("Resultados de búsqueda:");
        for (Contacto c : buscados) {
            System.out.println(c.getNombre());
        }
    }
}
