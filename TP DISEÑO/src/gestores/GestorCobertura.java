package gestores;

import entidades.TipoCobertura;

public class GestorCobertura {

	public GestorCobertura() {}
	
	public TipoCobertura obtenerCobertura() {
		TipoCobertura aux = new TipoCobertura();
		GestorBD gestorBD = new GestorBD();
		
		aux = gestorBD.recuperarCobertura();
		
		return aux;
	}
		
}
