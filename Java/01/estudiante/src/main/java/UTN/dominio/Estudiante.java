package UTN.dominio;

public class Estudiante {
    private int idEstudiante;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;

    public Estudiante() {} // Constructor vacio

    public Estudiante(int idEstudiante) { // Constructor para la llave primaria
        this.idEstudiante = idEstudiante;
    }

    // Constructor para insertar datos
    public Estudiante(String nombre, String apellido, String telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }

    // Constructor para actualizar datos
    public Estudiante(int idEstudiante, String nombre, String apellido, String telefono, String email) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }

    // Setters
    public void setIdEstudiante(int id) {
        this.idEstudiante = id;
    }

    public void setNombre(String str) {
        this.nombre = str;
    }

    public void setApellido(String str) {
        this.apellido = str;
    }

    public void setTelefono(String str) {
        this.telefono = str;
    }

    public void setEmail(String str) {
        this.email = str;
    }

    // Getters
    public int getIdEstudiante() {
        return this.idEstudiante;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public String getEmail() {
        return this.email;
    }

    @Override
    public String toString() {
        return "Estudiante {" +
            "idEstudiante = " + idEstudiante +
            ", nombre = '" + nombre + "'" +
            ", apellido = '" + apellido + "'" +
            ", telefono = '" + telefono + "'" +
            ", email = '" + email + "'" +
            '}';
    }
}
