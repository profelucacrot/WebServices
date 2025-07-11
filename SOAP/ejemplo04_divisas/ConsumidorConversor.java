package cliente;

import servicio.ConversorService;

import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import java.net.URL;

// Cliente que prueba conversiones entre diferentes monedas
public class ConsumidorConversor {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:8080/soap/divisas?wsdl");

        QName qname = new QName("http://servicio/", "ConversorServiceImplService");
        Service servicio = Service.create(url, qname);

        ConversorService conversor = servicio.getPort(ConversorService.class);

        double clp = conversor.convertir("USD", "CLP", 100);
        double eur = conversor.convertir("CLP", "EUR", 100000);
        double btc = conversor.convertir("USD", "BTC", 128000);

        System.out.println("100 USD a CLP = " + clp);
        System.out.println("100000 CLP a EUR = " + eur);
        System.out.println("128000 USD a BTC = " + btc);
    }
}
