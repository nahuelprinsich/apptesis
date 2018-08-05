package com.tesis.bo.impl;

import com.tesis.bo.UsuarioBO;
import com.tesis.dao.UsuarioDAO;
import com.tesis.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Nahuel on 4/8/2018.
 */
public class UsuarioBOImpl extends GenericBOImpl<Usuario> implements UsuarioBO {

    @Autowired
    private UsuarioDAO usuarioDAO;

    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public Usuario addUsuario(Usuario usuario) {
        return usuarioDAO.addUsuario(usuario);
    }
}
