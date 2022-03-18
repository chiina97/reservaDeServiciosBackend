package spring.dto;

import java.io.Serializable;



public class ReserveDTO implements Serializable{

 
	private static final long serialVersionUID = 1L;
	
	//evento:
	private Long id;
	private String name;
	private String direction;
	private int postalCode;
	private String province;
	private String coords;
	private String date;
	private String privateOrPublic;
		
	//reserva:
	private String description;
	private String payment;
	private String mail;
	private String phone;
	private String state;
	private boolean enable;
	
	private UserDTO user;
	
	private TypeEventDTO typeEvent;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCoords() {
		return coords;
	}

	public void setCoords(String coords) {
		this.coords = coords;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPrivateOrPublic() {
		return privateOrPublic;
	}

	public void setPrivateOrPublic(String privateOrPublic) {
		this.privateOrPublic = privateOrPublic;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public TypeEventDTO getTypeEvent() {
		return typeEvent;
	}

	public void setTypeEvent(TypeEventDTO typeEvent) {
		this.typeEvent = typeEvent;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
