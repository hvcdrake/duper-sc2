/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sc77.util.converter;

import com.sc77.dao.LocalidadDao;
import com.sc77.dao.impl.LocalidadDaoImpl;
import com.sc77.entities.Localidad;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Hans
 */
@FacesConverter(forClass = Localidad.class, value = "LocalidadConverter")
public class LocalidadConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value != null && value.trim().length() > 0) {
            LocalidadDao localidadDao = new LocalidadDaoImpl();
            Localidad found = localidadDao.buscarLocalidadPorNombre(value);
            return found;
        }
        else {
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.equals("")) {  
            return "";  
        } else {
            return ((Localidad) value).getNombreLocalidad();  
        }
    }
    
}
