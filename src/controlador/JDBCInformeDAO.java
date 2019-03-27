/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author duoc
 */
public class JDBCInformeDAO {
        
    public ArrayList<Object[]> llenarTablaHabitacionOcupada() {
//        Connection con = Conexion.getConnection();
//        ArrayList<Object[]> Al = new ArrayList<Object[]>();
//        try 
//        {
//            String query = "SELECT h.nombre, r.num_pasajeros \"numero de pasajeros\", p.nombre \"nombre producto consumido\", r.limite_tiempo\n" +
//                        "FROM habitacion h\n" +
//                        "JOIN reserva r\n" +
//                        "ON (h.idhabitacion = r.habitacion_idhabitacion)\n" +
//                        "JOIN reserva_has_producto rhp\n" +
//                        "ON (r.idjornada = rhp.reserva_idjornada)\n" +
//                        "JOIN producto p\n" +
//                        "ON (rhp.producto_idproducto = p.idproducto)\n" +
//                        "WHERE h.ocupado = '1'\n" +
//                        "AND r.idjornada = (SELECT MAX(idjornada) )\n" +
//                        "ORDER BY r.idjornada DESC";
//            
//            PreparedStatement ps = con.prepareStatement(query);
//            ResultSet rs = ps.executeQuery();
//            
            // Corregir query
//            while (rs.next()) {
//                Al.add(
//                        new Object[4] = {
//                            rs.getObject("nombre"),
//                            rs.getObject("numero de pasajeros"),
//                            rs.getObject("nombre producto consumido"),
//                            rs.getObject("limite_tiempo")
//                    }
//                
//            }
//            
//        } catch (SQLException e) {
//            e.printStackTrace();
////        }
////        
//        return Al;
    return null;
    }

}
