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
}

