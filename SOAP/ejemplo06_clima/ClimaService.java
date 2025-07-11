package servicio;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

// Servicio que entrega condiciones climáticas simuladas
@WebService
public interface ClimaService {
    
    @WebMethod
    public Clima obtenerClima(String ciudad);
}
