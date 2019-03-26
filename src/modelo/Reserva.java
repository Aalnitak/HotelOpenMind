/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDateTime;

/**
 *
 * @author duoc
 */
public class Reserva {

    private LocalDateTime fechaSalida,
            fechaEntrada,
            fechaSalidaEfectiva;
    private Integer rut,
            ocupantes,
            idJornada,
            idhabitacion;   
    private Boolean momento;
    private static Reserva res;

    private Reserva() {
    }

    public static Reserva getRes() {
        if (res == null) {
            res = new Reserva();
             
        }
        return res;
    }

    public static void clearRes() {
        res.fechaSalida = null;
        res.fechaEntrada = null;
        res.fechaSalidaEfectiva = null;
        res.rut = null;
        res.ocupantes = null;
        res.idJornada = null;
        res.idhabitacion = null;
        res.momento = null;

    }

    public LocalDateTime getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDateTime fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public LocalDateTime getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDateTime fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDateTime getFechaSalidaEfectiva() {
        return fechaSalidaEfectiva;
    }

    public void setFechaSalidaEfectiva(LocalDateTime fechaSalidaEfectiva) {
        this.fechaSalidaEfectiva = fechaSalidaEfectiva;
    }

    public Integer getRut() {
        return rut;
    }

    public void setRut(Integer rut) {
        this.rut = rut;
    }

    public Integer getOcupantes() {
        return ocupantes;
    }

    public void setOcupantes(Integer ocupantes) {
        this.ocupantes = ocupantes;
    }

    public Integer getIdJornada() {
        return idJornada;
    }

    public void setIdJornada(Integer idJornada) {
        this.idJornada = idJornada;
    }

    public Integer getIdhabitacion() {
        return idhabitacion;
    }

    public void setIdhabitacion(Integer idhabitacion) {
        this.idhabitacion = idhabitacion;
    }

    public Boolean getMomento() {
        return momento;
    }

    public void setMomento(Boolean momento) {
        this.momento = momento;
    }
    



}
