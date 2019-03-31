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
import modelo.Pax;
import java.sql.Date;

/**
 *
 * @author proyetco
 */
public class JDBCPaxDAO implements PaxDAO {

    Connection conexion = Conexion.getConnection();

    @Override
    public void insert(ArrayList<Pax> p) {

        try {

            for (Pax pax : p) {
                String sql = "INSERT INTO `pasajero` VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = conexion.prepareStatement(sql);
                preparedStatement.setInt(1, pax.getRut());
                preparedStatement.setString(2, pax.getNombre());
                preparedStatement.setString(3, pax.getApellidoPat());
                preparedStatement.setString(4, pax.getApellidoMat());
                preparedStatement.setString(5, pax.getSexo());
                preparedStatement.setObject(6, Date.valueOf(pax.getFechaNacimiento()));
                preparedStatement.setString(7, pax.getNacionalidad());
                preparedStatement.setString(8, pax.getDigitoVerificador());
                preparedStatement.execute();

            }

        } catch (SQLException ex) {

        }

    }

    @Override
    public void insert(Pax pax) {
        try {
            String sql = "INSERT INTO `pasajero` VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, pax.getRut());
            preparedStatement.setString(2, pax.getNombre());
            preparedStatement.setString(3, pax.getApellidoPat());
            preparedStatement.setString(4, pax.getApellidoMat());
            preparedStatement.setString(5, pax.getSexo());
            preparedStatement.setObject(6, Date.valueOf(pax.getFechaNacimiento()));
            preparedStatement.setString(7, pax.getNacionalidad());
            preparedStatement.setString(8, pax.getDigitoVerificador());
            preparedStatement.execute();

        } catch (SQLException ex) {

        }
    }

    @Override
    public Pax selectRead(int rut) {
        Pax pax = Pax.getPax();
        Pax.clearPax();
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement("SELECT * FROM `pasajero` WHERE rut =?");
            preparedStatement.setInt(1, rut);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            pax.setRut(rut);
            pax.setDigitoVerificador(resultSet.getString("digito_verificador"));
            pax.setNombre(resultSet.getString("nombres"));
            pax.setApellidoPat(resultSet.getString("apellido_paterno"));
            pax.setApellidoMat(resultSet.getString("apellido_materno"));
            pax.setSexo(resultSet.getString("sexo"));
            pax.setFechaNacimiento(resultSet.getDate("fecha_nacimiento").toLocalDate());
            pax.setNacionalidad(resultSet.getString("nacionalidad"));
            pax.setClienteFrecuente(resultSet.getBoolean("cliente_frecuente"));

        } catch (SQLException ex) {

        }
        return pax;
    }

    @Override
    public Pax selectClienteFrecuente() {

        //si hay mas de un elemento en el result set deberiamos (si hay tiempo)
        //hacer una validacion de esto y darle la oportunidad igual a cualquiera de todos o alguna regla por definir
        //opr ahora solo validará si es el primero en la lista
        Pax pax = Pax.getPax();
        Pax.clearPax();
        try {
            String sql = "select * from pasajero where rut = ("
                    + "select pasajero_rut from reserva where MAX(count(pasajero_rut)";
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();
            pax.setRut(resultSet.getInt("rut"));
            pax.setDigitoVerificador(resultSet.getString("digito_verificaor"));
            pax.setNombre(resultSet.getString("nombre"));
            pax.setApellidoPat(resultSet.getString("apellido_paterno"));
            pax.setApellidoMat(resultSet.getString("apellido_materno"));
            pax.setSexo(resultSet.getString("sexo"));
            pax.setFechaNacimiento(resultSet.getDate("fecha_nacimiento").toLocalDate());
            pax.setNacionalidad(resultSet.getString("nacionalidad"));

        } catch (SQLException ex) {

        }
        return pax;
    }

    @Override
    public boolean existe(int rut) {
        boolean pase = false;
        try {
            PreparedStatement preparedStatement = conexion.prepareStatement("SELECT * FROM `pasajero` WHERE rut =?");
            preparedStatement.setInt(1, rut);
            ResultSet resultSet = preparedStatement.executeQuery();
            pase = resultSet.next();
                
        } catch (SQLException e) {
            e.getMessage();
        }

        return pase;
    }

    @Override
    public boolean isClienteFrecuente(Pax pax) {
      boolean pase;
      int rut=0;
      try{
          String sql ="select pasajero_rut , count(*) from reserva group by pasajero_rut limit 1";
          PreparedStatement ps = conexion.prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          rs.next();
          rut = rs.getInt("pasajero_rut");
      }catch (SQLException e){
          e.getMessage();
      }
      pase = pax.getRut() == rut;
      return pase;
    }
    
    @Override
    public ArrayList<Object> llenarRuts() {
        String query = "SELECT rut FROM pasajero";
        ArrayList<Object> ruts = new ArrayList<Object>();
        try
        {
            PreparedStatement ps = conexion.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                ruts.add(rs.getObject("rut"));
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ruts;
    }
    
}
