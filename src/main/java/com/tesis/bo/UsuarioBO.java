package com.tesis.bo;

import com.tesis.models.Usuario;

/**
 * Created by Nahuel on 4/8/2018.
 */
public interface UsuarioBO extends GenericBO<Usuario> {

    public Usuario addUsuario(Usuario usuario);
}
