package spring.dto;

import java.io.Serializable;



public class QualificationDTO  implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private int cleaning;
	private int sympathy;
	private int priceQuality;
	private int taste;
	private int design;
	private boolean enable;
	
	private ServiceDTO service;
	
	private UserDTO user;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getCleaning() {
		return cleaning;
	}
	public void setCleaning(int cleaning) {
		this.cleaning = cleaning;
	}
	public int getSympathy() {
		return sympathy;
	}
	public void setSympathy(int sympathy) {
		this.sympathy = sympathy;
	}
	public int getPriceQuality() {
		return priceQuality;
	}
	public void setPriceQuality(int priceQuality) {
		this.priceQuality = priceQuality;
	}
	public int getTaste() {
		return taste;
	}
	public void setTaste(int taste) {
		this.taste = taste;
	}
	public int getDesign() {
		return design;
	}
	public void setDesign(int design) {
		this.design = design;
	}
	public boolean isEnable() {
		return enable;
	}
	public void setEnable(boolean enable) {
		this.enable = enable;
	}
	public ServiceDTO getService() {
		return service;
	}
	public void setService(ServiceDTO service) {
		this.service = service;
	}
	public UserDTO getUser() {
		return user;
	}
	public void setUser(UserDTO user) {
		this.user = user;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
