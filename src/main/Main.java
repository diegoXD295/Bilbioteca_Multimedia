package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import clases.Gestor;
import clases.Usuario;

public class Main {
	
	public static List<Usuario> listaUsuarios = new ArrayList<>();

	public static void main(String[] args) {
		Gestor.leerUsuariosCsv();
		System.out.println(listaUsuarios);

	}

}
