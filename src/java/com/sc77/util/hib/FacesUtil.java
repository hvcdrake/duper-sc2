/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sc77.util.hib;

import javax.faces.context.FacesContext;

/**
 *
 * @author María Padrón
 */
public class FacesUtil {
    // Getters -----------------------------------------------------------------------------------

    public static Object getSessionMapValue(String key) {
        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(key);
    }

    // Setters -----------------------------------------------------------------------------------

    public static void setSessionMapValue(String key, Object value) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(key, value);
    }
    
    // Getters -----------------------------------------------------------------------------------
    public static Object getReqMapValue(String key) {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(key);
    }

    // Setters -----------------------------------------------------------------------------------

    public static void setReqMapValue(String key, Object value) {
        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put(key, value);
    }
    
    public static void setAppMapValue(String key,Object value)
    {
        FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().put(key, value);
    }
    
    public static Object getAppMapValue(String key)
    {
        return FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get(key);
    }
}
