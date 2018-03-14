/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sc77.dao;

import com.sc77.entities.Examen;
import com.sc77.entities.Plazo;
import com.sc77.entities.UbicacionExamen;
import java.util.List;

/**
 *
 * @author Hans
 */
public interface ExamenDao {
    
    public String crearExamen(Examen examen);
    
    public String crearExamen(Examen examen, List<Plazo> plazos, List<UbicacionExamen> ubicaciones);
    
    public List<Examen> listarExamenes();
    
    public Boolean publicarExamen(Examen examen);
    
}
