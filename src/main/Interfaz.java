package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import clases.Usuario;
import clases.UsuarioManager;

public class Interfaz {

	public static void ejecutarInterfaz() {
		Scanner sc = new Scanner(System.in);
		int select;
		UsuarioManager.cargarUsuariosCsv(6);
		UsuarioManager.ordenarPorId();
		
		
		while(true) {
			
			
			String nombre;
			String apellido;
			String email;
			int edad;
			String sexo;
			try {
		System.out.println("\n"+"\u001B[36m---- MENÚ ----\n" + 
				"\n1) Usuarios" +
				"\n2) Recursos" + 
				"\n3) Préstamos y devoluciones" + 
				"\n4) Salir\u001B[0m \n");
		
		select = sc.nextInt();
		System.out.println();

		switch (select) {
		
		case(1):
			
			System.out.println("\n"+"\u001B[33m---- USUARIOS ----\n" + 
					"\n1) Mostrar todos" +
					"\n2) Buscar (ID)"+ 
					"\n3) Crear" + 
					"\n4) Modificar" + 
					"\n5) Eliminar"+ 
					"\n6) Salir \u001B[0m \n");
		
		int usr = sc.nextInt();
		sc.nextLine();
		System.out.println();
		
						switch(usr) {
						
						case(1):
							
							
							UsuarioManager.listarUsuarios();
							
							break;
							
						case(2):
							
							
							System.out.println("Introduzca el ID del usuario: ");
						
						System.out.println(UsuarioManager.buscarPorId(sc.nextInt())+"\n"); 
						
						sc.nextLine();
							
							break;
							
						case(3):
							
							
							System.out.print("Nombre: ");
						
							 nombre= sc.nextLine();
							
							System.out.print("Apellido: ");
							 apellido= sc.nextLine();
							
							System.out.print("Email: ");
							 email= sc.nextLine();
							
							System.out.print("Edad: ");
							 edad= sc.nextInt();
							 sc.nextLine(); 
							 
							System.out.print("Sexo: ");
							
							 sexo= sc.nextLine();
							
							Usuario newUser = new Usuario( Main.listaUsuarios.getLast().getId()+1, nombre, apellido, email, edad, sexo);
							UsuarioManager.agregarUsuario(newUser);
							System.out.println("\u001B[32m"+"Usuario creado correctamente con id: "+newUser.getId()+".☻\u001B[0m\n ");
							
							break;
						
						case(4):
							
							
							System.out.println("Inserte el ID del usuario a modificar: ");
							int id = sc.nextInt();
							sc.nextLine(); 
							
							System.out.print("Nombre: ");
								 nombre= sc.nextLine();
								
								System.out.print("Apellido: ");
								 apellido= sc.nextLine();
								
								System.out.print("Email: ");
								 email= sc.nextLine();
								
								System.out.print("Edad: ");
								 edad= sc.nextInt();
								 sc.nextLine(); 
								
								System.out.print("Sexo: ");
								sc.nextLine();
								 sexo= sc.nextLine();
							
							
							UsuarioManager.modificarUsuario(id, nombre, apellido, email, edad, sexo);
							
							
							break;
							
						case(5):
							
							
							System.out.println("Introduzca el ID del usuario: ");
						
							UsuarioManager.eliminarUsuario(sc.nextInt()); 
							
							System.out.println("Usuario eliminado exitosamente. ☻");
							
							break;
						
						case(6):
							
							
							guardarYSalir();
						
							
							break;
						
						default:
							System.out.println("\u001B[31mERROR: Opción no válida.\u001B[0m");
						}//switch usuarios
		
		
			break;
		case (4):

			guardarYSalir();
			
			break;

		default:
			System.out.println("\u001B[31mERROR: Opción no válida.\u001B[0m");
		
		}//switch menú
		
			}catch (InputMismatchException e) {
				System.out.println("\u001B[31mERROR: Caráter ingresado no válido.\u001B[0m");
				sc.nextLine();
			}
		
		}
	}
	
	public static void guardarYSalir() {
		UsuarioManager.guardarUsuariosCsv();
		System.out.println("Que tenga buen dia... Adiós.");
		System.exit(0);
	}
}
