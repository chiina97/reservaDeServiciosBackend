package spring.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class UserDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// no lo termine de entender, y cuando quise implementarlo en service.Impl se
	// rompe
	private Long id;
	@NotNull(message = "Debe ingresar un usuario")
	@NotBlank(message = "El usuario no puede tener espacios en blanco")
	private String username;
	@NotNull(message = "Debe ingresar un correo")
	@NotBlank(message = "El correo no puede tener espacios en blanco")
	@Email(message = "el correo debe tener el formato texto@texto.dominio")
	private String mail;
	@NotNull(message = "Debe ingresar una clave")
	@Size(min = 4, message = "La contraseña debe tener al menos 4 caracteres")
	private String password;
	@NotNull(message = "Debe ingresar un nombre")
	@NotBlank(message = "El nombre no puede tener espacios en blanco")
	@Pattern(regexp="[a-zA-Z]+", message = "el nombre solo puede contener letras")
	private String name;
	@NotNull(message = "Debe ingresar un apellido")
	@NotBlank(message = "El apellido no puede tener espacios en blanco")
	@Pattern(regexp="[a-zA-Z]+", message = "el apellido solo puede contener letras")
	private String surname;
	private boolean enable;
	
	private List<ReserveDTO> reserves;
	@JsonIgnore
	private List<ServiceDTO> services;
	
	private QualificationDTO qualification;
	
	private Set<String> roles = new HashSet<>();



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public List<ReserveDTO> getReserves() {
		return reserves;
	}

	public void setReserves(List<ReserveDTO> reserves) {
		this.reserves = reserves;
	}

	public List<ServiceDTO> getServices() {
		return services;
	}

	public void setServices(List<ServiceDTO> services) {
		this.services = services;
	}

	public QualificationDTO getQualification() {
		return qualification;
	}

	public void setQualification(QualificationDTO qualification) {
		this.qualification = qualification;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	
	
	
	
}
