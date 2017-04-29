/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sc77.bean;

import com.sc77.dao.CentroMasterDao;
import com.sc77.dao.impl.CentroMasterDaoImpl;
import com.sc77.entities.CentroMaster;
import com.sc77.entities.SubCentro;
import com.sc77.util.hib.FacesUtil;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Hans
 */
@ManagedBean(name="listSubCen")
@ViewScoped
public class listaSubCentro {
    
    private List<SubCentro> listaSubCentro;
    private List<SubCentro> listaFilteredSubCentro;
    private SubCentro subCentroSelected;
    private String nombreCentroMaster;
    private CentroMaster centroMasterPadre;
    
    

    public String getNombreCentroMaster() {
        return nombreCentroMaster;
    }

    public void setNombreCentroMaster(String nombreCentroMaster) {
        this.nombreCentroMaster = nombreCentroMaster;
    } 

    public List<SubCentro> getListaFilteredSubCentro() {
        return listaFilteredSubCentro;
    }

    public void setListaFilteredSubCentro(List<SubCentro> listaFilteredSubCentro) {
        this.listaFilteredSubCentro = listaFilteredSubCentro;
    }

    public SubCentro getSubCentroSelected() {
        return subCentroSelected;
    }

    public void setSubCentroSelected(SubCentro subCentroSelected) {
        this.subCentroSelected = subCentroSelected;
    }
    
    public List<SubCentro> getListaSubCentro() {
        return listaSubCentro;
    }

    public void setListaSubCentro(List<SubCentro> listaSubCentro) {
        this.listaSubCentro = listaSubCentro;
    }
    /**
     * Creates a new instance of listaSubCentro
     */
    public listaSubCentro() {
        System.out.println("CREANDO INSTANCIA DE LISTA SUBCENTRO");
        CentroMaster centroMaster;
        
        centroMaster = (CentroMaster) FacesUtil.getSessionMapValue("LoginBean.centroMaster");
        this.listaSubCentro=new ArrayList<SubCentro>();
        this.nombreCentroMaster="";
        
        if(centroMaster!=null){
            this.listaSubCentro.addAll(centroMaster.getSubCentros());
            this.nombreCentroMaster=centroMaster.getNombreCentromaster();
            this.centroMasterPadre=centroMaster;
            //System.out.println("LLego al constructor de crear subcentro"+centroMaster.getSubCentros().size());
        }
        
    }
    
    public void updateList(ActionEvent actionEvent){
        CentroMasterDao centroMasterDao=new CentroMasterDaoImpl();
        CentroMaster centroMaster;
        
        this.listaSubCentro=new ArrayList<SubCentro>();
        centroMaster=centroMasterDao.buscarCentroMaster(this.centroMasterPadre.getIdCentromaster());
        if(centroMaster!=null){
            this.listaSubCentro.addAll(centroMaster.getSubCentros());
        }
        
    }
}
