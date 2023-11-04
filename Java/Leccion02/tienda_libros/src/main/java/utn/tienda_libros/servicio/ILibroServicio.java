package utn.tienda_libros.servicio;

import java.util.List;
import utn.tienda_libros.modelo.Libro;

public interface ILibroServicio {

    public List<Libro> listarLibros();

    public Libro buscarLibroPorId(Integer idLibro);

    public void guardarLibro(Libro libro);

    public void eliminarLibro(Libro libro);
}
