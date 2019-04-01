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
import modelo.Producto;

/**
 *
 * @author duoc
 */
public class JDBCProductoDAO implements ProductoDAO {

    Connection c = Conexion.getConnection();

    @Override
    public void insert(Producto producto) {
        try {
            String query = "INSERT INTO producto (nombre,descripcion,precio,stock,tipo) VALUES (?,?,?,?,?)";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setInt(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());
            ps.setString(5, producto.getTipo());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Producto producto) {
        try {
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
        }
    }

    @Override
    public Producto select(String nombre) {
        Producto prod = Producto.getProducto();

        try {
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

        } catch (SQLException e) {
            e.getMessage();
        }

        return prod;
    }

    @Override
    public ArrayList<Object[]> selectProductos() {
        ArrayList<Object[]> productos = new ArrayList<>();

        try {
            String sql = "SELECT * from producto where not tipo = 'Habitacion'";
            PreparedStatement ps = c.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                productos.add(new Object[]{
                    rs.getObject("idproducto"),//0
                    rs.getObject("nombre"),//1
                    rs.getObject("descripcion"),//2
                    rs.getObject("precio"),//3
                    rs.getObject("stock"),//4
                    rs.getObject("tipo")});//5

            }
        } catch (SQLException e) {
            e.getMessage();
        }

        return productos;
    }

    

}
