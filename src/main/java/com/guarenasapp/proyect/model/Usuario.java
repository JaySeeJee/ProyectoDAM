
package com.guarenasapp.proyect.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.SQLDelete;

import com.guarenasapp.proyect.soft_delete.SoftDeletableBaseEntity;
import com.guarenasapp.proyect.soft_delete.SoftDeleteFilters;


@Entity
@Table(name = Usuario.TABLE_NAME)
@SQLDelete(sql = "UPDATE " + Usuario.TABLE_NAME + " SET deleted_at = NOW() WHERE id=?")
@FilterDef(name = SoftDeleteFilters.NOT_TRASHED)
@Filter(name = SoftDeleteFilters.NOT_TRASHED, condition = "deleted_at IS NULL")
@FilterDef(name = SoftDeleteFilters.ONLY_TRASHED)
@Filter(name =  SoftDeleteFilters.ONLY_TRASHED, condition = "deleted_at IS NOT NULL")
public class Usuario extends SoftDeletableBaseEntity {

	static final String TABLE_NAME = "Usuarios";


	private String username;
	private String nombre;
	private String email;
	private String password;
	private Integer estatus;	
	private Date fechaRegistro;

	@Column(name = "deleted_at")
    private Date deletedAt;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="UsuarioPerfil",
			   joinColumns = @JoinColumn(name="idUsuario"),
			   inverseJoinColumns = @JoinColumn(name="idPerfil")			
			)
	private List<Perfil> perfiles;
	
	public void agregar(Perfil tempPerfil) {
		if (perfiles == null) {
			perfiles = new LinkedList<Perfil>();
		}
		perfiles.add(tempPerfil);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getEstatus() {
		return estatus;
	}

	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
		

	public List<Perfil> getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(List<Perfil> perfiles) {
		this.perfiles = perfiles;
	}

	@Override
	public String toString() {
		return "Usuario [email=" + email + ", estatus=" + estatus + ", fechaRegistro=" + fechaRegistro + ", nombre="
				+ nombre + ", password=" + password + ", perfiles=" + perfiles + ", username=" + username + "]";
	}

	
	
}
