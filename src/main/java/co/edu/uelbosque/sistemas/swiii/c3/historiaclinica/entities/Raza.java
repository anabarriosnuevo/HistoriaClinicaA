/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uelbosque.sistemas.swiii.c3.historiaclinica.entities;

/**
 *
 * @author Alejandro
 */
public enum Raza {
    
    MESTIZO("Mestizo"),
    AFRO_COLOMBIANO("Afrocolombiano"),
    INDIGENA("Indigena");
    
    String raza;

    private Raza(String raza) {
        this.raza=raza;
                
    }
    
    
}
