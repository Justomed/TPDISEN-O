package gestores;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import entidades.AnioFabricacion;
import entidades.Cliente;
import entidades.Cuota;
import entidades.DomicilioCliente;
import entidades.Localidad;
import entidades.Marca;
import entidades.Modelo;
import entidades.Pago;
import entidades.Pais;
import entidades.Parametro;
import entidades.Poliza;
import entidades.Provincia;
import entidades.TipoCobertura;
import entidades.Vehiculo;

import java.sql.ResultSet;

public class GestorBD {
	private Connection connection;
	private DateFormat formatoInvertido = new SimpleDateFormat("yyyy-MM-dd");
	private DateFormat formatoNormal = new SimpleDateFormat("dd/MM/yy");
	public void GestorDB() {
		this.connection = null;
	}

	public Connection connectDatabase() {
		try {	
			// We register the PostgreSQL driver
			// Registramos el driver de PostgresSQL
			try { 
			    Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException ex) {
			    System.out.println("Error al registrar el driver de PostgreSQL: " + ex);
			}
			
			// Database connect
			// Conectamos con la base de datos
			connection = DriverManager.getConnection(
			        "jdbc:mysql://localhost/bd",
			        "root", "juani");
		}
		catch (java.sql.SQLException sqle) {
			System.out.println("Error al conectarse a la BD");
			System.out.println(sqle.getSQLState());
			System.out.println(sqle.getErrorCode());
			sqle.printStackTrace();
		}		
		return connection;
	}
	public void cerrarConexion() {
		try {
			this.connection.close();
		}
		catch (java.sql.SQLException sqle) {
			System.out.println("Error al cerrar la conexion de la BD");
		}
	}
	
	
	public void guardarPoliza(Poliza p) {
		connection=this.connectDatabase();
		String kmPA=p.getKmPorAnio();
		String nroS=p.getNroSiniestros();
		String nroP=p.getNroPoliza();
		String nroCliente=p.getCliente().getId();
		String patente=p.getPatente();
		
		Date auxFechaInicio;
		auxFechaInicio=p.getFechaInicioVigencia();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(auxFechaInicio);
		String fechaInicio = calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.DATE);
		
		Date auxFechaFinVigencia=p.getFechaFinVigencia();
		calendar.setTime(auxFechaFinVigencia);
		String fechaFin = calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.DATE);

	//	String sq ="INSERT INTO `bd`.`poliza` (`sumaAsegurada`, `kmPorAnio`, `numeroSiniestros`) VALUES (" +p.getSumaAsegurada()+ ',' +kmPA +','+ nroS+ ");";
		try {

			PreparedStatement insercion;
			insercion = connection.prepareStatement("INSERT INTO `bd`.`poliza` (`numeroPoliza`, `kmPorAnio`, `numeroSiniestros`,`fechaInicioVigencia`,`fechaFinVigencia`,`numCliente`,`patente`) VALUES ('"+nroP+"', '"+kmPA+"', '"+nroS+"','"+fechaInicio+"','"+fechaFin+"','"+nroCliente+"','"+patente+"');");
			/*insercion.setString(1, suma);
			insercion.setString(2, kmPA);
			insercion.setString(3, nroS);*/
			int res = insercion.executeUpdate(); //para ver si se ejecuta bien
			
			if(res>0) {
				System.out.println("se guardo registro");
			}
			
		} catch (Exception e) {
			System.out.println("no se pudo guardar poliza");
		}
		finally {
			this.cerrarConexion();
		}
		
	}
	
	public ArrayList<Cliente> recuperarCliente(String nroC, String ap, String nom, String tipoDoc, String nroDoc) {
		connection = this.connectDatabase();
		Statement stm = null;
		ResultSet rs=null;
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		String numero;
		String apellido;
		String nombre;
		String tipoDocumento;
		String documento;
		try {
			stm= connection.createStatement();
			rs=stm.executeQuery("SELECT * FROM cliente WHERE numCliente='"+nroC+ "' AND nombre='"+nom+"' AND apellido='"+ap+ "' AND tipoDocumento='"+tipoDoc+"' AND nroDni='"+nroDoc+"';");
			// AND nombre="+nom+" AND apellido="+ap+" AND nroDni="+nroDoc+" AND tipo="+tipoDoc+
			while(rs.next()) {//se va a ejecutar siempre que haya una fila por mostrar
				Cliente aux = new Cliente(); 
				numero = rs.getString(1);//traigo el valor de col 1 
				 nombre = rs.getString(2);
				 apellido = rs.getString(3);
				 documento = rs.getString(4);
				 tipoDocumento = rs.getString(5);
				 
				 aux.setId(numero);
				 aux.setNombre(nombre);
				 aux.setApellido(apellido);
				 aux.setDni(documento);
				 aux.setTipoDni(tipoDocumento);
				 aux.setDomicilio(this.recuperarDomicilioCliente(rs.getInt(10)));
				 
				 clientes.add(aux);
				 }
				  
		} catch (Exception e) {
			System.out.println("no se pudo ingresar al cliente");
		}
		finally {
			this.cerrarConexion();
		}
		
		return clientes;
	}
	
	public DomicilioCliente recuperarDomicilioCliente(int id) {
		DomicilioCliente domicilio = new DomicilioCliente();
		connection = this.connectDatabase();
		Statement stm = null;
		ResultSet rs=null;
		
		try {
			stm= connection.createStatement();
			rs=stm.executeQuery("SELECT * FROM domiciliocliente WHERE idDomicilioCliente='"+id+"';");
			while(rs.next()) {//se va a ejecutar siempre que haya una fila por mostrar
				domicilio.setCalle(rs.getString(2));
				domicilio.setNumero(rs.getInt(3));
				domicilio.setPiso(rs.getInt(4));
				domicilio.setLocalidad(this.recuperarLocalidad(rs.getInt(5)));
				 }
				  
		} catch (Exception e) {
			System.out.println("no se pudo ingresar al cliente");
		}
		finally {
			this.cerrarConexion();
		}
		
		return domicilio;
	}
	
	public Localidad recuperarLocalidad(int id) {
		Localidad aux = new Localidad();
		connection = this.connectDatabase();
		Statement stm = null;
		ResultSet rs=null;
		
		try {
			stm= connection.createStatement();
			rs=stm.executeQuery("SELECT * FROM localidad WHERE idLocalidad='"+id+"';");
			while(rs.next()) {//se va a ejecutar siempre que haya una fila por mostrar
				aux.setNombreLocalidad(rs.getString(2));
				aux.setNombreProvincia(this.recuperarProvincia(rs.getInt(3)));
				aux.setCodigoPostal(rs.getInt(4));
				 }
				  
		} catch (Exception e) {
			System.out.println("no se pudo ingresar al cliente");
		}
		finally {
			this.cerrarConexion();
		}
		
		return aux;
	}
	
	public void actualizarCuotasPagas(ArrayList<Cuota> cuotas, int idPago) {
		connection=this.connectDatabase();
		
		for(Cuota auxCuota : cuotas) {
			try {

				PreparedStatement insercion;
				insercion = connection.prepareStatement("UPDATE `bd`.`cuota` SET `idPago`='"+idPago+"' WHERE idcuota='"+auxCuota.getId()+"';");
				int res = insercion.executeUpdate(); //para ver si se ejecuta bien
				
				if(res>0) {
					System.out.println("se guardo registro");
				}
				
			} catch (Exception e) {
				System.out.println("no se pudo actualizar cuota");
			}
		}
		this.cerrarConexion();		
	}
	
	public Provincia recuperarProvincia(int id) {
		Provincia aux = new Provincia();
		connection = this.connectDatabase();
		Statement stm = null;
		ResultSet rs=null;
		
		try {
			stm= connection.createStatement();
			rs=stm.executeQuery("SELECT * FROM provincia WHERE idProvincia='"+id+"';");
			while(rs.next()) {//se va a ejecutar siempre que haya una fila por mostrar
				aux.setNombreProvincia(rs.getString(2));
				aux.setPais(this.recuperarPais(rs.getInt(3)));
				 }
				  
		} catch (Exception e) {
			System.out.println("no se pudo ingresar al cliente");
		}
		finally {
			this.cerrarConexion();
		}
		
		return aux;
	}
	
	public Pais recuperarPais(int id) {
		Pais aux = new Pais();
		connection = this.connectDatabase();
		Statement stm = null;
		ResultSet rs=null;
		
		try {
			stm= connection.createStatement();
			rs=stm.executeQuery("SELECT * FROM pais WHERE idPais='"+id+"';");
			while(rs.next()) {//se va a ejecutar siempre que haya una fila por mostrar
				aux.setNombrePais(rs.getString(2));
				 }
				  
		} catch (Exception e) {
			System.out.println("no se pudo ingresar al cliente");
		}
		finally {
			this.cerrarConexion();
		}
		
		return aux;
	}
	
	public Parametro recuperarParametro() {
		Parametro aux = new Parametro();
		float tasaRiesgo=0;
		float tasaSiniestro=0;
		float tasaSeguridad=0;
		float tasaLocalidad=0;
		float tasaHijo=0;
		float tasaKm=0;
		float tasaVehiculo=0;
		float tasaCobertura=0;
		connection = this.connectDatabase();
		Statement stm = null;
		ResultSet rs=null;
		try {
			stm= connection.createStatement();
			rs=stm.executeQuery("SELECT * FROM tasa;");
			// AND nombre="+nom+" AND apellido="+ap+" AND nroDni="+nroDoc+" AND tipo="+tipoDoc+
			while(rs.next()) {//se va a ejecutar siempre que haya una fila por mostrar
				 //int idUsuario = rs.getInt(1);//traigo el valor de col 1 
				 tasaVehiculo = rs.getFloat(2);
				 tasaKm = rs.getFloat(3);
				 tasaHijo = rs.getFloat(4);
				 tasaLocalidad = rs.getFloat(5);
				 tasaSeguridad = rs.getFloat(6);
				 tasaCobertura = rs.getFloat(7);
				 tasaSiniestro = rs.getFloat(8);
				 tasaRiesgo = rs.getFloat(9);
				 
				 // System.out.println(idUsuario+"-"+nombre); //HASTA ACA PARA
				 }
				  
		} catch (Exception e) {
			System.out.println("no se pudo ingresar a parametro");
		}
		finally {
			this.cerrarConexion();
		}
		
		aux.setTasaVehiculoActual(tasaVehiculo);
		aux.setTasaKmActual(tasaKm);
		aux.setTasaHijoActual(tasaHijo);
		aux.setTasaLocalidadActual(tasaLocalidad);
		aux.setTasaSeguridadActual(tasaSeguridad);
		aux.setTasaSiniestroActual(tasaSiniestro);
		aux.setTasaRiesgoActual(tasaRiesgo);
		aux.setTasaCoberturaActual(tasaCobertura);
		
		return aux;
	}
	
	public TipoCobertura recuperarCobertura() {
		TipoCobertura aux = new TipoCobertura();
		connection = this.connectDatabase();
		Statement stm = null;
		ResultSet rs=null;
		try {
			stm= connection.createStatement();
			rs=stm.executeQuery("SELECT * FROM tipoCobertura ");
			
			while(rs.next()) {//se va a ejecutar siempre que haya una fila por mostrar

				 String nombre = rs.getString(2);
				 String detalle = rs.getString(3);
				  
				  System.out.println(nombre+"-"+detalle); //HASTA ACA PARA
				 }
		} catch (Exception e) {
			System.out.println("no se pudo ingresar a cobertura");
		}
		finally {
			this.cerrarConexion();
		}
		return aux;
	}
	
	public Localidad recuperarLocalidad(String localidad) {
		Localidad aux = new Localidad();
		String nombre = null;
		connection = this.connectDatabase();
		Statement stm = null;
		ResultSet rs=null;
		try {
			stm= connection.createStatement();
			rs=stm.executeQuery("SELECT * FROM localidad WHERE nombreLocalidad='"+localidad+"';");
			
			while(rs.next()) {//se va a ejecutar siempre que haya una fila por mostrar

				 nombre = rs.getString(2);
				  
				  //System.out.println(nombre+"-"+detalle); //HASTA ACA PARA
				 }
		} catch (Exception e) {
			System.out.println("no se pudo ingresar a localidad");
		}
		finally {
			this.cerrarConexion();
		}
		aux.setNombreLocalidad(nombre);
	return aux;
	}
	
	public Provincia recuperarProvincia(String provincia) {
		Provincia aux = new Provincia();
		String nombre = null;
		connection = this.connectDatabase();
		Statement stm = null;
		ResultSet rs=null;
		try {
			stm= connection.createStatement();
			rs=stm.executeQuery("SELECT * FROM provincia WHERE nombreProvincia='"+provincia+"';");
			
			while(rs.next()) {//se va a ejecutar siempre que haya una fila por mostrar

				 nombre = rs.getString(2);
				  
				  //System.out.println(nombre+"-"+detalle); //HASTA ACA PARA
				 }
		} catch (Exception e) {
			System.out.println("no se pudo ingresar provincia");
		}
		finally {
			this.cerrarConexion();
		}
		aux.setNombreProvincia(nombre);
	return aux;
	}
	
	public AnioFabricacion recuperarAnioFabricacion(String anio) {
		AnioFabricacion aux = new AnioFabricacion();
		String nombre = null;
		int id = 0;
		connection = this.connectDatabase();
		Statement stm = null;
		ResultSet rs=null;
		try {
			stm= connection.createStatement();
			rs=stm.executeQuery("SELECT * FROM aniofabricacion WHERE anio='"+anio+"';");
			
			while(rs.next()) {//se va a ejecutar siempre que haya una fila por mostrar
				id = rs.getInt(1);
				 nombre = rs.getString(2);
				  
				  //System.out.println(nombre+"-"+detalle); //HASTA ACA PARA
				 }
		} catch (Exception e) {
			System.out.println("no se pudo ingresar a aniofabricacion");
		}
		finally {
			this.cerrarConexion();
		}
		aux.setAnio(nombre);
		aux.setId(id);
	return aux;
	}
	
	public ArrayList<Provincia> recuperarTodasLasProvincias(){
		connection = this.connectDatabase();
		Statement stm = null;
		ResultSet rs=null;
		ArrayList<Provincia> listaProvincias= new ArrayList<Provincia> ();
		String nombre;
		int id;
		try {
			stm= connection.createStatement();
			rs=stm.executeQuery("SELECT * FROM provincia;");
			
			while(rs.next()) {//se va a ejecutar siempre que haya una fila por mostrar
				Provincia provAux= new Provincia(); 
				id=rs.getInt(1);
				 nombre = rs.getString(2);
				 provAux.setId(id);
				 provAux.setNombreProvincia(nombre);
				 listaProvincias.add(provAux);
				  //System.out.println(nombre+"-"+detalle); //HASTA ACA PARA
				 }
		} catch (Exception e) {
			System.out.println("no se pudo ingresar a provincia");
		}
		finally {
			this.cerrarConexion();
		}
		/*for(int i=0; i<listaProvincias.size(); i++) {
			System.out.println(listaProvincias.get(i).getNombreProvincia());
			System.out.println(listaProvincias.get(i).getId());
		}*/
		
	return listaProvincias;
	}
	
	
	
	public ArrayList<Localidad> recuperarTodasLasLocalidades(int idProvincia){
		connection = this.connectDatabase();
		Statement stm = null;
		ResultSet rs=null;
		ArrayList<Localidad> listaLocalidades= new ArrayList<Localidad> ();
		
		String nombre;
		int codigoPostal;
		
		try {
			stm= connection.createStatement();
			rs=stm.executeQuery("SELECT * FROM localidad WHERE idProvincia="+idProvincia+";");
			
			while(rs.next()) {//se va a ejecutar siempre que haya una fila por mostrar
				Localidad localidadAux= new Localidad();
				 nombre = rs.getString(2);
				 codigoPostal=rs.getInt(4);
				 
				 localidadAux.setCodigoPostal(codigoPostal);
				 localidadAux.setNombreLocalidad(nombre);
				 listaLocalidades.add(localidadAux);
				  //System.out.println(nombre+"-"+detalle); //HASTA ACA PARA
				 }
		} catch (Exception e) {
			System.out.println("no se pudo ingresar a provincia");
		}
		finally {
			this.cerrarConexion();
		}
		for(int i=0; i<listaLocalidades.size(); i++) {
			System.out.println(listaLocalidades.get(i).getNombreLocalidad());
		}
	return listaLocalidades;
	}
	
	public int recuperarUltimoPago(){
		connection = this.connectDatabase();
		Statement stm = null;
		ResultSet rs=null;
		
		int idPago = 0;
		
		try {
			stm= connection.createStatement();
			rs=stm.executeQuery("SELECT MAX(idPago) FROM pago;");
			
			while(rs.next()) {//se va a ejecutar siempre que haya una fila por mostrar
				idPago = rs.getInt(1);
				  
				 }
		} catch (Exception e) {
			System.out.println("no se pudo ingresar a pago");
		}
		finally {
			this.cerrarConexion();
		}
	return idPago;
	}
	
	public void guardarPago(Pago pago) {
		connection = this.connectDatabase();
		String monto = pago.getMonto();
		
		Date auxFecha;
		auxFecha = pago.getFecha();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(auxFecha);
		String fechaPago = calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.DATE);
		
		try {
			PreparedStatement insercion;
			insercion = connection.prepareStatement("INSERT INTO `bd`.`pago` (`valor`,`fechaPago`) VALUES ('"+monto+"','"+fechaPago+"');");			
			int res = insercion.executeUpdate(); //para ver si se ejecuta bien
			if(res>0) {
				System.out.println("se guardo registro");
			}
			
		} catch (Exception e) {
			System.out.println("no se pudo guardar pago");
			System.out.println(e.getMessage());
		}
		finally {
			this.cerrarConexion();
		}
	}
	
	public void guardarVehiculo(Vehiculo vehiculo, String poliza) {
		int idSuma = this.recuperarIdSumaAsegurada(vehiculo);
		connection = this.connectDatabase();
		int modelo=vehiculo.getModelo().getId();
		try {
			PreparedStatement insercion;
			insercion = connection.prepareStatement("INSERT INTO `bd`.`vehiculo` (`idModelo`,`nroPoliza`,`idSumaAsegurada`) VALUES ('"+modelo+"','"+poliza+"','"+idSuma+"');");			
			int res = insercion.executeUpdate(); //para ver si se ejecuta bien
			if(res>0) {
				System.out.println("se guardo registro");
			}
			
		} catch (Exception e) {
			System.out.println("no se pudo guardar vehiculo");
			System.out.println(e.getMessage());
		}
		finally {
			this.cerrarConexion();
		}
	}
	
	public int recuperarIdSumaAsegurada(Vehiculo vehiculo ) {
		connection = this.connectDatabase();
		Statement stm = null;
		ResultSet rs=null;
		int idSumaAsegurada = 0;
		try {
			stm= connection.createStatement();
			rs=stm.executeQuery("SELECT * FROM sumaasegurada WHERE idmodelo='"+vehiculo.getModelo().getId()+"' AND idanio='"+vehiculo.getAnioFabricacion().getId()+"';");
			
			while(rs.next()) {//se va a ejecutar siempre que haya una fila por mostrar
				idSumaAsegurada = rs.getInt(1);
				 }
		} catch (Exception e) {
			System.out.println("no se pudo ingresar a suma asegurada");
		}
		finally {
			this.cerrarConexion();
		}
		return idSumaAsegurada;
	}
	
	public ArrayList<Marca> recuperarTodasLasMarcas(){
		connection = this.connectDatabase();
		Statement stm = null;
		ResultSet rs=null;
		ArrayList<Marca> listaMarcas= new ArrayList<Marca> ();
		String nombre;
		int id;
		
		try {
			stm= connection.createStatement();
			rs=stm.executeQuery("SELECT * FROM marca;");
			
			while(rs.next()) {//se va a ejecutar siempre que haya una fila por mostrar
				Marca marcaAux= new Marca();
				 id=rs.getInt(1);
				 nombre = rs.getString(2);
				 marcaAux.setId(id);
				 marcaAux.setMarca(nombre);
				 listaMarcas.add(marcaAux);
				  //System.out.println(nombre+"-"+detalle); //HASTA ACA PARA
				 }
		} catch (Exception e) {
			System.out.println("no se pudo ingresar a marca");
		}
		finally {
			this.cerrarConexion();
		}
	
	return listaMarcas;
	}
	
	
	
	public ArrayList<Modelo> recuperarTodasListaModelo(int idMarca){
		connection = this.connectDatabase();
		Statement stm = null;
		ResultSet rs=null;
		ArrayList<Modelo> listaModelos= new ArrayList<Modelo> ();
		
		String nombre;
		int idModelo;
		
		try {
			stm= connection.createStatement();
			rs=stm.executeQuery("SELECT * FROM modelo WHERE idMarca="+idMarca+";");
			
			while(rs.next()) {//se va a ejecutar siempre que haya una fila por mostrar
				Modelo modeloAux= new Modelo();
				 idModelo=rs.getInt(1);
				 nombre = rs.getString(2);

				 modeloAux.setId(idModelo);
				 modeloAux.setModelo(nombre);

				 listaModelos.add(modeloAux);
				  //System.out.println(nombre+"-"+detalle); //HASTA ACA PARA
				 }
		} catch (Exception e) {
			System.out.println("no se pudo ingresar a modelo");
		}
		finally {
			this.cerrarConexion();
		}

	return listaModelos;
	}
	
	
	
	
	public ArrayList<AnioFabricacion> recuperarTodosLosAnios(){
		connection = this.connectDatabase();
		Statement stm = null;
		ResultSet rs=null;
		ArrayList<AnioFabricacion> listaAnios= new ArrayList<AnioFabricacion> ();
		String anio;
		int idAnio;
		
		try {
			stm= connection.createStatement();
			rs=stm.executeQuery("SELECT * FROM aniofabricacion;");
			
			while(rs.next()) {//se va a ejecutar siempre que haya una fila por mostrar
				AnioFabricacion anioAux= new AnioFabricacion();
				 idAnio=rs.getInt(1);
				 anio = rs.getString(2);
				 
				 anioAux.setAnio(anio);
				 anioAux.setId(idAnio);
				 listaAnios.add(anioAux);
				  //System.out.println(nombre+"-"+detalle); //HASTA ACA PARA
				 }
		} catch (Exception e) {
			System.out.println("no se pudo ingresar a anio");
		}
		finally {
			this.cerrarConexion();
		}
	
	return listaAnios;
	}
	
	public String recuperarSumaAsegurada(int idModelo, int idAnio){
		connection = this.connectDatabase();
		Statement stm = null;
		ResultSet rs=null;
			
		String suma=null;
		
		try {
			stm= connection.createStatement();
			rs=stm.executeQuery("SELECT sumaasegurada FROM sumaasegurada WHERE idmodelo="+idModelo+" AND idanio="+idAnio+";");
			
			while(rs.next()) {//se va a ejecutar siempre que haya una fila por mostrar

				 suma = rs.getString(1);

				  //System.out.println(nombre+"-"+detalle); //HASTA ACA PARA
				 }
		} catch (Exception e) {
			System.out.println("no se pudo ingresar a suma asegurada");
		}
		finally {
			this.cerrarConexion();
		}
		System.out.println(suma);
	return suma;
	}	
	
	public Cliente recuperarCliente(String id) {
		Cliente aux = new Cliente();
		connection = this.connectDatabase();
		Statement stm = null;
		ResultSet rs=null;
		try {
			stm= connection.createStatement();
			rs=stm.executeQuery("SELECT * FROM cliente WHERE numCliente='"+id+"';");
			
			while(rs.next()) {//se va a ejecutar siempre que haya una fila por mostrar
				aux.setId(rs.getString(1));
				aux.setNombre(rs.getString(2));
				aux.setApellido(rs.getString(3));
				aux.setDni(rs.getString(4));
				aux.setTipoDni(rs.getString(5));
				  
				  //System.out.println(nombre+"-"+detalle); //HASTA ACA PARA
				 }
		} catch (Exception e) {
			System.out.println("no se pudo ingresar a cliente");
		}
		finally {
			this.cerrarConexion();
		}
		
	return aux;
	}
	
	public Poliza recuperarPoliza(String numeroPoliza) {
		Poliza aux = new Poliza();
		connection = this.connectDatabase();
		Statement stm = null;
		ResultSet rs=null;
		String fechaNormal;
		try {
			stm= connection.createStatement();
			rs=stm.executeQuery("SELECT * FROM poliza WHERE numeroPoliza='"+numeroPoliza+"';");
			
			while(rs.next()) {//se va a ejecutar siempre que haya una fila por mostrar
				aux.setNroPoliza(rs.getString(1));
				aux.setCliente(this.recuperarCliente(rs.getString(6)));
				aux.setCuotas(this.recuperarCuotas(rs.getString(1)));
				aux.setVehiculo(this.recuperarVehiculo(rs.getString(1)));
				
				Date fechaInvertidaInicio = formatoInvertido.parse(rs.getString(4));
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(fechaInvertidaInicio);
				
				if(calendar.get(Calendar.DATE) < 10) {
					if((calendar.get(Calendar.MONTH)+1) < 10) {
						fechaNormal = "0"+calendar.get(Calendar.DATE)+"/0"+(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.YEAR);
					} else {
						fechaNormal = "0"+calendar.get(Calendar.DATE)+"/"+(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.YEAR);
					}
				} else {
					if((calendar.get(Calendar.MONTH)+1) < 10) {
						fechaNormal = +calendar.get(Calendar.DATE)+"/0"+(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.YEAR);
					} else {
						fechaNormal = +calendar.get(Calendar.DATE)+"/"+(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.YEAR);
					}
				}
				
				aux.setFechaInicioVigencia(formatoNormal.parse(fechaNormal));
				
				Date fechaInvertidaFin = formatoInvertido.parse(rs.getString(5));
				calendar = Calendar.getInstance();
				calendar.setTime(fechaInvertidaFin);
				
				if(calendar.get(Calendar.DATE) < 10) {
					if((calendar.get(Calendar.MONTH)+1) < 10) {
						fechaNormal = "0"+calendar.get(Calendar.DATE)+"/0"+(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.YEAR);
					} else {
						fechaNormal = "0"+calendar.get(Calendar.DATE)+"/"+(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.YEAR);
					}
				} else {
					if((calendar.get(Calendar.MONTH)+1) < 10) {
						fechaNormal = +calendar.get(Calendar.DATE)+"/0"+(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.YEAR);
					} else {
						fechaNormal = +calendar.get(Calendar.DATE)+"/"+(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.YEAR);
					}
				}
				
				aux.setFechaFinVigencia(formatoNormal.parse(fechaNormal));
				aux.setPatente(rs.getString(12));
				 }
		} catch (Exception e) {
			System.out.println("no se pudo ingresar a localidad");
		}
		finally {
			this.cerrarConexion();
		}
	
	return aux;
	}
	
	public Vehiculo recuperarVehiculo(String id) {
		Vehiculo aux = new Vehiculo();
		connection = this.connectDatabase();
		Statement stm = null;
		ResultSet rs=null;
		try {
			stm= connection.createStatement();
			rs=stm.executeQuery("SELECT sumaasegurada.idmodelo,sumaasegurada.idanio FROM vehiculo,sumaasegurada WHERE nroPoliza='"+id+"' AND sumaasegurada.id=vehiculo.idSumaAsegurada;");
			
			while(rs.next()) {//se va a ejecutar siempre que haya una fila por mostrar
				aux.setModelo(this.recuperarModelo(rs.getInt(1)));
				connection = this.connectDatabase();
				aux.setAnioFabricacion(this.recuperarAnioFabricacion(rs.getInt(2)));
				connection = this.connectDatabase();
				aux.setMarca(this.recuperarMarca(rs.getInt(1)));
				 }
		} catch (Exception e) {
			System.out.println("no se pudo ingresar a cliente");
		}
		finally {
			this.cerrarConexion();
		}
		
	return aux;
	}
	
	public AnioFabricacion recuperarAnioFabricacion(int id) {
		AnioFabricacion aux = new AnioFabricacion();
		connection = this.connectDatabase();
		Statement stm = null;
		ResultSet rs=null;
		try {
			stm= connection.createStatement();
			rs=stm.executeQuery("SELECT * FROM aniofabricacion WHERE idanio='"+id+"';");
			
			while(rs.next()) {//se va a ejecutar siempre que haya una fila por mostrar
				aux.setId(rs.getInt(1));
				aux.setAnio(rs.getString(2));
				  
				  //System.out.println(nombre+"-"+detalle); //HASTA ACA PARA
				 }
		} catch (Exception e) {
			System.out.println("no se pudo ingresar a aniofabricacion");
		}
		finally {
			this.cerrarConexion();
		}
		
	return aux;
	}
	
	public Marca recuperarMarca(int idModelo) {
		Marca aux = new Marca();
		connection = this.connectDatabase();
		Statement stm = null;
		ResultSet rs=null;
		try {
			stm= connection.createStatement();
			rs=stm.executeQuery("SELECT marca.idmarca,marca.nombreMarca FROM marca,modelo WHERE modelo.idModelo='"+idModelo+"' AND marca.idmarca=modelo.idMarca;");
			
			while(rs.next()) {//se va a ejecutar siempre que haya una fila por mostrar
				aux.setId(rs.getInt(1));
				aux.setMarca(rs.getString(2));
				  
				  //System.out.println(nombre+"-"+detalle); //HASTA ACA PARA
				 }
		} catch (Exception e) {
			System.out.println("no se pudo ingresar a marca");
		}
		finally {
			this.cerrarConexion();
		}
		
	return aux;
	}
	
	public Modelo recuperarModelo(int id) {
		Modelo aux = new Modelo();
		connection = this.connectDatabase();
		Statement stm = null;
		ResultSet rs=null;
		try {
			stm= connection.createStatement();
			rs=stm.executeQuery("SELECT * FROM modelo WHERE idModelo='"+id+"';");
			
			while(rs.next()) {//se va a ejecutar siempre que haya una fila por mostrar
				aux.setId(rs.getInt(1));
				aux.setModelo(rs.getString(2));
				  
				  //System.out.println(nombre+"-"+detalle); //HASTA ACA PARA
				 }
		} catch (Exception e) {
			System.out.println("no se pudo ingresar a modelo");
		}
		finally {
			this.cerrarConexion();
		}
		
	return aux;
	}
	
	public ArrayList<Cuota> recuperarCuotas(String nroPoliza) {
		ArrayList<Cuota> aux = new ArrayList<Cuota>();
		String fechaNormal;
		connection=this.connectDatabase();
		Statement stm = null;
		ResultSet rs=null;

	//	String sq ="INSERT INTO `bd`.`poliza` (`sumaAsegurada`, `kmPorAnio`, `numeroSiniestros`) VALUES (" +p.getSumaAsegurada()+ ',' +kmPA +','+ nroS+ ");";
		try {
			stm= connection.createStatement();
			rs=stm.executeQuery("SELECT * FROM cuota WHERE numeroPoliza='"+nroPoliza+"';");
			
			while(rs.next()) {//se va a ejecutar siempre que haya una fila por mostrar
				Cuota cuotaAux = new Cuota();
				cuotaAux.setId(rs.getInt(1));
				cuotaAux.setNumeroCuota(rs.getInt(2));
				
				Date fechaInvertida = formatoInvertido.parse(rs.getString(3));
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(fechaInvertida);
				
				if(calendar.get(Calendar.DATE) < 10) {
					if((calendar.get(Calendar.MONTH)+1) < 10) {
						fechaNormal = "0"+calendar.get(Calendar.DATE)+"/0"+(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.YEAR);
					} else {
						fechaNormal = "0"+calendar.get(Calendar.DATE)+"/"+(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.YEAR);
					}
				} else {
					if((calendar.get(Calendar.MONTH)+1) < 10) {
						fechaNormal = +calendar.get(Calendar.DATE)+"/0"+(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.YEAR);
					} else {
						fechaNormal = +calendar.get(Calendar.DATE)+"/"+(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.YEAR);
					}
				}
				cuotaAux.setFechaVencimiento(formatoNormal.parse(fechaNormal));
				cuotaAux.setMontoFinal(rs.getString(4));
				cuotaAux.setPago(this.recuperarPago(rs.getInt(5)));
				
				connection=this.connectDatabase();
				
				aux.add(cuotaAux);
				 }
		} catch (Exception e) {
			System.out.println("no se pudo ingresar a cuotas");
		}
		finally {
			this.cerrarConexion();
		}
		return aux;
	}
	
	public Pago recuperarPago(int id) {
		Pago aux = new Pago();
		
		if(id != 0) {
			String fechaNormal;
			connection=this.connectDatabase();
			Statement stm = null;
			ResultSet rs=null;
			
			try {
				stm= connection.createStatement();
				rs=stm.executeQuery("SELECT * FROM pago WHERE idPago='"+id+"';");
				
				while(rs.next()) {//se va a ejecutar siempre que haya una fila por mostrar
					aux.setId(rs.getInt(1));
					aux.setMonto(rs.getString(2));
					
					Date fechaInvertida = formatoInvertido.parse(rs.getString(5));
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(fechaInvertida);
					
					if(calendar.get(Calendar.DATE) < 10) {
						if((calendar.get(Calendar.MONTH)+1) < 10) {
							fechaNormal = "0"+calendar.get(Calendar.DATE)+"/0"+(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.YEAR);
						} else {
							fechaNormal = "0"+calendar.get(Calendar.DATE)+"/"+(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.YEAR);
						}
					} else {
						if((calendar.get(Calendar.MONTH)+1) < 10) {
							fechaNormal = +calendar.get(Calendar.DATE)+"/0"+(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.YEAR);
						} else {
							fechaNormal = +calendar.get(Calendar.DATE)+"/"+(calendar.get(Calendar.MONTH)+1)+"/"+calendar.get(Calendar.YEAR);
						}
					}
					
					aux.setFecha(formatoNormal.parse(fechaNormal));
					
					 }
			} catch (Exception e) {
				System.out.println("no se pudo ingresar a pago");
			}
			finally {
				this.cerrarConexion();
			}
		}
		
		return aux;
	}
	
	public void guardarCuota(ArrayList<Cuota>  cuotas, String nroPoliza) {
		
		connection=this.connectDatabase();
		Statement stm = null;
		ResultSet rs=null;

	//	String sq ="INSERT INTO `bd`.`poliza` (`sumaAsegurada`, `kmPorAnio`, `numeroSiniestros`) VALUES (" +p.getSumaAsegurada()+ ',' +kmPA +','+ nroS+ ");";
		try {
			
			for(Cuota aux : cuotas) {
				PreparedStatement insercion;
				int nroC=aux.getNumeroCuota();
				Date fechaAux=aux.getFechaVencimiento();
				String montoFinal=aux.getMontoFinal();
				
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(fechaAux);
				String fechaFin = calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1)+"-"+calendar.get(Calendar.DATE);
				
				insercion = connection.prepareStatement("INSERT INTO `bd`.`cuota` (`nroCuota`,`fechaVencimiento`,`montoFinal`,`numeroPoliza`) VALUES ('"+nroC+"','"+fechaFin+"','"+montoFinal+"','"+nroPoliza+"');");
	
				int res = insercion.executeUpdate(); //para ver si se ejecuta bien
			
				if(res>0) {
					System.out.println("se guardo registro");
				}
			
			}
			
		} catch (Exception e) {
			System.out.println("no se pudo guardar poliza");
		}
		finally {
			this.cerrarConexion();
		}
		
	}
	
	
	
	
	
}
