package com.sc77.entities;
// Generated 01/05/2017 09:52:18 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Examen generated by hbm2java
 */
@Entity
@Table(name="Examen"
    ,catalog="sc77la_dev"
)
public class Examen  implements java.io.Serializable {


     private Integer idExamen;
     private Modalidad modalidad;
     private Grado grado;
     private Date fechaExamen;
     private String estado;
     private Set plazos = new HashSet(0);
     private Set programas = new HashSet(0);
     private Set ubicacionExamens = new HashSet(0);

    public Examen() {
    }

	
    public Examen(Modalidad modalidad, Grado grado, Date fechaExamen, String estado) {
        this.modalidad = modalidad;
        this.grado = grado;
        this.fechaExamen = fechaExamen;
        this.estado = estado;
    }
    public Examen(Modalidad modalidad, Grado grado, Date fechaExamen, String estado, Set plazos, Set programas, Set ubicacionExamens) {
       this.modalidad = modalidad;
       this.grado = grado;
       this.fechaExamen = fechaExamen;
       this.estado = estado;
       this.plazos = plazos;
       this.programas = programas;
       this.ubicacionExamens = ubicacionExamens;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id_examen", unique=true, nullable=false)
    public Integer getIdExamen() {
        return this.idExamen;
    }
    
    public void setIdExamen(Integer idExamen) {
        this.idExamen = idExamen;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_modalidad", nullable=false)
    public Modalidad getModalidad() {
        return this.modalidad;
    }
    
    public void setModalidad(Modalidad modalidad) {
        this.modalidad = modalidad;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_grado", nullable=false)
    public Grado getGrado() {
        return this.grado;
    }
    
    public void setGrado(Grado grado) {
        this.grado = grado;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="fecha_examen", nullable=false, length=10)
    public Date getFechaExamen() {
        return this.fechaExamen;
    }
    
    public void setFechaExamen(Date fechaExamen) {
        this.fechaExamen = fechaExamen;
    }
    
    @Column(name="estado", nullable=false, length=20)
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="examen")
    public Set getPlazos() {
        return this.plazos;
    }
    
    public void setPlazos(Set plazos) {
        this.plazos = plazos;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="examen")
    public Set getProgramas() {
        return this.programas;
    }
    
    public void setProgramas(Set programas) {
        this.programas = programas;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="examen")
    public Set getUbicacionExamens() {
        return this.ubicacionExamens;
    }
    
    public void setUbicacionExamens(Set ubicacionExamens) {
        this.ubicacionExamens = ubicacionExamens;
    }




}


