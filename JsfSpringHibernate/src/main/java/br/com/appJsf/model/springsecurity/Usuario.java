package br.com.appJsf.model.springsecurity;

import java.beans.Transient;
import java.util.Collection;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.appJsf.dao.AbstractEntity;

@Entity
@Table(name = "usuario")
public class Usuario extends AbstractEntity implements UserDetails {

	private static final long serialVersionUID = -4600299723132679222L;
	
	@Column(unique=true)
	private String nomeUsuario;
	private String senha;
	@ManyToMany
	@JoinTable(name="usuario_roles", joinColumns = {@JoinColumn(name="id")}, inverseJoinColumns = {@JoinColumn(name="id")})
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Role> roleLista;

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Role> getRoleLista() {
		return roleLista;
	}

	public void setRoleLista(List<Role> roleLista) {
		this.roleLista = roleLista;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transient
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return (Collection<? extends GrantedAuthority>) roleLista;
	}

	@Override
	@Transient
	public String getPassword() {
		return senha;
	}

	@Override
	@Transient
	public String getUsername() {
		return nomeUsuario;
	}

	@Override
	@Transient
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	@Transient
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	@Transient
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	@Transient
	public boolean isEnabled() {
		return false;
	}

}
