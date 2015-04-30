/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uelbosque.sistemas.swiii.c3.historiaclinica.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Alejandro
 */
@WebAppConfiguration
@ContextConfiguration(classes = {HistoriClinicaConfigQA.class})
public class HistoriaClinicaConfigTest  extends AbstractTestNGSpringContextTests{
    
     @Autowired
     DataSource ds;
     
     
    @Test
    public void pruebaParaCargarElContextoDeLaApplicacion(){
        
    }
    
    @Test
    public void elDataSourceNoEsNulo(){
        Assert.assertNotNull(ds);
    }
    
}

