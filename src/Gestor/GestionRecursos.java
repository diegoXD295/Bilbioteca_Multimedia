package Gestor;

import clases.Recurso;
import java.util.ArrayList;

public class GestionRecursos {

    // Colección para el almacenamiento temporal en memoria
    private ArrayList<Recurso> listaRecursos;

    // Constructor que inicializa la lista vacía
    public GestionRecursos() {
        this.listaRecursos = new ArrayList<>();
    }

    //metodo para buscar por id
    public Recurso buscarPorId(String id) {
        for (Recurso r : listaRecursos) {
            if (r.getId().equals(id)) {
                return r; 				// Devuelve el recurso si lo encuentra si no, null 
            }
        }
        return null; 
    }

    //  Añade un recurso sin que haya ningun id duplicado
    public void agregarRecurso(Recurso nuevoRecurso) {
    	
        // aqui comprobamos si el ID ya existe
        if (buscarPorId(nuevoRecurso.getId()) != null) {
            System.out.println("Error: Ya existe un recurso con el ID " + nuevoRecurso.getId());
        } else {
             listaRecursos.add(nuevoRecurso);
            System.out.println("Recurso añadido correctamente.");
        }
    }

    // lista  todos los recursos  con el toString
    public void listarRecursos() {
        if (listaRecursos.isEmpty()) {
        	
            System.out.println("No hay recursos registrados en la biblioteca.");
            return;
        }
        
        for (Recurso r : listaRecursos) {
            System.out.println(r.toString());
        }
    }
    
    
 //  Busca un recurso por ID y lo borra de la lista
    public void eliminarRecurso(String id) {
    	
        Recurso recurso = buscarPorId(id);
        if (recurso != null) {
            listaRecursos.remove(recurso);
            System.out.println("Recurso eliminado correctamente.");
        } else {
            System.out.println("Error: No se ha encontrado ningún recurso con el ID " + id + ".");
        }
    }

    //Permite editar los atributos generales de un recurso
    public void modificarRecurso(String id, String nuevoTitulo,  int nuevoAño) {
        Recurso recurso = buscarPorId(id);
        if (recurso != null) {
            recurso.setTitulo(nuevoTitulo);
                        recurso.setAño(nuevoAño); 
            System.out.println("Recurso modificado correctamente.");
        } else {
            System.out.println("Error: No se ha encontrado el recurso para modificar.");
        }
    }

    // Compruebaa si un recurso está libre o prestado
    public void consultarDisponibilidad(String id) {
        Recurso recurso = buscarPorId(id );
        if (recurso != null) {
            if (recurso.isDisponible()) {
                System.out.println("El recurso '" + recurso.getTitulo() + "' está DISPONIBLE.");
            } else {
                System.out.println("El recurso '" + recurso.getTitulo() + "' está PRESTADO.");
                
            }
        } else {
            System.out.println("Error:  El recurso con ID " + id + " no existe.");
        }
    }
}