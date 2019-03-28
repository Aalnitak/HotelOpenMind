/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ljrojas
 */
public class ControlInforme {
    
    public static void llenarTablaHabitacionesOcupadas(JTable tabla) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        JDBCInformeDAO jdbcInforme = new JDBCInformeDAO();
        
        ArrayList<Object[]> elementosTabla = jdbcInforme.llenarTablaHabitacionOcupada();
        
        elementosTabla.forEach((elemento) -> { model.addRow(elemento);});
        
    }
    
}
