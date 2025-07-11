package servicio;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

// Interfaz que define las operaciones expuestas vía SOAP
@WebService
public interface CalculadoraService {

    @WebMethod
    public double sumar(double a, double b);

    @WebMethod
    public double restar(double a, double b);

    @WebMethod
    public double multiplicar(double a, double b);

    @WebMethod
    public double dividir(double a, double b) throws IllegalArgumentException;

    @WebMethod
    public double potencia(double base, double exponente);

    @WebMethod
    public double raizCuadrada(double valor) throws IllegalArgumentException;
}
