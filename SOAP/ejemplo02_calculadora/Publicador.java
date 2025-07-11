package servicio;

import jakarta.xml.ws.Endpoint;

// Clase que publica el servicio SOAP en un puerto y contexto determinado
public class Publicador {
    public static void main(String[] args) {
        String url = "http://localhost:8080/soap/calculadora";
        Endpoint.publish(url, new CalculadoraServiceImpl());
        System.out.println("Servicio de Calculadora publicado en: " + url);
    }
}
