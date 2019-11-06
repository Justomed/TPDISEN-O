package entidades;

public class Poliza {
	int nro;
	float sumaAsegurada;
	String kmPorAnio;
	String nroSiniestros;
	TipoCobertura tipoCobertura;
	DomicilioDeRiesgo domicilioDeRiesgo;
	Parametro parametro;
	Seguridad seguridad;
	Usuario usuario;
	
	
	public Poliza() {

	}
	
	public Poliza (int nro,float suma,String km, String siniestros) {
		this.nro=nro;
		this.sumaAsegurada=suma;
		this.kmPorAnio=km;
		this.nroSiniestros=siniestros;
		System.out.println("se creo un objeto Poliza");
	}
	
	public int getnro(){
		return this.nro;
	}
	
	public float getSumaAsegurada() {
		return this.sumaAsegurada ;
	}
	public String getKmPorAnio(){
		return this.kmPorAnio;
	}
	public String getNroSiniestros() {
		
		return this.nroSiniestros;
	
	}
	
	public void setPoliza (float suma,String km, String siniestros) {
		this.sumaAsegurada=suma;
		this.kmPorAnio=km;
		this.nroSiniestros=siniestros;
		System.out.println("se seteo un objeto Poliza");
	}
	
	

	
	public void setDomRiesgo(DomicilioDeRiesgo domicilioDeRiesgo) {
		this.domicilioDeRiesgo=domicilioDeRiesgo;
	}

	public void setNro(int nro) {
		this.nro = nro;
	}

	public void setSumaAsegurada(float sumaAsegurada) {
		this.sumaAsegurada = sumaAsegurada;
	}

	public void setKmPorAnio(String kmPorAnio) {
		this.kmPorAnio = kmPorAnio;
	}

	public void setNroSiniestros(String nroSiniestros) {
		this.nroSiniestros = nroSiniestros;
	}

	public void setTipoCobertura(TipoCobertura tipoCobertura) {
		this.tipoCobertura = tipoCobertura;
	}

	public void setDomicilioDeRiesgo(DomicilioDeRiesgo domicilioDeRiesgo) {
		this.domicilioDeRiesgo = domicilioDeRiesgo;
	}

	public Parametro getParametro() {
		return parametro;
	}

	public void setParametro(Parametro parametro) {
		this.parametro = parametro;
	}

	public int getNro() {
		return nro;
	}

	public TipoCobertura getTipoCobertura() {
		return tipoCobertura;
	}

	public DomicilioDeRiesgo getDomicilioDeRiesgo() {
		return domicilioDeRiesgo;
	}

	public Seguridad getSeguridad() {
		return seguridad;
	}

	public void setSeguridad(Seguridad seguridad) {
		this.seguridad = seguridad;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
}
