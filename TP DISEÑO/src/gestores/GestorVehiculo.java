package gestores;

import entidades.AnioFabricacion;

public class GestorVehiculo {
	
	public GestorVehiculo() {}
	
	public AnioFabricacion obtenerAnio(String anio) {
		AnioFabricacion aux = new AnioFabricacion();
		GestorBD gestorBD = new GestorBD();
		
		aux = gestorBD.recuperarAnioFabricacion(anio);
		
		return aux;
	}
	
}
