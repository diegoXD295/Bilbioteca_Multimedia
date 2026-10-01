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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	
	

}
