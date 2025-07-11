package servicio;

import jakarta.xml.ws.Endpoint;

// Publica el servicio SOAP académico
public class Publicador {
    public static void main(String[] args) {
        String url = "http://localhost:8080/soap/registro";
        Endpoint.publish(url, new RegistroServiceImpl());
        System.out.println("Servicio de registro académico disponible en: " + url);
    }
}
