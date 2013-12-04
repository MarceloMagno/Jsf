package br.com.appJsf.springsecurity.service;

import br.com.appJsf.model.springsecurity.Usuario;

public interface LoginService {
	Usuario login(String nomeUsuario, String senha) throws IllegalArgumentException;
}
