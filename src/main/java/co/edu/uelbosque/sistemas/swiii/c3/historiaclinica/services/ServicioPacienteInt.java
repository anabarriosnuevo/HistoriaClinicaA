/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uelbosque.sistemas.swiii.c3.historiaclinica.services;

import co.edu.uelbosque.sistemas.swiii.c3.historiaclinica.repositories.RepositorioPaciente;


/**
 *
 * @author Alejandro
 */
public interface ServicioPacienteInt {

    /**
     * @return the rp
     */
    RepositorioPaciente getRp();

    /**
     * @param rp the rp to set
     */
    void setRp(RepositorioPaciente rp);
    
}
