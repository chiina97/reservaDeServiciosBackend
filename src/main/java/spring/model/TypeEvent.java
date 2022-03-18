package spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;

@Entity
@SQLDelete(sql = "UPDATE typeevent SET enable = false WHERE id = ?")
@Table(name = "typeEvent")
public class TypeEvent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "type")
	private String type;
	@Column(name = "enable")
	private boolean enable=true;
	
	
	public TypeEvent() {
		
	}


	
	
	public TypeEvent(String type, boolean enable) {
		super();
		this.type = type;
		this.enable = enable;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getType() {
		return type;
	}




	public void setType(String type) {
		this.type = type;
	}




	public boolean isEnable() {
		return enable;
	}




	public void setEnable(boolean enable) {
		this.enable = enable;
	}




}
