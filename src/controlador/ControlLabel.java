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
    
}
