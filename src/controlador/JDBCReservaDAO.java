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
import javax.swing.JOptionPane;
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
        
        try{
        String query = "INSERT INTO reserva (pasajero_rut, habitacion_idhabitacion, inicio, limite_tiempo, num_pasajeros, momento)  VALUES (?,?,?,?,?,?)";
        PreparedStatement ps = c.prepareStatement(query);
        ps.setInt(1, res.getRut());
        ps.setInt(2, res.getIdhabitacion());
        ps.setObject(3, Timestamp.valueOf(res.getFechaEntrada()));
        ps.setObject(4, Timestamp.valueOf(res.getFechaSalida()));
        ps.setInt(5, res.getOcupantes());
        ps.setBoolean(6, res.getMomento());
        
        ps.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Reserva ingresada exitosamente");
        }catch (SQLException e){
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public void updateMomentoEfectivoSalida(int rut) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        // recuperar idjornada por rut
        // ingresar timestamp now
    }
    
    
}
