package entidades;
import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {//aca se va a cargar el controlador
	
	private static final String CONTROLADOR = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/bd";	
	private static final String USUARIO = "root";
	private static final String CLAVE = "juani";
	
	
	static {
		
        try {
            Class.forName(CONTROLADOR);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al registrar el driver de MySQL: " + ex);
        }
		
	}
	public Connection conectar() {
        Connection connection = null;
		 try {
	            // Registramos el driver de MySQL (MariaDB)


	            
	            // Conectamos con la base de datos
	            connection = DriverManager.getConnection(
	                    URL,
	                    USUARIO, CLAVE);
	            
	            boolean valid = connection.isValid(50000);
	            System.out.println(valid ? "TEST OK" : "TEST FAIL");
	        } catch (java.sql.SQLException sqle) {
	            System.out.println("Error: " + sqle);
	        }
		return connection;
		
	}
}
