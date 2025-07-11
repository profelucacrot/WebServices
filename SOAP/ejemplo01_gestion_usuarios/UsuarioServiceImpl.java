package servicio;

import java.util.*;
import jakarta.jws.WebService;

// Implementación de la interfaz expuesta como servicio SOAP
@WebService(endpointInterface = "servicio.UsuarioService")
public class UsuarioServiceImpl implements UsuarioService {

    private Map<Integer, Usuario> usuarios = new HashMap<>();
    private int idActual = 1;

    @Override
    public Usuario crear(Usuario u) {
        u.setId(idActual++);
        usuarios.put(u.getId(), u);
        return u;
    }

    @Override
    public Usuario obtener(int id) {
        return usuarios.get(id);
    }

    @Override
    public List<Usuario> listar() {
        return new ArrayList<>(usuarios.values());
    }

    @Override
    public Usuario actualizar(Usuario u) {
        if (usuarios.containsKey(u.getId())) {
            usuarios.put(u.getId(), u);
            return u;
        }
        return null;
    }

    @Override
    public boolean eliminar(int id) {
        return usuarios.remove(id) != null;
    }
}
