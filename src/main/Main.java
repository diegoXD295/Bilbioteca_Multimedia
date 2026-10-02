package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import clases.Gestor;
import clases.Usuario;

public class Main {
	
	public static List<Usuario> listaUsuarios = new ArrayList<>();
	public static List<Usuario> listaRecursos = new ArrayList<>();
	public static List<Usuario> listaPrestamos = new ArrayList<>();

	public static void main(String[] args) {
		Gestor.cargarUsuariosCsv(3);
		//listaUsuarios.add(new Usuario(5,"pinpon","unMuñecomuyguapo@ydecarton.com"));
		Gestor.guardarUsuariosCsv();
		System.out.println(listaUsuarios);

	}

}
