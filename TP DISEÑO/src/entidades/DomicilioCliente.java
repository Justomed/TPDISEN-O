package entidades;

public class DomicilioCliente {
	
	private String calle;
	private int numero;
	private int piso;
	private String depto;
	private Localidad localidad;
	
	public DomicilioCliente() {
		this.localidad=new Localidad();
	}
	
	public DomicilioCliente(String calle, int numero, Localidad localidad) {
		this.calle=calle;
		this.numero=numero;
		this.localidad=localidad;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getPiso() {
		return piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public String getDepto() {
		return depto;
	}

	public void setDepto(String depto) {
		this.depto = depto;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
}
