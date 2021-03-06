package com.sc77.entities;
// Generated 01/05/2017 09:52:18 PM by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * UbicacionExamen generated by hbm2java
 */
@Entity
@Table(name="UbicacionExamen"
    ,catalog="sc77la_dev"
)
public class UbicacionExamen  implements java.io.Serializable {


     private Integer idUbicacionExamen;
     private SubCentro subCentro;
     private Examen examen;

    public UbicacionExamen() {
    }

    public UbicacionExamen(SubCentro subCentro, Examen examen) {
       this.subCentro = subCentro;
       this.examen = examen;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id_ubicacion_examen", unique=true, nullable=false)
    public Integer getIdUbicacionExamen() {
        return this.idUbicacionExamen;
    }
    
    public void setIdUbicacionExamen(Integer idUbicacionExamen) {
        this.idUbicacionExamen = idUbicacionExamen;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_subcentro", nullable=false)
    public SubCentro getSubCentro() {
        return this.subCentro;
    }
    
    public void setSubCentro(SubCentro subCentro) {
        this.subCentro = subCentro;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_examen", nullable=false)
    public Examen getExamen() {
        return this.examen;
    }
    
    public void setExamen(Examen examen) {
        this.examen = examen;
    }




}


