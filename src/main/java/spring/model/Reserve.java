package spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.SQLDelete;


@Entity
@SQLDelete(sql = "UPDATE reserve SET enable = false WHERE id = ?")
@Table(name = "reserve")
public class Reserve {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "direction")
	private String direction;
	@Column(name = "postalCode")
	private int postalCode;
	@Column(name = "province")
	private String province;
	@Column(name = "coords")
	private String coords;
	@Column(name = "date")
	private String date;
	@Column(name = "private")
	private String privateOrPublic;
	@Column(name = "description")
	private String description;
	@Column(name = "payment")
	private String payment;
	@Column(name = "mail")
	private String mail;
	@Column(name = "phone")
	private String phone;
	@Column(name = "state")
	private String state;
	@Column(name = "enable")
	private boolean enable=true;
	
	//relacion many to one
	 @ManyToOne()
	 private User user;

	
	//Relacion uno a one al tipo
		@OneToOne(fetch=FetchType.LAZY)
		 private TypeEvent typeEvent;

	
	public Reserve() {
		
	}


	
    
	public Reserve(String name, String direction, int postalCode, String province, String coords, String date,
			String privateOrPublic, String description, String payment, String mail, String phone, String state,
			User user, TypeEvent typeEvent) {
		super();
		this.name = name;
		this.direction = direction;
		this.postalCode = postalCode;
		this.province = province;
		this.coords = coords;
		this.date = date;
		this.privateOrPublic = privateOrPublic;
		this.description = description;
		this.payment = payment;
		this.mail = mail;
		this.phone = phone;
		this.state = state;
		this.user = user;
		this.typeEvent = typeEvent;
		this.enable=true;
	}




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
		this.payment= payment;
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




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	public TypeEvent getTypeEvent() {
		return typeEvent;
	}




	public void setTypeEvent(TypeEvent typeEvent) {
		this.typeEvent = typeEvent;
	}




}