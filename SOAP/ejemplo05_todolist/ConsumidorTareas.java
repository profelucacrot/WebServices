package cliente;

import servicio.Tarea;
import servicio.TareaService;

import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import java.net.URL;
import java.util.List;

// Cliente para probar gestión de tareas
public class ConsumidorTareas {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:8080/soap/tareas?wsdl");

        QName qname = new QName("http://servicio/", "TareaServiceImplService");
        Service servicio = Service.create(url, qname);

        TareaService tareas = servicio.getPort(TareaService.class);

        Tarea t1 = tareas.agregar("Preparar presentación");
        Tarea t2 = tareas.agregar("Enviar informe");

        tareas.marcarCompletada(t1.getId());

        List<Tarea> todas = tareas.listar();
        for (Tarea t : todas) {
            System.out.println(t.getId() + ": " + t.getDescripcion() +
                (t.isCompletado() ? " [✓]" : " [ ]"));
        }
    }
}
