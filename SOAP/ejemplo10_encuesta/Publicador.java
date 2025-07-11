package servicio;

import jakarta.xml.ws.Endpoint;

// Publica el servicio SOAP de encuesta
public class Publicador {
    public static void main(String[] args) {
        String url = "http://localhost:8080/soap/encuesta";
        Endpoint.publish(url, new EncuestaServiceImpl());
        System.out.println("Servicio de encuesta publicado en: " + url);
    }
}
