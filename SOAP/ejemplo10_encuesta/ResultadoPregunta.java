package servicio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlType;

// Clase que representa los resultados acumulados de una pregunta
@XmlType(name = "ResultadoPregunta")
public class ResultadoPregunta implements Serializable {
    private int numero;
    private List<Integer> respuestas = new ArrayList<>();

    public ResultadoPregunta() {}

    public ResultadoPregunta(int numero) {
        this.numero = numero;
    }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public List<Integer> getRespuestas() { return respuestas; }
    public void setRespuestas(List<Integer> respuestas) { this.respuestas = respuestas; }

    public void agregarRespuesta(int valor) {
        respuestas.add(valor);
    }

    public double promedio() {
        if (respuestas.isEmpty()) return 0.0;
        int suma = 0;
        for (int r : respuestas) suma += r;
        return Math.round((suma / (double) respuestas.size()) * 100.0) / 100.0;
    }
}
