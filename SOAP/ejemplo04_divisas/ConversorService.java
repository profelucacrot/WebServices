package servicio;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

// Interfaz que define la conversión de divisas
@WebService
public interface ConversorService {

    @WebMethod
    public double convertir(String desde, String hacia, double monto) throws IllegalArgumentException;
}
