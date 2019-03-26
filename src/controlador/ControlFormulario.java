/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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
        frp.setTFNombre(pax.getNombre());
        frp.setTFApellidoPat(pax.getApellidoPat());
        frp.setTFApellidoMat(pax.getApellidoMat());
        frp.setTFNac(pax.getNacionalidad());
        frp.setCBSexo(pax.getSexo());
        frp.setCBFechaAño(pax.getFechaNacimiento());
        frp.setCBFechaMes(pax.getFechaNacimiento());
        frp.setCBFechaDia(pax.getFechaNacimiento());
        
    }
    
}
