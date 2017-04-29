/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sc77.dao.impl;

import com.sc77.dao.GradoDao;
import com.sc77.entities.Grado;
import com.sc77.util.hib.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Hans
 */
public class GradoDaoImpl implements GradoDao{

    @Override
    public List<Grado> getAllGrados() {
        List<Grado> res=new ArrayList<Grado>();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        String sql = "from Grado order by idGrado"; 
        Query query = session.createQuery(sql);
        
        List<Grado> list = (List<Grado>)query.list();
        
        if(list!=null){
            res=list;
        }
        
        return res;
    }

    @Override
    public Grado buscarGradoPorDesc(String desc) {
        Grado res;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        String sql = "from Grado where descGrado=:desc";  
        
        Query query = session.createQuery(sql);
        query.setString("desc",desc);
            
        List<Grado> list = (List<Grado>)query.list();
        
        if(list.size()<=0){
            res=null;
        }
        else{
            res=list.get(0);
        }
        return res;
    }
    
}
