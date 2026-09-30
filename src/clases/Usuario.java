package clases;

public class Usuario {
	
	private int id;
	private String nombre;
	private String correoElectronico;
	
	public Usuario(int id, String nombre, String correoElectronico) {
		this.id = id;
		this.nombre = nombre;
		this.correoElectronico = correoElectronico;
		
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", correoElectronico=" + correoElectronico + "]";
	}
	
	

}
