/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import modelo.Pax;

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
    
    public static void sumarProductoStock(JTable TBLStock, int cantidad) {
        //restar cantidad del stock en tabla.
        DefaultTableModel model = (DefaultTableModel) TBLStock.getModel();
        int stock = (int) TBLStock.getValueAt(TBLStock.getSelectedRow(), 2);
        stock += cantidad;
        model.setValueAt(stock, TBLStock.getSelectedRow(), 2);

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
    
    public static void llenarListaInformes (JComboBox jc) {
        jc.addItem("--Seleccione--");
        jc.addItem("Informe Cliente");
        jc.addItem("Informe Cliente del Amor");
        jc.addItem("Habitación más visitada");
        jc.addItem("Habitación menos visitada");
        jc.addItem("Producto más vendido");
        jc.addItem("Producto menos vendido");
        jc.addItem("Habitación grupos más grandes");
        jc.addItem("Informe todas las habitaciones");
        
    }

    public static void llenarRutsInformeCliente(JComboBox jc) {
        JDBCPaxDAO jdbcPaxDao = new JDBCPaxDAO();
        
        ArrayList<Object> ruts = jdbcPaxDao.llenarRuts();
        
        ruts.forEach((rut) -> jc.addItem(rut));
        
    }
    
    public static void llenarInformacionPaxInformeCliente(int rut, JLabel nombre, JLabel sexo, JLabel fechaNacimiento, JLabel nacionalidad, JTable tabla) {
        Pax pax = Pax.getPax();
        JDBCPaxDAO jdbcpax = new JDBCPaxDAO();
        pax = jdbcpax.selectRead(rut);
        
        nombre.setText(pax.getNombre()+" "+pax.getApellidoPat()+" "+pax.getApellidoMat());
        sexo.setText(pax.getSexo());
        fechaNacimiento.setText(pax.getFechaNacimiento().toString());
        nacionalidad.setText(pax.getNacionalidad());
        
        DefaultTableModel model = (DefaultTableModel)tabla.getModel();
        
        JDBCInformeDAO jdbcinforme = new JDBCInformeDAO();
        
        ArrayList<Object[]> elementosTabla = jdbcinforme.informeCliente(rut);
        
        elementosTabla.forEach((elemento) -> {model.addRow(elemento);});
        
    }
}
