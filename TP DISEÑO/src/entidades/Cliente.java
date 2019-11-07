package entidades;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Cliente {
	//atributo
		int id;
		String nombre;
		String apellido;
		String dni;
		String tipoDni;
		String cuil;
		String sexo;
		Date fechaNac;
		List<Poliza> polizas;
		String estado;	
		int siniestros;
		Date fechaInicioActividad;
		
		public Cliente (int id,String nombre,String apellido, String dni,String tipoDni) {
			this.id=id;
			this.nombre=nombre;
			this.apellido=apellido;
			this.dni=dni;
			this.tipoDni=tipoDni;
			
		}
		public void actualizarEstado() {
			if(this.polizas.isEmpty()) {
				this.estado="Normal";
				return;
			}
			if(this.siniestros>0) {
				this.estado="Normal";
				return;
			}
			//for (Poliza p : polizas) {
			//	if(p.estado != "Vigente") {
					
			//	}
		//	}
				}

}
