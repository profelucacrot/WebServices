package servicio;

import jakarta.xml.ws.Endpoint;

// Publicador del servicio SOAP para agenda de contactos
public class Publicador {
    public static void main(String[] args) {
        String url = "http://localhost:8080/soap/agenda";
        Endpoint.publish(url, new AgendaServiceImpl());
        System.out.println("Servicio de agenda publicado en: " + url);
    }
}
