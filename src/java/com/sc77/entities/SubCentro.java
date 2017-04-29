package com.sc77.entities;
// Generated 27/04/2017 05:32:16 AM by Hibernate Tools 3.2.1.GA


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

/**
 * SubCentro generated by hbm2java
 */
@Entity
@Table(name="SubCentro"
    ,catalog="sc77la_dev"
)
public class SubCentro  implements java.io.Serializable {


     private Integer idSubcentro;
     private Localidad localidad;
     private CentroMaster centroMaster;
     private String nombreSubcentro;
     private String urlSubcentro;
     private int capacidadSubcentro;
     private int capacidadConfirmada;
     private int rankingListaPreferencia;
     private String dirSubcentro;
     private Set contactos = new HashSet(0);
     private Set examens = new HashSet(0);
     private Set ubicacionExamens = new HashSet(0);

    public SubCentro() {
    }

	
    public SubCentro(CentroMaster centroMaster, String nombreSubcentro, String urlSubcentro, int capacidadSubcentro, int capacidadConfirmada, int rankingListaPreferencia) {
        this.centroMaster = centroMaster;
        this.nombreSubcentro = nombreSubcentro;
        this.urlSubcentro = urlSubcentro;
        this.capacidadSubcentro = capacidadSubcentro;
        this.capacidadConfirmada = capacidadConfirmada;
        this.rankingListaPreferencia = rankingListaPreferencia;
    }
    public SubCentro(Localidad localidad, CentroMaster centroMaster, String nombreSubcentro, String urlSubcentro, int capacidadSubcentro, int capacidadConfirmada, int rankingListaPreferencia, String dirSubcentro, Set contactos, Set examens, Set ubicacionExamens) {
       this.localidad = localidad;
       this.centroMaster = centroMaster;
       this.nombreSubcentro = nombreSubcentro;
       this.urlSubcentro = urlSubcentro;
       this.capacidadSubcentro = capacidadSubcentro;
       this.capacidadConfirmada = capacidadConfirmada;
       this.rankingListaPreferencia = rankingListaPreferencia;
       this.dirSubcentro = dirSubcentro;
       this.contactos = contactos;
       this.examens = examens;
       this.ubicacionExamens = ubicacionExamens;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id_subcentro", unique=true, nullable=false)
    public Integer getIdSubcentro() {
        return this.idSubcentro;
    }
    
    public void setIdSubcentro(Integer idSubcentro) {
        this.idSubcentro = idSubcentro;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_localidad")
    public Localidad getLocalidad() {
        return this.localidad;
    }
    
    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_centromaster", nullable=false)
    public CentroMaster getCentroMaster() {
        return this.centroMaster;
    }
    
    public void setCentroMaster(CentroMaster centroMaster) {
        this.centroMaster = centroMaster;
    }
    
    @Column(name="nombre_subcentro", nullable=false, length=100)
    public String getNombreSubcentro() {
        return this.nombreSubcentro;
    }
    
    public void setNombreSubcentro(String nombreSubcentro) {
        this.nombreSubcentro = nombreSubcentro;
    }
    
    @Column(name="url_subcentro", nullable=false, length=50)
    public String getUrlSubcentro() {
        return this.urlSubcentro;
    }
    
    public void setUrlSubcentro(String urlSubcentro) {
        this.urlSubcentro = urlSubcentro;
    }
    
    @Column(name="capacidad_subcentro", nullable=false)
    public int getCapacidadSubcentro() {
        return this.capacidadSubcentro;
    }
    
    public void setCapacidadSubcentro(int capacidadSubcentro) {
        this.capacidadSubcentro = capacidadSubcentro;
    }
    
    @Column(name="capacidad_confirmada", nullable=false)
    public int getCapacidadConfirmada() {
        return this.capacidadConfirmada;
    }
    
    public void setCapacidadConfirmada(int capacidadConfirmada) {
        this.capacidadConfirmada = capacidadConfirmada;
    }
    
    @Column(name="ranking_lista_preferencia", nullable=false)
    public int getRankingListaPreferencia() {
        return this.rankingListaPreferencia;
    }
    
    public void setRankingListaPreferencia(int rankingListaPreferencia) {
        this.rankingListaPreferencia = rankingListaPreferencia;
    }
    
    @Column(name="dir_subcentro", length=150)
    public String getDirSubcentro() {
        return this.dirSubcentro;
    }
    
    public void setDirSubcentro(String dirSubcentro) {
        this.dirSubcentro = dirSubcentro;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="subCentro")
    public Set getContactos() {
        return this.contactos;
    }
    
    public void setContactos(Set contactos) {
        this.contactos = contactos;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="subCentro")
    public Set getExamens() {
        return this.examens;
    }
    
    public void setExamens(Set examens) {
        this.examens = examens;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="subCentro")
    public Set getUbicacionExamens() {
        return this.ubicacionExamens;
    }
    
    public void setUbicacionExamens(Set ubicacionExamens) {
        this.ubicacionExamens = ubicacionExamens;
    }




}


