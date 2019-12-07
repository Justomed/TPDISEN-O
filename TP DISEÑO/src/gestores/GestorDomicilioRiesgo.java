package gestores;

import entidades.DomicilioDeRiesgo;
import entidades.Localidad;
import entidades.Provincia;

public class GestorDomicilioRiesgo {

	public GestorDomicilioRiesgo() {}
	
	public DomicilioDeRiesgo obtenerDomicilioRiesgo(Localidad localidad, Provincia provincia) {
		DomicilioDeRiesgo domRiesgo = new DomicilioDeRiesgo();
		GestorBD gestorBD = new GestorBD();
		
		domRiesgo.setLocalidadDR(localidad);
		domRiesgo.setProvinciaDR(provincia);
		domRiesgo.setId(gestorBD.recuperarDomicilioRiesgo(localidad.getId()));
		
		System.out.println(localidad.getId());
		System.out.println(domRiesgo.getId());
		
		return domRiesgo;
	}
	
}

