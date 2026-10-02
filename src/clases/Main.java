package clases;

public class Main {
    public static void main(String[] args) {
        GestorBiblioteca gestor = new GestorBiblioteca();

        gestor.cargarDatosIniciales();

        try {
            gestor.prestarRecurso("U1", "R1");
            
            gestor.listarEstadoRecursos();
            gestor.mostrarUsuariosConMorosidad();
            
            System.out.println("\n--- Simulando devolución ---");
            gestor.devolverRecurso("R1");
            gestor.listarEstadoRecursos();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}