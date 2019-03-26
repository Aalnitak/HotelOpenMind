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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Producto producto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

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
