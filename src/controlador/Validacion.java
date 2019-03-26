/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

/**
 *
 * @author duoc
 */
public class Validacion {
    
    private static boolean pase;
    
    public static boolean validarInt(String str){
        try {
            Integer.valueOf(str);
            pase = true;
        } catch (NumberFormatException e) {
            pase = false;
        }

        return pase;
        
    }
    
}
