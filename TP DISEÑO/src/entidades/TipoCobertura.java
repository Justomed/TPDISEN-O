package entidades;

public class TipoCobertura {
	int id;
	String detalle;
	float tasaTipoCobertura;
	
	public TipoCobertura() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public float getTasaTipoCobertura() {
		return tasaTipoCobertura;
	}
	public void setTasaTipoCobertura(float tasaTipoCobertura) {
		this.tasaTipoCobertura = tasaTipoCobertura;
	}
}
