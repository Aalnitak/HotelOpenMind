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
 *  clase de controlador
 * para llenar objetos del tipo JTable
 * @author proyetco
 */
public class ControlInforme {
    
    public static void llenarTablaHabitacionesOcupadas(JTable tabla) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        JDBCInformeDAO jdbcInforme = new JDBCInformeDAO();
        
        ArrayList<Object[]> elementosTabla = jdbcInforme.llenarTablaHabitacionOcupada();
        
        elementosTabla.forEach((elemento) -> { model.addRow(elemento);});
        
    }
    
    public static void llenarTablaProductosHabitacion(JTable TBLStock){
        DefaultTableModel model = (DefaultTableModel) TBLStock.getModel();
        JDBCProductoDAO jdbcprod = new JDBCProductoDAO();
        ArrayList<Object[]> productos = jdbcprod.selectProductos();
        for (Object obj[] : productos){
                    Object[] objetosTabla = { obj[1],obj[3],obj[4] };
                    model.addRow(objetosTabla);

        }
        
        
    }
    
    
    public static void llenarTablaProductosControlStock(JTable TBLStock) {
        
        // implementar llenado de datos en controlstock
        
    }
    
    
}
