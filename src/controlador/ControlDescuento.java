/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author proyetco
 */
public class ControlDescuento {
    private double descuento;

    private ControlDescuento() {
    }
    
    /**
     *
     * @param cantidadOcupantes
     * la cantidad de ocupantes total de la reserva
     * @return
     * retorna el monto a multiplicar por el precio total
     */
    public static double getMultiplicadorDescuento(int cantidadOcupantes){
        if (cantidadOcupantes < 3){
            return 1;
        }
        double cant = cantidadOcupantes - 2;
        cant *= 0.1;
        cant= 1 - cant;
        
        return cant;
    
}

    /**
     *
     * @param cantidadOcupantes
     * la cantidad de ocupantes total de la reserva
     * @return
     * retorna el descuento en String formato "100%" 
     */
    public static String getDescuento (int cantidadOcupantes){
        String descuento;
        if (cantidadOcupantes < 3){
            descuento = "0%";
            return descuento;
        }
        int cant = cantidadOcupantes - 2;
        cant *= 10;
        descuento = String.valueOf(cant).concat("%");
        return descuento;
    }
    
    
}
