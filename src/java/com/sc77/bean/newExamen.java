/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sc77.bean;

import com.sc77.dao.CentroMasterDao;
import com.sc77.dao.ExamenDao;
import com.sc77.dao.GradoDao;
import com.sc77.dao.ModalidadDao;
import com.sc77.dao.impl.CentroMasterDaoImpl;
import com.sc77.dao.impl.ExamenDaoImpl;
import com.sc77.dao.impl.GradoDaoImpl;
import com.sc77.dao.impl.ModalidadDaoImpl;
import com.sc77.entities.CatalogoPlazo;
import com.sc77.entities.CentroMaster;
import com.sc77.entities.Examen;
import com.sc77.entities.Grado;
import com.sc77.entities.Modalidad;
import com.sc77.entities.Plazo;
import com.sc77.entities.SubCentro;
import com.sc77.entities.UbicacionExamen;
import com.sc77.util.hib.FacesUtil;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

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
    
    private Boolean disableInputs=Boolean.FALSE;
    private Boolean showResultButtons=Boolean.FALSE;
    private Boolean showAgendarButton=Boolean.TRUE;

    public Boolean getShowAgendarButton() {
        return showAgendarButton;
    }

    public void setShowAgendarButton(Boolean showAgendarButton) {
        this.showAgendarButton = showAgendarButton;
    }
    
    public Boolean getShowResultButtons() {
        return showResultButtons;
    }

    public void setShowResultButtons(Boolean showResultButtons) {
        this.showResultButtons = showResultButtons;
    }

    public Boolean getDisableInputs() {
        return disableInputs;
    }

    public void setDisableInputs(Boolean disableInputs) {
        this.disableInputs = disableInputs;
    }

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
        RequestContext context = RequestContext.getCurrentInstance();  
        FacesMessage msg;
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String result="Save failed. No Id.";
        Boolean agendarSuccess=Boolean.FALSE;
        
        GradoDao gradoDao=new GradoDaoImpl();
        ModalidadDao modalidadDao=new ModalidadDaoImpl();
        ExamenDao examenDao= new ExamenDaoImpl();
        CentroMasterDao centroMasterDao = new CentroMasterDaoImpl();
        
        Examen examen;
        Plazo plazoNormal;
        Plazo plazoExtemp;
        CatalogoPlazo regular=new CatalogoPlazo();
        CatalogoPlazo ext=new CatalogoPlazo();
        CentroMaster centroMaster;
        List<Plazo> plazos = new ArrayList<Plazo>();
        List<UbicacionExamen> ubicaciones = new ArrayList<UbicacionExamen>();
        List<SubCentro> subCentros = new ArrayList<SubCentro>();
        
        regular.setIdCatalogoPlazo(1);
        ext.setIdCatalogoPlazo(2);
        
        System.out.println("grado:"+this.gradoSel);
        System.out.println("modad:"+this.modalidadSel);
        System.out.println("fechha exa:"+sdf.format(this.fechaExamen));
        System.out.println("fechha pla ini:"+sdf.format(this.plazoRegularIni));
        System.out.println("fechha pla ini:"+sdf.format(this.plazoRegularFin));
        System.out.println("fechha ext ini:"+sdf.format(this.plazoExtIni));
        System.out.println("fechha ext fin:"+sdf.format(this.plazoExtFin));
               
        examen= new Examen(modalidadDao.buscarModalidadPorDesc(this.modalidadSel), 
                gradoDao.buscarGradoPorDesc(this.gradoSel), 
                this.fechaExamen, 
                "AGENDADO");
        
        plazoNormal=new Plazo(regular, examen, this.plazoRegularIni, this.plazoRegularFin);
        plazoExtemp=new Plazo(ext, examen, this.plazoExtIni, this.plazoExtFin);
        
        plazos.add(plazoExtemp);
        plazos.add(plazoNormal);
        
        centroMaster = (CentroMaster) FacesUtil.getSessionMapValue("LoginBean.centroMaster");
        centroMaster=centroMasterDao.buscarCentroMaster(centroMaster.getIdCentromaster());
        
        if(centroMaster!=null){
            subCentros.addAll(centroMaster.getSubCentros());
        }
        
        if(subCentros.size()>0){
            for (SubCentro sb:subCentros ){
                ubicaciones.add(new UbicacionExamen(sb, examen));
            }
        
            result=examenDao.crearExamen(examen, plazos, ubicaciones);
            System.out.println("Examen:"+result);
        }
        
        if(result.compareTo("Save failed. No Id.")==0){
            agendarSuccess=Boolean.FALSE;
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Algo salió mal. Intente nuevamente.", "Algo salió mal. Intente nuevamente."); 
        }
        else{
            agendarSuccess=Boolean.TRUE;
            this.disableInputs=Boolean.TRUE;
            this.showResultButtons=Boolean.TRUE;
            this.showAgendarButton=Boolean.FALSE;
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Examen agendado correctamente.", "Examen agendado correctamente."); 
        }
        
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("agendarSuccess", agendarSuccess);
    } 
}
