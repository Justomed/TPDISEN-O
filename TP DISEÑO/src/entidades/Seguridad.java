package entidades;

public class Seguridad {
	int garaje;
	int alarma;
	int rastreo;
	int tuerca;
	int tasaSeg;
	int id;
	
	public Seguridad() {
		
	}
	
	public Seguridad (int garaje, int alarma, int rastreo, int tuerca) {
		this.alarma=alarma;
		this.garaje=garaje;
		this.rastreo=rastreo;
		this.tuerca=tuerca;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGaraje() {
		return garaje;
	}

	public void setGaraje(int garaje) {
		this.garaje = garaje;
	}

	public int getAlarma() {
		return alarma;
	}

	public void setAlarma(int alarma) {
		this.alarma = alarma;
	}

	public int getRastreo() {
		return rastreo;
	}

	public void setRastreo(int rastreo) {
		this.rastreo = rastreo;
	}

	public int getTuerca() {
		return tuerca;
	}

	public void setTuerca(int tuerca) {
		this.tuerca = tuerca;
	}

	public int getTasaSeg() {
		return tasaSeg;
	}

	public void setTasaSeg(int tasaSeg) {
		this.tasaSeg = tasaSeg;
	}

}
