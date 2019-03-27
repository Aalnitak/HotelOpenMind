/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.time.LocalDate;
import modelo.FormularioRegistroPax;
import modelo.Pax;

/**
 *
 * @author proyetco
 */
public class ControlFormulario {
    
    public static void llenarFormularioRegistro(Pax pax, FormularioRegistroPax frp) {
        //ue lindo es soñar
        frp.setTFRut(pax.getRut());
        frp.setTFDigitoVerificador0(pax.getDigitoVerificador());
        frp.setTFNombre(pax.getNombre());
        frp.setTFApellidoPat(pax.getApellidoPat());
        frp.setTFApellidoMat(pax.getApellidoMat());
        frp.setTFNac(pax.getNacionalidad());
        frp.setCBSexo(pax.getSexo());
        frp.setCBFechaAño(pax.getFechaNacimiento());
        frp.setCBFechaMes(pax.getFechaNacimiento());
        ControlComboBox.llenarCBFechaNacimientoRegistro(pax.getFechaNacimiento().getMonthValue(), pax.getFechaNacimiento().getYear(), frp.getCBFechaDia0());
        frp.setCBFechaDia(pax.getFechaNacimiento());
        
    }
    public static void llenarPasajeroCon(FormularioRegistroPax frp, Pax pax){
        LocalDate cumpleaños = LocalDate.of(frp.getCBFechaAño(),frp.getCBFechaMes(),frp.getFechaDia());
        
        pax.setRut(frp.getTFRut());
        pax.setDigitoVerificador(frp.getTFDigitoVerificador0());
        pax.setNombre(frp.getTFNombre());
        pax.setApellidoPat(frp.getTFApellidoPat());
        pax.setApellidoMat(frp.getTFApellidoMat());
        pax.setNacionalidad(frp.getTFNac());
        pax.setSexo(frp.getCBSexo());
        pax.setFechaNacimiento(cumpleaños);
        
    }
    
}
