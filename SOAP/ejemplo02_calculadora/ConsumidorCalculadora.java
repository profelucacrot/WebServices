package cliente;

import servicio.CalculadoraService;

import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import java.net.URL;

public class ConsumidorCalculadora {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:8080/soap/calculadora?wsdl");

        QName qname = new QName("http://servicio/", "CalculadoraServiceImplService");
        Service servicio = Service.create(url, qname);

        CalculadoraService calc = servicio.getPort(CalculadoraService.class);

        System.out.println("Suma: " + calc.sumar(10, 5));
        System.out.println("Resta: " + calc.restar(10, 5));
        System.out.println("Multiplicación: " + calc.multiplicar(10, 5));
        System.out.println("División: " + calc.dividir(10, 5));
        System.out.println("Potencia: " + calc.potencia(2, 8));
        System.out.println("Raíz: " + calc.raizCuadrada(16));
    }
}
