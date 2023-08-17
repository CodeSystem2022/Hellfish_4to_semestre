package UTN.presentacion;

import UTN.datos.EstudianteDAO;
import UTN.dominio.Estudiante;

import java.util.Scanner;

public class SistemaEstudiantesApp {
    public static boolean main(String[] args) {
        var salir = false;
        var consola = new Scanner(System.in); // Para leer información de la consola
        // Se crea una instancia de la clase servicio, esto lo hacemos fuera del ciclo
        var estudianteDao = new EstudianteDAO(); // Esta instancia debe hacerse una vez
        while (!salir) {
            try {
                mostrarMenu(); // Mostramos el menú
                // Este será el método ejecutarOpciones que devolverá un booleano
                salir = ejecutarOpciones(consola, estudianteDao); // Este arroja una exception
            } catch (Exception e) {
                System.out.println("Ocurrió un error al ejecutar la operacion: " + e.getMessage());
            }
        } // Fin del ciclo while
    } // Fin del main