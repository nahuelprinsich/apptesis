package com.tesis.dao.impl;

import com.tesis.dao.UsuarioDAO;
import com.tesis.models.Usuario;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Nahuel on 4/8/2018.
 */
public class UsuarioDAOImpl extends GenericDAOImpl<Usuario> implements UsuarioDAO {

    public Usuario addUsuario(Usuario usuario) {
        Session session = this.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(usuario);
            tx.commit();
        }
        catch (RuntimeException e) {
            tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }

        return usuario;
    }
}
