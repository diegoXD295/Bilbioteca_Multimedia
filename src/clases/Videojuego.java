package clases;

public class Videojuego extends Recurso {

	private String plataforma;
	private int pegi; // Usamos int para guardar solo la edad numérica
	private String desarrolladora;
	
	public Videojuego(String id, String titulo, int año, boolean disponible, String plataforma, int pegi, String desarrolladora) {
		super(id, titulo, año, disponible);
		this.plataforma = plataforma;
		this.pegi = pegi;
		this.desarrolladora = desarrolladora;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public int getPegi() {
		return pegi;
	}

	public void setPegi(int pegi) {
		this.pegi = pegi;
	}

	public String getDesarrolladora() {
		return desarrolladora;
	}

	public void setDesarrolladora(String desarrolladora) {
		this.desarrolladora = desarrolladora;
	}

	@Override
	public String toString() {
		return "Videojuego [id=" + this.getId() + ", titulo=" + this.getTitulo() + 
               ", plataforma=" + plataforma + ", pegi=" + pegi + 
               ", desarrolladora=" + desarrolladora + "]";
	}
}