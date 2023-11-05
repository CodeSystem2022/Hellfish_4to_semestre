package utn.tienda_libros.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idLibro;
    String nombreLibro;
    String autor;
    Double precio;
    Integer existencias;

    // getters
    public Integer getIdLibro() {
        return idLibro;
    }

    public String getNombreLibro() {
        return this.nombreLibro;
    }

    public String getAutor() {
        return this.autor;
    }

    public Double getPrecio() {
        return this.precio;
    }

    public Integer getExistencias() {
        return this.existencias;
    }

    // Setters
    public void setNombreLibro(String str) {
        this.nombreLibro = str;
    }

    public void setAutor(String str) {
        this.autor = str;
    }

    public void setPrecio(Double n) {
        this.precio = n;
    }

    public void setExistencias(int n) {
        this.existencias = n;
    }
}
