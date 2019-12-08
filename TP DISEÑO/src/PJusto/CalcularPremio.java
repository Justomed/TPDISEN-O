package PJusto;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
	private JPanel panelAjustePago;
	private JPanel panelBoton;
	
	
public CalcularPremio() {
	
	this.setTitle("Calcular premio - descuentos");
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);
	this.setSize(500,600);
	this.setResizable(false);
	Container container = getContentPane();
	container.setLayout(new GridBagLayout());
	container.setBackground(Color.lightGray);
	GridBagConstraints constraints = new GridBagConstraints();
	
//---------------- DECLARACION DE COMPONENTES ---------------------	
	
	JTextArea tituloPremio = new JTextArea("Premio y derecho de emisión");
	JTextArea prima = new JTextArea("Prima por cobertura:                                         ");
	JTextArea ajusteDomicilio = new JTextArea("Ajuste por domicilio:                                         ");
	JTextArea ajusteEstadistica = new JTextArea("Ajuste por estadistica de robo del vehiculo:");
	JTextArea ajusteKm = new JTextArea("Ajuste por km/año:                                            ");
	JTextArea ajusteMedidas = new JTextArea("Ajuste por medidas de seguridad:                ");
	JTextArea ajusteSiniestros = new JTextArea("Ajuste por siniestros:                                       ");
	JTextArea ajusteHijos = new JTextArea("Ajuste por cantidad de hijos:                          ");
	JTextArea derecho = new JTextArea("Derecho de emisión:                                       ");
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
//----------------PANEL AJUSTE PAGO ----------------------------------
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

}
}
