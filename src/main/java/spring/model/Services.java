package spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;


@Entity
@SQLDelete(sql = "UPDATE service SET enable = false WHERE id = ?")
@Table(name = "service")
public class Services {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "instagram")
	private String instagram;
	@Column(name = "twitter")
	private String twitter; 
	@Column(name = "wsp")
	private String wsp;
	@Column(name = "urlWeb")
	private String urlWeb;
	@Column(name = "enable")
	private boolean enable=true;
	
	
	//relacion many to one:
	 @ManyToOne()
	 private User user;
	@JsonIgnore 
	 //relacion uno a muchos:
	 @OneToMany()
	 private List<Image> imags;

	 @OneToOne()
	 private TypeService typeService;
	 
	 
	 
	 @OneToMany(fetch = FetchType.LAZY)
	 private List<Qualification> Qualifications=new ArrayList<>();
	 
	 
	 
	 

	public Services() {

	}





	

	public Services(String name, String description, String instagram, String twitter, String wsp, String urlWeb,
			User user, List<Image> imags, TypeService typeServices, List<spring.model.Qualification> qualification) {
		super();
		this.name = name;
		this.description = description;
		this.instagram = instagram;
		this.twitter = twitter;
		this.wsp = wsp;
		this.urlWeb = urlWeb;
		this.user = user;
		this.imags = imags;
		this.typeService = typeServices;
		Qualifications = qualification;
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







	public String getDescription() {
		return description;
	}







	public void setDescription(String description) {
		this.description = description;
	}







	public String getInstagram() {
		return instagram;
	}







	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}







	public String getTwitter() {
		return twitter;
	}







	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}







	public String getWsp() {
		return wsp;
	}







	public void setWsp(String wsp) {
		this.wsp = wsp;
	}







	public String getUrlWeb() {
		return urlWeb;
	}







	public void setUrlWeb(String urlWeb) {
		this.urlWeb = urlWeb;
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







	public List<Image> getImags() {
		return imags;
	}







	public void setImags(List<Image> imags) {
		this.imags = imags;
	}







	public TypeService getTypeService() {
		return typeService;
	}







	public void setTypeService(TypeService typeServices) {
		this.typeService = typeServices;
	}







	public List<Qualification> getQualifications() {
		return Qualifications;
	}







	public void setQualifications(List<Qualification> qualification) {
		Qualifications = qualification;
	}



}
