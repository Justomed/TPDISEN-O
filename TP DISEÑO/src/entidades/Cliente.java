package entidades;

public class Cliente {
	//atributos
		int id;
		String nombre;
		String apellido;
		String dni;
		String tipoDni;
		String cuil;
		String sexo;
		//Date fechaNac;
		//Bool estado;
		
		public Cliente (int id,String nombre,String apellido, String dni,String tipoDni) {
			this.id=id;
			this.nombre=nombre;
			this.apellido=apellido;
			this.dni=dni;
			this.tipoDni=tipoDni;
			
		}

}
