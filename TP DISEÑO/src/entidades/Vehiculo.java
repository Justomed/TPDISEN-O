package entidades;

public class Vehiculo {
	private Marca marca;
	private Modelo modelo;
	private int anioFabricacion;
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
	public int getAnioFabricacion() {
		return anioFabricacion;
	}
	public void setAnioFabricacion(int anioFabricacion) {
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
	public Vehiculo(Marca marca, Modelo modelo, int anioFabricacion) {
		this.marca=marca;
		this.modelo=modelo;
		this.anioFabricacion=anioFabricacion;
	}
}
