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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.Reserva;


public class JDBCInformeDAO implements InformeDAO {

    private static Connection c = Conexion.getConnection();
    
    @Override
    public ArrayList<Object[]> llenarTablaHabitacionOcupada() {

        ArrayList<Object[]> elementosTabla = new ArrayList<Object[]>();

        try {
            String query = "SELECT h.nombre, r.num_pasajeros \"numero de pasajeros\", p.nombre \"nombre producto consumido\", r.limite_tiempo \"limite de tiempo\"\n"
                    + "FROM habitacion h\n"
                    + "JOIN reserva r\n"
                    + "ON (h.idhabitacion = r.habitacion_idhabitacion)\n"
                    + "INNER JOIN (SELECT rr.habitacion_idhabitacion idhabitacion, MAX(idjornada) idjornada\n"
                    + "FROM reserva rr\n"
                    + "GROUP BY idhabitacion\n"
                    + ") b ON h.idhabitacion = b.idhabitacion AND r.idjornada = b.idjornada\n"
                    + "JOIN reserva_has_producto rhp\n"
                    + "ON (r.idjornada = rhp.reserva_idjornada)\n"
                    + "JOIN producto p\n"
                    + "ON (rhp.producto_idproducto = p.idproducto)\n"
                    + "WHERE h.ocupado = '1'\n"
                    + "GROUP BY h.nombre\n"
                    + "ORDER BY r.idjornada DESC\n";

            PreparedStatement ps = c.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                elementosTabla.add(new Object[]{
                    rs.getObject("nombre"),
                    rs.getObject("numero de pasajeros"),
                    rs.getObject("nombre producto consumido"),
                    rs.getObject("limite de tiempo")
                });

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return elementosTabla;

    }
    
    @Override
    public ArrayList<Object[]> informeCliente(int rut) {return null;
}
    
    @Override
    public ArrayList<Object[]> informeClienteDelAmor() {return null;
}
    @Override
    public ArrayList<Object[]> informeHabitacion(boolean mayorUso){return null;
}
    @Override
    public ArrayList<Object[]> informeProducto(boolean mayorVenta){return null;
}
    @Override
    public ArrayList<Object[]> informeHabitacionMayorPromedioPasajeros(){return null;
}
    @Override
    public ArrayList<Object[]> informeHabitaciones(){return null;
}
}
