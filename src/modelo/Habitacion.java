/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.JDBCHabitacionDAO;

/**
 *
 * @author duoc
 */
public class Habitacion {

    private String nombre;
    private int id;
    private boolean ocupado;
    private static Habitacion[] hab;

    public Habitacion() {
    }

    //el hotel tendra 5 habitaciones distintas

    /**
     * esta funcion setea el array singleton de habitaciones
     * desde la base de datos
     * @return
     * 
     */
    public static Habitacion[] setHab() {
        JDBCHabitacionDAO jdbcHab = new JDBCHabitacionDAO();
        int cant = jdbcHab.selectCantidadHabitaciones();
        hab = new Habitacion[cant];

        for (int i = 0; i < cant; i++) {
            hab[i] = new Habitacion();
        }

        return hab;
    }
    
    /**
     *  esta funcion nos devuelve el singleton ya seteado
     * @return
     * array de habitaciones
     */
    public static Habitacion[] getHab(){
        return hab;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

}
