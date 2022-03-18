package spring.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;

import com.fasterxml.jackson.annotation.JsonIgnore;





@Entity
@SQLDelete(sql = "UPDATE user SET enable = false WHERE id = ?")


@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "username")
	private String username;
	@Column(name = "password")
	private String password;
	@Column(name = "mail")
	private String mail;
	@Column(name = "name")
	private String name;
	@Column(name = "surname")
	private String surname;
	@Column(name = "enable")
	private boolean enable=true;
	
	@JsonIgnore 
	//relacion one to many:
	@OneToMany(mappedBy="user" ) //tenemos que indicar con el atributo que se va a relacionar de la clase reserva
	 private List<Reserve> reserves;
	@JsonIgnore 
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL, orphanRemoval = true) //tenemos que indicar con el atributo que se va a relacionar de la clase reserva
	private List<Services> services;
	@JsonIgnore 
    //relacion uno a uno bidireccional:
	@OneToOne(mappedBy= "user", orphanRemoval = true,fetch=FetchType.LAZY)
	private Qualification qualification;
	
	// roles:
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

	
	
	public User() {

	}

	

	public User(String username, String password, String mail, String name, String surname) {
		super();
		this.username = username;
		this.password = password;
		this.mail = mail;
		this.name = name;
		this.surname = surname;
		this.enable = true;
	}



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



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
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



	public List<Reserve> getReserves() {
		return reserves;
	}



	public void setReserves(List<Reserve> reserves) {
		this.reserves = reserves;
	}



	public List<Services> getServices() {
		return services;
	}



	public void setServices(List<Services> services) {
		this.services = services;
	}



	public Qualification getQualification() {
		return qualification;
	}



	public void setQualification(Qualification qualification) {
		this.qualification = qualification;
	}



	public Set<Role> getRoles() {
		return roles;
	}



	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	

}