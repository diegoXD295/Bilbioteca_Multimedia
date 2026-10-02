package clases;

import java.time.LocalDate;

public class Prestamo {
    private Usuario usuario;
    private Recurso recurso;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private boolean activo;

    public Prestamo(Usuario usuario, Recurso recurso) {
        this.usuario = usuario;
        this.recurso = recurso;
        this.fechaPrestamo = LocalDate.now();
        this.activo = true;
    }

    public Usuario getUsuario() { return usuario; }
    public Recurso getRecurso() { return recurso; }
    public boolean isActivo() { return activo; }
    
    public void registrarDevolucion() {
        this.fechaDevolucion = LocalDate.now();
        this.activo = false;
    }

    @Override
    public String toString() {
        String estado = activo ? "Activo desde " + fechaPrestamo : "Devuelto el " + fechaDevolucion;
        return "Recurso: " + recurso.getTitulo() + " | Usuario: " + usuario.getNombre() + " | Estado: " + estado;
    }
}