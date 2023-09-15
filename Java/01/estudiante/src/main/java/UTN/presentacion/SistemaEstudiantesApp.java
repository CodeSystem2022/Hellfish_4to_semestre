package UTN.presentacion;

import UTN.datos.EstudianteDao;
import UTN.dominio.Estudiante;

import java.util.Scanner;

public class SistemaEstudiantesApp {
    public static void main(String[] args) {
        var salir = false;
        var consola = new Scanner(System.in);

        var estDao = new EstudianteDao();
        while (!salir) {
            try {
                mostrarMenu();
                salir = ejecutarOp(consola, estDao);
            } catch (Exception e) {
                System.out.println("Ocurrió un error al ejecutar la operación: " + e.getMessage());
            }
        }
    }

    private static void mostrarMenu() {
        System.out.print("""
                *** Sis Est ***
                1. Listar
                2. Buscar
                3. Agregar
                4. Modificar
                5. Eliminar
                6. Salir

                Ingrese opción:
                """);
    }
    
    private static boolean ejecutarOp(Scanner consola, EstudianteDao estudianteDao) {
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;

        switch (opcion) {
            case 1 -> {  // Listar estudiantes
                System.out.println("Listando estudiantes...");
                var estudiantes = estudianteDao.listarEstudiantes();
                estudiantes.forEach(System.out::println);

            } case 2 -> {  // Buscar estudiantes
                System.out.println("Ingrese id del estudiante:");
                var id = Integer.parseInt(consola.nextLine());
                var est = new Estudiante(id);
                var encontrado = estudianteDao.buscarEstPorId(est);

                if (encontrado) {
                    System.out.println("Estudiante encontrado: " + est);
                } else {
                    System.out.println("Estudiante NO encontrado");
                }
            } case 3 -> {  // Agregar
                System.out.println("Agregar estudiante");
                System.out.println("Ingrese nombre:");
                var nom = consola.nextLine();

                System.out.println("Ingrese apellido:");
                var ap = consola.nextLine();

                System.out.println("Ingrese teléfono:");
                var tel = consola.nextLine();

                System.out.println("Ingrese email:");
                var ema = consola.nextLine();

                var est = new Estudiante(nom, ap, tel, ema);

                var agre = estudianteDao.agregarEst(est);
                if (agre) {
                    System.out.println("Estudiante agregado: " + est);
                } else {
                    System.out.println("Estudiante NO agregado: " + est);
                }
            } case 4 -> {
                System.out.println("Modificar estudiante:");
                System.out.println("Ingrese ID:");
                var id = Integer.parseInt(consola.nextLine());

                System.out.println("Ingrese nombre:");
                var nom = consola.nextLine();

                System.out.println("Ingrese apellido:");
                var ap = consola.nextLine();

                System.out.println("Ingrese teléfono:");
                var tel = consola.nextLine();

                System.out.println("Ingrese email:");
                var ema = consola.nextLine();

                var est = new Estudiante(id, nom, ap, tel, ema);

                var mod = estudianteDao.agregarEst(est);
                if (mod) {
                    System.out.println("Estudiante modificado: " + est);
                } else {
                    System.out.println("Estudiante NO modificado: " + est);
                }

            } case 5 -> {  // Eliminar
                System.out.println("Modificar estudiante:");
                System.out.println("Ingrese ID:");
                var id = Integer.parseInt(consola.nextLine());
                var est = new Estudiante(id);

                var elim = estudianteDao.eliminarEstudiante(est);
                if (elim) {
                    System.out.println("Estudiante eliminado: " + est);
                } else {
                    System.out.println("Estudiante NO eliminado: " + est);
                }
            } case 6 -> {
                System.out.println("Saliendo del programa");
                salir = true;
            } default -> System.out.println("Opción inválida");
        }
        return salir;
    }
}