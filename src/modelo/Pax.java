/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author duoc
 */
public class Pax {

    private int rut,
            visitasComoPpal;
    private String digitoVerificador,
            nombre,
            apellidoPat,
            apellidoMat,
            sexo,
            nacionalidad;
    private LocalDate fechaNacimiento;
    private boolean clienteFrec,
            clientePpal;

    private static ArrayList<Pax> p;
    private static Pax pax;

    private Pax() {
    }

    public int getVisitasComoPpal() {
        return visitasComoPpal;
    }

    public void setVisitasComoPpal(int visitasComoPpal) {
        this.visitasComoPpal = visitasComoPpal;
    }

    public static ArrayList<Pax> getPaxes() {
        if (p == null) {
            p = new ArrayList<>();
        }
        return p;
    }
    
    public static Pax getPax() {
        if (pax==null) {
            pax = new Pax();
        }
        return pax;
    }

    public static void clearPax() {
        p.clear();
    }
    
    

    public int getRut() {
        return rut;
    }

    public void setRut(int rut) {
        this.rut = rut;
    }


    public String getDigitoVerificador() {
        return digitoVerificador;
    }

    public void setDigitoVerificador(String cv) {
        this.digitoVerificador = cv;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPat() {
        return apellidoPat;
    }

    public void setApellidoPat(String apellidoPat) {
        this.apellidoPat = apellidoPat;
    }

    public String getApellidoMat() {
        return apellidoMat;
    }

    public void setApellidoMat(String apellidoMat) {
        this.apellidoMat = apellidoMat;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public boolean isClienteFrec() {
        return clienteFrec;
    }

    public void setClienteFrec(boolean clienteFrec) {
        this.clienteFrec = clienteFrec;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public static ArrayList<Pax> getP() {
        return p;
    }

    public static void setP(ArrayList<Pax> p) {
        Pax.p = p;
    }

    public boolean isClientePpal() {
        return clientePpal;
    }

    public void setClientePpal(boolean clientePpal) {
        this.clientePpal = clientePpal;
    }

}
