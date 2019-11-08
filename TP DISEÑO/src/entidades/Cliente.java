package entidades;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Cliente {
	//atributo
		private String id;
		private String nombre;
		private String apellido;
		private String dni;
		private String tipoDni;
		private String cuil;
		private String sexo;
		private Date fechaNac;
		private List<Poliza> polizas;
		private String estado;	
		private int siniestros;
		private Date fechaInicioActividad;
		private DomicilioCliente domicilio;
		
		public Cliente (String id,String nombre,String apellido, String dni,String tipoDni) {
			this.id=id;
			this.nombre=nombre;
			this.apellido=apellido;
			this.dni=dni;
			this.tipoDni=tipoDni;
			
		}
		
		public DomicilioCliente getDomicilio() {
			return domicilio;
		}

		public void setDomicilio(DomicilioCliente domicilio) {
			this.domicilio = domicilio;
		}

		public Cliente() {
			this.domicilio=new DomicilioCliente();
		}
		
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public String getDni() {
			return dni;
		}

		public void setDni(String dni) {
			this.dni = dni;
		}

		public String getTipoDni() {
			return tipoDni;
		}

		public void setTipoDni(String tipoDni) {
			this.tipoDni = tipoDni;
		}

		public String getCuil() {
			return cuil;
		}

		public void setCuil(String cuil) {
			this.cuil = cuil;
		}

		public String getSexo() {
			return sexo;
		}

		public void setSexo(String sexo) {
			this.sexo = sexo;
		}

		public Date getFechaNac() {
			return fechaNac;
		}

		public void setFechaNac(Date fechaNac) {
			this.fechaNac = fechaNac;
		}

		public List<Poliza> getPolizas() {
			return polizas;
		}

		public void setPolizas(List<Poliza> polizas) {
			this.polizas = polizas;
		}

		public String getEstado() {
			return estado;
		}

		public void setEstado(String estado) {
			this.estado = estado;
		}

		public int getSiniestros() {
			return siniestros;
		}

		public void setSiniestros(int siniestros) {
			this.siniestros = siniestros;
		}

		public Date getFechaInicioActividad() {
			return fechaInicioActividad;
		}

		public void setFechaInicioActividad(Date fechaInicioActividad) {
			this.fechaInicioActividad = fechaInicioActividad;
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
