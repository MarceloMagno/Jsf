package br.com.appJsf.dao.springsecurity;

import java.util.List;

import javax.persistence.Query;

import br.com.appJsf.dao.GenericDAO;
import br.com.appJsf.model.springsecurity.Usuario;

public class UsuarioDAO extends GenericDAO<Usuario>{
	
	@SuppressWarnings("rawtypes")
    public Usuario login(String nomeUsuario, String senha) {
        String query = "FROM Usuario u where u.nomeUsuario = ? and u.senha=?";
        Query q = entityManager.createQuery(query);
        q.setParameter(1, nomeUsuario);
        q.setParameter(2, senha);
 
        List l = q.getResultList();
 
        if (l == null || l.isEmpty() || l.size() > 1) {
            return null;
        }
        return (Usuario) l.get(0);
    }
}
