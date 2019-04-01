/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.Producto;
import modelo.Reserva;

/**
 *
 * @author davidbousquet
 */
public interface ReservaDAO {
    public void insert(Reserva habitacion);
    public void update(Reserva habitacion, int idjornada);
    public Reserva select(int id_reserva);
    public int getIdReserva(int rut);
    public void updateMomentoEfectivoSalida(int rut);
    public int idjornadaPorIdhabitacion (int idhabitacion); 
    public void insertarProductoReservaHasProducto(Producto p, int idjornada, int cantidad);
    
}
