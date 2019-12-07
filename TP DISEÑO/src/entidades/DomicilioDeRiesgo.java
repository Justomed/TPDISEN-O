package entidades;

public class DomicilioDeRiesgo {

	Localidad localidadDR;
	Provincia provinciaDR;
	int id;
	
	public DomicilioDeRiesgo() {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Localidad getLocalidadDR() {
		return localidadDR;
	}
	public void setLocalidadDR(Localidad localidadDR) {
		this.localidadDR = localidadDR;
	}
	public Provincia getProvinciaDR() {
		return provinciaDR;
	}
	public void setProvinciaDR(Provincia provinciaDR) {
		this.provinciaDR = provinciaDR;
	}
	
	

	
}
