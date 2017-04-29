/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sc77.dao.impl;

import com.sc77.dao.LocalidadDao;
import com.sc77.entities.Localidad;
import com.sc77.util.hib.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Hans
 */
public class LocalidadDaoImpl implements LocalidadDao{

    @Override
    public List<Localidad> filtrarLocalidadPorDesc(String cad) {
        List<Localidad> res = new ArrayList<Localidad>();
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        String sql = "from Localidad where lower(nombreLocalidad) like :cad";  
        
        Query query = session.createQuery(sql);
        cad = "%"+cad.toLowerCase()+"%";
        query.setString("cad",cad);
        query.setMaxResults(10);
           
        List<Localidad> list = (List<Localidad>)query.list();
        System.out.println("Size of list:"+list.size()); 
        if(list.size()>0){
            res.addAll(list);
        }
        return res;
    }

    @Override
    public Localidad buscarLocalidadPorNombre(String nombre) {
        Localidad res;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        String sql = "from Localidad where nombreLocalidad=:nombre";  
        
        Query query = session.createQuery(sql);
        query.setString("nombre",nombre);
            
        List<Localidad> list = (List<Localidad>)query.list();
        
        if(list.size()<=0){
            res=null;
        }
        else{
            res=list.get(0);
        }
        
        return res;
    }
    
}
