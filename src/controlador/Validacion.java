/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Pax;
import modelo.Producto;

/**
 *
 * @author duoc
 */
public class Validacion {

    private static boolean pase;

    public static boolean validarInt(String str) {
        try {
            Integer.valueOf(str);
            pase = true;
        } catch (NumberFormatException e) {
            pase = false;
        }

        return pase;

    }

    public static boolean deRegistro(JTextField TFRut, JTextField TFNombre, JTextField TFApellidoPat, JTextField TFApellidoMat, JTextField TFNac) {
        Pax pasajero = Pax.getPax();
        String rut, nombre, apellidoPat, apellidoMat, nacionalidad;
        boolean isNull;

        rut = TFRut.getText();

        if (!rut.isEmpty() && Validacion.validarInt(rut)) {
            pasajero.setRut(Integer.valueOf(rut));
        }
         else {
            return false;
        }

        nombre = TFNombre.getText();

        if (!nombre.isEmpty() & !Validacion.validarInt(nombre)) {
            pasajero.setNombre(nombre);
        }

        apellidoPat = TFApellidoPat.getText();

        if (!apellidoPat.isEmpty() & !Validacion.validarInt(apellidoPat)) {
            pasajero.setApellidoPat(apellidoPat);
        }

        apellidoMat = TFApellidoMat.getText();

        if (!apellidoMat.isEmpty() & !Validacion.validarInt(apellidoMat)) {
            pasajero.setApellidoMat(apellidoMat);
        }

        nacionalidad = TFNac.getText();

        if (!nacionalidad.isEmpty() & !Validacion.validarInt(nacionalidad)) {
            pasajero.setNacionalidad(nacionalidad);
        }

        isNull = (rut.equals("") | nombre.equals("") | apellidoPat.equals("") | apellidoMat.equals("") | nacionalidad.equals(""));

        return !isNull;

    }

    public static boolean deFormularioControlStock(JTextField TFNombre, JTextField TFDescripcion, JTextField TFPrecio, JTextField TFStock, JTextField TFTipo) {
        Producto producto = Producto.getProducto();
        String nombre, descripcion, precio, stock, tipo;
        boolean isNull;

        nombre = TFNombre.getText();

        if (!nombre.isEmpty()) {
            producto.setNombre(nombre);
        }

        descripcion = TFDescripcion.getText();

        if (!descripcion.isEmpty()) {
            producto.setDescripcion(descripcion);
        }

        precio = TFPrecio.getText();

        if (!precio.isEmpty() && Validacion.validarInt(precio)) {
            producto.setPrecio(Integer.valueOf(precio));
        } else {
            return false;
        }
        
        stock = TFStock.getText();
        
        if (!stock.isEmpty() && Validacion.validarInt(stock)) {
            producto.setStock(Integer.valueOf(stock));
        } else {
            return false;
        }
        
        
        tipo = TFTipo.getText();
        
        if (!tipo.isEmpty()) {
            producto.setTipo(tipo);
        }
        
        isNull = (nombre.equals("") | descripcion.equals("") | precio.equals("") | stock.equals("") | tipo.equals(""));
        
        if(isNull == false) {
            JDBCProductoDAO jdbcProductoDAO = new JDBCProductoDAO();
            jdbcProductoDAO.insert(producto);
            JOptionPane.showMessageDialog(null, "Producto agregado exitosamente");
            TFNombre.setText("");                                                    
            TFDescripcion.setText("");
            TFPrecio.setText("");
            TFStock.setText("");
            TFTipo.setText("");
        }

        return !isNull;
    }
}
