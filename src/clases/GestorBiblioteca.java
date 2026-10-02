package clases;

import java.util.ArrayList;

public class GestorBiblioteca {
    // Aquí están los ArrayList privados, separados del Main
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Recurso> recursos = new ArrayList<>();
    private ArrayList<Prestamo> prestamos = new ArrayList<>();

    // Este es el método que tu compañero modificará para leer el CSV
    public void cargarDatosIniciales() {
        usuarios.add(new Usuario("U1", "Telmo", "telmo@email.com"));
        usuarios.add(new Usuario("U2", "Ibai", "ibai@email.com"));
        usuarios.add(new Usuario("U3", "Ane", "ane@email.com"));

        recursos.add(new Recurso("R1", "El Quijote", 1605));
        recursos.add(new Recurso("R2", "Matrix", 1999));
        recursos.add(new Recurso("R3", "Minecraft", 2011));
        
        System.out.println("Datos cargados correctamente en memoria.\n");
    }

    // --- LÓGICA DE PRÉSTAMOS Y DEVOLUCIONES ---
    public void prestarRecurso(String idUsuario, String idRecurso) throws Exception {
        Usuario u = buscarUsuarioPorId(idUsuario);
        Recurso r = buscarRecursoPorId(idRecurso);

        if (u == null || r == null) {
            throw new Exception("Error: El usuario o el recurso no existen.");
        }
        if (!r.isDisponible()) {
            throw new Exception("Error: El recurso ya está prestado.");
        }

        prestamos.add(new Prestamo(u, r));
        r.setDisponible(false);
        System.out.println("Préstamo de '" + r.getTitulo() + "' realizado con éxito.");
    }

    public void devolverRecurso(String idRecurso) throws Exception {
        for (Prestamo p : prestamos) {
            if (p.getRecurso().getId().equals(idRecurso) && p.isActivo()) {
                p.registrarDevolucion();
                p.getRecurso().setDisponible(true);
                System.out.println("Devolución de '" + p.getRecurso().getTitulo() + "' registrada con éxito.");
                return;
            }
        }
        throw new Exception("Error: No hay préstamos activos para este recurso.");
    }

    // --- BÚSQUEDAS Y CONSULTAS OBLIGATORIAS ---
    public void listarEstadoRecursos() {
        System.out.println("\n-- DISPONIBLES --");
        for (Recurso r : recursos) { if (r.isDisponible()) System.out.println(r); }
        System.out.println("-- PRESTADOS --");
        for (Recurso r : recursos) { if (!r.isDisponible()) System.out.println(r); }
    }

    public void buscarPorTitulo(String titulo) {
        System.out.println("\n-- Búsqueda: " + titulo + " --");
        for (Recurso r : recursos) {
            if (r.getTitulo().equalsIgnoreCase(titulo)) System.out.println("Encontrado: " + r);
        }
    }

    public void listarPrestamosDeUsuario(String idUsuario) {
        System.out.println("\n-- Préstamos del usuario " + idUsuario + " --");
        for (Prestamo p : prestamos) {
            if (p.getUsuario().getId().equals(idUsuario)) System.out.println(p);
        }
    }

    public void listarPrestamosActivos() {
        System.out.println("\n-- Todos los Préstamos Activos --");
        for (Prestamo p : prestamos) {
            if (p.isActivo()) System.out.println(p);
        }
    }

    public void filtrarPorTipo(Class<?> tipo) {
        System.out.println("\n-- Filtrando por tipo: " + tipo.getSimpleName() + " --");
        for (Recurso r : recursos) {
            if (tipo.isInstance(r)) System.out.println(r);
        }
    }

    // --- DOS CONSULTAS ADICIONALES ---
    public void contarRecursosTotales() {
        System.out.println("\nTotal de recursos registrados: " + recursos.size());
    }

    public void mostrarUsuariosConMorosidad() {
        System.out.println("\n-- Usuarios con recursos sin devolver --");
        for (Prestamo p : prestamos) {
            if (p.isActivo()) System.out.println(p.getUsuario().getNombre() + " tiene " + p.getRecurso().getTitulo());
        }
    }

    // Métodos auxiliares de búsqueda interna
    private Usuario buscarUsuarioPorId(String id) {
        for (Usuario u : usuarios) { if (u.getId().equals(id)) return u; }
        return null;
    }
    
    private Recurso buscarRecursoPorId(String id) {
        for (Recurso r : recursos) { if (r.getId().equals(id)) return r; }
        return null;
    }
}