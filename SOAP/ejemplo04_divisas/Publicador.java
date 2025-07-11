package servicio;

import jakarta.xml.ws.Endpoint;

// Publica el servicio SOAP para conversión de divisas
public class Publicador {
    public static void main(String[] args) {
        String url = "http://localhost:8080/soap/divisas";
        Endpoint.publish(url, new ConversorServiceImpl());
        System.out.println("Servicio de divisas publicado en: " + url);
    }
}
