package cliente;

import servicio.Reserva;
import servicio.ReservaService;

import javax.xml.namespace.QName;
import jakarta.xml.ws.Service;
import java.net.URL;
import java.util.List;

// Cliente simple para probar el servicio de reservas
public class ConsumidorReserva {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:8080/soap/reservas?wsdl");

        QName qname = new QName("http://servicio/", "ReservaServiceImplService");
        Service servicio = Service.create(url, qname);

        ReservaService rs = servicio.getPort(ReservaService.class);

        Reserva r = new Reserva();
        r.setNombreSala("Sala 101");
        r.setFecha("2025-06-26");
        r.setHoraInicio(10);
        r.setHoraFin(12);

        Reserva creada = rs.crear(r);
        if (creada != null) {
            System.out.println("Reserva creada con ID: " + creada.getId());
        } else {
            System.out.println("La sala ya está reservada en ese horario.");
        }

        List<Reserva> todas = rs.listar();
        for (Reserva reserva : todas) {
            System.out.println(reserva.getId() + " - " + reserva.getNombreSala() + " (" + reserva.getHoraInicio() + "-" + reserva.getHoraFin() + ")");
        }
    }
}
