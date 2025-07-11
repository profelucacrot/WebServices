package cliente;

import servicio.EncuestaService;
import servicio.ResultadoPregunta;

import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import java.net.URL;
import java.util.List;

public class ConsumidorEncuesta {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:8080/soap/encuesta?wsdl");

        QName qname = new QName("http://servicio/", "EncuestaServiceImplService");
        Service servicio = Service.create(url, qname);

        EncuestaService encuesta = servicio.getPort(EncuestaService.class);

        // Simula respuestas de varias personas
        encuesta.responder(1, 5);
        encuesta.responder(1, 4);
        encuesta.responder(2, 3);
        encuesta.responder(2, 2);
        encuesta.responder(2, 4);

        List<ResultadoPregunta> resultados = encuesta.obtenerResultados();
        for (ResultadoPregunta r : resultados) {
            System.out.println("Pregunta " + r.getNumero() + ": " + r.getRespuestas() +
                               " -> Promedio: " + encuesta.promedioPregunta(r.getNumero()));
        }
    }
}
