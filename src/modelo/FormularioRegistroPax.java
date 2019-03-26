/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author duoc
 */
public class FormularioRegistroPax {
    private static JTextField TFRut0,
            TFNombre0, 
            TFApellidoPat0, 
            TFApellidoMat0, 
            TFNac0;
    private static JComboBox CBFechaAño0, 
            CBFechaMes0, 
            CBFechaDia0,
            CBSexo0;
    private static FormularioRegistroPax frp;

    private FormularioRegistroPax() {
    }
    
    
    
    public static FormularioRegistroPax getForm(JTextField TFRut,
            JTextField TFNombre, JTextField TFApellidoPat, JTextField TFApellidoMat, 
            JTextField TFNac, JComboBox CBFechaAño, JComboBox CBFechaMes, JComboBox CBFechaDia,
            JComboBox CBSexo){
        frp = new FormularioRegistroPax();
        TFRut0 = TFRut;
        TFNombre0 = TFNombre;
        TFApellidoPat0 = TFApellidoPat;
        TFApellidoMat0 = TFApellidoMat;
        TFNac0 = TFNac;
        CBFechaAño0 = CBFechaAño;
        CBFechaMes0 = CBFechaMes;
        CBFechaDia0 = CBFechaDia;
        CBSexo0 = CBSexo;
        
        
        return frp;
    }
    
 

    public void setTFRut(int rut) {
        TFRut0.setText(String.valueOf(rut));
    }

    public void setTFNombre(String nombre) {
        TFNombre0.setText(nombre);
    }

    public void setTFApellidoPat(String apellidoPaterno) {
        TFApellidoPat0.setText(apellidoPaterno);
    }

    public void setTFApellidoMat(String apellidoMaterno) {
        TFApellidoMat0.setText(apellidoMaterno);
    }

    public void setTFNac(String nacionalidad) {
        TFNac0.setText(nacionalidad);
    }

    public void setCBFechaAño(LocalDate date) {
        CBFechaAño0.setSelectedItem(date.getYear());
    }

    public void setCBFechaMes(LocalDate date) {
        CBFechaMes0.setSelectedIndex(date.getMonth().getValue());
    }

    public void setCBFechaDia(LocalDate date) {
        CBFechaDia0.setSelectedIndex(date.getDayOfMonth());
    }

    public void setCBSexo(String sexo) {
        CBSexo0.setSelectedItem(sexo);
    }
    
}
