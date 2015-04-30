/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uelbosque.sistemas.swiii.c3.historiaclinica.services;

import co.edu.uelbosque.sistemas.swiii.c3.historiaclinica.repositories.RepositorioPaciente;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Este es el componente de spring para el manejo de
 * los pacientes
 * @author Alejandro
 */
@Component("servicioPaciente")
public class ServicioPaciente implements ServicioPacienteInt {
    
    @Autowired
    private RepositorioPaciente rp;
    
    public ServicioPaciente(){
      
    }
    
    /**
     * Debe ser llamado para configurar el servicio en la clase
     * estática
     */
    @PostConstruct
    public void load(){
         ServiciosDeAplicacionSpring.getServiciosDeAplicacionSpring().addServicio("servicioPaciente", this);
    }

    /**
     * @return the rp
     */
    @Override
    public RepositorioPaciente getRp() {
        return rp;
    }

    /**
     * @param rp the rp to set
     */
    @Override
    public void setRp(RepositorioPaciente rp) {
        this.rp = rp;
    }
}
