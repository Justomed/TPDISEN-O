package gestores;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Date;

import entidades.AnioFabricacion;
import entidades.Localidad;
import entidades.Parametro;
import entidades.Poliza;
import entidades.Provincia;
import entidades.TipoCobertura;

import java.sql.ResultSet;

public class GestorBD {
	private Connection connection;
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
		String suma=p.getSumaAsegurada();
		String kmPA=p.getKmPorAnio();
		String nroS=p.getNroSiniestros();
	//	String sq ="INSERT INTO `bd`.`poliza` (`sumaAsegurada`, `kmPorAnio`, `numeroSiniestros`) VALUES (" +p.getSumaAsegurada()+ ',' +kmPA +','+ nroS+ ");";
		try {

			PreparedStatement insercion;
			insercion = connection.prepareStatement("INSERT INTO `bd`.`poliza` (`sumaAsegurada`, `kmPorAnio`, `numeroSiniestros`) VALUES (' "+suma+" ', ' "+kmPA+" ', ' "+nroS+" ');");
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
	
	public void recuperarCliente(int nroC, String ap, String nom, String tipoDoc, String nroDoc) {
		connection = this.connectDatabase();
		Statement stm = null;
		ResultSet rs=null;
		try {
			stm= connection.createStatement();
			rs=stm.executeQuery("SELECT * FROM cliente WHERE numCliente="+nroC+ " AND nombre='"+nom+"' AND apellido='"+ap+ "' AND tipoDocumento='"+tipoDoc+"' AND nroDni='"+nroDoc+"';");
			// AND nombre="+nom+" AND apellido="+ap+" AND nroDni="+nroDoc+" AND tipo="+tipoDoc+
			while(rs.next()) {//se va a ejecutar siempre que haya una fila por mostrar
				 int idUsuario = rs.getInt(1);//traigo el valor de col 1 
				 String nombre = rs.getString(2);
				  
				  System.out.println(idUsuario+"-"+nombre); //HASTA ACA PARA
				 }
				  
		} catch (Exception e) {
			System.out.println("no se pudo ingresar al cliente");
		}
		finally {
			this.cerrarConexion();
		}
		
		
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
		connection = this.connectDatabase();
		Statement stm = null;
		ResultSet rs=null;
		try {
			stm= connection.createStatement();
			rs=stm.executeQuery("SELECT * FROM aniofabricacion WHERE anio='"+anio+"';");
			
			while(rs.next()) {//se va a ejecutar siempre que haya una fila por mostrar

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
	return aux;
	}
}
