package pantallas;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import entidades.Cliente;
import entidades.Hijo;
import entidades.Localidad;
import entidades.Marca;
import entidades.Modelo;
import entidades.Provincia;
import gestores.GestorPoliza;

public class CalcularPremio extends JFrame {
	
	private JPanel panelPremio;
	private JPanel panelPrima;
	private JPanel panelAjusteDomicilio;
	private JPanel panelAjusteEstadistica;
	private JPanel panelAjusteKm;
	private JPanel panelAjusteMedidas;
	private JPanel panelAjusteSiniestros;
	private JPanel panelAjusteHijos;
	private JPanel panelDerecho;
	private JPanel panelLinea;
	private JPanel panelTituloPoliza;
	private JPanel panelUnidades;
	private JPanel panelAjusteUnidad;
	private JPanel panelPago;
	private JPanel panelAjustePago;
	private JPanel panelBoton;
	private float premio = 0;
	private float descuento = 0;
	private float sumaAsegurada = 0;
	private int cantidadSeguridad = 0;
	private int cantidadSiniestros = 0;
	private int cantidadHijos = 0;
	private int cantidadUnidades = 0;
	
	
public CalcularPremio(Cliente cliente,
					  ArrayList<Hijo> listaHijos,
					  Marca marcaPoliza,
					  Modelo modeloPoliza,
					  String anioPoliza,
					  String motorPoliza,
					  String chasisPoliza,
					  String patentePoliza,
					  String fechaInicio,
					  String cobertura,
					  String formaPago,
					  String sumaAseguradaPoliza,
					  String kmAnio,
					  String siniestros,
					  Provincia provincia,
					  Localidad localidad,
					  ArrayList seguridad,
					  String tipoPago) {
	
	this.setTitle("Calcular premio - descuentos");
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	this.setVisible(true);
	this.setSize(450,550);
	this.setResizable(false);
	Container container = getContentPane();
	container.setLayout(new GridBagLayout());
	container.setBackground(Color.lightGray);
	GridBagConstraints constraints = new GridBagConstraints();
	
//---------------- DECLARACION DE COMPONENTES ---------------------	
	
	JTextArea tituloPremio = new JTextArea("Premio y derecho de emisión");
	JTextArea prima = new JTextArea("Prima por cobertura:                                         ");
	JTextArea ajusteDomicilio = new JTextArea("Ajuste por domicilio:                                          ");
	JTextArea ajusteEstadistica = new JTextArea("Ajuste por estadistica de robo del vehiculo:     ");
	JTextArea ajusteKm = new JTextArea("Ajuste por km/año:                                            ");
	JTextArea ajusteMedidas = new JTextArea("Ajuste por medidas de seguridad:                    ");
	JTextArea ajusteSiniestros = new JTextArea("Ajuste por siniestros:                                         ");
	JTextArea ajusteHijos = new JTextArea("Ajuste por cantidad de hijos:                             ");
	JTextArea derecho = new JTextArea("Derecho de emisión:                                         ");
	JTextArea tituloPoliza = new JTextArea("Descuentos a la póliza");
	JTextArea unidades = new JTextArea("Unidades aseguradas:                                   ");
	JTextArea ajusteUnidad = new JTextArea("Ajuste por mas de una unidad:                      ");
	JTextArea ajustePago = new JTextArea("Ajuste por pago semestral:                            ");
	JTextArea linea = new JTextArea("--------------------------------------------------------------------------");
	
	JButton calcular = new JButton("Calcular");

	JFormattedTextField primaTxt =new JFormattedTextField("_ _, _ _%");
	JFormattedTextField ajusteDomicilioTxt =new JFormattedTextField("_ _, _ _%");
	JFormattedTextField ajusteEstadisticaTxt =new JFormattedTextField("_ _, _ _%");
	JFormattedTextField ajusteKmTxt =new JFormattedTextField("_ _, _ _%");
	JFormattedTextField ajusteMedidasTxt =new JFormattedTextField("_ _, _ _%");
	JFormattedTextField ajusteSiniestrosTxt =new JFormattedTextField("_ _, _ _%");
	JFormattedTextField ajusteHijosTxt =new JFormattedTextField("_ _, _ _%");
	JFormattedTextField derechoTxt =new JFormattedTextField("_ _, _ _%");
	JTextField unidadesTxt =new JTextField();
	JFormattedTextField ajusteUnidadTxt =new JFormattedTextField("_ _, _ _%");
	JFormattedTextField ajustePagoTxt =new JFormattedTextField("_ _, _ _%");
	
	
	linea.setBackground(Color.lightGray);
	tituloPremio.setBackground(Color.lightGray);
	tituloPremio.setFont(new Font("Dialog", Font.BOLD, 15));
	prima.setBackground(Color.lightGray);	
	ajusteDomicilio.setBackground(Color.lightGray);
	ajusteEstadistica.setBackground(Color.lightGray);
	ajusteKm.setBackground(Color.lightGray);
	ajusteMedidas.setBackground(Color.lightGray);
	ajusteSiniestros.setBackground(Color.lightGray);
	ajusteHijos.setBackground(Color.lightGray);
	derecho.setBackground(Color.lightGray);
	tituloPoliza.setBackground(Color.lightGray);
	tituloPoliza.setFont(new Font("Dialog", Font.BOLD, 15));
	unidades.setBackground(Color.lightGray);
	ajusteUnidad.setBackground(Color.lightGray);
	ajustePago.setBackground(Color.lightGray);
	
	primaTxt.setEnabled(false);
	ajusteDomicilioTxt.setEnabled(false);
	ajusteEstadisticaTxt.setEnabled(false);
	ajusteKmTxt.setEnabled(false);
	ajusteMedidasTxt.setEnabled(false);
	ajusteSiniestrosTxt.setEnabled(false);
	ajusteHijosTxt.setEnabled(false);
	ajustePagoTxt.setEnabled(false);
	derechoTxt.setEnabled(false);
	unidadesTxt.setEnabled(false);
	ajusteUnidadTxt.setEnabled(false);
	ajustePagoTxt.setEnabled(false);	
	
//----------------PANEL PREMIO ----------------------------------
	panelPremio = new JPanel();
	panelPremio.setBackground(Color.lightGray);
	panelPremio.setVisible(true);
	panelPremio.setLayout(new FlowLayout());
	panelPremio.add(tituloPremio);
	constraints.anchor = GridBagConstraints.CENTER;
	constraints.gridx = 0;
	constraints.gridy = 1;
	constraints.gridy = 2;
	container.add(panelPremio, constraints);
//----------------PANEL PRIMA ----------------------------------
	panelPrima = new JPanel();
	panelPrima.setBackground(Color.lightGray);
	panelPrima.setVisible(true);
	panelPrima.setLayout(new FlowLayout());
	panelPrima.add(prima);
	panelPrima.add(primaTxt);
	constraints.anchor = GridBagConstraints.WEST;
	constraints.gridx = 0;
	constraints.gridy = 1;
	constraints.gridy = 3;
	container.add(panelPrima, constraints);
//----------------PANEL AJUSTE DOMICILIO ----------------------------------
	panelAjusteDomicilio = new JPanel();
	panelAjusteDomicilio.setBackground(Color.lightGray);
	panelAjusteDomicilio.setVisible(true);
	panelAjusteDomicilio.setLayout(new FlowLayout());
	panelAjusteDomicilio.add(ajusteDomicilio);
	panelAjusteDomicilio.add(ajusteDomicilioTxt);
	constraints.anchor = GridBagConstraints.WEST;
	constraints.gridx = 0;
	constraints.gridy = 1;
	constraints.gridy = 4;
	container.add(panelAjusteDomicilio, constraints);	
//----------------PANEL AJUSTE ESTADISTICA ----------------------------------
	panelAjusteEstadistica = new JPanel();
	panelAjusteEstadistica.setBackground(Color.lightGray);
	panelAjusteEstadistica.setVisible(true);
	panelAjusteEstadistica.setLayout(new FlowLayout());
	panelAjusteEstadistica.add(ajusteEstadistica);
	panelAjusteEstadistica.add(ajusteEstadisticaTxt);
	constraints.anchor = GridBagConstraints.WEST;
	constraints.gridx = 0;
	constraints.gridy = 1;
	constraints.gridy = 5;
	container.add(panelAjusteEstadistica, constraints);
//----------------PANEL AJUSTE KM ----------------------------------
	panelAjusteKm = new JPanel();
	panelAjusteKm.setBackground(Color.lightGray);
	panelAjusteKm.setVisible(true);
	panelAjusteKm.setLayout(new FlowLayout());
	panelAjusteKm.add(ajusteKm);
	panelAjusteKm.add(ajusteKmTxt);
	constraints.anchor = GridBagConstraints.WEST;
	constraints.gridx = 0;
	constraints.gridy = 1;
	constraints.gridy = 6;
	container.add(panelAjusteKm, constraints);
//----------------PANEL MEDIDAS ----------------------------------
	panelAjusteMedidas = new JPanel();
	panelAjusteMedidas.setBackground(Color.lightGray);
    panelAjusteMedidas.setVisible(true);
	panelAjusteMedidas.setLayout(new FlowLayout());
	panelAjusteMedidas.add(ajusteMedidas);
	panelAjusteMedidas.add(ajusteMedidasTxt);
	constraints.anchor = GridBagConstraints.WEST;
	constraints.gridx = 0;
	constraints.gridy = 1;
	constraints.gridy = 7;
	container.add(panelAjusteMedidas, constraints);
//----------------PANEL SINIESTROS ----------------------------------
	panelAjusteSiniestros = new JPanel();
	panelAjusteSiniestros.setBackground(Color.lightGray);
    panelAjusteSiniestros.setVisible(true);
	panelAjusteSiniestros.setLayout(new FlowLayout());
	panelAjusteSiniestros.add(ajusteSiniestros);
	panelAjusteSiniestros.add(ajusteSiniestrosTxt);
	constraints.anchor = GridBagConstraints.WEST;
	constraints.gridx = 0;
	constraints.gridy = 1;
	constraints.gridy = 8;
	container.add(panelAjusteSiniestros, constraints);
//----------------PANEL HIJOS ----------------------------------
	panelAjusteHijos = new JPanel();
	panelAjusteHijos.setBackground(Color.lightGray);
    panelAjusteHijos.setVisible(true);
	panelAjusteHijos.setLayout(new FlowLayout());
	panelAjusteHijos.add(ajusteHijos);
	panelAjusteHijos.add(ajusteHijosTxt);
	constraints.anchor = GridBagConstraints.WEST;
	constraints.gridx = 0;
	constraints.gridy = 1;
	constraints.gridy = 9;
	container.add(panelAjusteHijos, constraints);
//----------------PANEL DERECHO ----------------------------------
	panelDerecho = new JPanel();
	panelDerecho.setBackground(Color.lightGray);
    panelDerecho.setVisible(true);
	panelDerecho.setLayout(new FlowLayout());
	panelDerecho.add(derecho);
	panelDerecho.add(derechoTxt);
	constraints.anchor = GridBagConstraints.WEST;
	constraints.gridx = 0;
	constraints.gridy = 1;
	constraints.gridy = 10;
	container.add(panelDerecho, constraints);
//----------------PANEL LINEA ----------------------------------	
	panelLinea = new JPanel();
	panelLinea.setBackground(Color.lightGray);
    panelLinea.setVisible(true);
	panelLinea.setLayout(new FlowLayout());
	panelLinea.add(linea);
	constraints.anchor = GridBagConstraints.CENTER;
	constraints.gridx = 0;
	constraints.gridy = 1;
	constraints.gridy = 11;
	container.add(panelLinea, constraints);
//----------------PANEL TITULO POLIZA ----------------------------------
	panelTituloPoliza = new JPanel();
	panelTituloPoliza.setBackground(Color.lightGray);
    panelTituloPoliza.setVisible(true);
	panelTituloPoliza.setLayout(new FlowLayout());
	panelTituloPoliza.add(tituloPoliza);
	constraints.anchor = GridBagConstraints.CENTER;
	constraints.gridx = 0;
	constraints.gridy = 1;
	constraints.gridy = 12;
	container.add(panelTituloPoliza, constraints);

//----------------PANEL UNIDADES ----------------------------------
	panelUnidades = new JPanel();
	panelUnidades.setBackground(Color.lightGray);
    panelUnidades.setVisible(true);
	panelUnidades.setLayout(new FlowLayout());
	panelUnidades.add(unidades);
	panelUnidades.add(unidadesTxt);
	unidadesTxt.setColumns(5);
	constraints.anchor = GridBagConstraints.WEST;
	constraints.gridx = 0;
	constraints.gridy = 1;
	constraints.gridy = 13;
	container.add(panelUnidades, constraints);
//----------------PANEL AJUSTE UNIDAD ----------------------------------
	panelAjusteUnidad = new JPanel();
	panelAjusteUnidad.setBackground(Color.lightGray);
    panelAjusteUnidad.setVisible(true);
	panelAjusteUnidad.setLayout(new FlowLayout());
	panelAjusteUnidad.add(ajusteUnidad);
	panelAjusteUnidad.add(ajusteUnidadTxt);
	unidadesTxt.setColumns(5);
	constraints.anchor = GridBagConstraints.WEST;
	constraints.gridx = 0;
	constraints.gridy = 1;
	constraints.gridy = 14;
	container.add(panelAjusteUnidad, constraints);
//----------------PANEL AJUSTE PAGO ----------------------------------
	panelAjustePago = new JPanel();
	panelAjustePago.setBackground(Color.lightGray);
    panelAjustePago.setVisible(true);
	panelAjustePago.setLayout(new FlowLayout());
	panelAjustePago.add(ajustePago);
	panelAjustePago.add(ajustePagoTxt);
	constraints.anchor = GridBagConstraints.WEST;
	constraints.gridx = 0;
	constraints.gridy = 1;
	constraints.gridy = 15;
	container.add(panelAjustePago, constraints);
//----------------PANEL BOTON ----------------------------------
	panelBoton = new JPanel();
	panelBoton.setBackground(Color.lightGray);
    panelBoton.setVisible(true);
	panelBoton.setLayout(new FlowLayout());
	panelBoton.add(calcular);
	constraints.anchor = GridBagConstraints.CENTER;
	constraints.gridx = 0;
	constraints.gridy = 1;
	constraints.gridy = 16;
	container.add(panelBoton, constraints);
//---------------------FUNCIONAMIENTO PANTALLA-------------------------
	GestorPoliza gestorPoliza = new GestorPoliza();
	cantidadUnidades = gestorPoliza.recuperarUnidadesAseguradas(cliente.getId());
	
	switch(siniestros) {
	case "NINGUNO":
		break;
	case "UNO":
		cantidadSiniestros = 2;
		break;
	case "DOS":
		cantidadSiniestros = 4;
		break;
	default:
		cantidadSiniestros = 6;
		break;
	}
	
	for(int i=0; i<seguridad.size(); i++) {
		if(seguridad.get(i).equals(1)) {
			cantidadSeguridad += 2;
		}
	}
	
	for(Hijo aux : listaHijos) {
		cantidadHijos += 2;
	}
	
	switch(cobertura) {
	case "RESPONSABILIDAD CIVIL":
		sumaAsegurada = (float) (Float.valueOf(sumaAseguradaPoliza.substring(1))*0.01);
		break;
	case "RESPONSABILIDAD CIVIL, ROBO, INCENDIO TOTAL":
		sumaAsegurada = (float) (Float.valueOf(sumaAseguradaPoliza.substring(1))*0.02);
		break;
	case "TODO TOTAL":
		sumaAsegurada = (float) (Float.valueOf(sumaAseguradaPoliza.substring(1))*0.04);
		break;
	case "TERCEROS COMPLETOS":
		sumaAsegurada = (float) (Float.valueOf(sumaAseguradaPoliza.substring(1))*0.03);
		break;
	case "TODO RIESGO CON FRANQUICIA":
		sumaAsegurada = (float) (Float.valueOf(sumaAseguradaPoliza.substring(1))*0.05);
		break;
	}
	
	primaTxt.setText("$"+sumaAsegurada+"0");
	ajusteDomicilioTxt.setText("5%");
	ajusteEstadisticaTxt.setText("5%");
	ajusteKmTxt.setText("2%");
	ajusteMedidasTxt.setText(cantidadSeguridad+"%");
	ajusteSiniestrosTxt.setText(cantidadSiniestros+"%");
	ajusteHijosTxt.setText(cantidadHijos+"%");
	derechoTxt.setText("3%");
	unidadesTxt.setText(String.valueOf(cantidadUnidades));
	ajusteUnidadTxt.setText(String.valueOf(cantidadUnidades*5)+"%");
	
	switch(tipoPago) {
	case "mensual":
		ajustePagoTxt.setText("----");
		break;
	case "semestral":
		ajustePagoTxt.setText("20%");
		break;
	}
	
	calcular.addActionListener(e -> {
		float cantidadSeguridadPorcentaje = sumaAsegurada * (cantidadSeguridad/100);
		float cantidadSiniestrosPorcentaje = sumaAsegurada * (cantidadSiniestros/100);
		float cantidadHijosPorcentaje = sumaAsegurada * (cantidadHijos/100);
		float domicilioPorcentaje = (float) (sumaAsegurada * 0.05);
		float estadisticaPorcentaje = (float) (sumaAsegurada *0.05);
		float kmPorcentaje = (float) (sumaAsegurada * 0.02);
		float derechoPorcentaje = (float) (sumaAsegurada * 0.03);
		
		switch(cantidadSeguridad) {
		case 0:
			switch(cantidadSiniestros) {
			case 0:
				switch(cantidadHijos) {
				case 0:
					premio = sumaAsegurada + domicilioPorcentaje + estadisticaPorcentaje + kmPorcentaje + derechoPorcentaje;
					break;
				default:
					premio = sumaAsegurada + domicilioPorcentaje + estadisticaPorcentaje + kmPorcentaje + derechoPorcentaje + cantidadHijosPorcentaje;
					break;
				}
				break;
			default:
				switch(cantidadHijos) {
				case 0:
					premio = sumaAsegurada + domicilioPorcentaje + estadisticaPorcentaje + kmPorcentaje + derechoPorcentaje + cantidadSiniestrosPorcentaje;
					break;
				default:
					premio = sumaAsegurada + domicilioPorcentaje + estadisticaPorcentaje + kmPorcentaje + derechoPorcentaje + cantidadHijosPorcentaje + cantidadSiniestrosPorcentaje;
					break;
				}
				break;
			}
			break;
		default:
			switch(cantidadSiniestros) {
			case 0:
				switch(cantidadHijos) {
				case 0:
					premio = sumaAsegurada + domicilioPorcentaje + estadisticaPorcentaje + kmPorcentaje + derechoPorcentaje + cantidadSeguridadPorcentaje;
					break;
				default:
					premio = sumaAsegurada + domicilioPorcentaje + estadisticaPorcentaje + kmPorcentaje + derechoPorcentaje + cantidadHijosPorcentaje + cantidadSeguridadPorcentaje;
					break;
				}
				break;
			default:
				switch(cantidadHijos) {
				case 0:
					premio = sumaAsegurada + domicilioPorcentaje + estadisticaPorcentaje + kmPorcentaje + derechoPorcentaje + cantidadSiniestrosPorcentaje + cantidadSeguridadPorcentaje;
					break;
				default:
					premio = sumaAsegurada + domicilioPorcentaje + estadisticaPorcentaje + kmPorcentaje + derechoPorcentaje + cantidadHijosPorcentaje + cantidadSiniestrosPorcentaje + cantidadSeguridadPorcentaje;
					break;
				}
			break;
			}
		}	
		
		
		switch(tipoPago) {
		case "mensual":
			if(cantidadUnidades > 0) {
				descuento = (float) (sumaAsegurada * (cantidadUnidades*0.05));
			}
			break;
		case "semestral":
			if(cantidadUnidades > 0) {
				descuento = (float) ((sumaAsegurada * (cantidadUnidades*0.05)) + (sumaAsegurada * 0.2));
			} else {
				descuento = (float) (sumaAsegurada *  0.2);
			}
			break;
		}
		
		new ConfirmarPremio(cliente,
				 			listaHijos,
				 			marcaPoliza,
				 			modeloPoliza,
				 			anioPoliza,
				 			motorPoliza,
				 			chasisPoliza,
				 			patentePoliza,
				 			fechaInicio,
				 			cobertura,
				 			formaPago,
				 			sumaAseguradaPoliza,
				 			kmAnio,
				 			siniestros,
				 			provincia,
				 			localidad,
				 			seguridad,
				 			premio,
				 			descuento,
				 			tipoPago);
		this.dispose();
	});	
	}
}
