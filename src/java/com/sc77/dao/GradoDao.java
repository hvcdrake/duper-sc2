/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sc77.dao;

import com.sc77.entities.Grado;
import java.util.List;

/**
 *
 * @author Hans
 */
public interface GradoDao {
    
    public List<Grado> getAllGrados();
    
    public Grado buscarGradoPorDesc(String desc); 
}
