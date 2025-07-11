package servicio;

import jakarta.xml.ws.Endpoint;

// Publica el servicio en localhost
public class Publicador {
    public static void main(String[] args) {
        String url = "http://localhost:8080/soap/reservas";
        Endpoint.publish(url, new ReservaServiceImpl());
        System.out.println("Servicio de reservas publicado en: " + url);
    }
}
