package entidades;

import java.util.Date;

public class Cuota {
	private double valor;
	private Date fechaVencimiento;
	private int numeroCuota;
	private float tasaMora;
	private float descuento;
	private float recargo;
	private EstadoCuota estado;

	public Cuota() {}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public int getNumeroCuota() {
		return numeroCuota;
	}

	public void setNumeroCuota(int numeroCuota) {
		this.numeroCuota = numeroCuota;
	}

	public float getTasaMora() {
		return tasaMora;
	}

	public void setTasaMora(float tasaMora) {
		this.tasaMora = tasaMora;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public float getRecargo() {
		return recargo;
	}

	public void setRecargo(float recargo) {
		this.recargo = recargo;
	}

	public EstadoCuota getEstado() {
		return estado;
	}

	public void setEstado(EstadoCuota estado) {
		this.estado = estado;
	}
}
