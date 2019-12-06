package gestores;

import java.util.ArrayList;
import java.util.Date;

import entidades.Cuota;
import entidades.Pago;

public class GestorPago {
	
	public GestorPago() {
		
	}

	public void guardarPago(ArrayList<Cuota> cuotas, float montoTotal) {
		Pago pago = new Pago();
		pago.setMonto("$"+montoTotal+"0");
		pago.setFecha(new Date());
		
		GestorBD gestorBD = new GestorBD();
		gestorBD.guardarPago(pago);
		int idPago = gestorBD.recuperarUltimoPago();
		
		GestorPoliza gestorPoliza = new GestorPoliza();
		gestorPoliza.pagarCuotas(cuotas, idPago);
	}
	
}
