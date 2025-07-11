package cliente;

import servicio.Clima;
import servicio.ClimaService;

import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import java.net.URL;

public class ConsumidorClima {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:8080/soap/clima?wsdl");

        QName qname = new QName("http://servicio/", "ClimaServiceImplService");
        Service servicio = Service.create(url, qname);

        ClimaService clima = servicio.getPort(ClimaService.class);

        String[] ciudades = {"Concepción", "Santiago", "Temuco"};

        for (String ciudad : ciudades) {
            Clima c = clima.obtenerClima(ciudad);
            System.out.println(ciudad + ": " + c.getTemperatura() + "°C, " +
                               c.getHumedad() + "%, " + c.getEstado());
        }
    }
}
