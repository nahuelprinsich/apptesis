package com.tesis.services;

import com.tesis.bo.UsuarioBO;
import com.tesis.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Nahuel on 4/8/2018.
 */
@RestController
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioBO usuarioBO;

    public UsuarioBO getUsuarioBO() {
        return usuarioBO;
    }

    public void setUsuarioBO(UsuarioBO usuarioBO) {
        this.usuarioBO = usuarioBO;
    }

    public Usuario addUsuario(Usuario usuario) {
        return usuarioBO.addUsuario(usuario);
    }
}
