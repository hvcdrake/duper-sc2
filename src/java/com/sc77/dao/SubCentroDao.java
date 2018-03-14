/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sc77.dao;

import com.sc77.entities.CentroMaster;
import com.sc77.entities.SubCentro;
import java.util.List;

/**
 *
 * @author Hans
 */
public interface SubCentroDao {
    
    public String crearSubCentro(SubCentro subCentro);
    
    public int lastRankingPreferencia(CentroMaster centroMaster);
    
    public List<SubCentro> subCentrosSegunRankingPreferencia(CentroMaster centroMaster);
    
    public Boolean actualizarRankingSubCentros(List<SubCentro> subCentros);
}
