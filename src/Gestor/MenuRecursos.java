package Gestor;

import clases.Libro;
import clases.Recurso;
import java.util.Scanner;

public class MenuRecursos {

    private GestionRecursos gestor;
    private Scanner scanner;

    public MenuRecursos() {
        this.gestor = new GestionRecursos();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- GESTIÓN DE RECURSOS ---");
            System.out.println("1. Añadir recurso");
            System.out.println("2. Listar recursos");
            System.out.println("3. Modificar recurso (Título y Año)");
            System.out.println("4. Eliminar recurso");
            System.out.println("5. Consultar disponibilidad");
            System.out.println("6. Volver al menú principal");
            System.out.print("Elige una opción: ");

            try {
                // Leemos como texto y lo transformamos a número. Si introducen texto, salta al catch.
                int opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        menuAñadirRecurso();
                        break;
                    case 2:
                        gestor.listarRecursos();
                        break;
                    case 3:
                        menuModificar();
                        break;
                    case 4:
                        System.out.print("Introduce el ID del recurso a eliminar: ");
                        String idEliminar = scanner.nextLine();
                        gestor.eliminarRecurso(idEliminar);
                        break;
                    case 5:
                        System.out.print("Introduce el ID del recurso a consultar: ");
                        String idConsultar = scanner.nextLine();
                        gestor.consultarDisponibilidad(idConsultar);
                        break;
                    case 6:
                        salir = true;
                        break;
                    default:
                        System.out.println("Error: Opción no válida. Elige un número del 1 al 6.");
                }
            } catch (NumberFormatException e) {
            	
                // Cumple el requisito de evitar que el programa cierre por un error de formato
                System.out.println("Error: Debes introducir un número, no texto .");
            }
        }
    }

    // Submenú para añadir recursos con control de errores en los datos
    private void menuAñadirRecurso() {
        System.out.println("\n¿Qué tipo de recurso quieres añadir?");
        System.out.println("1. Libro");
        System.out.println("2. Película");
        System.out.println("3. Videojuego");
        System.out.print("Opción: ");

        try {
            int tipo = Integer.parseInt(scanner.nextLine());

            System.out.print("Introduce el ID: ");
            
            String id = scanner.nextLine();
            
            // Verificamos antes de pedir más datos si el ID ya existe en el gestor
            if (gestor.buscarPorId(id) != null) {
                System.out.println("Error: Ya existe un recurso con ese ID.");
                return; // Corta la ejecución del método y vuelve al menú
            }

            System.out.print("Introduce el Título: ");
            String titulo = scanner.nextLine();

            System.out.print("Introduce el Año de publicación: ");
            int anio = Integer.parseInt(scanner.nextLine()); // Puede lanzar NumberFormatException

            // Todos los recursos nuevos nacen disponibles por defecto
            boolean disponible = true;

            if (tipo == 1) {
                System.out.print("Introduce el Autor: ");
                String autor = scanner.nextLine();
                
                System.out.print("Introduce el número de páginas: ");
                int paginas = Integer.parseInt(scanner.nextLine()); // Puede lanzar NumberFormatException
                
                System.out.print("Introduce la Editorial: ");
                String editorial = scanner.nextLine();

                Libro nuevoLibro = new Libro(id, titulo, anio, disponible, autor, paginas, editorial);
                gestor.agregarRecurso(nuevoLibro);
                
            } else if (tipo == 2) {
                // Aquí pedirías Director, Género y Duración (con Integer.parseInt para la duración si usas int)
                System.out.println("Funcionalidad de película en construcción...");
            } else if (tipo == 3) {
                // Aquí pedirías Plataforma, PEGI (con Integer.parseInt) y Desarrolladora
                System.out.println("Funcionalidad de videojuego en construcción...");
            } else {
                System.out.println("Tipo de recurso no válido.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Error en la creación: Has introducido texto en un campo numérico (Año, Páginas, etc.). Operación cancelada.");
        }
    }

    
    // Submenú para pedir los datos a modificar
    private void menuModificar() {
    	
        System.out.print("Introduce el ID del recurso que quieres modificar: ");
        String id = scanner.nextLine();
        
        System.out.print("Introduce el nuevo título: ");
        String nuevoTitulo = scanner.nextLine();
        
        try {
            System.out.print("Introduce el nuevo año:  ");
            int nuevoAño = Integer.parseInt(scanner.nextLine());
            
            gestor.modificarRecurso(id, nuevoTitulo, nuevoAño);
        } catch (NumberFormatException e) {
            System.out.println("Error al modificar: El año debe ser un número.") ;
            
        }
    }
}
