/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.Reserva;

/**
 *
 * @author davidbousquet
 */
public interface ReservaDAO {
    public void insert(Reserva habitacion);
    public void update(Reserva habitacion);
    public Reserva selectInformeMaxMin(int ID_reserva,boolean max);
    public Reserva select(int id_reserva);

    
}
