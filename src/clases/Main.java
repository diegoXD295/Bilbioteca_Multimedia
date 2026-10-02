package clases;

public class Main {
    public static void main(String[] args) {
        // El Main ahora está limpio. Solo crea el gestor y le da órdenes.
        GestorBiblioteca gestor = new GestorBiblioteca();

        // 1. Cargamos los datos en los ArrayList
        gestor.cargarDatosIniciales();

        try {
            // 2. Ejecutamos un préstamo
            gestor.prestarRecurso("U1", "R1");
            
            // 3. Imprimimos el estado y las consultas
            gestor.listarEstadoRecursos();
            gestor.mostrarUsuariosConMorosidad();
            
            // 4. Devolvemos el recurso
            System.out.println("\n--- Simulando devolución ---");
            gestor.devolverRecurso("R1");
            gestor.listarEstadoRecursos();
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}