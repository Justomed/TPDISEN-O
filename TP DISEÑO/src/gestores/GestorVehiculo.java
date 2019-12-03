package gestores;

import entidades.AnioFabricacion;
import entidades.Vehiculo;

public class GestorVehiculo {
	
	public GestorVehiculo() {}
	
	public AnioFabricacion obtenerAnio(String anio) {
		AnioFabricacion aux = new AnioFabricacion();
		GestorBD gestorBD = new GestorBD();
		
		aux = gestorBD.recuperarAnioFabricacion(anio);
		
		return aux;
	}
	
	public void guardarVehiculo(Vehiculo vehiculo, String poliza) {
		GestorBD gestorBD = new GestorBD();
		gestorBD.guardarVehiculo(vehiculo, poliza);
	}
}
