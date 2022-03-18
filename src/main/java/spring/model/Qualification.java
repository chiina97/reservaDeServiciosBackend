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
@SQLDelete(sql = "UPDATE qualification SET enable = false WHERE id = ?")
@Table(name = "qualification")
public class Qualification {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "cleaning")
	private int cleaning;
	@Column(name = "sympathy")
	private int sympathy;
	@Column(name = "priceQuality")
	private int priceQuality;
	@Column(name = "taste")
	private int taste;
	@Column(name = "design")
	private int design;
	@Column(name = "enable")
	private boolean enable=true;

	// relacion one a muchos:
	@ManyToOne()
	private Services service;

	// relacion uno a uno:
	@OneToOne(fetch = FetchType.LAZY)
	private User user;

	public Qualification() {

	}
	

	

	public Qualification(int cleaning, int sympathy, int priceQuality, int taste, int design, Services service,
			User user) {
		super();
		this.cleaning = cleaning;
		this.sympathy = sympathy;
		this.priceQuality = priceQuality;
		this.taste = taste;
		this.design = design;
		this.service = service;
		this.user = user;
		this.enable=true;
	}




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




	public Services getService() {
		return service;
	}




	public void setService(Services service) {
		this.service = service;
	}




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	
}
