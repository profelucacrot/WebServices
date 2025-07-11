package cliente;

import servicio.Asignatura;
import servicio.RegistroService;

import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import java.net.URL;
import java.util.List;

public class ConsumidorRegistro {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:8080/soap/registro?wsdl");

        QName qname = new QName("http://servicio/", "RegistroServiceImplService");
        Service servicio = Service.create(url, qname);

        RegistroService registro = servicio.getPort(RegistroService.class);

        registro.registrar("Estructuras de Datos", 6.0);
        registro.registrar("Arquitectura", 5.5);
        registro.registrar("IA", 6.8); // fuera de rango, no debería agregarse

        List<Asignatura> lista = registro.listar();
        System.out.println("Asignaturas registradas:");
        for (Asignatura a : lista) {
            System.out.println("- " + a.getNombre() + ": " + a.getNota());
        }

        System.out.println("Promedio general: " + registro.promedio());
    }
}
