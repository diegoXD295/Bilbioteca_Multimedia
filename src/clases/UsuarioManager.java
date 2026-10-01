package clases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class UsuarioManager {

    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public void cargarUsuariosDesdeCSV(String rutaCSV) {
        usuarios.clear();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaCSV))) {
  
            String linea;
            boolean primera = true;

            while ((linea = br.readLine()) != null) {

                if (primera) {
                    primera = false;
                    continue;
                }

                String[] datos = linea.split(",");

                Usuario u = new Usuario(
                        Integer.parseInt(datos[0]),
                        datos[1],
                        datos[2],
                        datos[3],
                        Integer.parseInt(datos[4]),
                        datos[5]
                );

                usuarios.add(u);
            }

            ordenarPorEdad();

        } catch (Exception e) {
            System.out.println("ERROR leyendo CSV: " + e.getMessage());
        }
    }

    public boolean idDuplicado(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean emailDuplicado(String email) {
        for (Usuario u : usuarios) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

    public void ordenarPorEdad() {
        usuarios.sort((u1, u2) -> Integer.compare(u1.getEdad(), u2.getEdad()));
    }

    public boolean agregarUsuario(Usuario nuevo) {

        if (idDuplicado(nuevo.getId())) {
            System.out.println("ERROR: ID duplicado.");
            return false;
        }

        if (emailDuplicado(nuevo.getEmail())) {
            System.out.println("ERROR: Email duplicado.");
            return false;
        }

        usuarios.add(nuevo);
        ordenarPorEdad();
        return true;
    }

    public void listarUsuarios() {
        for (Usuario u : usuarios) {
            System.out.println(u);
        }
    }

    public Usuario buscarPorId(int id) {
        for (Usuario u : usuarios) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

    public boolean modificarUsuario(int id, String nuevoNombre, String nuevoApellido,
                                    String nuevoEmail, int nuevaEdad, String nuevoSexo) {

        Usuario u = buscarPorId(id);
        if (u == null) {
            return false;
        }

        if (!u.getEmail().equalsIgnoreCase(nuevoEmail) && emailDuplicado(nuevoEmail)) {
            System.out.println("ERROR: Email duplicado.");
            return false;
        }

        u.setNombre(nuevoNombre);
        u.setApellido(nuevoApellido);
        u.setEmail(nuevoEmail);
        u.setEdad(nuevaEdad);
        u.setSexo(nuevoSexo);

        ordenarPorEdad();
        return true;
    }

    public boolean eliminarUsuario(int id) {
        Usuario u = buscarPorId(id);
        if (u == null) {
            return false;
        }
        usuarios.remove(u);
        return true;
    }
}
