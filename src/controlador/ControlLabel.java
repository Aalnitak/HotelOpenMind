/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.Producto;
import modelo.Reserva;

/**
 *
 * @author duoc
 */
public class ControlLabel {
    
    public static void setLabelPrecioIngreso(String nombreProd, JTextField TFCantPax, JLabel LBTotal, JLabel LBPreciopp) {
        JDBCProductoDAO prodDAO = new JDBCProductoDAO();
        Producto prod = prodDAO.select(nombreProd);
        if (Validacion.validarInt(TFCantPax.getText())) {
            LBPreciopp.setText(String.valueOf(prod.getPrecio()));
            int total = prod.getPrecio() * Integer.parseInt(TFCantPax.getText());
            LBTotal.setText(String.valueOf(total));
        } else {
            JOptionPane.showMessageDialog(null, "Datos incorrectos");
        }
    }
    public static void setLabelPrecioPorPersona(Reserva res, JLabel LBPreciopp){
        JDBCProductoDAO jdbcprod = new JDBCProductoDAO();
        JDBCHabitacionDAO jdbchab = new JDBCHabitacionDAO();
        String modo;
        if(res.getMomento()){
            modo="_momento";
        }else{
            modo="_jornada";
        }
        String nombrehab = jdbchab.selectNombreHab(res.getIdhabitacion());
        String nombreProd = nombrehab.concat(modo);
        Producto prod = jdbcprod.select(nombreProd);
        LBPreciopp.setText(String.valueOf(prod.getPrecio()));
        
    }
    
    /**
     * la funcion setea el texto del label con el total sin descuento
     * @param res
     * @param LBSubTotal
     */
    public static void setPrecioSubTotal(Reserva res, JLabel LBSubTotal){
        JDBCProductoDAO jdbcprod = new JDBCProductoDAO();
        JDBCHabitacionDAO jdbchab = new JDBCHabitacionDAO();
        String modo;
        if(res.getMomento()){
            modo="_momento";
        }else{
            modo="_jornada";
        }
        String nombreProd = jdbchab.selectNombreHab(res.getIdhabitacion()).concat(modo);
        Producto prod = jdbcprod.select(nombreProd);
        int total = prod.getPrecio()*res.getOcupantes();
        LBSubTotal.setText(String.valueOf(total));
        
    }

    /**
     * la funcion setea el label con el total incluido el descuento
     * @param res
     * @param LBSubTotal
     * @param descuento
     */
    public static void setPrecioTotal(Reserva res, JLabel LBSubTotal, double descuento){
        JDBCProductoDAO jdbcprod = new JDBCProductoDAO();
        JDBCHabitacionDAO jdbchab = new JDBCHabitacionDAO();
        String modo;
        if(res.getMomento()){
            modo="_momento";
        }else{
            modo="_jornada";
        }
        String nombreProd = jdbchab.selectNombreHab(res.getIdhabitacion()).concat(modo);
        Producto prod = jdbcprod.select(nombreProd);
        double total = prod.getPrecio()*res.getOcupantes()*descuento;
        total = Math.floor(total/100)*100;
        LBSubTotal.setText(String.valueOf((int)total));
        
    }
    
}
