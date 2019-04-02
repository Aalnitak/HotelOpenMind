/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.util.ArrayList;
import modelo.Pax;

/**
 *
 * @author duoc
 */
public interface PaxDAO {
    
    public void insert(ArrayList<Pax> pax);
    public void insert(Pax pax);
    public Pax selectRead(int rut);
    public Pax selectClienteFrecuente();
    public boolean isClienteFrecuente(Pax pax);
    public boolean existe(int rut);
    public ArrayList<Object> llenarRuts();
    public ArrayList<Object[]> llenarTablaPaxResumenVisita(int idjornada);
    
    
}
