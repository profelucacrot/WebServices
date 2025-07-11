package servicio;

import java.io.Serializable;
import jakarta.xml.bind.annotation.XmlType;

// Representa una tarea individual
@XmlType(name = "Tarea")
public class Tarea implements Serializable {
    private int id;
    private String descripcion;
    private boolean completado;

    public Tarea() {}

    public Tarea(int id, String descripcion, boolean completado) {
        this.id = id;
        this.descripcion = descripcion;
        this.completado = completado;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public boolean isCompletado() { return completado; }
    public void setCompletado(boolean completado) { this.completado = completado; }
}
