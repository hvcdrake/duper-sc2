/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sc77.dao.impl;

import com.sc77.dao.UsuarioDao;
import com.sc77.entities.Usuario;
import com.sc77.util.hib.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Hans
 */
public class UsuarioDaoImpl implements UsuarioDao{

    @Override
    public Usuario buscarUsuario(String u,String p) {
        Usuario usuario;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        String sql = "from Usuario where usernameUsuario =:user and passwordUsuario =:pass"; 
        Query query = session.createQuery(sql);
        query.setString("user",u);
        query.setString("pass",p);
        
        List<Usuario> list = (List<Usuario>) query.list();
        
        if(list.size()<=0){
            usuario=null;
        }
        else{
            usuario=list.get(0);
        }
        
        return usuario;
    }
    
}
