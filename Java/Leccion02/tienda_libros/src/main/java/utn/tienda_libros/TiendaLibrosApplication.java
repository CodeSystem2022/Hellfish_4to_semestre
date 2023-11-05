package utn.tienda_libros;

import java.awt.EventQueue;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import utn.tienda_libros.vista.LibroFrom;

@SpringBootApplication
public class TiendaLibrosApplication {

	public static void main(String[] args) {

        ConfigurableApplicationContext contextoSpring =
            new SpringApplicationBuilder(TiendaLibrosApplication.class)
                .headless(false)
                .web(WebApplicationType.NONE)
                .run(args);

        // Ejecutamos para cargar el formulario
        EventQueue.invokeLater(() -> {
            // obtenemos objeto form a traves de spring
            LibroFrom libroFrom = contextoSpring.getBean(LibroFrom.class);
            libroFrom.setVisible(true);
        });
	}
}
