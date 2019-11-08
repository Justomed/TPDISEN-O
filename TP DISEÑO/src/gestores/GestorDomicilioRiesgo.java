package gestores;

import entidades.DomicilioDeRiesgo;
import entidades.Localidad;
import entidades.Provincia;

public class GestorDomicilioRiesgo {

	public GestorDomicilioRiesgo() {}
	
	public DomicilioDeRiesgo obtenerDomicilioRiesgo(String localidad, String provincia) {
		DomicilioDeRiesgo domRiesgo = new DomicilioDeRiesgo();
		GestorBD gestorBD = new GestorBD();
		
		domRiesgo.setLocalidadDR(gestorBD.recuperarLocalidad(localidad));
		domRiesgo.setProvinciaDR(gestorBD.recuperarProvincia(provincia));
		domRiesgo.getLocalidadDR().setNombreProvincia(domRiesgo.getProvinciaDR());
		
		return domRiesgo;
	}
	
}

