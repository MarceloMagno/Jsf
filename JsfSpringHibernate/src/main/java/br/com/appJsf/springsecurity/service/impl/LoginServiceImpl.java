package br.com.appJsf.springsecurity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.appJsf.dao.springsecurity.UsuarioDAO;
import br.com.appJsf.model.springsecurity.Usuario;
import br.com.appJsf.springsecurity.service.LoginService;

public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private UsuarioDAO dao;

	@Override
	public Usuario login(String nomeUsuario, String senha) throws IllegalArgumentException {
		if (isEmptyOrNull(nomeUsuario) || isEmptyOrNull(senha)) {
            throw new IllegalArgumentException("Atenção, username ou password vazios!");
        }
		
        Usuario u = dao.login(nomeUsuario, senha);
         
        if (u == null) {
            throw new IllegalArgumentException("Erro: username ou password incorretos!");
        }
        return u;
    }
	
	private boolean isEmptyOrNull(String s) {
        return s == null || s.equals("");
    }
	
}
