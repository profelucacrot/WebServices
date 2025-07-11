package servicio;

import jakarta.jws.WebService;
import java.util.*;
import java.util.regex.Pattern;

// Implementación de la agenda de contactos
@WebService(endpointInterface = "servicio.AgendaService")
public class AgendaServiceImpl implements AgendaService {

    private Map<Integer, Contacto> contactos = new HashMap<>();
    private int idActual = 1;

    private final Pattern emailRegex = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");

    @Override
    public Contacto agregar(String nombre, String email, String telefono) {
        if (!emailRegex.matcher(email).matches()) {
            return null; // email inválido
        }

        Contacto c = new Contacto(idActual++, nombre, email, telefono);
        contactos.put(c.getId(), c);
        return c;
    }

    @Override
    public List<Contacto> listar() {
        return new ArrayList<>(contactos.values());
    }

    @Override
    public boolean eliminar(int id) {
        return contactos.remove(id) != null;
    }

    @Override
    public List<Contacto> buscarPorNombre(String nombreParcial) {
        List<Contacto> resultado = new ArrayList<>();
        for (Contacto c : contactos.values()) {
            if (c.getNombre().toLowerCase().contains(nombreParcial.toLowerCase())) {
                resultado.add(c);
            }
        }
        return resultado;
    }
}
