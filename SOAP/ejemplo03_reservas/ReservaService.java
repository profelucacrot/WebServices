package servicio;

import java.util.List;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

// Interfaz SOAP para gestionar reservas
@WebService
public interface ReservaService {

    @WebMethod
    public Reserva crear(Reserva r);

    @WebMethod
    public List<Reserva> listar();

    @WebMethod
    public boolean eliminar(int id);
}
