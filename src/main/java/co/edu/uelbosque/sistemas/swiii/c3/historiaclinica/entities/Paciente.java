/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uelbosque.sistemas.swiii.c3.historiaclinica.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.GenericGenerator;
import org.joda.time.Duration;
import org.joda.time.LocalDate;
import org.joda.time.Period;
import org.joda.time.PeriodType;

/**
 *
 * @author Alejandro
 */
@Entity
@ManagedBean
@SessionScoped
public class Paciente implements Serializable {

    @Id
    @GenericGenerator(name = "generadorIdPaciente", strategy = "increment")
    @GeneratedValue(generator = "generadorIdPaciente")
    private Long id;
    String nombre;
    String apellidos;
    @Temporal(value = TemporalType.DATE)
    Date fechaNacimiento;
    @Enumerated(EnumType.STRING)
    Sexo fenotipoSexual;
    @Enumerated(EnumType.STRING)
    Raza caracteristicaFenotipica;
    Integer meses;
    Integer dias;
    Integer edad;

    private transient Calendar nacimiento;
    
    public Paciente() {
        this.nacimiento = Calendar.getInstance();
        this.meses = 0;
        this.dias = 0;
        this.edad = 0;
    }

    public Integer getMeses() {
        return meses;
    }

    public void setMeses(Integer meses) {
        Calendar x = Calendar.getInstance();
        x.add(Calendar.MONTH, -1 * meses);
        this.nacimiento = x;
        this.meses = meses;
    }

    public Integer getDias() {

        return dias;
    }

    public void setDias(Integer dias) {
        Calendar x = Calendar.getInstance();
        x.add(Calendar.DAY_OF_MONTH, -1 * dias);
        this.nacimiento = x;

        this.dias = dias;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.toUpperCase();
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos.toUpperCase();
    }

    private Calendar getNacimiento() {
        return nacimiento;
    }

    private void setNacimiento(Calendar nacimiento) {
        Calendar ahora = Calendar.getInstance();
        long hoy = ahora.getTimeInMillis();
        long dias = hoy - nacimiento.getTimeInMillis();
        Duration d = new Duration(dias);
        this.dias = (int) d.getStandardDays();
        Period period = new Period(nacimiento.getTimeInMillis(), hoy, PeriodType.months());
        this.meses = period.getMonths();
        this.nacimiento = nacimiento;
    }

    public Sexo getFenotipoSexual() {
        return fenotipoSexual;
    }

    public void setFenotipoSexual(Sexo fenotipoSexual) {
        this.fenotipoSexual = fenotipoSexual;
    }

    public Raza getCaracteristicaFenotipica() {
        return caracteristicaFenotipica;
    }

    public void setCaracteristicaFenotipica(Raza caracteristicaFenotipica) {
        this.caracteristicaFenotipica = caracteristicaFenotipica;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Paciente{" + "id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + '}';
    }

    /**
     * @return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        Calendar x=Calendar.getInstance();
        x.setTime(fechaNacimiento);
        this.setNacimiento(x);
        this.fechaNacimiento = this.nacimiento.getTime();
    }

}
