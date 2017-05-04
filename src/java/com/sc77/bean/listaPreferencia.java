/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sc77.bean;

import com.sc77.dao.CentroMasterDao;
import com.sc77.dao.SubCentroDao;
import com.sc77.dao.impl.CentroMasterDaoImpl;
import com.sc77.dao.impl.SubCentroDaoImpl;
import com.sc77.entities.CentroMaster;
import com.sc77.entities.SubCentro;
import com.sc77.util.hib.FacesUtil;
import java.awt.event.ActionEvent;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Hans
 */
@ManagedBean(name = "listPref")
@RequestScoped
public class listaPreferencia {

    private List<SubCentro> listaOriginal;
    private List<String> rankingSubCentros;

    public List<String> getRankingSubCentros() {
        return rankingSubCentros;
    }

    public void setRankingSubCentros(List<String> rankingSubCentros) {
        this.rankingSubCentros = rankingSubCentros;
    }
   
    /**
     * Creates a new instance of listaPreferencia
     */
    public listaPreferencia() {
    }
    
    @PostConstruct
    public void init(){
        SubCentroDao subCentroDao = new SubCentroDaoImpl();
        CentroMasterDao centroMasterDao = new CentroMasterDaoImpl();
        CentroMaster centroMaster;
        List<SubCentro> subCentros;
        this.rankingSubCentros = new ArrayList<String>();
        
        centroMaster = (CentroMaster) FacesUtil.getSessionMapValue("LoginBean.centroMaster");
        centroMaster=centroMasterDao.buscarCentroMaster(centroMaster.getIdCentromaster());
        
        subCentros = subCentroDao.subCentrosSegunRankingPreferencia(centroMaster);
        this.listaOriginal = new ArrayList<SubCentro>();
        this.listaOriginal.addAll(subCentros);
        
        for(SubCentro sb:subCentros){
            this.rankingSubCentros.add(sb.getNombreSubcentro());
        }
    }
    
    public void guardarCambiosListaPref(ActionEvent actionEvent){
        System.out.println("Guardar cambios");
        Boolean cambios=Boolean.FALSE;
        RequestContext context = RequestContext.getCurrentInstance();  
        FacesMessage msg;
        List<SubCentro> listaActualizar = new ArrayList<SubCentro>();
        SubCentroDao subCentroDao = new SubCentroDaoImpl();
        int k;
        int rank=1;
        
        if(this.rankingSubCentros.size()==this.listaOriginal.size() &&
                this.rankingSubCentros.size()>0 &&
                this.listaOriginal.size()>0){
            for(k=0;k<this.rankingSubCentros.size();k++){
                if(this.rankingSubCentros.get(k).compareTo(this.listaOriginal.get(k).getNombreSubcentro())==0){
                    
                }
                else{
                    cambios=Boolean.TRUE;
                    SubCentro sb = this.buscarSubCentro(this.rankingSubCentros.get(k));
                    if(sb!=null){
                        System.out.println("Se debería actualizar: "+sb.getNombreSubcentro()+" con :"+rank);
                        sb.setRankingListaPreferencia(rank);
                        listaActualizar.add(sb);
                    }
                }
                rank++;
            }
            
            if(listaActualizar.size()>0){
                Boolean act = subCentroDao.actualizarRankingSubCentros(listaActualizar);
                if (act){
                   msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Ranking actualizado correctamente!", "Ranking actualizado correctamente!");
                }
                else{
                    msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Algo salió mal. Recargue la página e intente nuevamente.", "Algo salió mal. Recargue la página e intente nuevamente.");   
                }
            }else{
                    msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "No hay cambios que actualizar.", "No hay cambios que actualizar.");                
            }   
        }
        else{
            msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Algo salió mal. Recargue la página e intente nuevamente.", "Algo salió mal. Recargue la página e intente nuevamente.");
        }
        
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("cambios", cambios);
    }
    
    public SubCentro buscarSubCentro(String nombre){
        SubCentro res=null;
        
        for(SubCentro sc : this.listaOriginal){
            if(sc.getNombreSubcentro().compareTo(nombre)==0){
                return sc;
            }
        }
        return res;
    }
}
