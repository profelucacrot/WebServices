package servicio;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import java.util.List;

// Interfaz que expone las operaciones del sistema de encuesta
@WebService
public interface EncuestaService {

    @WebMethod
    public boolean responder(int numeroPregunta, int valor); // entre 1 y 5

    @WebMethod
    public List<ResultadoPregunta> obtenerResultados();

    @WebMethod
    public double promedioPregunta(int numeroPregunta);
}
