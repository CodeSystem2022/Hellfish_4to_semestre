package utn.estudiantes.repositorio;

import utn.estudiantes.modelo.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepositorio extends JpaRepository<Estudiante, Integer> {

}
