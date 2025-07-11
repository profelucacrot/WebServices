package servicio;

import java.io.Serializable;
import jakarta.xml.bind.annotation.XmlType;

// Clase que representa los datos del clima para una ciudad
@XmlType(name = "Clima")
public class Clima implements Serializable {
    private String ciudad;
    private double temperatura;
    private int humedad;
    private String estado; // Soleado, Lluvioso, Nublado, etc.

    public Clima() {}

    public Clima(String ciudad, double temperatura, int humedad, String estado) {
        this.ciudad = ciudad;
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.estado = estado;
    }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public double getTemperatura() { return temperatura; }
    public void setTemperatura(double temperatura) { this.temperatura = temperatura; }

    public int getHumedad() { return humedad; }
    public void setHumedad(int humedad) { this.humedad = humedad; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
