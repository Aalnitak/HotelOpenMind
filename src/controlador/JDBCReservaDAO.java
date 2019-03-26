/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        /*try{
        String sql = "INSERT INTO reserva VALUES ?,?,?,?,?,?,?,?";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setInt(1, res.getId());
        
        
        }catch (SQLException e){
        e.getMessage();
        }*/
    }

    @Override
    public void update(Reserva habitacion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reserva selectInformeMaxMin(int ID_reserva, boolean max) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Reserva select(int id_reserva) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
