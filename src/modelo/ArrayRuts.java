/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author proyetco
 */
public class ArrayRuts {

    private static ArrayList<Integer> ruts;

    private ArrayRuts() {

    }

    public static ArrayList<Integer> getArray() {
        if (ruts==null){
            ruts = new ArrayList<>();
            
        }
        return ruts;
    }

    public static void setRut(int rut) {
        ruts.add(rut);
    }

    public static void clearArray() {
        ruts.clear();
    }

}
