/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uelbosque.sistemas.swiii.c3.historiaclinica.view;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import co.edu.uelbosque.sistemas.swiii.c3.historiaclinica.entities.Paciente;
import co.edu.uelbosque.sistemas.swiii.c3.historiaclinica.services.ServicioPacienteInt;
import co.edu.uelbosque.sistemas.swiii.c3.historiaclinica.services.ServiciosDeAplicacionSpring;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;

/**
 *
 * @author Alejandro
 */
@ManagedBean
@SessionScoped
public class VistaPaciente implements Serializable {

    @ManagedProperty(value = "#{paciente}")
    private Paciente paciente;

    private transient ServicioPacienteInt sp;

    public void cambioTab(TabChangeEvent event) {
        salvarPaciente();
    }

    public void cerroTab(TabCloseEvent event) {
        salvarPaciente();
    }

    private void salvarPaciente() {

        sp.getRp().save(paciente);
    }

    /**
     * @return the paciente
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * @param paciente the paciente to set
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    /**
     * @return the sp
     */
    public ServicioPacienteInt getSp() {
        return sp;
    }

    /**
     * @param sp the sp to set
     */
    public void setSp(ServicioPacienteInt sp) {
        this.sp = sp;
    }

    @PostConstruct
    public void injectSpringServiceManually() {
        String name = "servicioPaciente";
        this.sp = ServiciosDeAplicacionSpring.getServiciosDeAplicacionSpring().getServicioPaciente(name);
    }

    public void actualizarFechaNacimiento(AjaxBehaviorEvent event) {
        
        Calendar calendar =  (Calendar) event.getSource();
        Date d=(Date)calendar.getLocalValue();
        paciente.setFechaNacimiento(d);
        
    }
}
