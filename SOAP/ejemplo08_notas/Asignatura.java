package servicio;

import java.io.Serializable;
import jakarta.xml.bind.annotation.XmlType;

// Representa una asignatura con su nota
@XmlType(name = "Asignatura")
public class Asignatura implements Serializable {
    private String nombre;
    private double nota;

    public Asignatura() {}

    public Asignatura(String nombre, double nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getNota() { return nota; }
    public void setNota(double nota) { this.nota = nota; }
}
