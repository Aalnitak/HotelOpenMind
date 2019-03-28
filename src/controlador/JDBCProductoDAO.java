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
import modelo.Producto;

/**
 *
 * @author duoc
 */
public class JDBCProductoDAO implements ProductoDAO {
    
    Connection c = Conexion.getConnection();

    @Override
    public void insert(Producto producto) {
        try
        {
            String query = "INSERT INTO producto (nombre,descripcion,precio,stock,tipo) VALUES (?,?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setInt(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());
            ps.setString(5, producto.getDescripcion());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void update(Producto producto) {
 try
        {
            String query = "UPDATE producto SET nombre = ?, descripcion = ?, precio = ? ,stock = ?, tipo = ? WHERE idproducto = ?";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setInt(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());
            ps.setString(5, producto.getDescripcion());
            ps.setInt(6, producto.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }    }

    @Override
    public Producto select(String nombre) {
        Producto prod = Producto.getProducto();
        
        try{
            String sql = "SELECT * FROM producto where nombre = ?";
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            rs.next();
            prod.setId(rs.getInt("idproducto"));
            prod.setNombre(rs.getString("nombre"));
            prod.setDescripcion(rs.getString("descripcion"));
            prod.setPrecio(rs.getInt("precio"));
            prod.setStock(rs.getInt("stock"));
            prod.setTipo(rs.getString("tipo"));
            
        }catch(SQLException e){
            e.getMessage();
        }
        
        return prod;
    }

   
    
}
