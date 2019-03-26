/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JTextField;
import modelo.Pax;

/**
 *
 * @author duoc
 */
public class ValidarFormulario {
    
    public static void deRegistro(JTextField TFRut, JTextField TFNombre, JTextField TFApellidoPat, JTextField TFApellidoMat, JTextField TFNac) {
        Pax pasajero = Pax.getPax();
        String rut, nombre, apellidoPat, apellidoMat, nacionalidad;
        boolean isNull;
        
        rut = TFRut.getText();
        
        if(!rut.isEmpty() && Validacion.validarInt(rut)) {
            pasajero.setRut(Integer.valueOf(rut));
        }
        
        nombre = TFNombre.getText();
        
        if(!nombre.isEmpty() & !Validacion.validarInt(nombre)) {
            pasajero.setNombre(nombre);
        }
        
        apellidoPat = TFApellidoPat.getText();
        
        if(!apellidoPat.isEmpty() & !Validacion.validarInt(apellidoPat)) {
            pasajero.setApellidoPat(apellidoPat);
        }
        
        apellidoMat = TFApellidoMat.getText();
        
        if(!apellidoMat.isEmpty() & !Validacion.validarInt(apellidoMat)) {
            pasajero.setApellidoMat(apellidoMat);
        }
        
        
        nacionalidad = TFNac.getText();
        
        if(!nacionalidad.isEmpty() & !Validacion.validarInt(nacionalidad)) {
            pasajero.setNacionalidad(nacionalidad);
        }
        
        
        
        
        
        
    }
    
}
