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
    
    public static void llenarTablaHabitacionesOcupadas (JTable tabla) {
        // llamar DAO habitaciones, retornar mapa <nombres,id> habitaciones ocupadas
        // 1. llenar nombres habitaciones ocupadas en la tabla
        // 2. Recuperar idreserva a partir de id_habitación donde idjornada sea máximo
        // 3. Buscar n_pasajeros a partir de idjornada
        // 4. Recuperar "última acción" a partir de la tabla reserva_has_producto donde la id_reserva_has_producto
        //      sea la mayor para la idjornada (o la fecha sea la mayor)
        //      aplicar formato a la query sql { "Pagó "-inserte producto- " a las "-inserte hora }
        // 5. Recuperar hora de término y calcular cuenta regresiva para desocuparse
    }
}
  