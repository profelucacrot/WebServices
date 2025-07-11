package servicio;

import java.io.Serializable;
import jakarta.xml.bind.annotation.XmlType;

// Clase que representa un contacto en la agenda
@XmlType(name = "Contacto")
public class Contacto implements Serializable {
    private int id;
    private String nombre;
    private String email;
    private String telefono;

    public Contacto() {}

    public Contacto(int id, String nombre, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
}
