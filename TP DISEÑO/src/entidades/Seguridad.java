package entidades;

public class Seguridad {
	boolean garage;
	boolean alarma;
	boolean rastreo;
	boolean tuerca;
	float tasaSeg;
	
	
	public boolean isGarage() {
		return garage;
	}
	public void setGarage(boolean garage) {
		this.garage = garage;
	}
	public boolean isAlarma() {
		return alarma;
	}
	public void setAlarma(boolean alarma) {
		this.alarma = alarma;
	}
	public boolean isRastreo() {
		return rastreo;
	}
	public void setRastreo(boolean rastreo) {
		this.rastreo = rastreo;
	}
	public boolean isTuerca() {
		return tuerca;
	}
	public void setTuerca(boolean tuerca) {
		this.tuerca = tuerca;
	}
	public float getTasaSeg() {
		return tasaSeg;
	}
	public void setTasaSeg(float tasaSeg) {
		this.tasaSeg = tasaSeg;
	}
	public Seguridad() {
		
	}
	public Seguridad (boolean garage, boolean alarma, boolean rastreo, boolean tuerca) {
		this.alarma=alarma;
		this.garage=garage;
		this.rastreo=rastreo;
		this.tuerca=tuerca;
	}

}
