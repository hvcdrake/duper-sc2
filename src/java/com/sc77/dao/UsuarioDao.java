/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sc77.dao;

import com.sc77.entities.Usuario;

/**
 *
 * @author Hans
 */
public interface UsuarioDao {
    
    public Usuario buscarUsuario(String u,String p);
    //public UserSessionShow logUsuario(String user,String pass);   
}
