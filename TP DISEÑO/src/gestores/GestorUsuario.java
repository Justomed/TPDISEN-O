package gestores;

import entidades.Usuario;

public class GestorUsuario {

	public GestorUsuario() {
		
	}
	
	public Usuario recuperarUsuario(String usuario) {
		Usuario aux = new Usuario();
		GestorBD gestorBD = new GestorBD();
		
		aux = gestorBD.recuperarUsuario(usuario);
		
		return aux;
	}
	
}
