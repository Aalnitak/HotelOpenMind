/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import java.util.HashMap;
import modelo.Habitacion;

/**
 *
 * @author davidbousquet
 */
public interface HabitacionDAO {
    
    public void updateOcupado(Habitacion habitacion);
    public Habitacion[] selectAll();
    public int selectCantidadHabitaciones();
    public String selectNombreHab(int id);
    //public HashMap<String,Integer> getMap();

    
}
