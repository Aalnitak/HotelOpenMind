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
import java.util.HashMap;
import modelo.Habitacion;

/**
 *
 * @author proyetco
 */
public class JDBCHabitacionDAO implements HabitacionDAO {

    HashMap<String, Integer> mapHabitacionDisponible;
    HashMap<String, Integer> mapHabitacionOcupada;
    Connection c = Conexion.getConnection();

    public JDBCHabitacionDAO() {
        this.mapHabitacionDisponible = new HashMap<>();
        mapHabitacionDisponible = getMap();
        this.mapHabitacionOcupada = new HashMap<>();
        mapHabitacionOcupada = getMapOcupada();
    }

    @Override
    public Habitacion[] selectAll() {
        Habitacion[] h = Habitacion.getHab();

        try {
            String sql = "Select * from habitacion";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            for (Habitacion hab : h) {
                rs.next();
                hab.setId(rs.getInt("idhabitacion"));
                hab.setNombre(rs.getString("nombre"));
                hab.setOcupado(rs.getBoolean("ocupado"));
                

            }

        } catch (SQLException e) {

        }

        return h;
    }

    @Override
    public int selectCantidadHabitaciones() {
        int cantidad = 0;

        try {
            String sql = "select count(*) from habitacion";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            rs.next();
            cantidad = rs.getInt(1);
        } catch (SQLException e) {

        }

        return cantidad;
    }

    @Override
    public void updateOcupado(Habitacion habitacion) {
        try {
            String sql = "UPDATE habitacion set  ocupado = ? WHERE idhabitacion = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setBoolean(1, habitacion.isOcupado());
            ps.setInt(2, habitacion.getId());
            ps.executeUpdate();

        } catch (SQLException e) {

        }

    }

    public HashMap<String, Integer> getMap() {

        try {
            String sql = "Select * from habitacion where ocupado = '0'";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String clave = rs.getString("nombre");
                Integer valor = rs.getInt("idhabitacion");

                mapHabitacionDisponible.put(clave, valor);

            }

        } catch (SQLException e) {
            e.getMessage();
        }
        return mapHabitacionDisponible;
    }

    public HashMap<String, Integer> getMapOcupada() {

        try {
            String sql = "Select * from habitacion where ocupado = '1'";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String clave = rs.getString("nombre");
                Integer valor = rs.getInt("idhabitacion");
                mapHabitacionOcupada.put(clave, valor);

            }

        } catch (SQLException e) {
            e.getMessage();
        }
        return mapHabitacionOcupada;
    }

    @Override
    public String selectNombreHab(int id) {
        String nombre = null;
        Habitacion[] h = selectAll();
        for (Habitacion hab : h) {
            System.out.println(hab.getId());
            if (hab.getId() == id) {
                nombre = hab.getNombre();
            }
        }
        return nombre;
    }

}
