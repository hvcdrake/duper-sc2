/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sc77.dao;

import com.sc77.entities.Modalidad;
import java.util.List;

/**
 *
 * @author Hans
 */
public interface ModalidadDao {
    
    public List<Modalidad> getAllModalidades();
    
    public Modalidad buscarModalidadPorDesc(String desc);     
}
