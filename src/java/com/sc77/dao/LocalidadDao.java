/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sc77.dao;

import com.sc77.entities.Localidad;
import java.util.List;

/**
 *
 * @author Hans
 */
public interface LocalidadDao {
    
    public List<Localidad> filtrarLocalidadPorDesc(String cad);
    
    public Localidad buscarLocalidadPorNombre(String nombre);    
}
