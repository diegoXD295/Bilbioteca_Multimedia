package clases;

public class Usuarios {

    public static void main(String[] args) {

        UsuarioManager manager = new UsuarioManager();

        System.out.println("USUARIOS CARGADOS DESDE CSV");
        manager.cargarUsuariosDesdeCSV("src/clases/usuarios.csv");
        manager.listarUsuarios();

        System.out.println("\nCOMPROBAR ID");
        System.out.println("¿ID 1 duplicado? " + manager.idDuplicado(1));
        System.out.println("¿ID 10 duplicado? " + manager.idDuplicado(10));

        System.out.println("\nCOMPROBAR EMAIL");
        System.out.println("¿oier@gmail.com duplicado? " + manager.emailDuplicado("oier@gmail.com"));
        System.out.println("¿otro@gmail.com duplicado? " + manager.emailDuplicado("otro@gmail.com"));

        System.out.println("\nAGREGAR USUARIO");
        Usuario u4 = new Usuario(4, "Unai", "Martinez", "unai@gmail.com", 22, "Hombre");
        if (manager.agregarUsuario(u4)) {
            System.out.println("Usuario agregado correctamente.");
        } else {
            System.out.println("No se pudo agregar.");
        }
        manager.listarUsuarios();

        System.out.println("\nID DUPLICADO");
        Usuario u5 = new Usuario(1, "Pedro", "Perez", "pedro@gmail.com", 30, "Hombre");
        if (manager.agregarUsuario(u5)) {
            System.out.println("Usuario agregado.");
        } else {
            System.out.println("Usuario NO agregado.");
        }

        System.out.println("\nEMAIL DUPLICADO");
        Usuario u6 = new Usuario(6, "Maria", "Gomez", "oier@gmail.com", 30, "Mujer");
        if (manager.agregarUsuario(u6)) {
            System.out.println("Usuario agregado.");
        } else {
            System.out.println("Usuario NO agregado.");
        }

        System.out.println("\nBUSCAR USUARIO");
        Usuario encontrado = manager.buscarPorId(2);
        if (encontrado != null) {
            System.out.println("Usuario encontrado:");
            System.out.println(encontrado);
        } else {
            System.out.println("Usuario no encontrado.");
        }

        System.out.println("\nMODIFICAR USUARIO");
        if (manager.modificarUsuario(2, "Iker", "Garcia Modificado", "iker2@gmail.com", 30, "Hombre")) {
            System.out.println("Usuario modificado correctamente.");
        } else {
            System.out.println("No se pudo modificar.");
        }
        manager.listarUsuarios();

        System.out.println("\nMODIFICAR CON EMAIL DUPLICADO");
        if (manager.modificarUsuario(2, "Iker", "Garcia", "oier@gmail.com", 30, "Hombre")) {
            System.out.println("Usuario modificado.");
        } else {
            System.out.println("Usuario NO modificado.");
        }

        System.out.println("\nELIMINAR USUARIO");
        if (manager.eliminarUsuario(3)) {
            System.out.println("Usuario eliminado correctamente.");
        } else {
            System.out.println("No se pudo eliminar.");
        }
        manager.listarUsuarios();

        System.out.println("\nELIMINAR USUARIO INEXISTENTE");
        if (manager.eliminarUsuario(100)) {
            System.out.println("Usuario eliminado.");
        } else {
            System.out.println("El usuario no existe.");
        }
    }
}
