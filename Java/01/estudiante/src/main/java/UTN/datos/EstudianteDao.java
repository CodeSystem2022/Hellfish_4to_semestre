package UTN.datos;

import static UTN.conexion.Conexion.getConnection;
import UTN.dominio.Estudiante;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EstudianteDao {
    // Método listar
    public List<Estudiante> listarEstudiantes() {
        List<Estudiante> estudiantes = new ArrayList<>();

        // Creamos algunos objetos necesarios para comunicarnos con la base de datos 
        PreparedStatement ps; // Envía la sentencia
        ResultSet rs;  // Obtiene el resultado

        // Creamos objeto de tipo conexión
        Connection con = getConnection();
        String sql = "SELECT * FROM estudiantes2022 ORDER BY idestudiantes2022;";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                var estudiante = new Estudiante();

                estudiante.setIdEstudiante(rs.getInt("idestudiantes2022"));
                estudiante.setNombre(rs.getString("nombre"));
                estudiante.setApellido(rs.getString("apellido"));
                estudiante.setTelefono(rs.getString("telefono"));
                estudiante.setEmail(rs.getString("email"));

                // Falta agregarlo a la lista
                estudiantes.add(estudiante);
            }

        } catch (Exception e) {
            System.out.println("Ocurrió un error al seleccionar datos: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Ocurrió un error al cerrar la conexión: " + e.getMessage());
            }
        }

        return estudiantes;
    }

    // Método por id -> find by id
    public boolean buscarEstPorId(Estudiante est) {
        PreparedStatement ps;
        ResultSet rs;
        Connection con = getConnection();

        String sql = "SELECT * FROM estudiantes2022 WHERE idestudiante2022 = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, est.getIdEstudiante());

            rs = ps.executeQuery();

            if (rs.next()) {
                est.setNombre(rs.getString("nombre"));
                est.setApellido(rs.getString("apellido"));
                est.setTelefono(rs.getString("telefono"));
                est.setEmail(rs.getString("email"));

                return true;  // Se encontró un registro
            }

        } catch (Exception e) {
            System.out.println("Ocurrió un error al buscar estudiante: " + e.getMessage());

        } finally {
            try {
                con.close();

            } catch (Exception e) {
                System.out.println("Ocurrió un error al cerrar conexión: " + e.getMessage());
            }
        }
        return false;
    }

    public boolean agregarEst(Estudiante est) {
        PreparedStatement ps;
        Connection con = getConnection();

        String sql = "INSERT INTO estudiantes2022 (nombre, apellido, telefono, email) VALUES (?, ?, ?, ?)";

        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, est.getNombre());
            ps.setString(2, est.getApellido());
            ps.setString(3, est.getTelefono());
            ps.setString(4, est.getEmail());

            ps.execute();
            return true;

        } catch (Exception e) {
            System.out.println("Ocurrió un error al agregar estudiante: " + e.getMessage());
        } finally {
            try {
                con.close();

            } catch (Exception e) {
                System.out.println("Ocurrió un error al cerrar conexión: " + e.getMessage());
            }
        }
        return false;
    }

    public boolean modificarEst(Estudiante est) {
        PreparedStatement ps;
        Connection con = getConnection();

        String sql = "UPDATE estudiantes2022 SET nombre=?, apellido=?, telefono=?, email=? WHERE idestudiantes2022=?";
        
        try {
            ps = con.prepareStatement(sql);

            ps.setString(1, est.getNombre());
            ps.setString(2, est.getApellido());
            ps.setString(3, est.getTelefono());
            ps.setString(4, est.getEmail());
            ps.setInt(5, est.getIdEstudiante());

            ps.execute();
            return true;

        } catch (Exception e) {
            System.out.println("Ocurrió un error al modificar estudiante: " + e.getMessage());

        } finally {
            try {
                con.close();

            } catch (Exception e) {
                System.out.println("Ocurrió un error al cerrar conexión: " + e.getMessage());
            }
        }
        return false;
    }

    public boolean eliminarEstudiante(Estudiante estudiante) {
        PreparedStatement ps;
        Connection con = getConnection();
        String sql = "DELETE FROM estudiantes2022 WHERE idestudiantes2022=?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, estudiante.getIdEstudiante());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar estudiante: " + e.getMessage());
        } finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conexión: " + e.getMessage());
            }
        }
        return false;
    }

    public static void main(String[] args) {
        var estudianteDao = new EstudianteDao();

        /* Buscar por id
        var est1 = new Estudiante(1);
        System.out.println("Estudiantes antes de la busqueda: " + est1);
        var encontrado = estudianteDao.buscarEstPorId(est1);

        if (encontrado) {
            System.out.println("Estudiante encontrado: " + est1);
        } else {
            System.out.println("No se encontró el estudiante: " + est1.getIdEstudiante());
        }
        */

        /*
        // Agregar Estudiante
        var est2 = new Estudiante("Carlas", "Lol", "12346969", "cjasdñ@gmuil.cum");
        
        var agregado = estudianteDao.agregarEst(est2);

        if (agregado) {
            System.out.println("Estudiante agregado: " + est2);
        } else {
            System.out.println("No se ha agregado estudiante: " + est2);
        } 
        */


        /*
        // Modificar Estudiante
        var eM = new Estudiante(1, "Juanita", "Null", "1000101", "fdas@asdf.qwe");
        var modificado = estudianteDao.modificarEst(eM);

        if (modificado) {
            System.out.println("Estudiante modificado: " + eM);
        } else {
            System.out.println("No se modificó el estudiante" + eM);
        }
        */

        // Eliminar estudiante con id 3
        var estudianteEliminar = new Estudiante(3);
        var eliminado = estudianteDao.eliminarEstudiante(estudianteEliminar);
        if (eliminado) {
            System.out.println("Estudiante eliminado: " + estudianteEliminar);
        } else {
            System.out.println("No se eliminó al estudiante: " + estudianteEliminar);
        }

        // Listar los estudiantes
        System.out.println("Listado de estudiantes:");
        List<Estudiante> estudiantes = estudianteDao.listarEstudiantes();
        estudiantes.forEach(System.out::println); // Función lambda para imprimir
    }
}
