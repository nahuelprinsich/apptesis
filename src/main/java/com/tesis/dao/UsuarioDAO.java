package com.tesis.dao;

import com.tesis.models.Usuario;

/**
 * Created by Nahuel on 4/8/2018.
 */
public interface UsuarioDAO extends GenericDAO<Usuario> {

    public Usuario addUsuario(Usuario usuario);
}
