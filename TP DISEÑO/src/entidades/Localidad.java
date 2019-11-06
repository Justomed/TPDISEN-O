package entidades;

public class Localidad {
	String nombreLocalidad;
	int codigoPostal;
	Provincia nombreProvincia;
	float tasaDeRiesgo;
	
	
	public String getNombreLocalidad() {
		return nombreLocalidad;
	}
	public void setNombreLocalidad(String nombreLocalidad) {
		this.nombreLocalidad = nombreLocalidad;
	}
	public int getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public Provincia getProvincia() {
		return nombreProvincia;
	}
	public void setNombreProvincia(Provincia provincia) {
		this.nombreProvincia = provincia;
	}
	public float getTasaDeRiesgo() {
		return tasaDeRiesgo;
	}
	public void setTasaDeRiesgo(float tasaDeRiesgo) {
		this.tasaDeRiesgo = tasaDeRiesgo;
	}
	
	

	
}
