/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sc77.bean;

import com.sc77.dao.UsuarioDao;
import com.sc77.dao.impl.UsuarioDaoImpl;
import com.sc77.entities.CentroMaster;
import com.sc77.entities.Contacto;
import com.sc77.entities.Usuario;
import com.sc77.util.hib.FacesUtil;
import java.util.Iterator;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Hans
 */
@ManagedBean(name = "log123")
@SessionScoped
public class LoginBean {

    /**
     * Variables
     */
    private Usuario usuario;
    private String p;
    private String u;    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    public String getU() {
        return u;
    }

    public void setU(String u) {
        this.u = u;
    }
    
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }
    
    
     /**
     * Metodos
     */
    
    public void login() throws InterruptedException { 
        
        RequestContext context = RequestContext.getCurrentInstance();  
        FacesMessage msg;  
        boolean loggedIn;  
        
        UsuarioDao usuarioDao = new UsuarioDaoImpl();

        //this.usuario = usuarioDao.logUsuario(this.u, this.p);
        System.out.println("Usuario: "+this.u);
        System.out.println("Pass: "+this.p);
        
        this.usuario = usuarioDao.buscarUsuario(this.u,this.p);
        
        System.out.println("Usuario find: "+this.usuario.getUsernameUsuario());
        System.out.println("Pass find: "+this.usuario.getPasswordUsuario());
        
        if(this.usuario != null) {
            loggedIn = true;
            this.guardarDatosSession(this.usuario);
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "BIENVENIDO", this.usuario.getUsernameUsuario());            
        } 
        else 
        {  
            loggedIn = false;  
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "ERROR", "Datos Inválidos");  
        }        
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn);  
    }
    
    public void guardarDatosSession(Usuario u){
        System.out.println("Guardando datos de la session");
        CentroMaster centroMaster=null;

        Iterator<Contacto> iteratorContacto = u.getContactos().iterator();
        if(iteratorContacto.hasNext()){
            Contacto c= iteratorContacto.next();

            centroMaster=c.getCentroMaster();
            System.out.println("Sub centros"+centroMaster.getSubCentros().size());               
                         
        }
        FacesUtil.setSessionMapValue("LoginBean.centroMaster", centroMaster);
    }
}
