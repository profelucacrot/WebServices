package servicio;

import java.io.Serializable;
import jakarta.xml.bind.annotation.XmlType;

// Clase que representa una reserva de sala
@XmlType(name = "Reserva")
public class Reserva implements Serializable {
    private int id;
    private String nombreSala;
    private String fecha; // Formato "YYYY-MM-DD"
    private int horaInicio; // 0-23
    private int horaFin;

    public Reserva() {}

    public Reserva(int id, String nombreSala, String fecha, int horaInicio, int horaFin) {
        this.id = id;
        this.nombreSala = nombreSala;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombreSala() { return nombreSala; }
    public void setNombreSala(String nombreSala) { this.nombreSala = nombreSala; }

    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }

    public int getHoraInicio() { return horaInicio; }
    public void setHoraInicio(int horaInicio) { this.horaInicio = horaInicio; }

    public int getHoraFin() { return horaFin; }
    public void setHoraFin(int horaFin) { this.horaFin = horaFin; }
}