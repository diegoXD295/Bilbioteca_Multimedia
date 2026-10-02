package clases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import main.Main;

public class UsuarioManager {

 // aqui se leen los Usuarios del .csv y se añaden al Arraylist del Usuarios del Main
 	public  static void cargarUsuariosCsv(int numAtributos) {
 		BufferedReader br = null;
 		String linea;
 		int lineaActual = 1;
 		
 		
 		try {
 			br = new BufferedReader(new FileReader("usuarios.csv"));
 			List<Usuario> listaUsuariosTemp = new ArrayList<>();
 			
 			for(int i=1;(linea = br.readLine())!=null;i++, lineaActual++) {
 				if(linea.isBlank()) {continue;}
 				
 				String[] datos = linea.split(",");
 				
 				if (datos.length==numAtributos) {
 					
 					
 					Usuario usuarioTemp = new Usuario(
 							Integer.parseInt(datos[0].trim()),
 							datos[1].trim(),
 							datos[2].trim(),
 							datos[3].trim(),
 							Integer.parseInt(datos[4].trim()),
 							datos[5]);
 					
 					listaUsuariosTemp.add(usuarioTemp);
 					
 					
 					}else if(datos.length>numAtributos) {
 					throw new Exception("El usuario posee más campos de los requeridos. linea("+i+")");
 					}else if(datos.length<numAtributos) {
 					throw new Exception("El usuario posee menos campos de los requeridos. linea("+i+")");
 					}
 				}
 			Main.listaUsuarios = listaUsuariosTemp;
 			System.out.println("\u001B[32m"+"Datos cargados correctamente.☻"+"\u001B[0m\n");
 			
 			 
 			
 			
 		} catch (FileNotFoundException e) {
 			e.printStackTrace();
 		}catch (IOException e) {
 			e.printStackTrace();
 		}catch(NumberFormatException e){
 			System.out.println("\u001B[31m"+"ERROR: El formato de uno de los datos es invalido. linea("+lineaActual+")"+"\u001B[0m\n");
 		}catch (Exception   e) {
 		System.out.println("\u001B[31m"+"ERROR: "+e.getMessage()+"\u001B[0m\n");	
 		}
 		finally {
 			try {
 				br.close();
 			} catch (IOException e) {
 				e.printStackTrace();
 			}
 		}
 			
 		
 	}
 	
//aqui se toman los usuarios del arraylist del Main y se escriben en el .csv
 	public static  void guardarUsuariosCsv() {
 		BufferedWriter bw = null;
 		
 		
 		try {
 			 bw = new BufferedWriter (new FileWriter("usuarios.csv"));
 			 
 			 for(Usuario u : Main.listaUsuarios) {
 				 
 				 String linea = u.getId()+","+u.getNombre()+","+u.getApellido()+","+u.getEmail()+","+u.getEdad()+","+u.getSexo();
 				 
 				 bw.write(linea);
 				 if(u!=Main.listaUsuarios.getLast())
 				 bw.newLine();
 				 
 			 }
 			System.out.println("\u001B[32m"+"Datos Guardados correctamente.☻"+"\u001B[0m\n");
 			 
 		}catch(FileNotFoundException e) {
 			e.printStackTrace();
 		} catch (IOException e) {
 			e.printStackTrace();
 			
 		}finally {
 			try {
 				bw.close();
 			} catch (IOException e) {
 				e.printStackTrace();
 			}
 		}
 		
 	}
 	
//función que detecta si el id que se pasa ya está en el array del Main  (True/False)
    public static boolean idDuplicado(int id) {
        for (Usuario u : Main.listaUsuarios) {
            if (u.getId() == id) {
                return true;
            }
        }
        return false;
    }

//función que detecta si el email que se pasa ya está en el array del Main  (True/False)
    public static boolean emailDuplicado(String email) {
        for (Usuario u : Main.listaUsuarios) {
            if (u.getEmail().equalsIgnoreCase(email)) {
                return true;
            }
        }
        return false;
    }

//Función para ordenar por edad el Array del Main
    public static void ordenarPorEdad() {
        Main.listaUsuarios.sort((u1, u2) -> Integer.compare(u1.getEdad(), u2.getEdad()));
    }
    
//Función para ordenar por ID el Array del Main
    public  static void ordenarPorId() {
        Main.listaUsuarios.sort((u1, u2) -> Integer.compare(u1.getId(), u2.getId()));
    }
    
//función a la que se le pasa un usuario y revisa con las anteriores funciones si es valido,
//si lo es lo añade al array de Main, y devuelve True,
//y si no, solo devuelve False
    public static boolean agregarUsuario(Usuario nuevo) {

        if (idDuplicado(nuevo.getId())) {
            System.out.println("ERROR: ID duplicado.");
            return false;
        }

        if (emailDuplicado(nuevo.getEmail())) {
            System.out.println("ERROR: Email duplicado.");
            return false;
        }

        Main.listaUsuarios.add(nuevo);
        ordenarPorId();
        return true;
    }

    public static void listarUsuarios() {
        for (Usuario u : Main.listaUsuarios) {
            System.out.println(u);
        }
    }

//Devuelve una instancia de Usuario si encuentra una con el ID que se le pasa
    public   static Usuario buscarPorId(int id) {
        for (Usuario u : Main.listaUsuarios) {
            if (u.getId() == id) {
                return u;
            }
        }
        return null;
    }

//Busca al Usuario por ID (Si no existe devuelve salta ERROR), 
//Luego revisa si el nuevo mail es igual al anterior o si ya está en la lista (en ese caso da ERROR),
//en caso de que sea valido modifica los datos del usuario y salta un mensaje de que se ralizó correctamente
    public static void modificarUsuario(int id, String nuevoNombre, String nuevoApellido,
                                    String nuevoEmail, int nuevaEdad, String nuevoSexo) {
try {
        Usuario u = buscarPorId(id);
        if (u == null) {
            throw new Exception("Usuario no encontrado.");
        }

        if (u.getEmail().equalsIgnoreCase(nuevoEmail) || emailDuplicado(nuevoEmail)) {
            throw new Exception("Email duplicado.");
        }

        u.setNombre(nuevoNombre);
        u.setApellido(nuevoApellido);
        u.setEmail(nuevoEmail);
        u.setEdad(nuevaEdad);
        u.setSexo(nuevoSexo);
        
        System.out.println("\u001B[32m"+"Usuario Modificado Correctamente.☻"+"\u001B[0m\n");

        
}catch(Exception e) {
	System.out.println("\u001B[32m"+"ERROR: "+e.getMessage()+"\u001B[0m\n");
}
    }

//Busca al Usuario por ID (Si no existe devuelve salta ERROR),
//pero si lo encuentra lo elimina del array
    public  void eliminarUsuario(int id) {
    	try {
        Usuario u = buscarPorId(id);
        if (u == null) {
           throw new Exception("Usuario no encontrado.");
        }
        Main.listaUsuarios.remove(u);
        
    	}catch(Exception e) {
    		System.out.println("\u001B[32m"+"ERROR: "+e.getMessage()+"\u001B[0m\n");
    	}
    }

}
