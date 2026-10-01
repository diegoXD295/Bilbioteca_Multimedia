package clases;

public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private int edad;
    private String sexo;

    public Usuario(int id, String nombre, String apellido,
                   String email, int edad, String sexo) {

        if (!sexo.equalsIgnoreCase("Hombre") &&
            !sexo.equalsIgnoreCase("Mujer")) {
            throw new IllegalArgumentException("El sexo debe ser Hombre o Mujer");
        }

        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.edad = edad;
        this.sexo = sexo;
    }

    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getEmail() {
        return email;
    }
    public int getEdad() {
        return edad;
    }
    public String getSexo() {
        return sexo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setSexo(String sexo) {
        if (!sexo.equalsIgnoreCase("Hombre") &&
            !sexo.equalsIgnoreCase("Mujer")) {
            throw new IllegalArgumentException("El sexo debe ser Hombre o Mujer");
        }
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "ID: " + id
                + "  Nombre: " + nombre
                + "  Apellido: " + apellido
                + "  Email: " + email
                + "  Edad: " + edad
                + "  Sexo: " + sexo;
    }
}
