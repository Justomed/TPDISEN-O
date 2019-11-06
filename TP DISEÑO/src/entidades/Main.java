package entidades;
import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement;


public class Main {
	
public static void main(String[] args) {
	GestorBD c = new GestorBD();
	Connection cn = null;
	ResultSet rs=null;
	Statement stm = null;
	 try {
		 cn= c.connectDatabase();
		  stm= cn.createStatement();
		  rs=stm.executeQuery("SELECT * FROM cliente");
		  while(rs.next()) {//se va a ejecutar siempre que haya una fila por mostrar
		  		int idUsuario = rs.getInt(1);//traigo el valor de col 1
				String nombre = rs.getString(2);
			
				System.out.println(idUsuario+"-"+nombre);
				//HASTA ACA PARA MOSTRAR------------------------------------
		  		}

	 	} catch (SQLException e) {
			  System.out.println("no se pudo acceder a clientes");
	 			}
	 finally {
		 		c.cerrarConexion();
	 			}

	}

	

}
	

