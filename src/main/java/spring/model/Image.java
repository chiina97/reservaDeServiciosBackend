package spring.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "imag")
public class Image {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "imag",nullable = true)
	@Lob
	private byte[] imag;
	
	
	
	

	
	public Image() {
	
	}


	public String toString() {
		return this.getId().toString();
	}






	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public byte[] getImag() {
		return imag;
	}






	public void setImag(byte[] imag) {
		this.imag = imag;
	}
	
	
	
}

