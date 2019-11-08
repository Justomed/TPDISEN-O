package entidades;
import java.util.Date;

public class Hijo {
	private Date fechaNacimiento;
	private String sexo;
	private String estadoCivil;
	
	public Hijo() {}
	
	public Hijo(Date fecha, String sexo, String estadoCivil) {
		this.fechaNacimiento=fecha;
		this.sexo=sexo;
		this.estadoCivil=estadoCivil;
	}
	
	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	
}
