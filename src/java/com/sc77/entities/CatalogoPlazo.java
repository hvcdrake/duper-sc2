package com.sc77.entities;
// Generated 01/05/2017 09:52:18 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * CatalogoPlazo generated by hbm2java
 */
@Entity
@Table(name="CatalogoPlazo"
    ,catalog="sc77la_dev"
)
public class CatalogoPlazo  implements java.io.Serializable {


     private Integer idCatalogoPlazo;
     private String descPlazo;
     private Set plazos = new HashSet(0);

    public CatalogoPlazo() {
    }

	
    public CatalogoPlazo(String descPlazo) {
        this.descPlazo = descPlazo;
    }
    public CatalogoPlazo(String descPlazo, Set plazos) {
       this.descPlazo = descPlazo;
       this.plazos = plazos;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id_catalogo_plazo", unique=true, nullable=false)
    public Integer getIdCatalogoPlazo() {
        return this.idCatalogoPlazo;
    }
    
    public void setIdCatalogoPlazo(Integer idCatalogoPlazo) {
        this.idCatalogoPlazo = idCatalogoPlazo;
    }
    
    @Column(name="desc_plazo", nullable=false, length=30)
    public String getDescPlazo() {
        return this.descPlazo;
    }
    
    public void setDescPlazo(String descPlazo) {
        this.descPlazo = descPlazo;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="catalogoPlazo")
    public Set getPlazos() {
        return this.plazos;
    }
    
    public void setPlazos(Set plazos) {
        this.plazos = plazos;
    }




}


