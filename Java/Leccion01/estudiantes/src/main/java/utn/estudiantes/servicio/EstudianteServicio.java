package utn.estudiantes.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.estudiantes.modelo.Estudiantes2022;
import utn.estudiantes.repositorio.EstudianteRepositorio;

import java.util.List;

@Service
public class EstudianteServicio implements IEstudianteServicio {
    @Autowired
    private EstudianteRepositorio eR;

    @Override
    public List<Estudiantes2022> listarEstudiantes() {
        List<Estudiantes2022> e = eR.findAll();
        return e;
    }

    @Override
    public Estudiantes2022 buscarEstudiantePorId(Integer idEstudiante) {
        Estudiantes2022 e = eR.findById(idEstudiante).orElse(null);
        return e;
    }

    @Override
    public void guardarEstudiante(Estudiantes2022 estudiante) {
        eR.save(estudiante);
    }

    @Override
    public void eliminarEstudiante(Estudiantes2022 estudiante) {
        eR.delete(estudiante);
    }
}
