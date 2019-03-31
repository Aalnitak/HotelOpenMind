/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 * clase de controlador para llenar objetos del tipo JTable
 *
 * @author proyetco
 */
public class ControlInforme {

    public static void llenarTablaHabitacionesOcupadas(JTable tabla) {
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        JDBCInformeDAO jdbcInforme = new JDBCInformeDAO();

        ArrayList<Object[]> elementosTabla = jdbcInforme.llenarTablaHabitacionOcupada();

        elementosTabla.forEach((elemento) -> {
            model.addRow(elemento);
        });

    }

    public static void llenarTablaProductosHabitacion(JTable TBLStock) {
        DefaultTableModel model = (DefaultTableModel) TBLStock.getModel();
        JDBCProductoDAO jdbcprod = new JDBCProductoDAO();
        ArrayList<Object[]> productos = jdbcprod.selectProductos();
        for (Object obj[] : productos) {
            Object[] objetosTabla = {obj[1], obj[3], obj[4]};
            model.addRow(objetosTabla);

        }

    }

    public static void transferirProductoATablaPedido(JTable TBLStock, int rowIndex, JTable TBLCarrito, int pedido) {
        //se asume que stock sera siempre el elemento de mas a la derecha en la tabla TBLStock
        DefaultTableModel modelstock = (DefaultTableModel) TBLStock.getModel();
        DefaultTableModel modelcarrito = (DefaultTableModel) TBLCarrito.getModel();
        Object[] rowData = new Object[modelstock.getColumnCount()];
        for (int i = 0; i < modelstock.getColumnCount(); i++) {

            if (i != (modelstock.getColumnCount() - 1)) {
                rowData[i] = modelstock.getValueAt(rowIndex, i);
            } else {
                rowData[i] = pedido;
            }
        }
        modelcarrito.addRow(rowData);

    }
    
    public static void eliminarProductoCarrito(JTable TBLCarrito, int rowIndex){
        DefaultTableModel carrito = (DefaultTableModel)TBLCarrito.getModel();
        carrito.removeRow(rowIndex);
        //se hace negativo para sumar... (deberia ser alrevez)
        
    }
    
    public static void sumarProductoStock(JTable TBLStock, int cantidad, String nombreProd) {
        //restar cantidad del stock en tabla.
        DefaultTableModel model = (DefaultTableModel) TBLStock.getModel();
        int index = getIndexfromNombre(TBLStock,nombreProd);
        int stock = (int) TBLStock.getValueAt(index, 2);
        stock += cantidad;
        model.setValueAt(stock, index, 2);

    }
    
    public static int getIndexfromNombre(JTable TBLStock, String nombreProd){
        DefaultTableModel model = (DefaultTableModel) TBLStock.getModel();
        int index = -1;
        for (int i = 0; i<TBLStock.getRowCount();i++){
            if (TBLStock.getValueAt(i, 0).equals((Object)nombreProd))
                index= i;
        }
        return index;
    }

    public static void restarProductoStock(JTable TBLStock, int cantidad) {
        //restar cantidad del stock en tabla.
        DefaultTableModel model = (DefaultTableModel) TBLStock.getModel();
        int stock = (int) TBLStock.getValueAt(TBLStock.getSelectedRow(), 2);
        stock -= cantidad;
        model.setValueAt(stock, TBLStock.getSelectedRow(), 2);

    }

    public static void llenarTablaProductosControlStock(JTable TBLStock) {
        DefaultTableModel model = (DefaultTableModel) TBLStock.getModel();
        JDBCProductoDAO jdbcProductDAO = new JDBCProductoDAO();

        ArrayList<Object[]> productos = jdbcProductDAO.selectProductos();

        productos.forEach((elemento) -> {
            model.addRow(elemento);
        });

    }

}
