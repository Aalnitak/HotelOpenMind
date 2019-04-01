/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author duoc
 */
public class Producto {
    private Integer id,
            precio,
            stock;
    private String nombre,
            descripcion,
            tipo;
    
    private static Producto producto;
    
    private Producto(){
        
    }
    
    public static Producto getProducto(){
        if (producto ==null){
            producto = new Producto();
        }
        clearProducto();
        return producto;
        
    }
    
    public static void clearProducto(){
        producto.id=null;
        producto.precio=null;
        producto.stock=null;
        producto.nombre=null;
        producto.descripcion=null;
        producto.tipo=null;
    }
    
    public void restarStock(int cantidad){
       int aux = producto.getStock();
       aux -=cantidad;
       producto.setStock(aux);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", precio=" + precio + ", stock=" + stock + ", nombre=" + nombre + ", descripcion=" + descripcion + ", tipo=" + tipo + '}';
    }
    
    
}
