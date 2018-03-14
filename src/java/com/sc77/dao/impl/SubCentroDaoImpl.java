/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sc77.dao.impl;

import com.sc77.dao.SubCentroDao;
import com.sc77.entities.CentroMaster;
import com.sc77.entities.SubCentro;
import com.sc77.util.hib.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.StatelessSession;
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
        int res=0;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        String sql = "select max(rankingListaPreferencia) from SubCentro where centroMaster.idCentromaster=:idCM"; 
        Query query = session.createQuery(sql);
        query.setInteger("idCM",centroMaster.getIdCentromaster());
        
        Object r=query.uniqueResult();
        
        
        if(r!=null){
            res = (Integer)r;
        }
        else{
            res=0;
        }
        
        return res;
    }

    @Override
    public List<SubCentro> subCentrosSegunRankingPreferencia(CentroMaster centroMaster) {
        List<SubCentro> res=new ArrayList<SubCentro>();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        String sql = "from SubCentro order by rankingListaPreferencia asc"; 
        Query query = session.createQuery(sql);
        
        List<SubCentro> list = (List<SubCentro>)query.list();
        
        if(list!=null){
            res=list;
        }
        return res;
    }

    @Override
    public Boolean actualizarRankingSubCentros(List<SubCentro> subCentros) {
        StatelessSession session = HibernateUtil.getSessionFactory().openStatelessSession();
        Transaction transaction = null;
        Boolean res;
        
        try {
            transaction = session.beginTransaction();     
            for(SubCentro sc : subCentros){
                session.update(sc);
            }          
            transaction.commit();
            System.out.println("Records updated sucessessfully");
            res=Boolean.TRUE;
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
            res=Boolean.FALSE;
        } finally {
            session.close();         
        }
        return res;
    }
   
}
