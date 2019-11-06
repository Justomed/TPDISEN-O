package gestores;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
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
		float suma=p.getSumaAsegurada();
		String kmPA=p.getKmPorAnio();
		String nroS=p.getNroSiniestros();
	//	String sq ="INSERT INTO `bd`.`poliza` (`sumaAsegurada`, `kmPorAnio`, `numeroSiniestros`) VALUES (" +p.getSumaAsegurada()+ ',' +kmPA +','+ nroS+ ");";
		try {

			PreparedStatement insercion;
			insercion = connection.prepareStatement("INSERT INTO `bd`.`poliza` (`sumaAsegurada`, `kmPorAnio`, `numeroSiniestros`) VALUES (?,?,?)");
			insercion.setFloat(1, suma);
			insercion.setString(2, kmPA);
			insercion.setString(3, nroS);
			int res = insercion.executeUpdate(); //para ver si se ejecuta bien
			
			if(res>0) {
				System.out.println("se guardo registro");
			}
			
		} catch (Exception e) {

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
			System.out.println("no se pudo ingresar");
		}
		finally {
			this.cerrarConexion();
		}
		
		
	}
	
	public void recuperarCobertura(int id) {
		connection = this.connectDatabase();
		Statement stm = null;
		ResultSet rs=null;
		try {
			stm= connection.createStatement();
			rs=stm.executeQuery("SELECT * FROM tipoCobertura WHERE idTipoCobertura="+id);
			
			while(rs.next()) {//se va a ejecutar siempre que haya una fila por mostrar

				 String nombre = rs.getString(2);
				 String detalle = rs.getString(3);
				  
				  System.out.println(nombre+"-"+detalle); //HASTA ACA PARA
				 }
		} catch (Exception e) {
			System.out.println("no se pudo ingresar");
		}
		finally {
			this.cerrarConexion();
		}
	}
	
	
	
}
