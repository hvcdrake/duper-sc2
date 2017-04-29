package com.sc77.entities;
// Generated 27/04/2017 05:32:16 AM by Hibernate Tools 3.2.1.GA


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
 * Contacto generated by hbm2java
 */
@Entity
@Table(name="Contacto"
    ,catalog="sc77la_dev"
)
public class Contacto  implements java.io.Serializable {


     private Integer idContacto;
     private CentroMaster centroMaster;
     private Usuario usuario;
     private SubCentro subCentro;
     private String emailContacto;
     private String telefonoContacto;
     private String celularContacto;
     private String nombreContacto;
     private String apellidoContacto;
     private String estadoContacto;

    public Contacto() {
    }

	
    public Contacto(String emailContacto, String telefonoContacto, String celularContacto, String nombreContacto, String apellidoContacto, String estadoContacto) {
        this.emailContacto = emailContacto;
        this.telefonoContacto = telefonoContacto;
        this.celularContacto = celularContacto;
        this.nombreContacto = nombreContacto;
        this.apellidoContacto = apellidoContacto;
        this.estadoContacto = estadoContacto;
    }
    public Contacto(CentroMaster centroMaster, Usuario usuario, SubCentro subCentro, String emailContacto, String telefonoContacto, String celularContacto, String nombreContacto, String apellidoContacto, String estadoContacto) {
       this.centroMaster = centroMaster;
       this.usuario = usuario;
       this.subCentro = subCentro;
       this.emailContacto = emailContacto;
       this.telefonoContacto = telefonoContacto;
       this.celularContacto = celularContacto;
       this.nombreContacto = nombreContacto;
       this.apellidoContacto = apellidoContacto;
       this.estadoContacto = estadoContacto;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id_contacto", unique=true, nullable=false)
    public Integer getIdContacto() {
        return this.idContacto;
    }
    
    public void setIdContacto(Integer idContacto) {
        this.idContacto = idContacto;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_centromaster")
    public CentroMaster getCentroMaster() {
        return this.centroMaster;
    }
    
    public void setCentroMaster(CentroMaster centroMaster) {
        this.centroMaster = centroMaster;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_usuario")
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_subcentro")
    public SubCentro getSubCentro() {
        return this.subCentro;
    }
    
    public void setSubCentro(SubCentro subCentro) {
        this.subCentro = subCentro;
    }
    
    @Column(name="email_contacto", nullable=false, length=100)
    public String getEmailContacto() {
        return this.emailContacto;
    }
    
    public void setEmailContacto(String emailContacto) {
        this.emailContacto = emailContacto;
    }
    
    @Column(name="telefono_contacto", nullable=false, length=30)
    public String getTelefonoContacto() {
        return this.telefonoContacto;
    }
    
    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }
    
    @Column(name="celular_contacto", nullable=false, length=30)
    public String getCelularContacto() {
        return this.celularContacto;
    }
    
    public void setCelularContacto(String celularContacto) {
        this.celularContacto = celularContacto;
    }
    
    @Column(name="nombre_contacto", nullable=false, length=100)
    public String getNombreContacto() {
        return this.nombreContacto;
    }
    
    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }
    
    @Column(name="apellido_contacto", nullable=false, length=100)
    public String getApellidoContacto() {
        return this.apellidoContacto;
    }
    
    public void setApellidoContacto(String apellidoContacto) {
        this.apellidoContacto = apellidoContacto;
    }
    
    @Column(name="estado_contacto", nullable=false, length=25)
    public String getEstadoContacto() {
        return this.estadoContacto;
    }
    
    public void setEstadoContacto(String estadoContacto) {
        this.estadoContacto = estadoContacto;
    }




}

