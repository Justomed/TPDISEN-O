package entidades;

import java.util.List;

public class Provincia {
	String nombreProvincia;
	Pais pais;
	List<Localidad> localidades;
	
	
	public String getNombreProvincia() {
		return nombreProvincia;
	}
	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	

}
