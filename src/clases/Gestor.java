package clases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.text.ParseException;

import main.Main;

public class Gestor {
	
	
		
	
	public static void leerUsuariosCsv() {
		BufferedReader br = null;
		String linea;
		int lineaActual = 1;
		
		try {
			br = new BufferedReader(new FileReader("usuarios.csv"));
			
			for(int i=1;(linea = br.readLine())!=null;i++, lineaActual++) {
				
				String[] datos = linea.split(",");
				if (datos.length==3) {//cambiar el 3 por la cantidad de atributos que tenga el usuario
					
					
					
					Usuario usuarioTemp = new Usuario(Integer.parseInt(datos[0]), datos[1], datos[2]);
					Main.listaUsuarios.add(usuarioTemp);
					
				}else if(datos.length>3) {throw new Exception("El usuario posee más campos de los requeridos. linea("+i+")");}
				
			}
			
			 
			
			
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
}

