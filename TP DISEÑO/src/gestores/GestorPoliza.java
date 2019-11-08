package gestores;

import java.util.ArrayList;
import java.util.Date;

import entidades.*;

public class GestorPoliza {
	
	public GestorPoliza() {}

	public void darAltaPoliza(ArrayList<Hijo> listaHijos, 
							  String cobertura, 
							  String provincia, 
							  String localidad,
							  String anioPoliza, 
							  String marcaPoliza, 
							  String modeloPoliza, 
							  String motorPoliza,
							  String chasisPoliza, 
							  String patentePoliza,
							  ArrayList<Boolean> seguridad, 
							  String sumaAseguradaPoliza, 
							  Date fechaInicio, 
							  Date finVigencia, 
							  String kmAnio,
							  Cliente cliente
							  ) {
		
		Poliza poliza = new Poliza();
		
		poliza.setFechaInicioVigencia(fechaInicio);
		poliza.setFechaFinVigencia(finVigencia);
		poliza.setHijosDeclarados(listaHijos);
		poliza.setKmPorAnio(kmAnio);
		poliza.setSumaAsegurada(sumaAseguradaPoliza);
		poliza.setChasis(chasisPoliza);
		poliza.setMotor(motorPoliza);
		poliza.setPatente(patentePoliza);
		
		GestorParametro gestorParametro = new GestorParametro();
		
		Parametro parametro = gestorParametro.obtenerParametros();
		
		poliza.setParametro(parametro);
		
		//COBERTURA
		
		/*GestorCobertura gestorCobertura = new GestorCobertura();
		
		TipoCobertura cobertura = gestorCobertura.obtenerCobertura();*/
		
		GestorDomicilioRiesgo gestorDomicilioRiesgo = new GestorDomicilioRiesgo();
		
		DomicilioDeRiesgo domicilioRiesgo = gestorDomicilioRiesgo.obtenerDomicilioRiesgo(localidad, provincia);
		
		poliza.setDomRiesgo(domicilioRiesgo); //domicilio seteado
		
		GestorVehiculo gestorVehiculo = new GestorVehiculo();
		
		AnioFabricacion anio = gestorVehiculo.obtenerAnio(anioPoliza);
		Marca marca = new Marca(marcaPoliza);
		Modelo modelo = new Modelo(modeloPoliza);
		
		Vehiculo vehiculo = new Vehiculo(marca, modelo, anio); //vehiculo creado
		
		poliza.setVehiculo(vehiculo); //vehiculo seteado
		
		Seguridad seguridadPoliza = new Seguridad(seguridad.get(0), seguridad.get(1), seguridad.get(2), seguridad.get(3));
		
		poliza.setSeguridad(seguridadPoliza); //seguridad seteada
		
		ArrayList<Cuota> cuotas = new ArrayList<Cuota>();
		
		for(int i=0; i>6; i++) {
			Cuota aux = new Cuota();
			aux.setValor(1000.00);
			cuotas.add(aux);
		}
		
		poliza.setCuotas(cuotas);
		poliza.setCliente(cliente);
		GestorBD gestorBD = new GestorBD();
		gestorBD.guardarPoliza(poliza);
	}
	
}
