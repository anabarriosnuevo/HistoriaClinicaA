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
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import org.joda.time.Duration;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.primefaces.component.calendar.Calendar;
import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.TabCloseEvent;

/**
 *
 * @author Alejandro
 */
@ManagedBean
@ViewScoped
public class VistaPaciente implements Serializable {
    
    private Paciente paciente;
    
    
    private String nombre;
    private String apellido;
    private String sexo;
    private int meses;
    private int dias;
    private Date fechaNac;
    
    private transient ServicioPacienteInt sp;
    
    
    public void cambioTab(TabChangeEvent event) {
        salvarPaciente();
    }
    
    public void cerroTab(TabCloseEvent event) {
        salvarPaciente();
    }
    
    private void salvarPaciente() {
        
        if (paciente == null) {
            paciente = new Paciente();
        }
        
        paciente.setApellidos(this.apellido);
        paciente.setDias(this.dias);
        paciente.setFechaNacimiento(this.fechaNac);
        paciente.setMeses(this.meses);
        paciente.setNombre(this.nombre);
        
        sp.getRp().save(paciente);
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
        java.util.Calendar fecNacCal = java.util.Calendar.getInstance();
        fecNacCal.setTime((Date)calendar.getLocalValue());
        this.fechaNac = fecNacCal.getTime();
        
        java.util.Calendar ahora = java.util.Calendar.getInstance();
        long hoy = ahora.getTimeInMillis();
        long diasv = hoy - fecNacCal.getTimeInMillis();
        
        
        Duration d = new Duration(diasv);
        this.dias = (int) d.getStandardDays();
        Period period = new Period(fecNacCal.getTimeInMillis(), hoy, PeriodType.months());
        this.meses = period.getMonths();
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    public String getSexo() {
        return sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public int getMeses() {
        return meses;
    }
    
    public void setMeses(int meses) {
        this.meses = meses;
    }
    
    public int getDias() {
        return dias;
    }
    
    public void setDias(int dias) {
        this.dias = dias;
    }
    
    public Date getFechaNac() {
        return fechaNac;
    }
    
    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }
    
    
}
