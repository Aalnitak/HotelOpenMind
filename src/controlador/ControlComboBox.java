/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import javax.swing.JComboBox;

/**
 *
 * @author duoc
 */
public class ControlComboBox {

    public static void llenarCBHabitacion(JComboBox cb) {
            JDBCHabitacionDAO jdbcHab = new JDBCHabitacionDAO();
            cb.addItem("--Seleccione--");
            jdbcHab.mapHabitacionDisponible.keySet().forEach((name) -> {
                cb.addItem(name);
        });
            


    }

}
