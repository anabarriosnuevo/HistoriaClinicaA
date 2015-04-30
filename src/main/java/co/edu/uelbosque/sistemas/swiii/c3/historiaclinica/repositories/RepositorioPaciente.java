/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uelbosque.sistemas.swiii.c3.historiaclinica.repositories;

import co.edu.uelbosque.sistemas.swiii.c3.historiaclinica.entities.Paciente;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Alejandro
 */
public interface RepositorioPaciente extends CrudRepository<Paciente, Long>{
    
    
}
