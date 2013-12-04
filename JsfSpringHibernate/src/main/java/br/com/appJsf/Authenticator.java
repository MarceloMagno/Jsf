package br.com.appJsf;

import java.util.Collection;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import br.com.appJsf.model.springsecurity.Usuario;
import br.com.appJsf.springsecurity.service.LoginService;

@Controller
@Scope("request")
public class Authenticator implements AuthenticationProvider {
	
	@Autowired
    private LoginService service;
 
    @Autowired
    private UserSession session;
 
    private String username;
    private String password;
 
    public String login() {
        try {
            Usuario usuario = service.login(username, password);
            loginSpringSecurity(usuario);
            session.setUsuario(usuario);
            return "successfulPage";
        } catch (IllegalArgumentException ex) {
            message(ex.getMessage());
        }
        return "";
    }
 
    private void loginSpringSecurity(Usuario user) {
        @SuppressWarnings("unchecked")
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getUsername(), null, (Collection<? extends GrantedAuthority>) user.getRoleLista());
        token.setDetails(user);
 
        SecurityContextHolder.createEmptyContext();
        SecurityContextHolder.getContext().setAuthentication(token);
    }
 
    public String logout() {
        SecurityContextHolder.clearContext();
        session.setUsuario(null);
        return "index";
    }
 
    private void message(String message) {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(message));
    }
 
	

	public LoginService getService() {
		return service;
	}

	public void setService(LoginService service) {
		this.service = service;
	}

	public UserSession getSession() {
		return session;
	}

	public void setSession(UserSession session) {
		this.session = session;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return false;
	}

}
