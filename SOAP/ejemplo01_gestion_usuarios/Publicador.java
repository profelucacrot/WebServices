package servicio;

import jakarta.xml.ws.Endpoint;

// Publicador del servicio SOAP, arranca el servidor embebido
public class Publicador {
    public static void main(String[] args) {
        String url = "http://localhost:8080/soap/usuarios";
        Endpoint.publish(url, new UsuarioServiceImpl());
        System.out.println("Servicio SOAP publicado en: " + url);
    }
}
