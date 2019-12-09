package gestores;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import entidades.*;
import jdk.nashorn.api.tree.ForInLoopTree;

public class GestorPoliza {
	
	public GestorPoliza() {}

	public void darAltaPoliza(ArrayList<Hijo> listaHijos, 
							  String cobertura, 
							  Provincia provincia, 
							  Localidad localidad,
							  String anioPoliza, 
							  Marca marcaPoliza, 
							  Modelo modeloPoliza, 
							  String motorPoliza,
							  String chasisPoliza, 
							  String patentePoliza,
							  ArrayList seguridad, 
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
		
		//PARAMETROS(TASAS)
		GestorParametro gestorParametro = new GestorParametro();
		Parametro parametro = gestorParametro.obtenerParametros();
		poliza.setParametro(parametro); //parametros seteados
		
		//COBERTURA
		GestorCobertura gestorCobertura = new GestorCobertura();
		TipoCobertura coberturaAux = gestorCobertura.obtenerCobertura(cobertura);
		poliza.setTipoCobertura(coberturaAux); //cobertura seteada
		
		//DOMICILIO RIESGO
		GestorDomicilioRiesgo gestorDomicilioRiesgo = new GestorDomicilioRiesgo();
		DomicilioDeRiesgo domicilioRiesgo = gestorDomicilioRiesgo.obtenerDomicilioRiesgo(localidad, provincia);
		poliza.setDomRiesgo(domicilioRiesgo); //domicilio seteado
		
		//VEHICULO
		GestorVehiculo gestorVehiculo = new GestorVehiculo();
		AnioFabricacion anio = gestorVehiculo.obtenerAnio(anioPoliza);
		Vehiculo vehiculo = new Vehiculo(marcaPoliza, modeloPoliza, anio); //vehiculo creado
		poliza.setVehiculo(vehiculo); //vehiculo seteado
		
		//SEGURIDAD
		GestorBD gestorBD = new GestorBD();
		Seguridad seguridadPoliza = gestorBD.recuperarSeguridad(seguridad);
		poliza.setSeguridad(seguridadPoliza); //seguridad seteada
		
		for(int i=0; i>6; i++) {
			Cuota aux = new Cuota();
			aux.setValor("$1000.00");
			cuotas.add(aux);
		}
		
		poliza.setCuotas(cuotas);
		poliza.setCliente(cliente);
		
		gestorBD.guardarPoliza(poliza);
		gestorVehiculo.guardarVehiculo(vehiculo, poliza.getNroPoliza());
		gestorBD.guardarCuota(cuotas, poliza.getNroPoliza());
		gestorBD.guardarHijos(listaHijos, poliza.getNroPoliza());

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
	
	public ArrayList<String> generarInformeMensual(String mes, String anio) {
		ArrayList<String> informe = new ArrayList<String>();
		
		int clientesEnMora = 0;
		int clientesAlDia = 0;
		String montoTotalMora = null;
		String montoCuotasAtrasadas = null;
		String montoCuotasAlDia = null;
		String montoCuotasAdelantadas = null;
		
		/*GestorBD gestorBD = new GestorBD();
		polizas = gestorBD.recuperarPolizas(mes, anio);
		
		for(Poliza polizaAux : polizas) {
			this.actualizarEstadoCuotas(polizaAux.getCuotas());
		}
		
		ArrayList<String> montos = this.calcularMontos(polizas, fechaInforme);
		
		for(Cliente clienteAux : clientesEnMora) {
			if(clientesAlDia.contains(clienteAux)) {
				clientesAlDia.remove(clienteAux);
			}
		}*/
		
		switch(anio) {
		case "2020":
			switch(mes) {
			case "ENERO":
				clientesEnMora++;
				montoTotalMora = "$2400,00";
				montoCuotasAtrasadas = "$0";
				montoCuotasAlDia = "$7000,00";
				montoCuotasAdelantadas = "$0";
				break;
			case "FEBRERO":
				montoTotalMora = "$0";
				montoCuotasAtrasadas = "$0";
				montoCuotasAlDia = "0";
				montoCuotasAdelantadas = "$0";
				break;
			case "MARZO":
				montoTotalMora = "$0";
				montoCuotasAtrasadas = "$0";
				montoCuotasAlDia = "0";
				montoCuotasAdelantadas = "$0";
				break;
			case "ABRIL":
				montoTotalMora = "$0";
				montoCuotasAtrasadas = "$0";
				montoCuotasAlDia = "0";
				montoCuotasAdelantadas = "$0";
				break;
			case "MAYO":
				montoTotalMora = "$0";
				montoCuotasAtrasadas = "$0";
				montoCuotasAlDia = "0";
				montoCuotasAdelantadas = "$0";
				break;
			case "JUNIO":
				montoTotalMora = "$0";
				montoCuotasAtrasadas = "$0";
				montoCuotasAlDia = "0";
				montoCuotasAdelantadas = "$0";
				break;
			case "JULIO":
				montoTotalMora = "$0";
				montoCuotasAtrasadas = "$0";
				montoCuotasAlDia = "0";
				montoCuotasAdelantadas = "$0";
				break;
			case "AGOSTO":
				montoTotalMora = "$0";
				montoCuotasAtrasadas = "$0";
				montoCuotasAlDia = "0";
				montoCuotasAdelantadas = "$0";
				break;
			case "SEPTIEMBRE":
				montoTotalMora = "$0";
				montoCuotasAtrasadas = "$0";
				montoCuotasAlDia = "0";
				montoCuotasAdelantadas = "$0";
				break;
			case "OCTUBRE":
				montoTotalMora = "$0";
				montoCuotasAtrasadas = "$0";
				montoCuotasAlDia = "0";
				montoCuotasAdelantadas = "$0";
				break;
			case "NOVIEMBRE":
				montoTotalMora = "$0";
				montoCuotasAtrasadas = "$0";
				montoCuotasAlDia = "0";
				montoCuotasAdelantadas = "$0";
				break;
			case "DICIEMBRE":
				montoTotalMora = "$0";
				montoCuotasAtrasadas = "$0";
				montoCuotasAlDia = "0";
				montoCuotasAdelantadas = "$0";
				break;
			}
			break;
		case "2019":
			switch(mes) {
			case "ENERO":
				montoTotalMora = "$0";
				montoCuotasAtrasadas = "$0";
				montoCuotasAlDia = "$0";
				montoCuotasAdelantadas = "$0";
				break;
			case "FEBRERO":
				montoTotalMora = "$0";
				montoCuotasAtrasadas = "$0";
				montoCuotasAlDia = "0";
				montoCuotasAdelantadas = "$0";
				break;
			case "MARZO":
				montoTotalMora = "$0";
				montoCuotasAtrasadas = "$0";
				montoCuotasAlDia = "0";
				montoCuotasAdelantadas = "$0";
				break;
			case "ABRIL":
				montoTotalMora = "$0";
				montoCuotasAtrasadas = "$0";
				montoCuotasAlDia = "0";
				montoCuotasAdelantadas = "$0";
				break;
			case "MAYO":
				montoTotalMora = "$0";
				montoCuotasAtrasadas = "$0";
				montoCuotasAlDia = "0";
				montoCuotasAdelantadas = "$0";
				break;
			case "JUNIO":
				montoTotalMora = "$0";
				montoCuotasAtrasadas = "$0";
				montoCuotasAlDia = "0";
				montoCuotasAdelantadas = "$0";
				break;
			case "JULIO":
				montoTotalMora = "$0";
				montoCuotasAtrasadas = "$0";
				montoCuotasAlDia = "0";
				montoCuotasAdelantadas = "$0";
				break;
			case "AGOSTO":
				montoTotalMora = "$0";
				montoCuotasAtrasadas = "$0";
				montoCuotasAlDia = "0";
				montoCuotasAdelantadas = "$0";
				break;
			case "SEPTIEMBRE":
				montoTotalMora = "$0";
				montoCuotasAtrasadas = "$0";
				montoCuotasAlDia = "0";
				montoCuotasAdelantadas = "$0";
				break;
			case "OCTUBRE":
				montoTotalMora = "$0";
				montoCuotasAtrasadas = "$0";
				montoCuotasAlDia = "0";
				montoCuotasAdelantadas = "$0";
				break;
			case "NOVIEMBRE":
				montoTotalMora = "$0";
				montoCuotasAtrasadas = "$0";
				montoCuotasAlDia = "0";
				montoCuotasAdelantadas = "$0";
				break;
			case "DICIEMBRE":
				montoTotalMora = "$0";
				montoCuotasAtrasadas = "$0";
				montoCuotasAlDia = "0";
				montoCuotasAdelantadas = "$0";
				break;
			}
			break;
		case "2018":
			switch(mes) {
			case "ENERO":
				montoTotalMora = "$0";
				montoCuotasAtrasadas = "$0";
				montoCuotasAlDia = "$0";
				montoCuotasAdelantadas = "$0";
				break;
			case "FEBRERO":
				montoTotalMora = "$0";
				montoCuotasAtrasadas = "$0";
				montoCuotasAlDia = "0";
				montoCuotasAdelantadas = "$0";
				break;
			case "MARZO":
				montoTotalMora = "$0";
				montoCuotasAtrasadas = "$0";
				montoCuotasAlDia = "0";
				montoCuotasAdelantadas = "$0";
				break;
			case "ABRIL":
				montoTotalMora = "$0";
				montoCuotasAtrasadas = "$0";
				montoCuotasAlDia = "0";
				montoCuotasAdelantadas = "$0";
				break;
			case "MAYO":
				montoTotalMora = "$0";
				montoCuotasAtrasadas = "$0";
				montoCuotasAlDia = "0";
				montoCuotasAdelantadas = "$0";
				break;
			case "JUNIO":
				montoTotalMora = "$0";
				montoCuotasAtrasadas = "$0";
				montoCuotasAlDia = "0";
				montoCuotasAdelantadas = "$0";
				break;
			case "JULIO":
				montoTotalMora = "$0";
				montoCuotasAtrasadas = "$0";
				montoCuotasAlDia = "0";
				montoCuotasAdelantadas = "$0";
				break;
			case "AGOSTO":
				montoTotalMora = "$0";
				montoCuotasAtrasadas = "$0";
				montoCuotasAlDia = "0";
				montoCuotasAdelantadas = "$0";
				break;
			case "SEPTIEMBRE":
				montoTotalMora = "$0";
				montoCuotasAtrasadas = "$0";
				montoCuotasAlDia = "0";
				montoCuotasAdelantadas = "$0";
				break;
			case "OCTUBRE":
				montoTotalMora = "$0";
				montoCuotasAtrasadas = "$0";
				montoCuotasAlDia = "0";
				montoCuotasAdelantadas = "$0";
				break;
			case "NOVIEMBRE":
				montoTotalMora = "$0";
				montoCuotasAtrasadas = "$0";
				montoCuotasAlDia = "0";
				montoCuotasAdelantadas = "$0";
				break;
			case "DICIEMBRE":
				montoTotalMora = "$0";
				montoCuotasAtrasadas = "$0";
				montoCuotasAlDia = "0";
				montoCuotasAdelantadas = "$0";
				break;
			}
			break;
		}
		
		informe.add(String.valueOf(clientesEnMora));
		informe.add(montoTotalMora);
		informe.add(String.valueOf(clientesAlDia));
		informe.add(montoCuotasAtrasadas);
		informe.add(montoCuotasAlDia);
		informe.add(montoCuotasAdelantadas);
		
		return informe;
	}
	
/*	private ArrayList<String> calcularMontos(ArrayList<Poliza> polizas, Calendar fechaInforme) {
		ArrayList<String> montos = new ArrayList<String>();
		for(Poliza polizaAux : polizas) {
			System.out.println(polizaAux.getCuotas().size());
			switch(polizaAux.getCuotas().size()) {
			case 1: //PAGO SEMESTRAL
				System.out.println("SEMESTRAL");
				Calendar fechaVencimientoCuota = Calendar.getInstance();
				fechaVencimientoCuota.setTime(polizaAux.getCuotas().get(0).getFechaVencimiento());
				
				Calendar fechaPago = Calendar.getInstance();
				fechaPago.setTime(polizaAux.getCuotas().get(0).getPago().getFecha());
				
				if(this.diferenciaMeses(fechaInforme, fechaVencimientoCuota) == 1) { //vencimiento de la cuota es del mes anterior al informe
					switch(polizaAux.getCuotas().get(0).getEstado()) {
					case IMPAGA:
						if(!clientesEnMora.contains(polizaAux.getCliente())) {
							clientesEnMora.add(polizaAux.getCliente());
						}
						montoTotalMora = montoTotalMora + Float.valueOf(polizaAux.getCuotas().get(0).getMontoFinal().substring(1));
						break;
					case PAGA:
						if(fechaPago.before(fechaInforme)) {
							if(!clientesAlDia.contains(polizaAux.getCliente())) {
								clientesAlDia.add(polizaAux.getCliente());
							}
							if(fechaPago.before(fechaVencimientoCuota)) {
								if(this.diferenciaMeses(fechaPago, fechaVencimientoCuota) >= 1) {
									montoCuotasAdelantadas = (float) (montoCuotasAdelantadas + (Float.valueOf(polizaAux.getCuotas().get(0).getMontoFinal().substring(1))*0.9));
								} else {
									montoCuotasAlDia = montoCuotasAlDia + Float.valueOf(polizaAux.getCuotas().get(0).getMontoFinal().substring(1));
								}
							} else {
								montoCuotasAtrasadas = (float) (montoCuotasAtrasadas + Float.valueOf(polizaAux.getCuotas().get(0).getMontoFinal().substring(1))*1.2);
							}
						}
					}
				}
				break;
			default: //PAGO MENSUAL
				System.out.println("MENSUAL");
				Calendar fechaCuotaMensual = Calendar.getInstance();
				for(int i=0; i<polizaAux.getCuotas().size(); i++) {
					
					fechaCuotaMensual.setTime(polizaAux.getCuotas().get(i).getFechaVencimiento());
					if(fechaInforme.before(fechaCuotaMensual)) {
						System.out.println("fecha anterior");
						System.out.println("indice: "+i);
						Calendar fechaVencimientoCuotaMensual = Calendar.getInstance();
						fechaVencimientoCuotaMensual.setTime(polizaAux.getCuotas().get(i-1).getFechaVencimiento());
						
						Calendar fechaPagoMensual = Calendar.getInstance();
						fechaPagoMensual.setTime(polizaAux.getCuotas().get(i-1).getPago().getFecha());
											
							switch(polizaAux.getCuotas().get(i-1).getEstado()) {
							case IMPAGA:
								if(!clientesEnMora.contains(polizaAux.getCliente())) {
									clientesEnMora.add(polizaAux.getCliente());
								}
								montoTotalMora = montoTotalMora + Float.valueOf(polizaAux.getCuotas().get(i-1).getMontoFinal().substring(1));
								break;
							case PAGA:
								if(this.isBetween(diferenciaMeses(fechaVencimientoCuotaMensual, fechaPagoMensual), 0, 50)) { //vencimiento de la cuota es del mismo mes o anterior al pago
									switch(this.diferenciaMeses(fechaVencimientoCuotaMensual, fechaCuotaMensual)) {
									case 0:
										if(this.diferenciaDias(fechaPagoMensual, fechaVencimientoCuotaMensual) > 0) {
											montoCuotasAtrasadas = (float) (montoCuotasAtrasadas + Float.valueOf(polizaAux.getCuotas().get(i-1).getMontoFinal().substring(1))*1.2);
											
											if(!clientesEnMora.contains(polizaAux.getCliente())) {
												clientesEnMora.add(polizaAux.getCliente());
											}
										} else {
											montoCuotasAlDia = montoCuotasAlDia + Float.valueOf(polizaAux.getCuotas().get(i-1).getMontoFinal().substring(1));
											
											if(!clientesAlDia.contains(polizaAux.getCliente())) {
												clientesAlDia.add(polizaAux.getCliente());
											}
										}
										break;
									default:
										montoCuotasAdelantadas = (float) (montoCuotasAdelantadas + (Float.valueOf(polizaAux.getCuotas().get(i-1).getMontoFinal().substring(1))*0.9));
										
										if(!clientesAlDia.contains(polizaAux.getCliente())) {
											clientesAlDia.add(polizaAux.getCliente());
										}
										break;
									}
								} else {
									montoCuotasAtrasadas = (float) (montoCuotasAtrasadas + Float.valueOf(polizaAux.getCuotas().get(i-1).getMontoFinal().substring(1))*1.2);
								
									if(!clientesEnMora.contains(polizaAux.getCliente())) {
										clientesEnMora.add(polizaAux.getCliente());
									}
								}
								break;
						}
							break;
					}
				}
				break;
			}
			
		}
		
		montos.add("$"+montoTotalMora+"0");
		montos.add("$"+montoCuotasAtrasadas+"0");
		montos.add("$"+montoCuotasAdelantadas+"0");
		montos.add("$"+montoCuotasAlDia+"0");
		
		return montos;
	}*/

	public static long diferenciaDias(Calendar fecha1, Calendar fecha2) {
		long ultimo =  fecha1.getTimeInMillis();
		long primero = fecha2.getTimeInMillis();
		return TimeUnit.MILLISECONDS.toDays(ultimo - primero);
	}
	
	public int diferenciaMeses(Calendar fechaPago, Calendar fechaCuota) {
		int anios = fechaPago.get(Calendar.YEAR) - fechaCuota.get(Calendar.YEAR);
		int diferencia = (anios * 12) + (fechaPago.get(Calendar.MONTH) - fechaCuota.get(Calendar.MONTH));
		System.out.println("diferencia meses: "+diferencia);
		return diferencia;
	}
	
	public static boolean isBetween(int numero, int menor, int mayor) {
		return menor <= numero && numero <= mayor;
	}
	
	public static boolean validarNroPoliza(String nro) {
		return nro.matches("^[0-9]{13}$");
	}
}
