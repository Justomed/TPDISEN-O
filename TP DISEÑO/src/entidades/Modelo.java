package entidades;

public class Modelo {
	private String modelo;
	int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Modelo() {}
	
	public Modelo(String modelo) {
		this.modelo=modelo;
	}
	
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
}
