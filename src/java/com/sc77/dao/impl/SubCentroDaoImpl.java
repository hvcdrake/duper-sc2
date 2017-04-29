/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sc77.dao.impl;

import com.sc77.dao.SubCentroDao;
import com.sc77.entities.CentroMaster;
import com.sc77.entities.Localidad;
import com.sc77.entities.SubCentro;
import com.sc77.util.hib.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Hans
 */
public class SubCentroDaoImpl implements SubCentroDao{

    @Override
    public String crearSubCentro(SubCentro subCentro) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        String id="Save failed. No Id.";
        
        try {
            transaction = session.beginTransaction();
            id=session.save(subCentro).toString();
            transaction.commit();
            System.out.println("Records inserted sucessessfully");
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            return id;
        }
    }

    @Override
    public int lastRankingPreferencia(CentroMaster centroMaster) {
        int res;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        String sql = "select max(rankingListaPreferencia) from SubCentro where centroMaster.idCentromaster=:idCM"; 
        Query query = session.createQuery(sql);
        query.setInteger("idCM",centroMaster.getIdCentromaster());
        
        res = (Integer) query.uniqueResult();
        
        return res;
    }
   
}
