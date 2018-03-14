/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sc77.bean;

import com.sc77.dao.ExamenDao;
import com.sc77.dao.impl.ExamenDaoImpl;
import com.sc77.entities.Examen;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Hans
 */
@ManagedBean(name="listExaCM")
@ViewScoped
public class listaExamenesCentroMaster {

    private List<Examen> examenes;
    private List<Examen> examenesFiltered;
    private Examen examenSelected;

    public List<Examen> getExamenesFiltered() {
        return examenesFiltered;
    }

    public void setExamenesFiltered(List<Examen> examenesFiltered) {
        this.examenesFiltered = examenesFiltered;
    }

    public Examen getExamenSelected() {
        return examenSelected;
    }

    public void setExamenSelected(Examen examenSelected) {
        this.examenSelected = examenSelected;
    }
    
    public List<Examen> getExamenes() {
        return examenes;
    }

    public void setExamenes(List<Examen> examenes) {
        this.examenes = examenes;
    }
    /**
     * Creates a new instance of listaExamenesCentroMaster
     */
    public listaExamenesCentroMaster() {
    }
    
    @PostConstruct
    public void init(){
        this.listarExamenes();
    }
    
    public void listarExamenes(){
        ExamenDao examenDao = new ExamenDaoImpl();
        this.examenes=examenDao.listarExamenes();        
    }
    
    public String mostrarPublicar(String estado){
        if(estado.compareToIgnoreCase("AGENDADO")==0){
            return "true";
        }
        else{
            return "false";
        }
    }
    
    public void publicarExamen(ActionEvent actionEvent){
        ExamenDao examenDao = new ExamenDaoImpl();
        FacesMessage msg;
        
        System.out.println("Examen:"+this.examenSelected.getGrado().getNombreCortoGrado()
                +" "+this.examenSelected.getFechaExamen());
        
        examenDao.publicarExamen(this.examenSelected);
        this.listarExamenes();
        
        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "INFO", "Examen publicado!!!");
        FacesContext.getCurrentInstance().addMessage(null, msg);  
    }
}
