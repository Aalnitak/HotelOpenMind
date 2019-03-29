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
    public ArrayList<Object[]> informeCliente(int rut) {
        // Retorna toda la información del cliente contenida en la clase
        // Además de todos sus registros de entrada, habitaciones utilizadas y consumo por periodo
       ArrayList<Object[]> elementosTabla = new ArrayList<Object[]>(); 
          
        try 
        {
            String query = "SELECT \n" +
                        "    r.inicio 'Fecha y hora de ingreso',\n" +
                        "    CASE r.pasajero_rut\n" +
                        "        WHEN '?' THEN 'Pasajero Principal'\n" +
                        "        ELSE 'Acompañante'\n" +
                        "    END AS 'Visita como',\n" +
                        "    h.nombre AS 'Nombre Habitación',\n" +
                        "    SUM(p.precio) AS 'Consumo Total'\n" +
                        "FROM\n" +
                        "    registro_pasajeros rp\n" +
                        "        JOIN\n" +
                        "    reserva r ON r.idjornada = rp.reserva_idjornada\n" +
                        "        JOIN\n" +
                        "    habitacion h ON r.habitacion_idhabitacion = h.idhabitacion\n" +
                        "        JOIN\n" +
                        "    reserva_has_producto rhp ON r.idjornada = rhp.reserva_idjornada\n" +
                        "        JOIN\n" +
                        "    producto p ON rhp.producto_idproducto = p.idproducto\n" +
                        "WHERE\n" +
                        "    rp.pasajero_rut = ?\n" +
                        "GROUP BY r.idjornada";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, rut);
            ResultSet rs = ps.executeQuery();
            while (rs.next() ) {
                elementosTabla.add(new Object[] {
                    rs.getObject("Fecha y hora de ingreso"),
                    rs.getObject("Visita como"),
                    rs.getObject("Nombre Habitación"),
                    rs.getObject("Consumo Total")
                });
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return elementosTabla;
        
}
    
    @Override
    public ArrayList<Object[]> informeClienteDelAmor() {
        // similar pero sin rut a busqueda cliente
        // recuperar RUT del cliente del amor
        ArrayList<Object[]> elementosTabla = new ArrayList<Object[]>(); 
        int rut = 0;
        try {
            String query1 = "SELECT r.pasajero_rut , COUNT(r.pasajero_rut) cuenta\n" +
                            "FROM reserva r\n" +
                            "GROUP BY r.pasajero_rut\n" +
                            "ORDER BY cuenta DESC\n" +
                            "LIMIT 1";
            PreparedStatement ps = c.prepareStatement(query1);
            ResultSet rs1 = ps.executeQuery();
            rs1.next();
            rut = rs1.getInt("pasajero_rut");
            
            elementosTabla = informeCliente(rut);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return elementosTabla;
    
    
}
    @Override
    public ArrayList<Object[]> informeHabitacion(boolean mayorUso){
        // Habitacion con mayor registro de utilizacion cuando mayourUso == True
        // cuando False, menor registro de utilizacion
        // clientes que la han utilizado, gasto por periodo, total gasto
        // 
        // JLabel: nombre de la habitacion
        // Tabla 1:
        // cliente X: total veces utilizada, como principal, como acompañante
        // Tabla 2:
        // Fecha jornada, gasto por periodo
        // UNION total jornadas, gasto total
        
        
        return null;
}
    @Override
    public ArrayList<Object[]> informeProducto(boolean mayorVenta){
        // producto mas ventas (true) menos ventas (false)
        // habitacion mayor ventas, numero ventas
        // habitacion menor ventas, numero ventas
        
        
        return null;
}
    @Override
    public ArrayList<Object[]> informeHabitacionMayorPromedioPasajeros(){
        // informe habitacion pero en vez de mayor uso mayor promedio pasajeros ingreso
        
        return null;
}
    @Override
    public ArrayList<Object[]> informeHabitaciones(){
        
        // nombre habitacion, promedio pasajeros
        
        return null;
}
}
