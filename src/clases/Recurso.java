package clases;

public class Recurso {
    private String id;
    private String titulo;
    private int anio;
    private boolean disponible;

    public Recurso(String id, String titulo, int anio) {
        this.id = id;
        this.titulo = titulo;
        this.anio = anio;
        this.disponible = true; 
    }

    public String getId() { return id; }
    public String getTitulo() { return titulo; }
    public int getAnio() { return anio; }
    public boolean isDisponible() { return disponible; }
    
    public void setDisponible(boolean disponible) { 
        this.disponible = disponible; 
    }

    @Override
    public String toString() {
        return id + " - " + titulo + " (" + anio + ") | " + (disponible ? "Disponible" : "Prestado");
    }
}