package gestores;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import entidades.*;
import jdk.nashorn.api.tree.ForInLoopTree;

public class GestorPoliza {
	
	public GestorPoliza() {}

	public void darAltaPoliza(ArrayList<Hijo> listaHijos, 
							  String cobertura, 
							  String provincia, 
							  String localidad,
							  String anioPoliza, 
							  Marca marcaPoliza, 
							  Modelo modeloPoliza, 
							  String motorPoliza,
							  String chasisPoliza, 
							  String patentePoliza,
							  ArrayList<Boolean> seguridad, 
							  String sumaAseguradaPoliza, 
							  Date fechaInicio, 
							  Date finVigencia, 
							  String kmAnio,
							  Cliente cliente,
							  ArrayList<Cuota> cuotas,
							  String siniestros
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
		poliza.setCuotas(cuotas);
		poliza.setNroSiniestros(siniestros);
		poliza.setPatente(patentePoliza);
		
		String sucursal = "0001";
		String nroClienteAux = cliente.getId().substring(4);
		Random r = new Random();
		int random = r.nextInt(100);
		
		String nroPoliza;
		if(random < 10) {
			nroPoliza = sucursal + nroClienteAux + '0' + random;
		} else {
			nroPoliza = sucursal + nroClienteAux + random;
		}
		
		poliza.setNroPoliza(nroPoliza);
		
		System.out.println(nroPoliza);
		
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
		
		Vehiculo vehiculo = new Vehiculo(marcaPoliza, modeloPoliza, anio); //vehiculo creado
		
		poliza.setVehiculo(vehiculo); //vehiculo seteado
		
		Seguridad seguridadPoliza = new Seguridad(seguridad.get(0), seguridad.get(1), seguridad.get(2), seguridad.get(3));
		
		poliza.setSeguridad(seguridadPoliza); //seguridad seteada
		
		for(int i=0; i>6; i++) {
			Cuota aux = new Cuota();
			aux.setValor("$1000.00");
			cuotas.add(aux);
		}
		
		poliza.setCuotas(cuotas);
		poliza.setCliente(cliente);
		GestorBD gestorBD = new GestorBD();
		
		System.out.println(poliza.getSumaAsegurada());
		//System.out.println("antes de envio"); HASTA ACA OK
		gestorBD.guardarPoliza(poliza);
		gestorVehiculo.guardarVehiculo(vehiculo, poliza.getNroPoliza());
		gestorBD.guardarCuota(cuotas, poliza.getNroPoliza());

	}
	
	public String validarDatos(String patente, String motor, String chasis, ArrayList<Hijo> listaHijos) {
		
		if(this.validarPatente(patente) == false) {
			return "patente";
		}
		if(this.validarMotor(motor) == false) {
			return "motor";
		}
		if(this.validarChasis(chasis) == false) {
			return "chasis";
		}

		for(Hijo aux : listaHijos) {
			
			Date hoy = new Date();
			
			switch(aux.getFechaNacimiento().compareTo(hoy)) {
			case 0:
				return "hijos";
			case 1:
				return "hijos";
			case -1:
				Calendar auxHijo = Calendar.getInstance();
				Calendar auxHoy = Calendar.getInstance();
				
				auxHijo.setTime(aux.getFechaNacimiento());
				auxHoy.setTime(hoy);
				
				if(auxHoy.get(Calendar.YEAR) - auxHijo.get(Calendar.YEAR) < 18) {
					return "hijos";
				}
				
				if(auxHoy.get(Calendar.YEAR) - auxHijo.get(Calendar.YEAR) > 30) {
					return "hijos";
				}
			}
		}
		return "";
	}

	public boolean validarFecha(Date fechaInicio) {
		
		Date hoy = new Date();
		
		Calendar auxHoy = Calendar.getInstance();
		Calendar auxFechaInicio = Calendar.getInstance();
		
		auxHoy.setTime(hoy);
		auxFechaInicio.setTime(fechaInicio);
		
		if(auxHoy.get(Calendar.MONTH) - auxFechaInicio.get(Calendar.MONTH) < 0) {
			return false;
		}
		
		if(auxFechaInicio.get(Calendar.DAY_OF_MONTH) - (auxHoy.get(Calendar.DAY_OF_MONTH)+1) < 0) {
			return false;
		}
		
		return true;
	}
	
	public static boolean validarMotor(String motor) {
		return motor.matches("^[A-Z]{10}[0-9]{7}$");
	}
	public static boolean validarPatente(String patente) {
		return patente.matches("^[A-Z]{3}[0-9]{3}|[A-Z]{2}[0-9]{3}[A-Z]{2}$");
	}
	public static boolean validarChasis(String chasis) {
		return chasis.matches("^[A-Z]{1}[0-9]{7}$");
	}
	
	public Poliza recuperarPoliza(String poliza) {
		Poliza aux = new Poliza();
		GestorBD gestorBD = new GestorBD();
		
		aux = gestorBD.recuperarPoliza(poliza);
		this.actualizarEstadoCuotas(aux.getCuotas());
		
		return aux;
	}
	
	public void actualizarEstadoCuotas(ArrayList<Cuota> cuotas) {
		for(Cuota aux : cuotas) {
			if(aux.getPago().getMonto() != null) {
				aux.setEstado(EstadoCuota.PAGA);
			} else {
				aux.setEstado(EstadoCuota.IMPAGA);
			}
		}
	}
	
	public void pagarCuotas(ArrayList<Cuota> cuotas, int idPago) {
		GestorBD gestorBD = new GestorBD();
		gestorBD.actualizarCuotasPagas(cuotas, idPago);
	}
	
}
