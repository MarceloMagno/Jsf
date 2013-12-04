package br.com.appJsf.model.springsecurity;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;

import br.com.appJsf.dao.AbstractEntity;

@Entity
@Table(name="roles")
public class Role extends AbstractEntity implements GrantedAuthoritiesContainer{

	private static final long serialVersionUID = -4882192740173090300L;
	
	@Column(unique=true)
	private String descricao;
	
	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public Collection<? extends GrantedAuthority> getGrantedAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

}
