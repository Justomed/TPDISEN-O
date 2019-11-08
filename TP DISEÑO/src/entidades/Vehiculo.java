package entidades;

public class Vehiculo {
	private Marca marca;
	private Modelo modelo;
	private AnioFabricacion anioFabricacion;
	private float kilometros;
	private float tasavehiculo;
	
	
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	public Modelo getModelo() {
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	public AnioFabricacion getAnioFabricacion() {
		return anioFabricacion;
	}
	public void setAnioFabricacion(AnioFabricacion anioFabricacion) {
		this.anioFabricacion = anioFabricacion;
	}
	public float getKilometros() {
		return kilometros;
	}
	public void setKilometros(float kilometros) {
		this.kilometros = kilometros;
	}
	public float getTasavehiculo() {
		return tasavehiculo;
	}
	public void setTasavehiculo(float tasavehiculo) {
		this.tasavehiculo = tasavehiculo;
	}
	
	public Vehiculo() {
		
	}
	public Vehiculo(Marca marca, Modelo modelo, AnioFabricacion anioFabricacion) {
		this.marca=marca;
		this.modelo=modelo;
		this.anioFabricacion=anioFabricacion;
	}
}
