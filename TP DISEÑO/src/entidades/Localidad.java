package entidades;

public class Localidad {
	String nombreLocalidad;
	int codigoPostal;
	Provincia nombreProvincia;
	float tasaDeRiesgo;

	
	public Localidad() {
		this.nombreProvincia=new Provincia();
	}
	
	public Localidad(String nombre, int cp, Provincia provincia) {
		this.nombreLocalidad=nombre;
		this.codigoPostal=cp;
		this.nombreProvincia=provincia;
	}
	
	public Localidad(String nombre, int cp, Provincia provincia, float tasaRiesgo) {
		this.nombreLocalidad=nombre;
		this.codigoPostal=cp;
		this.nombreProvincia=provincia;
		this.tasaDeRiesgo=tasaRiesgo;
	}
	
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
