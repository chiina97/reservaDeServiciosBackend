package spring.dto;

import java.io.Serializable;

public class TypeEventDTO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String type;
	private boolean enable;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
