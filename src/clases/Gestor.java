package clases;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import main.Main;

public class Gestor {
	
	
		
// aqui se leen los Usuarios del .csv y se añaden al Arraylist del Usuarios del Main
	public static void cargarUsuariosCsv(int numAtributos) {
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
					
					
					
					
					Usuario usuarioTemp = new Usuario(Integer.parseInt(datos[0]), datos[1].trim(), datos[2].trim());
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
			System.err.println("ERROR: El formato de uno de los datos es invalido. linea("+lineaActual+")");
		}catch (Exception   e) {
		System.err.println("ERROR: "+e.getMessage());	
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
	public static void guardarUsuariosCsv() {
		BufferedWriter bw = null;
		
		
		try {
			 bw = new BufferedWriter (new FileWriter("usuarios.csv"));
			 
			 for(Usuario u : Main.listaUsuarios) {
				 
				 String linea = u.getId()+","+u.getNombre()+","+u.getCorreoElectronico();
				 
				 bw.write(linea);
				 if(u!=Main.listaUsuarios.getLast())
				 bw.newLine();
				 
			 }
			 
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
	
}

