/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.Producto;


/**
 *
 * @author davidbousquet
 */
public interface ProductoDAO {
    
    public void insert(Producto producto);
    public void update(Producto producto);
    public Producto select(String nombre);
}
