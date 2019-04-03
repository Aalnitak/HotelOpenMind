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
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Producto;
import modelo.Reserva;


/**
 *
 * @author davidbousquet
 */
public class JDBCReservaDAO implements ReservaDAO {
    private static Connection c = Conexion.getConnection();
    
    //incompleto
    @Override
    public void insert(Reserva res) {
        
        int idjornada = 0;
        String nombreProducto = "";
        int idproducto = 0;
        int precio = 0;
        
        try{
        String query1 = "INSERT INTO reserva (pasajero_rut, habitacion_idhabitacion, inicio, limite_tiempo, num_pasajeros, momento)  VALUES (?,?,?,?,?,?)"; 
        PreparedStatement ps1 = c.prepareStatement(query1);
        ps1.setInt(1, res.getRut());
        ps1.setInt(2, res.getIdhabitacion());
        ps1.setObject(3, Timestamp.valueOf(res.getFechaEntrada()));
        ps1.setObject(4, Timestamp.valueOf(res.getFechaSalida()));
        ps1.setInt(5, res.getOcupantes());
        ps1.setBoolean(6, res.getMomento());
        
        ps1.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error en insertar a tabla rerserva");
            e.printStackTrace();
        }
        try 
        {
        String query2 = "SELECT idjornada FROM reserva WHERE pasajero_rut = ? AND habitacion_idhabitacion = ? ORDER BY idjornada DESC LIMIT 1";
        PreparedStatement ps2 = c.prepareStatement(query2);
        ps2.setInt(1, res.getRut());
//        System.out.println(res.getRut());
        ps2.setInt(2, res.getIdhabitacion());
//        System.out.println(res.getIdhabitacion());
        
        
        
        ResultSet rs2 = ps2.executeQuery();
        
        rs2.next();
       
        idjornada = rs2.getInt("idjornada");
        res.setIdJornada(idjornada);
       } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al recuperar idjornada");
       }
       
        try 
        { 
        String query3 = "SELECT nombre FROM habitacion WHERE idhabitacion = ?";
        PreparedStatement ps3 = c.prepareStatement(query3);
        ps3.setInt(1, res.getIdhabitacion());
        
        ResultSet rs3 = ps3.executeQuery();
        rs3.next();
        String nombreHabitacion = rs3.getString("nombre");
        
        
        if (res.getMomento()) {
            nombreProducto = nombreHabitacion+"_momento";
        } else {
            nombreProducto = nombreHabitacion+"_jornada";
        }
        
        String query4 = "SELECT * FROM producto WHERE nombre = ?";
        PreparedStatement ps4 = c.prepareStatement(query4);
        ps4.setString(1, nombreProducto);
        ResultSet rs4 = ps4.executeQuery();
        rs4.next();
        
        idproducto = rs4.getInt("idproducto");
        precio = rs4.getInt("precio");
        } catch (SQLException e) {
            System.out.println("Error al recuperar informacion del producto (pagar habitacion)");
            e.printStackTrace();
        }
        
        try 
        {
        String query5 = "INSERT INTO reserva_has_producto (reserva_idjornada, producto_idproducto, precio, cantidad) VALUES (?,?,?,1)";
        PreparedStatement ps5 = c.prepareStatement(query5);
        ps5.setInt(1, idjornada);
        System.out.println(idjornada);
        ps5.setInt(2, idproducto);
        System.out.println(idproducto);
        ps5.setInt(3, precio);
        System.out.println(precio);
        
        
        
        ps5.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Reserva ingresada exitosamente");
        }catch (SQLException e){
            System.out.println("Error al ingresar reserva has producto.");
        System.out.println(e.getMessage());
        JOptionPane.showMessageDialog(null, "Error al ingresar reserva");
        }
    }

    @Override
    public void update(Reserva reserva, int idjornada) {
        try
        {
            String query = "UPDATE reserva SET pasajero_rut = ?, habitacion_idhabitacion = ?, inicio = ?, limite_tiempo = ?, num_pasajeros = ?, momento = ? WHERE idjornada = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, reserva.getRut());
            ps.setInt(2, reserva.getIdhabitacion());
            ps.setObject(3, Timestamp.valueOf(reserva.getFechaEntrada()));
            ps.setObject(4, Timestamp.valueOf(reserva.getFechaSalida()));
            ps.setInt(5, reserva.getOcupantes());
            ps.setBoolean(6, reserva.getMomento());
            ps.setInt(7, idjornada);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Reserva select(int id_reserva) {
        
        Reserva res = Reserva.getRes();
        Reserva.clearRes();
        try
        {
        String query = "SELECT * FROM reserva WHERE idjornada = ?";
        PreparedStatement ps = c.prepareStatement(query);
        ps.setInt(1,id_reserva);
        ResultSet rs = ps.executeQuery();
        rs.next();
        
        res.setRut(rs.getInt("pasajero_rut"));
        res.setIdJornada(id_reserva);
        res.setFechaEntrada(rs.getTimestamp("inicio").toLocalDateTime());
        res.setFechaSalida(rs.getTimestamp("limite_tiempo").toLocalDateTime());
        res.setIdhabitacion(rs.getInt("habitacion_idhabitacion"));
        res.setMomento(rs.getBoolean("momento"));
        res.setOcupantes(rs.getInt("num_pasajeros"));
        
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return res;
    }

    /**
     * Retorna el id de la jornada reserva más actual para el rut del pasajero principal
     * Usado para hacer el ingreso del array de ruts en la tabla REGISTRO_PASAJEROS
     * @param rut
     * @return
     * idjornada (int) más actual (max) para el rut dado en la tabla de RESERVA
     */
    @Override
    public int getIdReserva(int rut) {
        int idjornada = 0;
        try
        {
            String query = "SELECT a.idjornada \n" +
                    "FROM reserva a\n" +
                    "INNER JOIN (SELECT pasajero_rut, MAX(idjornada) idjornada\n" +
                    "FROM reserva r\n" +
                    "GROUP BY pasajero_rut) b\n" +
                    "ON a.pasajero_rut = b.pasajero_rut AND a.idjornada = b.idjornada\n" +
                    "WHERE a.pasajero_rut = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(0, rut);
            ResultSet rs = ps.executeQuery();
            
            rs.next();
            idjornada =rs.getInt("idjornada");
                    
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return idjornada;
    }

    @Override
    public void updateMomentoEfectivoSalida(int idhabitacion) {
        
        
        // recuperar idjornada por idhabitacion
        int idjornada = 0;
        
        try
        {
            String query1 = "SELECT r.idjornada FROM reserva r JOIN habitacion h ON r.habitacion_idhabitacion = h.idhabitacion WHERE h.ocupado='1' AND h.idhabitacion = ? ORDER BY r.idjornada DESC LIMIT 1";
            PreparedStatement ps1 = c.prepareStatement(query1);
            ps1.setInt(1, idhabitacion);
            ResultSet rs = ps1.executeQuery();
            rs.next();
            idjornada = rs.getInt("idjornada");
           
            
            
        } catch (SQLException e) {
            System.out.println("Error al recuperar idjornada");
            e.printStackTrace();
        }
       
        try
        {
            String query2 = "UPDATE reserva SET momento_salida = ? WHERE idjornada = ?";
            PreparedStatement ps2 = c.prepareStatement(query2);
            ps2.setObject(1, Timestamp.valueOf(LocalDateTime.now()));
            ps2.setInt(2, idjornada);
            ps2.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("Error al ingresar hora de salida");
            e.printStackTrace();
        }
        
        
        // ingresar timestamp now
    }
    @Override
    public int idjornadaPorIdhabitacion (int idhabitacion) {
        int idjornada = 0; 
        try
             
        {
            System.out.println(idhabitacion);
            String query1 = "SELECT r.idjornada FROM reserva r JOIN habitacion h ON r.habitacion_idhabitacion = h.idhabitacion WHERE h.ocupado = '1' AND h.idhabitacion = ? ORDER BY r.idjornada DESC LIMIT 1";
            PreparedStatement ps1 = c.prepareStatement(query1);
            ps1.setInt(1, idhabitacion);
            ResultSet rs = ps1.executeQuery();
            rs.next();
            idjornada = rs.getInt("idjornada");
           
            
            
        } catch (SQLException e) {
            System.out.println("Error al recuperar idjornada");
            e.printStackTrace();
        }
         
         return idjornada;
    }

    @Override
    public void insertarProductoReservaHasProducto(Producto p, int idjornada, int cantidad) {
        // insert producto a reserva has producto
        try
        {
            String query = "INSERT INTO reserva_has_producto (reserva_idjornada, producto_idproducto, precio, cantidad) VALUES (?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, idjornada);
            ps.setInt(2, p.getId());
            ps.setInt(3, p.getPrecio());
            ps.setInt(4, cantidad);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto agregado a la habitación exitosamente");
        } catch (SQLException e) {
            e.printStackTrace();
             JOptionPane.showMessageDialog(null, "Error al cargar el producto a la habitación, favor intentar nuevamente");
        }
        
        
        
    }

    @Override
    public void insertarArrayRutsRegistroPax(ArrayList<Integer> ar,int idjornada) {
        try
        {
            for (int i = 0; i < ar.size(); i++) {
            System.out.println(ar.get(i));
            String query = "INSERT INTO registro_pasajeros (reserva_idjornada, pasajero_rut) VALUES (?,?)";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, idjornada);
            ps.setInt(2, ar.get(i));
            ps.executeUpdate();
        }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
    
    
}
