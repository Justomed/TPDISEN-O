package pantallas;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entidades.Cliente;
import entidades.Cuota;
import entidades.Hijo;
import entidades.Marca;
import entidades.Modelo;
import entidades.Poliza;
import gestores.GestorPoliza;

public class PolizaGenerarSemestral extends JFrame{
	
	private JPanel panelTitular;
	private JPanel panelApellido;
	private JPanel panelDatos;
	private JPanel panelMarca;
	private JPanel panelVigencia;
	private JPanel panelInicio;
	private JPanel panelSuma;
	private JPanel panelImporte;
	private JPanel panelUltimo;
	private JPanel panelBotones;
	private JPanel panelBotonDetalle;
	private JPanel panelBotonCuota;
	private JPanel panelTablaDescuento;
	private JPanel panelTablaCuotas;
	private JPanel panelBlanco;
	private JPanel panelBlanco1;
	private JFrame frame=this;
	private JTable tablaDescuentos;
	private JTable tablaCuotas;
	private DateFormat formato = new SimpleDateFormat("dd/MM/yy");
	
	public PolizaGenerarSemestral(Cliente cliente,
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
						 String provincia,
						 String localidad,
						 ArrayList<Boolean> seguridad) {
		
		this.setTitle("Poliza a generar");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setSize(780,430);
		this.setResizable(false);
		Container container = getContentPane();
		container.setLayout(new GridBagLayout());
		container.setBackground(Color.lightGray);
		GridBagConstraints constraints = new GridBagConstraints();
			
		JTextField apellidoTxt = new JTextField();
		JTextField nombreTxt = new JTextField();
		JTextField marcaTxt = new JTextField();
		JTextField modeloTxt = new JTextField();
		JTextField motorTxt = new JTextField();
		JTextField chasisTxt = new JTextField();
		JTextField patenteTxt = new JTextField();
		JTextField inicioTxt = new JTextField();
		JTextField finTxt = new JTextField();
		JTextField sumaAseguradaTxt = new JTextField();
		JTextField premioTxt = new JTextField();
		JTextField importeDescuentoTxt = new JTextField();
		JTextField diaPagoTxt = new JTextField();
		JTextField montoTotalTxt = new JTextField();
		
		Date finVigencia = null;
		Date ultimoPago = null;
		try {
			finVigencia = formato.parse(fechaInicio);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(finVigencia);
		calendar.add(Calendar.DAY_OF_YEAR, -1);
		ultimoPago = calendar.getTime();
		
		calendar.setTime(finVigencia);
		calendar.add(Calendar.MONTH, 6);
		finVigencia = calendar.getTime();
		Date auxFechaFinVigencia = finVigencia;
		
		apellidoTxt.setText(cliente.getApellido());
		nombreTxt.setText(cliente.getNombre());
		marcaTxt.setText(marcaPoliza.getMarca());
		modeloTxt.setText(modeloPoliza.getModelo());
		motorTxt.setText(motorPoliza);
		chasisTxt.setText(chasisPoliza);
		patenteTxt.setText(patentePoliza);
		inicioTxt.setText(fechaInicio);
		finTxt.setText(formato.format(auxFechaFinVigencia));
		sumaAseguradaTxt.setText(sumaAseguradaPoliza);
		premioTxt.setText("$6600.00");
		importeDescuentoTxt.setText("$600.00");
		diaPagoTxt.setText(formato.format(ultimoPago));
		montoTotalTxt.setText("$6000.00");
		
		apellidoTxt.setEnabled(false);
		nombreTxt.setEnabled(false);
		marcaTxt.setEnabled(false);
		modeloTxt.setEnabled(false);
		motorTxt.setEnabled(false);
		chasisTxt.setEnabled(false);
		patenteTxt.setEnabled(false);
		inicioTxt.setEnabled(false);
		finTxt.setEnabled(false);
		sumaAseguradaTxt.setEnabled(false);
		premioTxt.setEnabled(false);
		importeDescuentoTxt.setEnabled(false);
		diaPagoTxt.setEnabled(false);
		montoTotalTxt.setEnabled(false);
		
		JTextArea apellido = new JTextArea("Apellido:");
		JTextArea nombre = new JTextArea("Nombre:");
		JTextArea marca = new JTextArea("Marca:");
		JTextArea modelo = new JTextArea("Modelo:");
		JTextArea motor = new JTextArea("Motor:");
		JTextArea chasis = new JTextArea("Chasis:");
		JTextArea patente = new JTextArea("Patente:");
		JTextArea inicio = new JTextArea("Inicio:");
		JTextArea fin = new JTextArea("Fin:");
		JTextArea sumaAsegurada = new JTextArea("Suma asegurada:");
		JTextArea premio = new JTextArea("Premio:");
		JTextArea importeDescuento = new JTextArea("Importe por descuentos:");
		JTextArea diaPago = new JTextArea("Ultimo dia de pago:");
		JTextArea montoTotal = new JTextArea("Monto total a abonar:");
		
		JTextArea titular = new JTextArea("Titular del seguro:");
		JTextArea datosVehiculo = new JTextArea("Datos del vehiculo:");
		JTextArea vigencia = new JTextArea("Vigencia:");
		
		apellido.setBackground(Color.lightGray);
		nombre.setBackground(Color.lightGray);
		marca.setBackground(Color.lightGray);
		modelo.setBackground(Color.lightGray);
		motor.setBackground(Color.lightGray);
		chasis.setBackground(Color.lightGray);
		patente.setBackground(Color.lightGray);
		titular.setBackground(Color.lightGray);
		datosVehiculo.setBackground(Color.lightGray);
		vigencia.setBackground(Color.lightGray);
		inicio.setBackground(Color.lightGray);
		fin.setBackground(Color.lightGray);
		sumaAsegurada.setBackground(Color.lightGray);
		premio.setBackground(Color.lightGray);
		importeDescuento.setBackground(Color.lightGray);
		diaPago.setBackground(Color.lightGray);
		montoTotal.setBackground(Color.lightGray);
		
		JButton emisionPoliza = new JButton("Realizar emision de poliza");
		JButton cancelar = new JButton("Cancelar");
		JButton detalle = new JButton("Detalle de descuentos");

		panelBlanco = new JPanel();
		panelBlanco.setBackground(Color.lightGray);
		
//----------------PANEL TITULAR ------------------------------------		
		panelTitular = new JPanel();
		panelTitular.setBackground(Color.lightGray);
		panelTitular.setVisible(true);
		panelTitular.setLayout(new FlowLayout());
		panelTitular.add(titular);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 2;
		container.add(panelTitular, constraints);
//----------------PANEL APELLIDO ------------------------------------		
		panelApellido = new JPanel();
		panelApellido.setBackground(Color.lightGray);
		panelApellido.setVisible(true);
		panelApellido.setLayout(new FlowLayout());
		panelApellido.add(apellido);
		panelApellido.add(apellidoTxt);
		apellidoTxt.setColumns(10);
		panelApellido.add(nombre);
		panelApellido.add(nombreTxt);
		nombreTxt.setColumns(10);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 3;
		container.add(panelApellido, constraints);
//----------------PANEL DATOS ------------------------------------		
		panelDatos = new JPanel();
		panelDatos.setBackground(Color.lightGray);
		panelDatos.setVisible(true);
		panelDatos.setLayout(new FlowLayout());
		panelDatos.add(datosVehiculo);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 4;
		container.add(panelDatos, constraints);
//----------------PANEL MARCA ------------------------------------		
		panelMarca = new JPanel();
		panelMarca.setBackground(Color.lightGray);
		panelMarca.setVisible(true);
		panelMarca.setLayout(new FlowLayout());
		panelMarca.add(marca);
		panelMarca.add(marcaTxt);
		marcaTxt.setColumns(10);
		panelMarca.add(modelo);
		panelMarca.add(modeloTxt);
		modeloTxt.setColumns(10);
		panelMarca.add(motor);
		panelMarca.add(motorTxt);
		motorTxt.setColumns(10);
		panelMarca.add(chasis);
		panelMarca.add(chasisTxt);
		chasisTxt.setColumns(10);
		panelMarca.add(patente);
		panelMarca.add(patenteTxt);
		patenteTxt.setColumns(8);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 5;
		container.add(panelMarca, constraints);
//----------------PANEL VIGENCIA ------------------------------------		
		panelVigencia = new JPanel();
		panelVigencia.setBackground(Color.lightGray);
		panelVigencia.setVisible(true);
		panelVigencia.setLayout(new FlowLayout());
		panelVigencia.add(vigencia);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 6;
		container.add(panelVigencia, constraints);
//----------------PANEL INICIO ------------------------------------		
		panelInicio = new JPanel();
		panelInicio.setBackground(Color.lightGray);
		panelInicio.setVisible(true);
		panelInicio.setLayout(new FlowLayout());
		panelInicio.add(inicio);
		panelInicio.add(inicioTxt);
		inicioTxt.setColumns(10);
		panelInicio.add(fin);
		panelInicio.add(finTxt);
		finTxt.setColumns(10);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 7;
		container.add(panelInicio, constraints);
//----------------PANEL SUMA------------------------------------		
     	panelSuma = new JPanel();
		panelSuma.setBackground(Color.lightGray);
		panelSuma.setVisible(true);
		panelSuma.setLayout(new FlowLayout());
		panelSuma.add(sumaAsegurada);
        panelSuma.add(sumaAseguradaTxt);
		sumaAseguradaTxt.setColumns(10);
		panelSuma.add(premio);
		panelSuma.add(premioTxt);
		premioTxt.setColumns(10);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 8;
		container.add(panelSuma, constraints);
//----------------PANEL IMPORTE------------------------------------		
 	    panelImporte = new JPanel();
        panelImporte.setBackground(Color.lightGray);
	    panelImporte.setVisible(true);
		panelImporte.setLayout(new FlowLayout());
		panelImporte.add(importeDescuento);
        panelImporte.add(importeDescuentoTxt);
		importeDescuentoTxt.setColumns(10);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 9;
		container.add(panelImporte, constraints);
//----------------PANEL ULTIMO------------------------------------		
 	    panelUltimo = new JPanel();
        panelUltimo.setBackground(Color.lightGray);
	    panelUltimo.setVisible(true);
		panelUltimo.setLayout(new FlowLayout());
		panelUltimo.add(diaPago);
        panelUltimo.add(diaPagoTxt);
		diaPagoTxt.setColumns(10);
		panelUltimo.add(montoTotal);
        panelUltimo.add(montoTotalTxt);
		montoTotalTxt.setColumns(10);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 11;
		container.add(panelUltimo, constraints);
//----------------PANEL DETALLE------------------------------------	 
		panelBotonDetalle = new JPanel();
		panelBotonDetalle.setBackground(Color.lightGray);
		panelBotonDetalle.setVisible(true);
		panelBotonDetalle.setLayout(new FlowLayout());
		panelBotonDetalle.add(detalle);
		constraints.gridx = 0;
    	constraints.gridy = 10;
		constraints.gridwidth = 1;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 10;
		container.add(panelBotonDetalle, constraints);
//----------------PANEL BOTONES------------------------------------	 
		panelBotones = new JPanel();
		panelBotones.setBackground(Color.lightGray);
		panelBotones.setVisible(true);
		panelBotones.setLayout(new FlowLayout());
		panelBotones.add(emisionPoliza);
		panelBotones.add(cancelar);
		constraints.gridx = 0;
		constraints.gridy = 10;
		constraints.gridwidth = 2;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 13;
		constraints.anchor = GridBagConstraints.CENTER;
		container.add(panelBotones, constraints);
        
        
//----------------PANEL TABLA DESCUENTOS ------------------------------------	        
		panelTablaDescuento = new JPanel();
		panelTablaDescuento.setBackground(Color.lightGray);
		panelTablaDescuento.setVisible(true);
		panelTablaDescuento.setLayout(new FlowLayout());
		DefaultTableModel model = new DefaultTableModel();

		model.addColumn("N° cuota");
		model.addColumn("Monto descuento");
		Object rowData[] = {"1", "$600.00"};
		
		model.addRow(rowData);
		tablaDescuentos = new JTable(2,1);
		tablaDescuentos.setBackground(Color.lightGray);
		tablaDescuentos.setModel(model);	
		tablaDescuentos.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(tablaDescuentos);
		scrollPane.setBackground(Color.lightGray);
		panelTablaDescuento.add(scrollPane);
		tablaDescuentos.setSize(2, 3);
		constraints.anchor = GridBagConstraints.NORTHEAST;
		constraints.fill = GridBagConstraints.BOTH;
		detalle.addActionListener(e -> {
			JOptionPane.showConfirmDialog(this, panelTablaDescuento, "Detalle de descuentos", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		});
//-----------------------------------------------------------------------   
		ArrayList<Cuota> cuotas = new ArrayList<Cuota>();
		calendar.setTime(ultimoPago);
		Date fechaCuota = null;
		
		fechaCuota = calendar.getTime();
			
		Cuota cuotaAux = new Cuota();
		cuotaAux.setNumeroCuota(1);
		cuotaAux.setMontoFinal(montoTotalTxt.getText());
		cuotaAux.setFechaVencimiento(fechaCuota);
		cuotas.add(cuotaAux);
				
		emisionPoliza.addActionListener(e -> {
			GestorPoliza gestorPoliza = new GestorPoliza();
			Date auxFechaInicio = null;
			try {
				auxFechaInicio = formato.parse(fechaInicio);
			} catch (ParseException e1) {
				e1.printStackTrace();
			}

			gestorPoliza.darAltaPoliza(listaHijos,
									   cobertura,
									   provincia,
									   localidad,
									   anioPoliza,
									   marcaPoliza,
									   modeloPoliza,
									   motorPoliza,
									   chasisPoliza,
									   patentePoliza,
									   seguridad,
									   sumaAseguradaPoliza,
									   auxFechaInicio,
									   auxFechaFinVigencia,
									   kmAnio,
									   cliente,
									   cuotas,
									   siniestros
			);
			
			JOptionPane.showMessageDialog(this, "POLIZA CREADA EXITOSAMENTE");
			new Menu();
			this.dispose();
			
		});
		
		cancelar.addActionListener(e -> {
			new DarAltaPoliza(new Cliente());
			this.dispose();
		});
	}
	
}
