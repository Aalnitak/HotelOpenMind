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

    private Integer rut,
            visitasComoPpal;
    private String digitoVerificador,
            nombre,
            apellidoPat,
            apellidoMat,
            sexo,
            nacionalidad;
    private LocalDate fechaNacimiento;
    private Boolean clienteFrec,
            clientePpal,
            premiado;

    private static ArrayList<Pax> p;
    private static Pax pax;

    private Pax() {
    }

    public int getVisitasComoPpal() {
        return visitasComoPpal;
    }

    public void agregarVisitaComoPpal() {
        this.visitasComoPpal ++;
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
        pax.setRut(null);
        pax.setNombre(null);
        pax.setApellidoPat(null);
        pax.setApellidoMat(null);
        pax.setNacionalidad(null);
        pax.setSexo(null);
        pax.setVisitasComoPpal(0);
        pax.setClientePpal(false);
        pax.setDigitoVerificador(null);
        pax.setFechaNacimiento(null);
        pax.setClienteFrecuente(null);
    }

    public Boolean getClienteFrec() {
        return clienteFrec;
    }

    public void setClienteFrec(Boolean clienteFrec) {
        this.clienteFrec = clienteFrec;
    }

    public Boolean getPremiado() {
        return premiado;
    }

    public void setPremiado(Boolean premiado) {
        this.premiado = premiado;
    }

    public void setVisitasComoPpal(Integer visitasComoPpal) {
        this.visitasComoPpal = visitasComoPpal;
    }
    
    

    public int getRut() {
        return rut;
    }

    public void setRut(Integer rut) {
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

    public Boolean isClienteFrec() {
        return clienteFrec;
    }

    public void setClienteFrecuente(Boolean clienteFrec) {
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

    public Boolean isClientePpal() {
        return clientePpal;
    }

    public void setClientePpal(Boolean clientePpal) {
        this.clientePpal = clientePpal;
    }

    @Override
    public String toString() {
        return "Pax{" + "rut=" + rut + ", visitasComoPpal=" + visitasComoPpal + ", digitoVerificador=" + digitoVerificador + ", nombre=" + nombre + ", apellidoPat=" + apellidoPat + ", apellidoMat=" + apellidoMat + ", sexo=" + sexo + ", nacionalidad=" + nacionalidad + ", fechaNacimiento=" + fechaNacimiento + ", clienteFrec=" + clienteFrec + ", clientePpal=" + clientePpal + '}';
    }
    

}
