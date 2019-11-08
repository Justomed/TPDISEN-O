package entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Poliza {
	int nro;
	Cliente cliente;
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	String sumaAsegurada;
	String kmPorAnio;
	String nroSiniestros;
	TipoCobertura tipoCobertura;
	DomicilioDeRiesgo domicilioDeRiesgo;
	Parametro parametro;
	Seguridad seguridad;
	Usuario usuario;
	ArrayList <Hijo> hijosDeclarados;
	ArrayList<Cuota> cuotas;
	String estado;
	Vehiculo vehiculo;
	Date fechaInicioVigencia;
	Date fechaFinVigencia;
	String motor;
	String chasis;
	String patente;
	
	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String getChasis() {
		return chasis;
	}

	public void setChasis(String chasis) {
		this.chasis = chasis;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}
	
	public Date getFechaInicioVigencia() {
		return fechaInicioVigencia;
	}

	public void setFechaInicioVigencia(Date fechaInicioVigencia) {
		this.fechaInicioVigencia = fechaInicioVigencia;
	}

	public Date getFechaFinVigencia() {
		return fechaFinVigencia;
	}

	public void setFechaFinVigencia(Date fechaFinVigencia) {
		this.fechaFinVigencia = fechaFinVigencia;
	}

	public Poliza() {

	}
	
	public Poliza (int nro,String suma,String km, String siniestros) {
		this.nro=nro;
		this.sumaAsegurada=suma;
		this.kmPorAnio=km;
		this.nroSiniestros=siniestros;
		System.out.println("se creo un objeto Poliza");
	}
	
	public ArrayList<Cuota> getCuotas() {
		return cuotas;
	}

	public void setCuotas(ArrayList<Cuota> cuotas) {
		this.cuotas = cuotas;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public int getnro(){
		return this.nro;
	}
	
	public String getSumaAsegurada() {
		return this.sumaAsegurada ;
	}
	public String getKmPorAnio(){
		return this.kmPorAnio;
	}
	public String getNroSiniestros() {
		
		return this.nroSiniestros;
	
	}
	
	public void setPoliza (String suma,String km, String siniestros) {
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

	public void setSumaAsegurada(String sumaAsegurada) {
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

	public List<Hijo> getHijosDeclarados() {
		return hijosDeclarados;
	}

	public void setHijosDeclarados(ArrayList<Hijo> hijosDeclarados) {
		this.hijosDeclarados = hijosDeclarados;
	}
	
	public void estadoCuotas() {
		
	}
	
	public void actualizarEstado() {
		
	}
	
	
}
