package entidades;

import java.util.List;

public class Pais {
	String nombrePais;
	List<Provincia> provincias;

	public Pais() {}
	
	public Pais(String nombre) {
		this.nombrePais=nombre;
	}
	
	public String getNombrePais() {
		return nombrePais;
	}

	public void setNombrePais(String nombrePais) {
		this.nombrePais = nombrePais;
	}

	public List<Provincia> getProvincias() {
		return provincias;
	}

	public void setProvincias(List<Provincia> provincias) {
		this.provincias = provincias;
	}
	
	
	
	
}
