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
            TFDigitoVerificador0,
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

    public static FormularioRegistroPax getForm(JTextField TFRut, JTextField TFDigitoVerificador,
            JTextField TFNombre, JTextField TFApellidoPat, JTextField TFApellidoMat,
            JTextField TFNac, JComboBox CBFechaAño, JComboBox CBFechaMes, JComboBox CBFechaDia,
            JComboBox CBSexo) {
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
        TFDigitoVerificador0 = TFDigitoVerificador;
        return frp;
    }
    
    public static FormularioRegistroPax getFrp() {
        return frp;
    }

    public int getTFRut() {
        return Integer.parseInt(TFRut0.getText());
    }

    public String getTFNombre() {
        return TFNombre0.getText();
    }

    public String getTFDigitoVerificador0() {
        return TFDigitoVerificador0.getText();
    }

    public void setTFDigitoVerificador0(String digitoVerificador) {
        TFDigitoVerificador0.setText(digitoVerificador);
    }

    public String getTFApellidoPat() {
        return TFApellidoPat0.getText();
    }

    public String getTFApellidoMat() {
        return TFApellidoMat0.getText();
    }

    public String getTFNac() {
        return TFNac0.getText();
    }

    public int getCBFechaAño() {
        return Integer.parseInt(CBFechaAño0.getSelectedItem().toString());
    }

    public int getCBFechaMes() {
        return CBFechaMes0.getSelectedIndex();
    }

    public String getCBSexo() {
        return CBSexo0.getSelectedItem().toString();
    }

    public int getFechaDia() {
        return Integer.parseInt(CBFechaDia0.getSelectedItem().toString());
    }

    public JComboBox getCBFechaDia0() {
        return CBFechaDia0;
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
        CBFechaAño0.setSelectedItem(String.valueOf(date.getYear()));
    }

    public void setCBFechaMes(LocalDate date) {
        CBFechaMes0.setSelectedIndex(date.getMonth().getValue());
    }

    public void setCBFechaDia(LocalDate date) {
        CBFechaDia0.setSelectedItem(String.valueOf(date.getDayOfMonth()));
    }

    public void setCBSexo(String sexo) {
        CBSexo0.setSelectedItem(sexo);
    }

}
