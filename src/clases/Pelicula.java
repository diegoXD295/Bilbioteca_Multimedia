package clases;

public class Pelicula extends Recurso{

	private String director;
	private double duracion;
	private String genero;
	
	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Pelicula(String id, String titulo, int año, boolean disponible, String director, String genero, double duracion) {
		super(id, titulo, año, disponible);
		this.director = director;
		this.genero = genero;
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + this.getId() + ", titulo=" + this.getTitulo() + 
               ", director=" + director + ", duracion=" + duracion + 
               ", genero=" + genero + "]";
	}

}
