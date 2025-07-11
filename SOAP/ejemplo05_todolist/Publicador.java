package servicio;

import jakarta.xml.ws.Endpoint;

// Publica el servicio en localhost
public class Publicador {
    public static void main(String[] args) {
        String url = "http://localhost:8080/soap/tareas";
        Endpoint.publish(url, new TareaServiceImpl());
        System.out.println("Servicio de tareas publicado en: " + url);
    }
}
