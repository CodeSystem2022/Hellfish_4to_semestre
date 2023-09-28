package utn.estudiantes.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import utn.estudiantes.modelo.Estudiante;
import utn.estudiantes.repositorio.EstudianteRepositorio;

import java.util.List;

@Service
public class EstudianteServicio implements IEstudianteServicio {
    @Autowired
    private EstudianteRepositorio eR;

    @Override
    public List<Estudiante> listarEstudiantes() {
        List<Estudiante> e = eR.findAll();
        return e;
    }

    @Override
    public Estudiante buscarEstudiantePorId(Integer idEstudiante) {
        Estudiante e = eR.findById(idEstudiante).orElse(null);
        return e;
    }

    @Override
    public void guardarEstudiante(Estudiante estudiante) {
        eR.save(estudiante);

    }

    @Override
    public void eliminarEstudiante(Estudiante estudiante) {
        eR.delete(estudiante);
    }
}
