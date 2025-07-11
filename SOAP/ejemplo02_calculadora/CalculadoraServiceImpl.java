package servicio;

import jakarta.jws.WebService;

@WebService(endpointInterface = "servicio.CalculadoraService")
public class CalculadoraServiceImpl implements CalculadoraService {

    @Override
    public double sumar(double a, double b) {
        return a + b;
    }

    @Override
    public double restar(double a, double b) {
        return a - b;
    }

    @Override
    public double multiplicar(double a, double b) {
        return a * b;
    }

    @Override
    public double dividir(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero.");
        }
        return a / b;
    }

    @Override
    public double potencia(double base, double exponente) {
        return Math.pow(base, exponente);
    }

    @Override
    public double raizCuadrada(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("No se puede calcular la raíz de un número negativo.");
        }
        return Math.sqrt(valor);
    }
}
