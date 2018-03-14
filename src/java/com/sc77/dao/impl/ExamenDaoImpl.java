/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sc77.dao.impl;

import com.sc77.dao.ExamenDao;
import com.sc77.entities.Examen;
import com.sc77.entities.Plazo;
import com.sc77.entities.UbicacionExamen;
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
public class ExamenDaoImpl implements ExamenDao {

    @Override
    public String crearExamen(Examen examen) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        String id="Save failed. No Id.";
        
        try {
            transaction = session.beginTransaction();
            id=session.save(examen).toString();
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
    public String crearExamen(Examen examen, List<Plazo> plazos, List<UbicacionExamen> ubicaciones) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        String id="Save failed. No Id.";
        int i;
        
        try {
            transaction = session.beginTransaction();
            id=session.save(examen).toString();
            
            i=0;
            for(Plazo p : plazos){
                session.save(p);
                if ( ++i % 20 == 0 ) {
                    session.flush();
                    session.clear();
                 }
            }
            
            i=0;
            for(UbicacionExamen u : ubicaciones){
                session.save(u);
                if ( ++i % 20 == 0 ) {
                    session.flush();
                    session.clear();
                 }                
            }
            
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
    public List<Examen> listarExamenes() {
        List<Examen> res=new ArrayList<Examen>();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        String sql = "from Examen order by fechaExamen desc"; 
        Query query = session.createQuery(sql);
        
        List<Examen> list = (List<Examen>)query.list();
        
        if(list!=null){
            res=list;
        }
        
        return res;
    }

    @Override
    public Boolean publicarExamen(Examen examen) {
        StatelessSession session = HibernateUtil.getSessionFactory().openStatelessSession();
        Transaction transaction = null;
        Boolean res;
        
        try {
            transaction = session.beginTransaction();
            examen.setEstado("PUBLICADO");
            session.update(examen);
       
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
