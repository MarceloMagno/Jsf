package br.com.appJsf;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.appJsf.model.springsecurity.Usuario;

@Component
@Scope("session")
public class UserSession {

	private Usuario usuario;
         
    public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isLoggedIn(){
        return usuario != null;
    }
}