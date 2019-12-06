package entidades;

import java.util.Date;

public class Cuota {
	private String valor;
	private Date fechaVencimiento;
	private int numeroCuota;
	private float tasaMora;
	private float descuento;
	private float recargo;
	private EstadoCuota estado;
	private String montoFinal;
	private Pago pago;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pago getPago() {
		return pago;
	}

	public void setPago(Pago pago) {
		this.pago = pago;
	}

	public String getMontoFinal() {
		return montoFinal;
	}

	public void setMontoFinal(String montoFinal) {
		this.montoFinal = montoFinal;
	}

	public Cuota() {}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
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
