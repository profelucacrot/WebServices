package servicio;

import jakarta.xml.ws.Endpoint;

// Publica el servicio de inventario
public class Publicador {
    public static void main(String[] args) {
        String url = "http://localhost:8080/soap/inventario";
        Endpoint.publish(url, new InventarioServiceImpl());
        System.out.println("Servicio de inventario publicado en: " + url);
    }
}
