/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sc77.bean;

import com.sc77.dao.GradoDao;
import com.sc77.dao.ModalidadDao;
import com.sc77.dao.impl.GradoDaoImpl;
import com.sc77.dao.impl.ModalidadDaoImpl;
import com.sc77.entities.Examen;
import com.sc77.entities.Grado;
import com.sc77.entities.Modalidad;
import com.sc77.entities.Plazo;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Hans
 */
@ManagedBean(name="newEx")
@RequestScoped
public class newExamen {
    
    private Date fechaExamen;
    
    private Map<String,String> modalidades;
    private String modalidadSel;
    
    private Map<String,String> grados;
    private String gradoSel;
    
    private Date plazoRegularIni;
    private Date plazoRegularFin;
    private Date plazoExtFin;
    private Date plazoExtIni;

    public Date getPlazoRegularIni() {
        return plazoRegularIni;
    }

    public void setPlazoRegularIni(Date plazoRegularIni) {
        this.plazoRegularIni = plazoRegularIni;
    }

    public Date getPlazoRegularFin() {
        return plazoRegularFin;
    }

    public void setPlazoRegularFin(Date plazoRegularFin) {
        this.plazoRegularFin = plazoRegularFin;
    }

    public Date getPlazoExtFin() {
        return plazoExtFin;
    }

    public void setPlazoExtFin(Date plazoExtFin) {
        this.plazoExtFin = plazoExtFin;
    }

    public Date getPlazoExtIni() {
        return plazoExtIni;
    }

    public void setPlazoExtIni(Date plazoExtIni) {
        this.plazoExtIni = plazoExtIni;
    }
    
    public Map<String, String> getGrados() {
        return grados;
    }

    public void setGrados(Map<String, String> grados) {
        this.grados = grados;
    }

    public String getGradoSel() {
        return gradoSel;
    }

    public void setGradoSel(String gradoSel) {
        this.gradoSel = gradoSel;
    }

    public Map<String, String> getModalidades() {
        return modalidades;
    }

    public void setModalidades(Map<String, String> modalidades) {
        this.modalidades = modalidades;
    }

    public String getModalidadSel() {
        return modalidadSel;
    }

    public void setModalidadSel(String modalidadSel) {
        this.modalidadSel = modalidadSel;
    }
    
    public Date getFechaExamen() {
        return fechaExamen;
    }

    public void setFechaExamen(Date fechaExamen) {
        this.fechaExamen = fechaExamen;
    }

    /**
     * Creates a new instance of newExamen
     */
    public newExamen() {
        System.out.println("MANAGED BEAN NEW EXAMEN INSTANCIADO");
        this.inicializarDropDowns();
    }
    
    public void inicializarDropDowns(){
        
        this.llenarModalidades();
        this.llenarGrados();
    }
    
    public void llenarModalidades(){
        ModalidadDao modalidadDao=new ModalidadDaoImpl();
        List<Modalidad> list=modalidadDao.getAllModalidades();
        this.modalidades = new HashMap<String, String>();
        
        for(Modalidad m:list){
            this.modalidades.put(m.getDescModalidad(),m.getDescModalidad());            
        }
    }
    
    public void llenarGrados(){
        GradoDao gradoDao=new GradoDaoImpl();
        List<Grado> list=gradoDao.getAllGrados();
        this.grados = new HashMap<String, String>();
        
        for(Grado g:list){
            this.grados.put(g.getDescGrado(),g.getDescGrado());            
        }        
    }
    
    public void agendarExamen(ActionEvent actionEvent){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        GradoDao gradoDao=new GradoDaoImpl();
        ModalidadDao modalidadDao=new ModalidadDaoImpl();
        Examen examen=new Examen();
        Plazo plazoNormal=new Plazo();
        Plazo plazoExtemp=new Plazo();
        
        System.out.println("grado:"+this.gradoSel);
        System.out.println("modad:"+this.modalidadSel);
        System.out.println("fechha exa:"+sdf.format(this.fechaExamen));
        System.out.println("fechha pla ini:"+sdf.format(this.plazoRegularIni));
        System.out.println("fechha pla ini:"+sdf.format(this.plazoRegularFin));
        System.out.println("fechha ext ini:"+sdf.format(this.plazoExtIni));
        System.out.println("fechha ext fin:"+sdf.format(this.plazoExtFin));
          
        examen.setEstado("AGENDADO");
        examen.setFechaExamen(this.fechaExamen);
        examen.setGrado(
                gradoDao.buscarGradoPorDesc(this.gradoSel)
                );
        examen.setModalidad(
                modalidadDao.buscarModalidadPorDesc(this.modalidadSel)
                );
    } 
}
