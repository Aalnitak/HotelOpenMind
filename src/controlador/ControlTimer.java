/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.time.LocalDateTime;

/**
 *
 * @author ljrojas
 */
public class ControlTimer {
    
    public static String CuentaReg(LocalDateTime a) {
                String CuentaReg;
                Long diferencia = java.time.Duration.between(LocalDateTime.now(), a).getSeconds();
                Long segundos = diferencia % 60;
                Long minutos = diferencia / 60;
                Long horas = minutos / 60;
                Long min = minutos % 60;

                String HH = String.valueOf(horas);
                String mm = String.valueOf(min);
                String ss = String.valueOf(segundos);

                if (horas<10) {
                    HH = "0"+HH;
                }
                if (min <10){
                    mm = "0"+mm;
                }
                if (segundos<10) {
                    ss = "0"+ss;
                }

                CuentaReg = HH+":"+mm+":"+ss;

                return CuentaReg;            
            }
    
}
