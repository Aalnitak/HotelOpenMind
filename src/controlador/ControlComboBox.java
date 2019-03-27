/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import javax.swing.JComboBox;

/**
 *
 * @author duoc
 */
public class ControlComboBox {

    public static void llenarCBHabitacion(JComboBox cb) {
            JDBCHabitacionDAO jdbcHab = new JDBCHabitacionDAO();
            cb.addItem("--Seleccione--");
            jdbcHab.mapHabitacionDisponible.keySet().forEach((name) -> {
                cb.addItem(name);
        });
            


    }
    
    public static void llenarCBFechaNacimientoRegistro(int idMes, int año, JComboBox diaFechaComboBox) {
        
        idMes +=1;
        int i;
        boolean bisiesto;
        bisiesto = año % 4 == 0;
        switch(idMes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                i = 31;
                break;
            case 2:
                i = 28;
                if(bisiesto) i = 29;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                i = 30;
                break;
            default:
                i = 0;
        }
       
        diaFechaComboBox.removeAllItems();
        
        for(int j=0;j<i;j++){
            diaFechaComboBox.addItem(String.valueOf(j+1));
        }
        
    }

}
