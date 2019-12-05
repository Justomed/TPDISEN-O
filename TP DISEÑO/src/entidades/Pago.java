package entidades;

import java.util.Date;

public class Pago {
	
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String monto;
	private Date fecha;
	private float tasaAnticipada;
	
	public Pago() {
		
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public float getTasaAnticipada() {
		return tasaAnticipada;
	}

	public void setTasaAnticipada(float tasaAnticipada) {
		this.tasaAnticipada = tasaAnticipada;
	}
	
}
