package gestores;

import java.util.ArrayList;

import entidades.Cliente;

public class GestorCliente {
	
	public ArrayList<Cliente> recuperarCliente(String nroCliente, String apellido, String nombre, String tipoDoc, String documento) {
		GestorBD gestorBD = new GestorBD();
		
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		
		clientes = gestorBD.recuperarCliente(nroCliente, apellido, nombre, tipoDoc, documento);
		
		return clientes;
	}
	
	public String validarDatos(String nroCliente, String apellido, String nombre, String tipoDoc, String nroDoc) {
		String resultado = "";
		
		if(!nroCliente.equals("")) {
			if(!this.validarNroCliente(nroCliente)) {
				return "cliente";
			}
		}
		
		if(!apellido.equals("")) {
			if(!this.validarApellido(apellido)) {
				return "apellido";
			}
		}
		
		if(!nombre.equals("")) {
			if(!this.validarNombre(nombre)) {
				return "nombre";
			}
		}
		
		if(!nroDoc.equals("")) {
			switch(tipoDoc) {
			case "DNI":
				if(!this.validarDni(nroDoc)) {
					return "DNI";
				}
				break;
			case "LE":
				if(!this.validarLE(nroDoc)) {
					return "LE";
				}
				break;
			case "LC":
				if(!this.validarLC(nroDoc)) {
					return "LC";
				}
				break;
			}
		}		
		return resultado;
	}
	
	public static boolean validarNroCliente(String nro) {
		return nro.matches("^[0-9]{2}[-][0-9]{8}$");
	}
	
	public static boolean validarDni(String dni) {
		return dni.matches("^[0-9]{7,8}$");
	}
	public static boolean validarNombre(String nombre) {
		return nombre.matches("^[A-Z]{1}[a-z]{1,39}$");
	}
	public static boolean validarApellido(String apellido) {
		return apellido.matches("^[A-Z]{1}[a-z]{1,39}$");
	}
	public static boolean validarLE(String le) {
		return le.matches("^[M,F][0-9]{7}$");
	}
	public static boolean validarLC(String lc) {
		return lc.matches("^[0-9]{7}$");
	}
}

