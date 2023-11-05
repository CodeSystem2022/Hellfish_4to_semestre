package utn.tienda_libros.vista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utn.tienda_libros.modelo.Libro;
import utn.tienda_libros.servicio.LibroServicio;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

// estoy usando los mismos nombres que usa el profe btw
@Component
public class LibroFrom extends JFrame {
    LibroServicio libroServicio;
    private JPanel panel;
    private JTable tablaLibros;
    private JTextField idTexto;
    private JTextField libroTexto;
    private JTextField autorTexto;
    private JTextField precioTexto;
    private JTextField existenciasTexto;
    private JButton agregarButton;
    private JButton modificarButton;
    private JButton eliminarButton;
    private DefaultTableModel tablaModeloLibros;

    @Autowired
    public LibroFrom(LibroServicio libSer) {
        this.libroServicio = libSer;
        iniciarForma();
        agregarButton.addActionListener(e -> agregarLibro());
        tablaLibros.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                cargarLibroSeleccionado();
            }
        });

        modificarButton.addActionListener(e -> modificarLibro());
        eliminarButton.addActionListener(e -> eliminarLibro());
    }

    private void iniciarForma() {
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(900,700);

        // dimensiones de pantalla
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension pantalla = tk.getScreenSize();

        // posicion
        int x = (pantalla.width - getWidth()/2);
        int y = (pantalla.height - getHeight()/2);
        setLocation(x, y);
    }

    private void agregarLibro() {
        // leer los valores del formulario
        if (libroTexto.getText().equals("")) {
            mostrarMensaje("Ingresa el nombre del libro");
            libroTexto.requestFocusInWindow();
            return;
        }

        var nombre = libroTexto.getText();
        var autor = autorTexto.getText();
        var precio = Double.parseDouble(precioTexto.getText());
        var existencias = Integer.parseInt(existenciasTexto.getText());

        // creamos objeto libro
        var libro = new Libro(null, nombre, autor, precio, existencias);
        // libro.setNombreLibro(nombre);
        // libro.setAutor(autor);
        // libro.setPrecio(precio);
        // libro.setExistencias(existencias);

        this.libroServicio.guardarLibro(libro);
        mostrarMensaje("Se agregó el libro");
        limpiarFormulario();
        listarLibros();
    }

    private void cargarLibroSeleccionado(){
        // los indices de las columnas inician en cero
       var reglon = tablaLibros.getSelectedRow();

       if (reglon != -1) {
           String idLibro = tablaLibros.getModel().getValueAt(reglon, 0).toString();
           idTexto.setText(idLibro);

           String nombreLibro = tablaLibros.getModel().getValueAt(reglon, 1).toString();
           libroTexto.setText(nombreLibro);

           String autor = tablaLibros.getModel().getValueAt(reglon, 2).toString();
           autorTexto.setText(autor);

           String precio = tablaLibros.getModel().getValueAt(reglon, 3).toString();
           precioTexto.setText(precio);

           String existencias = tablaLibros.getModel().getValueAt(reglon, 4).toString();
           existenciasTexto.setText(existencias);
       }
    }

    private void modificarLibro() {
        if (this.idTexto.equals("")) {
            mostrarMensaje("Debes seleccionar un registro en la tabla");

        } else {
            // verificamos nombre no nulo
            if (libroTexto.getText().equals("")) {
                mostrarMensaje("Ingrese nombre de libro");
                libroTexto.requestFocusInWindow();
                return;
            }
            // llenamos obj libro a actualizar
            int idLibro = Integer.parseInt(idTexto.getText());
            var nombreLibro = libroTexto.getText();
            var autor = autorTexto.getText();
            var precio = Double.parseDouble(precioTexto.getText());
            var existencias = Integer.parseInt(existenciasTexto.getText());

            var libro = new Libro(idLibro, nombreLibro, autor, precio, existencias);

            libroServicio.guardarLibro(libro);

            mostrarMensaje("Se modifico el libro");
            limpiarFormulario();
            listarLibros();
        }
    }

    private void eliminarLibro() {
        var reglon = tablaLibros.getSelectedRow();

        if (reglon != -1) {
            String idLibro = tablaLibros.getModel().getValueAt(reglon, 0).toString();

            var libro = new Libro();
            libro.setIdLibro(Integer.parseInt(idLibro));
            libroServicio.eliminarLibro(libro);
            mostrarMensaje("Libro " + idLibro + " ELIMINADO");
            limpiarFormulario();
            listarLibros();

        } else {
            mostrarMensaje("No se ha seleccionado ningun libro");
        }

    }

    private void limpiarFormulario() {
        libroTexto.setText("");
        autorTexto.setText("");
        precioTexto.setText("");
        existenciasTexto.setText("");
    }

    private void mostrarMensaje(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    private void createUIComponents() {
        idTexto = new JTextField("");
        idTexto.setVisible(false);

        this.tablaModeloLibros = new DefaultTableModel(0, 5){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String[] cabecera = {"Id", "Libro", "Autor", "Precio", "Existencias"};
        this.tablaModeloLibros.setColumnIdentifiers(cabecera);

        this.tablaLibros = new JTable(tablaModeloLibros);

        // evitamos multiple seleccion
        tablaLibros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listarLibros();
    }

    private void listarLibros() {
        // limpiar tabla
        tablaModeloLibros.setRowCount(0);

        // obtener libros de la BD
        var libros = libroServicio.listarLibros();

        // iteramos cada libro
        libros.forEach((libro) -> {
            Object [] renglonLibro = {
                libro.getIdLibro(),
                libro.getNombreLibro(),
                libro.getAutor(),
                libro.getPrecio(),
                libro.getExistencias()
            };

            this.tablaModeloLibros.addRow(renglonLibro);
        });
    }
}
