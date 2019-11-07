package entidades;

public class TipoCobertura {
	boolean responsabilidadCivil;
	boolean respCivilRoboIncendioTotal;
	boolean todoTotal;
	boolean tercerosCompletos;
	boolean todoRiesgoConFranquicia;
	String detalle;
	float tasaTipoCobertura;
	
	
	public boolean isResponsabilidadCivil() {
		return responsabilidadCivil;
	}
	public void setResponsabilidadCivil(boolean responsabilidadCivil) {
		this.responsabilidadCivil = responsabilidadCivil;
	}
	public boolean isRespCivilRoboIncendioTotal() {
		return respCivilRoboIncendioTotal;
	}
	public void setRespCivilRoboIncendioTotal(boolean respCivilRoboIncendioTotal) {
		this.respCivilRoboIncendioTotal = respCivilRoboIncendioTotal;
	}
	public boolean isTodoTotal() {
		return todoTotal;
	}
	public void setTodoTotal(boolean todoTotal) {
		this.todoTotal = todoTotal;
	}
	public boolean isTercerosCompletos() {
		return tercerosCompletos;
	}
	public void setTercerosCompletos(boolean tercerosCompletos) {
		this.tercerosCompletos = tercerosCompletos;
	}
	public boolean isTodoRiesgoConFranquicia() {
		return todoRiesgoConFranquicia;
	}
	public void setTodoRiesgoConFranquicia(boolean todoRiesgoConFranquicia) {
		this.todoRiesgoConFranquicia = todoRiesgoConFranquicia;
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
