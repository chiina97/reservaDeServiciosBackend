package spring.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import spring.model.User;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


public class MainUser implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id; // chquear si va
	private String password;
	private String mail;
	private String name;
	private String surname;
	private String username;
	private boolean enable;
	
	private Collection<? extends GrantedAuthority> authorities;

	public MainUser(Long id,String username,String password, String mail, String name,String surname, boolean enable,
			Collection<? extends GrantedAuthority> authorities) {
		this.id = id;
		this.password = password;
		this.mail = mail;
		this.username=username;
		this.name = name;
		this.surname=surname;
		this.enable=enable;
		this.authorities = authorities;
	}

	public static MainUser build(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(rol -> new SimpleGrantedAuthority(rol.getRoleName().name())).collect(Collectors.toList());
		return new MainUser(user.getId(),  user.getUsername(),user.getPassword(), user.getMail(), user.getName(),user.getSurname(),user.isEnable(),
				authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	public String getUser() {
		return name;
	}
	
	

	public String getSurname() {
		return surname;
	}
	
	public String getMail() {
		return mail;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	

}

