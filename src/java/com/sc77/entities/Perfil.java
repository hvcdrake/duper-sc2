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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Perfil generated by hbm2java
 */
@Entity
@Table(name="Perfil"
    ,catalog="sc77la_dev"
)
public class Perfil  implements java.io.Serializable {


     private Integer idPerfil;
     private String descPerfil;
     private Set permisoses = new HashSet(0);
     private Set usuarios = new HashSet(0);

    public Perfil() {
    }

	
    public Perfil(String descPerfil) {
        this.descPerfil = descPerfil;
    }
    public Perfil(String descPerfil, Set permisoses, Set usuarios) {
       this.descPerfil = descPerfil;
       this.permisoses = permisoses;
       this.usuarios = usuarios;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="id_perfil", unique=true, nullable=false)
    public Integer getIdPerfil() {
        return this.idPerfil;
    }
    
    public void setIdPerfil(Integer idPerfil) {
        this.idPerfil = idPerfil;
    }
    
    @Column(name="desc_perfil", nullable=false, length=30)
    public String getDescPerfil() {
        return this.descPerfil;
    }
    
    public void setDescPerfil(String descPerfil) {
        this.descPerfil = descPerfil;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="perfil")
    public Set getPermisoses() {
        return this.permisoses;
    }
    
    public void setPermisoses(Set permisoses) {
        this.permisoses = permisoses;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="perfil")
    public Set getUsuarios() {
        return this.usuarios;
    }
    
    public void setUsuarios(Set usuarios) {
        this.usuarios = usuarios;
    }




}


