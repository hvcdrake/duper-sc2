package com.sc77.entities;
// Generated 01/05/2017 09:52:18 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Plazo generated by hbm2java
 */
@Entity
@Table(name="Plazo"
    ,catalog="sc77la_dev"
)
public class Plazo  implements java.io.Serializable {


     private Integer idPlazo;
     private CatalogoPlazo catalogoPlazo;
     private Examen examen;
     private Date fechaInico;
     private Date fechaFin;

    public Plazo() {
    }

    public Plazo(CatalogoPlazo catalogoPlazo, Examen examen, Date fechaInico, Date fechaFin) {
       this.catalogoPlazo = catalogoPlazo;
       this.examen = examen;
       this.fechaInico = fechaInico;
       this.fechaFin = fechaFin;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id_plazo", unique=true, nullable=false)
    public Integer getIdPlazo() {
        return this.idPlazo;
    }
    
    public void setIdPlazo(Integer idPlazo) {
        this.idPlazo = idPlazo;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_catalogo_plazo", nullable=false)
    public CatalogoPlazo getCatalogoPlazo() {
        return this.catalogoPlazo;
    }
    
    public void setCatalogoPlazo(CatalogoPlazo catalogoPlazo) {
        this.catalogoPlazo = catalogoPlazo;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_examen", nullable=false)
    public Examen getExamen() {
        return this.examen;
    }
    
    public void setExamen(Examen examen) {
        this.examen = examen;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="fecha_inico", nullable=false, length=10)
    public Date getFechaInico() {
        return this.fechaInico;
    }
    
    public void setFechaInico(Date fechaInico) {
        this.fechaInico = fechaInico;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="fecha_fin", nullable=false, length=10)
    public Date getFechaFin() {
        return this.fechaFin;
    }
    
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }




}


