/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sc77.dao.impl;

import com.sc77.dao.ExamenDao;
import com.sc77.entities.Examen;
import com.sc77.util.hib.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
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
}
