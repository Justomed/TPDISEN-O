package pantallas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class DarAltaPoliza extends JFrame{
	
	private JPanel panelBuscarCliente;
	private JPanel panelSeparador;
	private JPanel panelSeparador2;
	private JPanel panelDatosCliente;
	private JPanel panelTituloCliente;
	private JPanel panelTituloPoliza;
	private JPanel panelPoliza;
	private JPanel panelHijos;
	private JPanel panelTablaHijos;
	private JPanel panelBotones;
	private JPanel panelSeguridad;
	private JPanel panelSiniestros;
	private JPanel panelHijosPopUp;
	private JPanel panelHijosPopUpFecha;
	private JPanel panelPremioDescuento;
	private JPanel panelBlanco;
	private JPanel panelBlanco1;
	private JPanel panelBlanco2;
	private JPanel panelBlanco3;
	private JPanel panelBlanco4;
	private JPanel panelBlanco5;
	private JPanel panelBlanco6;
	private JPanel panelBlanco7;
	private JPanel panelBlanco8;
	private JPanel panelBlanco9;
	private JPanel panelBlanco10;
	private JPanel panelBlanco11;
	private JPanel panelBlanco12;
	private JPanel panelBlanco13;
	private JPanel panelBlanco14;
	private JPanel panelBlanco15;
	private JPanel panelBlanco16;
	private JPanel panelBlanco17;
	private JPanel panelBlanco18;
	private JPanel panelBlanco19;
	private JPanel panelBlanco20;
	private JPanel panelBlanco21;
	private JPanel panelBlanco22;
	private JPanel panelBlanco23;
	private JPanel panelBlanco24;
	private JPanel panelBlanco25;
	private JPanel panelBlanco26;
	private JPanel panelBlanco27;
	private JPanel panelBlanco28;
	private JPanel panelBlanco29;
	private JPanel panelBlanco30;
	private JFrame frame=this;
	private JTable tablaHijos;
	
	public DarAltaPoliza() {
		
		this.setTitle("Dar de alta poliza");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setSize(860,770);
		this.setResizable(false);
		Container container = getContentPane();
		container.setLayout(new GridBagLayout());
		container.setBackground(Color.lightGray);
		GridBagConstraints constraints = new GridBagConstraints();
				
		JButton buscarCliente = new JButton("Buscar Cliente");
		JButton agregarHijo = new JButton ("Agregar datos de hijo");
		JButton eliminarHijo = new JButton ("Eliminar hijo");
		JButton confirmar = new JButton("Confirmar");
		JButton cancelar = new JButton("Cancelar");
		JComboBox provinciaComboBox = new JComboBox();
		JComboBox localidadComboBox = new JComboBox();
		JComboBox marcaComboBox = new JComboBox();
		JComboBox modeloComboBox = new JComboBox();
		JComboBox anioComboBox = new JComboBox();
		JComboBox kmAnioComboBox = new JComboBox();
		JComboBox siniestrosComboBox = new JComboBox();
		JComboBox tipoCoberturaPopUpComboBox = new JComboBox();
		JComboBox formaPagoPopUpComboBox = new JComboBox();
		JTextField nroClienteTxt = new JTextField();
		JTextField tipoDocumentoTxt = new JTextField();
		JTextField nroDocumentoTxt = new JTextField();
		JTextField apellidoTxt = new JTextField();
		JTextField nombreTxt = new JTextField();
		JTextField paisTxt = new JTextField();
		JTextField provinciaTxt = new JTextField();
		JTextField localidadTxt = new JTextField();
		JTextField cpTxt = new JTextField();
		JTextField calleTxt = new JTextField();
		JTextField numeroTxt = new JTextField();
		JTextField sumaAseguradaTxt = new JTextField();
		JTextField motorTxt = new JTextField();
		JTextField chasisTxt = new JTextField();
		JTextField patenteTxt = new JTextField();
		JTextField sexoPopUpTxt = new JTextField();
		JTextField estadoCivilPopUpTxt = new JTextField();
		JDateChooser fechaInicioPopUpCalendar = new JDateChooser("dd/MM/yy", "##/##/##",'_');
		JDateChooser fechaNacimientoTxt = new JDateChooser("dd/MM/yy", "##/##/##",'_');
		JLabel separador = new JLabel("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		JLabel separador2 = new JLabel("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		JLabel espacio = new JLabel("");
		JLabel fechaNacimiento = new JLabel("Fecha de nacimiento:");
		JLabel sexoPopUp = new JLabel("Sexo:");
		JLabel estadoCivilPopUp = new JLabel ("Estado civil:");
		JLabel tipoCoberturaPopUp = new JLabel("Tipo de cobertura:");
		JLabel fechaInicioPopUp = new JLabel("Fecha de inicio:");
		JLabel formaPagoPopUp = new JLabel("Forma de pago");
		JTextArea nroCliente = new JTextArea("Nro. cliente:");
		JTextArea tipoDocumento = new JTextArea("Tipo de documento:");
		JTextArea nroDocumento = new JTextArea("Nro. de documento:");
		JTextArea apellido = new JTextArea("Apellido:");
		JTextArea nombre = new JTextArea("Nombre:");
		JTextArea domicilio = new JTextArea("Domicilio:");
		JTextArea pais = new JTextArea("Pais:");
		JTextArea provincia = new JTextArea("Provincia:");
		JTextArea localidad = new JTextArea("Localidad:");
		JTextArea cp = new JTextArea("C.P.:");
		JTextArea calle = new JTextArea("Calle:");
		JTextArea numero = new JTextArea("Numero:");
		JTextArea domRiesgo = new JTextArea("Domicilio de riesgo:");
		JTextArea provinciaComboBoxLabel = new JTextArea("*Provincia:");
		JTextArea localidadComboBoxLabel = new JTextArea("*Localidad:");
		JTextArea datosVehiculo = new JTextArea("Datos del Vehiculo");
		JTextArea marca = new JTextArea("*Marca:");
		JTextArea modelo = new JTextArea("*Modelo:");
		JTextArea anio = new JTextArea("*Año:");
		JTextArea sumaAsegurada = new JTextArea("Suma asegurada:");
		JTextArea motor = new JTextArea("*Motor:");
		JTextArea chasis = new JTextArea("*Chasis:");
		JTextArea patente = new JTextArea("Patente:");
		JTextArea kmAnio = new JTextArea("*Km/Año:");
		JTextArea medidasSeguridad = new JTextArea("Medidas de seguridad:");
		JTextArea siniestrosComboBoxLabel = new JTextArea("*Nro. de siniestros en el ultimo año:");
		JTextArea hijos = new JTextArea("Hijos entre 18 y 30 años:");
		JTextArea clienteTitulo = new JTextArea("Datos de cliente seleccionado  ");
		JTextArea polizaTitulo = new JTextArea("Datos de poliza  ");
		JCheckBox garaje = new JCheckBox("¿Se guarda en garaje?");
		JCheckBox alarma = new JCheckBox("¿Tiene alarma?");
		JCheckBox rastreo = new JCheckBox("¿Posee dispositivo de rastreo vehicular?");
		JCheckBox tuercaAntirrobo = new JCheckBox("¿Posee tuercas antirrobo en las cuatro ruedas?");
		
		clienteTitulo.setFont(new Font("Dialog", Font.BOLD, 20));
		clienteTitulo.setBackground(Color.lightGray);
		polizaTitulo.setFont(new Font("Dialog", Font.BOLD, 20));
		polizaTitulo.setBackground(Color.lightGray);
		nroCliente.setBackground(Color.lightGray);
		tipoDocumento.setBackground(Color.lightGray);
		nroDocumento.setBackground(Color.lightGray);
		apellido.setBackground(Color.lightGray);
		nombre.setBackground(Color.lightGray);
		domicilio.setBackground(Color.lightGray);
		pais.setBackground(Color.lightGray);
		provincia.setBackground(Color.lightGray);
		localidad.setBackground(Color.lightGray);
		cp.setBackground(Color.lightGray);
		calle.setBackground(Color.lightGray);
		domRiesgo.setBackground(Color.lightGray);
		provinciaComboBoxLabel.setBackground(Color.lightGray);
		localidadComboBoxLabel.setBackground(Color.lightGray);
		datosVehiculo.setBackground(Color.lightGray);
		marca.setBackground(Color.lightGray);
		modelo.setBackground(Color.lightGray);
		anio.setBackground(Color.lightGray);
		sumaAsegurada.setBackground(Color.lightGray);
		motor.setBackground(Color.lightGray);
		chasis.setBackground(Color.lightGray);
		patente.setBackground(Color.lightGray);
		kmAnio.setBackground(Color.lightGray);
		medidasSeguridad.setBackground(Color.lightGray);
		siniestrosComboBoxLabel.setBackground(Color.lightGray);
		hijos.setBackground(Color.lightGray);
		numero.setBackground(Color.lightGray);
		garaje.setBackground(Color.lightGray);
		garaje.setFont(new Font("Dialog", Font.PLAIN, 12));
		alarma.setBackground(Color.lightGray);
		alarma.setFont(new Font("Dialog", Font.PLAIN, 12));
		rastreo.setBackground(Color.lightGray);
		rastreo.setFont(new Font("Dialog", Font.PLAIN, 12));
		tuercaAntirrobo.setBackground(Color.lightGray);
		tuercaAntirrobo.setFont(new Font("Dialog", Font.PLAIN, 12));
		
		panelBuscarCliente = new JPanel();
		panelBuscarCliente.setBackground(Color.lightGray);
		panelBuscarCliente.setVisible(true);
		panelBuscarCliente.setLayout(new FlowLayout());
		panelBuscarCliente.add(buscarCliente);
		
		buscarCliente.addActionListener(e -> {
			new BuscarCliente();
		});
		
		constraints.anchor = GridBagConstraints.NORTHWEST;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
		
		container.add(panelBuscarCliente, constraints);
		
		panelSeparador = new JPanel();
		panelSeparador.setBackground(Color.lightGray);
		panelSeparador.setVisible(true);
		panelSeparador.setLayout(new FlowLayout());
		panelSeparador.add(separador);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 2;
		
		container.add(panelSeparador, constraints);
		
		panelTituloCliente = new JPanel();
		panelTituloCliente.setBackground(Color.lightGray);
		panelTituloCliente.setVisible(true);
		panelTituloCliente.setLayout(new FlowLayout());
		panelTituloCliente.add(clienteTitulo);
		
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 2;
		
		container.add(panelTituloCliente, constraints);
		
		panelDatosCliente = new JPanel();
		panelDatosCliente.setBackground(Color.lightGray);
		panelDatosCliente.setVisible(true);		
		GridLayout glDatosCliente = new GridLayout(7,4);
		glDatosCliente.setVgap(1);
		glDatosCliente.setHgap(3);
		panelDatosCliente.setLayout(glDatosCliente);
		
		panelBlanco = new JPanel();
		panelBlanco1 = new JPanel();
		panelBlanco2 = new JPanel();
		panelBlanco3 = new JPanel();
		panelBlanco4 = new JPanel();
		panelBlanco.setBackground(Color.lightGray);
		panelBlanco1.setBackground(Color.lightGray);
		panelBlanco2.setBackground(Color.lightGray);
		panelBlanco3.setBackground(Color.lightGray);
		panelBlanco4.setBackground(Color.lightGray);
		
		panelDatosCliente.add(nroCliente);
		panelDatosCliente.add(nroClienteTxt);
		panelDatosCliente.add(panelBlanco);
		panelDatosCliente.add(panelBlanco1);
		panelDatosCliente.add(tipoDocumento);
		panelDatosCliente.add(tipoDocumentoTxt);
		panelDatosCliente.add(nroDocumento);
		panelDatosCliente.add(nroDocumentoTxt);
		panelDatosCliente.add(apellido);
		panelDatosCliente.add(apellidoTxt);
		panelDatosCliente.add(nombre);
		panelDatosCliente.add(nombreTxt);
		panelDatosCliente.add(domicilio);
		panelDatosCliente.add(panelBlanco2);
		panelDatosCliente.add(panelBlanco3);
		panelDatosCliente.add(panelBlanco4);
		panelDatosCliente.add(pais);
		panelDatosCliente.add(paisTxt);
		panelDatosCliente.add(provincia);
		panelDatosCliente.add(provinciaTxt);
		panelDatosCliente.add(localidad);
		panelDatosCliente.add(localidadTxt);
		panelDatosCliente.add(cp);
		panelDatosCliente.add(cpTxt);
		panelDatosCliente.add(calle);
		panelDatosCliente.add(calleTxt);
		panelDatosCliente.add(numero);
		panelDatosCliente.add(numeroTxt);
		
		
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 2;
		
		container.add(panelDatosCliente, constraints);
		
		panelSeparador2 = new JPanel();
		panelSeparador2.setBackground(Color.lightGray);
		panelSeparador2.setVisible(true);
		panelSeparador2.setLayout(new FlowLayout());
		panelSeparador2.add(separador2);
		
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.gridwidth = 2;
		
		container.add(panelSeparador2, constraints);
		
		panelTituloPoliza = new JPanel();
		panelTituloPoliza.setBackground(Color.lightGray);
		panelTituloPoliza.setVisible(true);
		panelTituloPoliza.setLayout(new FlowLayout());
		panelTituloPoliza.add(polizaTitulo);
		
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 5;
		constraints.gridwidth = 2;
		
		container.add(panelTituloPoliza, constraints);
		
		panelPoliza = new JPanel();
		panelPoliza.setBackground(Color.LIGHT_GRAY);
		panelPoliza.setVisible(true);	
		GridLayout glPoliza = new GridLayout(6,8);
		glPoliza.setVgap(1);
		glPoliza.setHgap(1);
		panelPoliza.setLayout(glPoliza);
		
		panelBlanco5 = new JPanel();
		panelBlanco6 = new JPanel();
		panelBlanco7 = new JPanel();
		panelBlanco8 = new JPanel();
		panelBlanco9 = new JPanel();
		panelBlanco10 = new JPanel();
		panelBlanco11 = new JPanel();
		panelBlanco12 = new JPanel();
		panelBlanco13 = new JPanel();
		panelBlanco14 = new JPanel();
		panelBlanco15 = new JPanel();
		panelBlanco16 = new JPanel();
		panelBlanco17 = new JPanel();
		panelBlanco18 = new JPanel();
		panelBlanco19 = new JPanel();
		panelBlanco20 = new JPanel();
		panelBlanco21 = new JPanel();
		panelBlanco22 = new JPanel();
		panelBlanco23 = new JPanel();
		panelBlanco24 = new JPanel();
		panelBlanco25 = new JPanel();
		panelBlanco26 = new JPanel();
		panelBlanco27 = new JPanel();
		panelBlanco28 = new JPanel();
		panelBlanco29 = new JPanel();
		panelBlanco30 = new JPanel();
		
		panelBlanco5.setBackground(Color.lightGray);
		panelBlanco6.setBackground(Color.lightGray);
		panelBlanco7.setBackground(Color.lightGray);
		panelBlanco8.setBackground(Color.lightGray);
		panelBlanco9.setBackground(Color.lightGray);
		panelBlanco10.setBackground(Color.lightGray);
		panelBlanco11.setBackground(Color.lightGray);
		panelBlanco12.setBackground(Color.lightGray);
		panelBlanco13.setBackground(Color.lightGray);
		panelBlanco14.setBackground(Color.lightGray);
		panelBlanco15.setBackground(Color.lightGray);
		panelBlanco16.setBackground(Color.lightGray);
		panelBlanco17.setBackground(Color.lightGray);
		panelBlanco18.setBackground(Color.lightGray);
		panelBlanco19.setBackground(Color.lightGray);
		panelBlanco20.setBackground(Color.lightGray);
		panelBlanco21.setBackground(Color.lightGray);
		panelBlanco22.setBackground(Color.lightGray);
		panelBlanco23.setBackground(Color.lightGray);
		panelBlanco24.setBackground(Color.lightGray);
		panelBlanco25.setBackground(Color.lightGray);
		panelBlanco26.setBackground(Color.lightGray);
		panelBlanco27.setBackground(Color.lightGray);
		panelBlanco28.setBackground(Color.lightGray);
		panelBlanco29.setBackground(Color.lightGray);
		panelBlanco30.setBackground(Color.lightGray);
		
		panelPoliza.add(domRiesgo);
		panelPoliza.add(panelBlanco5);
		panelPoliza.add(panelBlanco6);
		panelPoliza.add(panelBlanco7);
		panelPoliza.add(panelBlanco8);
		panelPoliza.add(panelBlanco9);
		panelPoliza.add(panelBlanco10);
		panelPoliza.add(panelBlanco11);
		panelPoliza.add(provinciaComboBoxLabel);
		panelPoliza.add(provinciaComboBox);
		panelPoliza.add(localidadComboBoxLabel);
		panelPoliza.add(localidadComboBox);
		panelPoliza.add(panelBlanco12);
		panelPoliza.add(panelBlanco13);
		panelPoliza.add(panelBlanco14);
		panelPoliza.add(panelBlanco15);
		panelPoliza.add(datosVehiculo);
		panelPoliza.add(panelBlanco16);
		panelPoliza.add(panelBlanco17);
		panelPoliza.add(panelBlanco18);
		panelPoliza.add(panelBlanco19);
		panelPoliza.add(panelBlanco20);
		panelPoliza.add(panelBlanco21);
		panelPoliza.add(panelBlanco22);
		panelPoliza.add(marca);
		panelPoliza.add(marcaComboBox);
		panelPoliza.add(modelo);
		panelPoliza.add(modeloComboBox);
		panelPoliza.add(anio);
		panelPoliza.add(anioComboBox);
		panelPoliza.add(panelBlanco23);
		panelPoliza.add(panelBlanco24);
		panelPoliza.add(sumaAsegurada);
		panelPoliza.add(sumaAseguradaTxt);
		panelPoliza.add(panelBlanco25);
		panelPoliza.add(panelBlanco26);
		panelPoliza.add(panelBlanco27);
		panelPoliza.add(panelBlanco28);
		panelPoliza.add(panelBlanco29);
		panelPoliza.add(panelBlanco30);
		panelPoliza.add(motor);
		panelPoliza.add(motorTxt);
		panelPoliza.add(chasis);
		panelPoliza.add(chasisTxt);
		panelPoliza.add(patente);
		panelPoliza.add(patenteTxt);
		panelPoliza.add(kmAnio);
		panelPoliza.add(kmAnioComboBox);	
		
		
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 6;
		constraints.gridwidth = 2;
		container.add(panelPoliza, constraints);
		
		panelSeguridad = new JPanel();
		panelSeguridad.setBackground(Color.lightGray);
		panelSeguridad.setVisible(true);
		panelSeguridad.setLayout(new GridBagLayout());
		GridBagConstraints constraintsSeguridad = new GridBagConstraints();
		
		constraintsSeguridad.gridx = 0;
		constraintsSeguridad.gridy = 0;
		constraintsSeguridad.anchor = GridBagConstraints.WEST;
		panelSeguridad.add(medidasSeguridad, constraintsSeguridad);
		
		constraintsSeguridad.gridx = 0;
		constraintsSeguridad.gridy = 1;
		constraintsSeguridad.fill = GridBagConstraints.HORIZONTAL;
		panelSeguridad.add(garaje, constraintsSeguridad);
		
		constraintsSeguridad.gridx = 0;
		constraintsSeguridad.gridy = 2;
		panelSeguridad.add(alarma, constraintsSeguridad);
		
		constraintsSeguridad.gridx = 0;
		constraintsSeguridad.gridy = 3;
		panelSeguridad.add(rastreo, constraintsSeguridad);
		
		constraintsSeguridad.gridx = 0;
		constraintsSeguridad.gridy = 4;
		panelSeguridad.add(tuercaAntirrobo, constraintsSeguridad);
		
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 7;
		constraints.gridwidth = 2;
		container.add(panelSeguridad, constraints);
		
		panelSiniestros = new JPanel();
		panelSiniestros.setBackground(Color.lightGray);
		panelSiniestros.setVisible(true);
		GridLayout glSiniestros = new GridLayout(1,2);
		glSiniestros.setVgap(2);
		panelSiniestros.setLayout(glSiniestros);
		
		panelSiniestros.add(siniestrosComboBoxLabel);
		panelSiniestros.add(siniestrosComboBox);
		
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 8;
		constraints.gridwidth = 2;
		container.add(panelSiniestros, constraints);
		
		panelHijos = new JPanel();
		panelHijos.setBackground(Color.lightGray);
		panelHijos.setVisible(true);
		GridLayout glHijos = new GridLayout(3,1);
		panelHijos.setLayout(glHijos);
		glHijos.setVgap(3);
		
		panelHijos.add(hijos);
		panelHijos.add(agregarHijo);
		panelHijos.add(eliminarHijo);
		
		panelHijosPopUp = new JPanel();
		panelHijosPopUp.setVisible(true);
		panelHijosPopUp.setLayout(new BorderLayout());
		
		panelHijosPopUpFecha = new JPanel();
		panelHijosPopUpFecha.setVisible(true);
		GridLayout glHijosPopUp = new GridLayout(3,2);
		glHijosPopUp.setVgap(3);
		glHijosPopUp.setHgap(3);
		panelHijosPopUpFecha.setLayout(glHijosPopUp);
		
		panelHijosPopUpFecha.add(fechaNacimiento);
		panelHijosPopUpFecha.add(fechaNacimientoTxt);
		panelHijosPopUpFecha.add(sexoPopUp);
		panelHijosPopUpFecha.add(sexoPopUpTxt);
		panelHijosPopUpFecha.add(estadoCivilPopUp);
		panelHijosPopUpFecha.add(estadoCivilPopUpTxt);
		
		panelHijosPopUp.add(panelHijosPopUpFecha, BorderLayout.NORTH);
		
		agregarHijo.addActionListener(e -> {
			int respuesta = JOptionPane.showConfirmDialog(this, panelHijosPopUp, "Declarar hijo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		});
			
		
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 9;
		container.add(panelHijos, constraints);
		
		panelTablaHijos = new JPanel();
		panelTablaHijos.setBackground(Color.lightGray);
		panelTablaHijos.setVisible(true);
		panelTablaHijos.setLayout(new FlowLayout());
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("N°");
		model.addColumn("Fecha de nacimiento");
		model.addColumn("Sexo");
		model.addColumn("Estado civil");
		
		Object rowData[] = null;
		
		model.addRow(rowData);
		model.addRow(rowData);
		model.addRow(rowData);
		
		tablaHijos = new JTable(4,4);
		tablaHijos.setBackground(Color.lightGray);
		tablaHijos.setModel(model);	
		tablaHijos.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(tablaHijos);
		scrollPane.setBackground(Color.lightGray);
		panelTablaHijos.add(scrollPane);
		
		constraints.anchor = GridBagConstraints.NORTHEAST;
		constraints.gridx = 1;
		constraints.gridy = 9;
		constraints.gridheight = 3;
		constraints.fill = GridBagConstraints.BOTH;
		container.add(panelTablaHijos, constraints);
		
		panelBotones = new JPanel();
		panelBotones.setBackground(Color.lightGray);
		panelBotones.setVisible(true);
		panelBotones.setLayout(new FlowLayout());
		panelBotones.add(confirmar);
		panelBotones.add(cancelar);
		
		panelPremioDescuento = new JPanel();
		panelPremioDescuento.setVisible(true);
		GridLayout glPremioDescuento = new GridLayout(3,2);
		glHijosPopUp.setVgap(3);
		glHijosPopUp.setHgap(3);
		panelPremioDescuento.setLayout(glPremioDescuento);
		
		panelPremioDescuento.add(tipoCoberturaPopUp);
		panelPremioDescuento.add(tipoCoberturaPopUpComboBox);
		panelPremioDescuento.add(fechaInicioPopUp);
		panelPremioDescuento.add(fechaInicioPopUpCalendar);
		panelPremioDescuento.add(formaPagoPopUp);
		panelPremioDescuento.add(formaPagoPopUpComboBox);
		
		confirmar.addActionListener(e -> {
			int respuesta = JOptionPane.showConfirmDialog(this, panelPremioDescuento, "Tipo de cobertura y forma de pago", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
		});
		
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 10;
		constraints.gridwidth = 2;
		container.add(panelBotones, constraints);
				
	}
	
}
