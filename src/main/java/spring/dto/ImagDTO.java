package spring.dto;

import java.io.Serializable;

public class ImagDTO implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private byte[] imag;
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
