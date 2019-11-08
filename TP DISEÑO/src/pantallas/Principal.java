package pantallas;

import entidades.Cliente;

public class Principal {
	
	public static void main (String[] args) {
		
		Cliente cliente = new Cliente();
		DarAltaPoliza frame = new DarAltaPoliza(cliente);
		frame.setVisible(true);
		
	}
	
}
