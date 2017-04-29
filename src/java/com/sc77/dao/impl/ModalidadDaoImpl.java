/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sc77.dao.impl;

import com.sc77.dao.ModalidadDao;
import com.sc77.entities.Modalidad;
import com.sc77.util.hib.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Hans
 */
public class ModalidadDaoImpl implements ModalidadDao {

    @Override
    public List<Modalidad> getAllModalidades() {
        List<Modalidad> res=new ArrayList<Modalidad>();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        String sql = "from Modalidad"; 
        Query query = session.createQuery(sql);
        
        List<Modalidad> list = (List<Modalidad>)query.list();
        
        if(list!=null){
            res=list;
        }
        
        return res;
    }

    @Override
    public Modalidad buscarModalidadPorDesc(String desc) {
        Modalidad res;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        String sql = "from Modalidad where descModalidad=:desc";  
        
        Query query = session.createQuery(sql);
        query.setString("desc",desc);
            
        List<Modalidad> list = (List<Modalidad>)query.list();
        
        if(list.size()<=0){
            res=null;
        }
        else{
            res=list.get(0);
        }
        return res;
    }
    
}
