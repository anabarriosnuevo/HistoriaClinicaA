/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uelbosque.sistemas.swiii.c3.historiaclinica.services;

import java.util.HashMap;

/**
 *
 * @author Alejandro
 */
public class ServiciosDeAplicacionSpring {
    
    private static HashMap<String,Object> servicios;
    private static ServiciosDeAplicacionSpring instance;
    
    private  ServiciosDeAplicacionSpring(){
        servicios=new HashMap<>();
    }
    
    public static ServiciosDeAplicacionSpring getServiciosDeAplicacionSpring(){
        if(instance==null){
            instance=new ServiciosDeAplicacionSpring();
        }
        return instance;
    }
    
    public ServicioPacienteInt getServicioPaciente(String id){
        return (ServicioPacienteInt)servicios.get(id);
    }
    
    public void addServicio(String name, Object Servicio){
        servicios.put(name, Servicio);
    }
}
