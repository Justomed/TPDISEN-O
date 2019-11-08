package gestores;

import entidades.Parametro;

public class GestorParametro {
	
	public GestorParametro() {}

	public Parametro obtenerParametros() {
		Parametro aux = new Parametro();
		GestorBD gestorBD = new GestorBD();
		
		aux = gestorBD.recuperarParametro();
		
		return aux;
	}
	
	

}
