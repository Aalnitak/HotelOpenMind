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
 * @author duoc
 */
public interface InformeDAO {
    // metodos de las querys para cada informe
    
    public ArrayList<Object[]> llenarTablaHabitacionOcupada();
    public Reserva selectInformeMaxMin(int ID_reserva,boolean max);

}
