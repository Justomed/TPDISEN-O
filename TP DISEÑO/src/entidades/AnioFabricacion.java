package entidades;

public class AnioFabricacion {
	
	private String anio;
	int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public AnioFabricacion(String anio) {
		this.anio = anio;
	}

	public AnioFabricacion() {}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}
	
}
