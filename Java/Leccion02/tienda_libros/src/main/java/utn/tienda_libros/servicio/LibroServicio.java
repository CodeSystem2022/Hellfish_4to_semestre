package utn.tienda_libros.servicio;

import java.util.List;

import utn.tienda_libros.modelo.Libro;
import utn.tienda_libros.repositorio.LibroRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroServicio implements ILibroServicio {

    @Autowired
    private LibroRepositorio libroRepositorio;

    @Override
    public List<Libro> listarLibros() {
        return libroRepositorio.findAll();
    }

    @Override
    public Libro buscarLibroPorId(Integer idLibro) {
        Libro l = libroRepositorio.findById(idLibro).orElse(null);
        return l;
    }

    @Override
    public void guardarLibro(Libro libro) {
        libroRepositorio.save(libro);
    }

    @Override
    public void eliminarLibro(Libro libro) {
        libroRepositorio.delete(libro);
    }
}
