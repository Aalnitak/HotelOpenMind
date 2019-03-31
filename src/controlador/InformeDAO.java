/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import javax.swing.JTable;
import modelo.Reserva;

/**
 *
 * @author duoc
 */
public interface InformeDAO {
    // metodos de las querys para cada informe
    
    public ArrayList<Object[]> llenarTablaHabitacionOcupada();
    public ArrayList<Object[]> informeCliente(int rut);
    public ArrayList<Object[]> informeClienteDelAmor();
    public ArrayList<Object[]> informeHabitacion(boolean mayorUso);
    public Object[] informeProducto(boolean mayorVenta);
    public Object[] informeHabitacionMayorPromedioPasajeros();
    public ArrayList<Object[]> informeHabitaciones();
    public Object nombreHabitacion(boolean mayorUso);

}
