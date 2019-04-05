/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import modelo.Habitacion;
import modelo.Pax;
import modelo.Reserva;

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

         if (model.getRowCount() > 0) {
            for (int i = model.getRowCount() - 1; i > -1; i--) {
                model.removeRow(i);
            }
        }

        
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
        if (pedido < 1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar la cantidad antes de agregar el producto");
        } else {
            for (int i = 0; i < modelstock.getColumnCount(); i++) {

                if (i != (modelstock.getColumnCount() - 1)) {
                    rowData[i] = modelstock.getValueAt(rowIndex, i);
                } else {
                    rowData[i] = pedido;
                }
            }
            modelcarrito.addRow(rowData);
        }

    }

    public static void calcularTotalPedidoProductos(JTable TBLCarrito, JLabel LBTotal) {
        DefaultTableModel modeloCarrito = (DefaultTableModel) TBLCarrito.getModel();
        int precioTemp, precioTotal, cantidad;
        precioTotal = 0;
        for (int i = 0; i < modeloCarrito.getRowCount(); i++) {
            precioTemp = Integer.parseInt(modeloCarrito.getValueAt(i, 1).toString());
            cantidad = Integer.valueOf(modeloCarrito.getValueAt(i, 2).toString());
            precioTotal = precioTotal + (precioTemp * cantidad);   
        }
        LBTotal.setText("$"+precioTotal);
    }

    public static void eliminarProductoCarrito(JTable TBLCarrito, int rowIndex) {
        DefaultTableModel carrito = (DefaultTableModel) TBLCarrito.getModel();
        carrito.removeRow(rowIndex);
        //se hace negativo para sumar... (deberia ser alrevez)

    }

    public static void sumarProductoStock(JTable TBLStock, int cantidad, String nombreProd) {
        //restar cantidad del stock en tabla.
        DefaultTableModel model = (DefaultTableModel) TBLStock.getModel();
        int index = getIndexfromNombre(TBLStock, nombreProd);
        int stock = (int) TBLStock.getValueAt(index, 2);
        stock += cantidad;
        model.setValueAt(stock, index, 2);

    }

    public static int getIndexfromNombre(JTable TBLStock, String nombreProd) {
        DefaultTableModel model = (DefaultTableModel) TBLStock.getModel();
        int index = -1;
        for (int i = 0; i < TBLStock.getRowCount(); i++) {
            if (TBLStock.getValueAt(i, 0).equals((Object) nombreProd)) {
                index = i;
            }
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

    public static void llenarListaInformes(JComboBox jc) {
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

        nombre.setText(pax.getNombre() + " " + pax.getApellidoPat() + " " + pax.getApellidoMat());
        sexo.setText(pax.getSexo());
        fechaNacimiento.setText(
                String.valueOf(pax.getFechaNacimiento().getDayOfMonth()) + "-"
                + String.valueOf(pax.getFechaNacimiento().getMonthValue()) + "-"
                + String.valueOf(pax.getFechaNacimiento().getYear())
        );
        nacionalidad.setText(pax.getNacionalidad());

        DefaultTableModel model = (DefaultTableModel) tabla.getModel();

        if (model.getRowCount() > 0) {
            for (int i = model.getRowCount() - 1; i > -1; i--) {
                model.removeRow(i);
            }
        }

        JDBCInformeDAO jdbcinforme = new JDBCInformeDAO();

        ArrayList<Object[]> elementosTabla = jdbcinforme.informeCliente(rut);

        elementosTabla.forEach((elemento) -> {
            model.addRow(elemento);
        });

    }

    public static void llenarInformeClienteAmor(JLabel nombreCliente, JLabel sexoCliente, JLabel fechaCliente, JLabel nacionalidadCliente, JTable tabla) {
        Pax pax = Pax.getPax();
        JDBCPaxDAO jdbcpax = new JDBCPaxDAO();

        pax = jdbcpax.selectClienteFrecuente();

        nombreCliente.setText(pax.getNombre() + " " + pax.getApellidoPat() + " " + pax.getApellidoMat());
        sexoCliente.setText(pax.getSexo());
        fechaCliente.setText(String.valueOf(pax.getFechaNacimiento().getDayOfMonth()) + "-"
                + String.valueOf(pax.getFechaNacimiento().getMonthValue()) + "-"
                + String.valueOf(pax.getFechaNacimiento().getYear()));
        nacionalidadCliente.setText(pax.getNacionalidad());

        DefaultTableModel model = (DefaultTableModel) tabla.getModel();

        JDBCInformeDAO jdbcinforme = new JDBCInformeDAO();

        ArrayList<Object[]> elementosTabla = jdbcinforme.informeClienteDelAmor();

        elementosTabla.forEach((elemento) -> {
            model.addRow(elemento);
        });
    }

    public static void llenarInformeHabitacionMasUsada(JLabel nombreHabitacion, JTable tabla) {
        JDBCInformeDAO jdbcinforme = new JDBCInformeDAO();

        nombreHabitacion.setText(jdbcinforme.nombreHabitacion(true).toString());

        ArrayList<Object[]> elementos = jdbcinforme.informeHabitacion(true);

        DefaultTableModel model = (DefaultTableModel) tabla.getModel();

        elementos.forEach((elemento) -> {
            model.addRow(elemento);
        });

    }

    public static void llenarInformeHabitacionMenosUsada(JLabel nombreHabitacion, JTable tabla) {
        JDBCInformeDAO jdbcinforme = new JDBCInformeDAO();

        nombreHabitacion.setText(jdbcinforme.nombreHabitacion(false).toString());

        ArrayList<Object[]> elementos = jdbcinforme.informeHabitacion(false);

        DefaultTableModel model = (DefaultTableModel) tabla.getModel();

        elementos.forEach((elemento) -> {
            model.addRow(elemento);
        });

    }

    public static void llenarInformeProductoMasVendido(JLabel nombreProducto, JLabel habitacionMas, JLabel habitacionMenos) {
        JDBCInformeDAO jdbcinforme = new JDBCInformeDAO();

        Object[] elementos = jdbcinforme.informeProducto(true);

        nombreProducto.setText(elementos[0].toString());
        habitacionMas.setText(elementos[1].toString());
        habitacionMenos.setText(elementos[2].toString());
    }

    public static void llenarInformeProductoMenisVendido(JLabel nombreProducto, JLabel habitacionMas, JLabel habitacionMenos) {
        JDBCInformeDAO jdbcinforme = new JDBCInformeDAO();

        Object[] elementos = jdbcinforme.informeProducto(false);

        nombreProducto.setText(elementos[0].toString());
        habitacionMas.setText(elementos[1].toString());
        habitacionMenos.setText(elementos[2].toString());
    }

    public static void llenarInformeHabitacionGrupos(JLabel nombre, JLabel promedio) {
        JDBCInformeDAO jdbcinforme = new JDBCInformeDAO();

        Object[] elementos = jdbcinforme.informeHabitacionMayorPromedioPasajeros();

        nombre.setText(elementos[0].toString());
        promedio.setText(elementos[1].toString());

    }

    public static void llenarInformeTodasHabitaciones(JTable tabla) {

        JDBCInformeDAO jdbcinforme = new JDBCInformeDAO();

        ArrayList<Object[]> elementos = jdbcinforme.informeHabitaciones();

        DefaultTableModel model = (DefaultTableModel) tabla.getModel();

        elementos.forEach((elemento) -> {
            model.addRow(elemento);
        });

    }
    
    public static void llenarResumenVisita(int idjornada, JLabel idreserva, JLabel inicio, JLabel termino, JLabel nombreHabitacion, JLabel numPasajeros, JTable pasajeros, JTable consumo, JLabel consumoTotal) {
        
        Habitacion[] h;
        JDBCHabitacionDAO jdbchabitacion = new JDBCHabitacionDAO();
        JDBCReservaDAO jdbcreserva = new JDBCReservaDAO();
        JDBCPaxDAO jdbcpax = new JDBCPaxDAO();
        JDBCInformeDAO jdbcinforme = new JDBCInformeDAO();
     
        
        Reserva res = Reserva.getRes();
        res = jdbcreserva.selectSalida(idjornada);
        
        
        
        idreserva.setText(res.getIdJornada().toString());
        inicio.setText(res.getFechaEntrada().toString());
        termino.setText(res.getFechaSalidaEfectiva().toString());
        nombreHabitacion.setText(jdbchabitacion.selectNombreHab(res.getIdhabitacion()));
        numPasajeros.setText(res.getOcupantes().toString());
        
        DefaultTableModel modelPasajeros = (DefaultTableModel) pasajeros.getModel();
        ArrayList<Object[]> ArrayPax = jdbcpax.llenarTablaPaxResumenVisita(idjornada);
        ArrayPax.forEach((elemento) -> {modelPasajeros.addRow(elemento);});
        
        DefaultTableModel modelConsumo = (DefaultTableModel) consumo.getModel();
        ArrayList<Object[]> ArrayConsumo = jdbcinforme.informeConsumoReserva(idjornada);
        ArrayConsumo.forEach((elemento) -> {modelConsumo.addRow(elemento);});
        
        int cTotal = 0;
        
        for (int i=0; i <modelConsumo.getRowCount(); i++) {
            cTotal = cTotal + Integer.valueOf(modelConsumo.getValueAt(i, 3).toString());
        }
        
        consumoTotal.setText(String.valueOf(cTotal));        
        
        
        
    }
}
