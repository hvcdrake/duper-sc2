/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sc77.dao.impl;

import com.sc77.dao.CentroMasterDao;
import com.sc77.entities.CentroMaster;
import com.sc77.util.hib.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Hans
 */
public class CentroMasterDaoImpl implements CentroMasterDao{

    @Override
    public CentroMaster buscarCentroMaster(int id) {
        CentroMaster centroMaster;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        String sql = "from CentroMaster where idCentromaster =:id"; 
        Query query = session.createQuery(sql);
        query.setInteger("id",id);
        
        List<CentroMaster> list = (List<CentroMaster>) query.list();
        
        if(list.size()<=0){
            centroMaster=null;
        }
        else{
            centroMaster=list.get(0);
        }
        
        return centroMaster;
    }      
}
