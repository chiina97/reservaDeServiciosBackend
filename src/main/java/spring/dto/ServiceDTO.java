package spring.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;






public class ServiceDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotNull(message = "Debe ingresar un nombre")
	@NotBlank(message = "El nombre no puede tener espacios en blanco")
	private String name;
	@NotNull(message = "Debe ingresar una descripcion")
	@NotBlank(message = "La descripcion no puede tener espacios en blanco")
	private String description;
	private String instagram;
	private String twitter; 
	private String wsp;
	private String urlWeb;
	private boolean enable;
	 
	 private Long userId;
	 
	 private List<ImagDTO> imags;
	 
	 @NotNull(message ="Debe seleccionar un tipo de servicio")
	 private Long typeServiceId;
	 
	 private List<QualificationDTO> Qualifications;

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



	public List<ImagDTO> getImags() {
		return imags;
	}

	public void setImags(List<ImagDTO> imags) {
		this.imags = imags;
	}



	public List<QualificationDTO> getQualifications() {
		return Qualifications;
	}

	public void setQualifications(List<QualificationDTO> qualifications) {
		Qualifications = qualifications;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getTypeServiceId() {
		return typeServiceId;
	}

	public void setTypeServiceId(Long typeServiceId) {
		this.typeServiceId = typeServiceId;
	}

	
}
