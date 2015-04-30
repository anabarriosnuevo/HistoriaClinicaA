/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uelbosque.sistemas.swiii.c3.historiaclinica.entities;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Alejandro
 */
@ManagedBean
@ApplicationScoped
public class FenotipoSexual {
    
    public Sexo[] getSexos(){
        return Sexo.values();
    }
}
