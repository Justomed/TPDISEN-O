package entidades;

import java.util.List;

public class Provincia {
	String nombreProvincia;
	Pais pais;
	int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Provincia() {
		this.pais=new Pais();
	}
	
	public Provincia(String nombre, Pais pais) {
		this.nombreProvincia=nombre;
		this.pais=pais;
	}
	
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
