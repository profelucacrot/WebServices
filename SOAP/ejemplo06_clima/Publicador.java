package servicio;

import jakarta.xml.ws.Endpoint;

// Publicador del servicio del clima
public class Publicador {
    public static void main(String[] args) {
        String url = "http://localhost:8080/soap/clima";
        Endpoint.publish(url, new ClimaServiceImpl());
        System.out.println("Servicio climático publicado en: " + url);
    }
}
