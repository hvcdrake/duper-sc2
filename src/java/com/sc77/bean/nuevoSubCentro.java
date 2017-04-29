/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sc77.bean;

import com.sc77.dao.LocalidadDao;
import com.sc77.dao.SubCentroDao;
import com.sc77.dao.impl.LocalidadDaoImpl;
import com.sc77.dao.impl.SubCentroDaoImpl;
import com.sc77.entities.CentroMaster;
import com.sc77.entities.Localidad;
import com.sc77.entities.SubCentro;
import com.sc77.util.hib.FacesUtil;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Hans
 */
@ManagedBean(name="nSubCentro")
@RequestScoped
public class nuevoSubCentro {
    
    private String nombreSubCentro;
    private String urlSubCentro;
    private int capacidadSubCentro;
    
    private String dirSubCentro;
    private String nombreProvincia;
    private String nombreAutonomia;
    
    private Localidad localidadAutomatica=null;

    public String getNombreProvincia() {
        return nombreProvincia;
    }

    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
    }

    public String getNombreAutonomia() {
        return nombreAutonomia;
    }

    public void setNombreAutonomia(String nombreAutonomia) {
        this.nombreAutonomia = nombreAutonomia;
    }
    
    public Localidad getLocalidadAutomatica() {
        return localidadAutomatica;
    }

    public void setLocalidadAutomatica(Localidad localidadAutomatica) {
        this.localidadAutomatica = localidadAutomatica;
    }
    
    public String getDirSubCentro() {
        return dirSubCentro;
    }

    public void setDirSubCentro(String dirSubCentro) {
        this.dirSubCentro = dirSubCentro;
    }

    public String getNombreSubCentro() {
        return nombreSubCentro;
    }

    public void setNombreSubCentro(String nombreSubCentro) {
        this.nombreSubCentro = nombreSubCentro;
    }

    public String getUrlSubCentro() {
        return urlSubCentro;
    }

    public void setUrlSubCentro(String urlSubCentro) {
        this.urlSubCentro = urlSubCentro;
    }

    public int getCapacidadSubCentro() {
        return capacidadSubCentro;
    }

    public void setCapacidadSubCentro(int capacidadSubCentro) {
        this.capacidadSubCentro = capacidadSubCentro;
    }

    /**
     * Creates a new instance of nuevoSubCentro
     */
    public nuevoSubCentro() {
    }
    
    public void limpiarCampos(){
        this.nombreSubCentro="";
        this.urlSubCentro="";
        this.capacidadSubCentro=0;
        this.dirSubCentro="";
        this.localidadAutomatica=null;
        this.nombreProvincia="";
        this.nombreAutonomia="";
    }
    
    public void crearSubCentro(ActionEvent actionEvent){      
        SubCentro subCentro=new SubCentro();
        CentroMaster centroMaster;
        SubCentroDao subCentroDao=new SubCentroDaoImpl();
        
        centroMaster = (CentroMaster) FacesUtil.getSessionMapValue("LoginBean.centroMaster");
        
        
            subCentro.setNombreSubcentro(this.nombreSubCentro);
            subCentro.setUrlSubcentro(this.urlSubCentro);
            subCentro.setCapacidadConfirmada(this.capacidadSubCentro);
            subCentro.setCapacidadSubcentro(this.capacidadSubCentro);
            subCentro.setRankingListaPreferencia(subCentroDao.lastRankingPreferencia(centroMaster)+1);
            subCentro.setLocalidad(this.localidadAutomatica);
            subCentro.setDirSubcentro(this.dirSubCentro);
            subCentro.setCentroMaster(centroMaster);

            String res=subCentroDao.crearSubCentro(subCentro);
            System.out.println("ID:" +res);
        
        this.limpiarCampos();
    }
    
    public List<Localidad> listaAutoCompleteLocalidad(String cad)
    {
        this.localidadAutomatica= null;
        LocalidadDao localidadDao = new LocalidadDaoImpl();
        List<Localidad> listaFiltrada = localidadDao.filtrarLocalidadPorDesc(cad);
        return listaFiltrada;
    }
    
    public void selectLocalidad()
    {
        System.out.println("SELECT LOCALIDAD");
        
        System.out.println("ID Localidad automatica:"+this.localidadAutomatica.getIdLocalidad());
        System.out.println("Nombre Localidad automatica:"+this.localidadAutomatica.getNombreLocalidad());
        this.nombreProvincia=this.localidadAutomatica.getProvincia().getNombreProvincia();
        this.nombreAutonomia=this.localidadAutomatica.getProvincia().getAutonomia().getNombreAutonomia();
    }
}
