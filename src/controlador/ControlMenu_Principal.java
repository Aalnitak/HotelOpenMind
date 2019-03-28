/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ljrojas
 */
public class ControlMenu_Principal {
    public static void llenarTablaHabitacionesDisponibles (JTable tabla) {
        // llamar DAO habitaciones y retornar los nombres de las habitaciones disponibles
        JDBCHabitacionDAO jdbcHabitacion = new JDBCHabitacionDAO();
        
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        
        jdbcHabitacion.mapHabitacionDisponible.keySet().forEach((name) -> {
                model.addRow(new Object[] {name});
        });
           
    }
    
//    public static void llenarTablaHabitacionesOcupadas (JTable tabla) {
//        // llamar DAO habitaciones, retornar mapa <nombres,id> habitaciones ocupadas
//        JDBCHabitacionDAO jdbcHabitacion = new JDBCHabitacionDAO();
//        JDBCInformeDAO jdbcInforme = new JDBCInformeDAO();
//        
//        jdbcInforme.llenarTablaHabitacionOcupada(tabla);
//        
//    
//    }
       
    
}
  