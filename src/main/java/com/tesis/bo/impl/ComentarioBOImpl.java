package com.tesis.bo.impl;

import com.tesis.bo.ComentarioBO;
import com.tesis.bo.GenericBO;
import com.tesis.dao.ComentarioDAO;
import com.tesis.models.Comentario;

/**
 * Created by Nahuel on 6/12/2017.
 */
public class ComentarioBOImpl extends GenericBOImpl<Comentario> implements ComentarioBO {

    private ComentarioDAO comentarioDAO;

    public ComentarioDAO getComentarioDAO() {
        return comentarioDAO;
    }

    public void setComentarioDAO(ComentarioDAO comentarioDAO) {
        this.comentarioDAO = comentarioDAO;
    }
}
