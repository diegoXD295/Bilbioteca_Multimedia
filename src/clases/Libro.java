package clases;

public class Libro extends Recurso{

	private String autor;
	private int paginas;
	private String editorial;
	
	public Libro(String id, String titulo, int año, boolean disponible, String autor, int paginas, String editorial) {
		super(id, titulo, año, disponible);
		this.autor = autor;
		this.paginas = paginas;
		this.editorial = editorial;
	}

	
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}


	@Override
	public String toString() {
		return "Libro [id=" + getId() + ", titulo=" + getTitulo() + ", autor=" + autor + ", paginas=" + paginas + ", editorial="
				+ editorial + "]";
	}


	
}
