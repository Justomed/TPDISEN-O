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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
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

import org.joda.time.DateTime;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import entidades.AnioFabricacion;
import entidades.Cliente;
import entidades.Hijo;
import entidades.Localidad;
import entidades.Marca;
import entidades.Modelo;
import entidades.Provincia;
import gestores.GestorBD;
import utility.FocusTextField;
import utility.MyOwnFocusTraversalPolicy;

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
	private int auxComboBox;
	private int auxModelo;
	private int contador=0;
	private Object[] hijosDeclarados;
	private ArrayList<Hijo> listaHijos = new ArrayList<Hijo>();
	private DateFormat formato = new SimpleDateFormat("dd/MM/yy");
	private ArrayList<Boolean> seguridad = new ArrayList<Boolean>();
	private ArrayList<Provincia> listaProvincias = new ArrayList<Provincia>();
	private ArrayList<Localidad> listaLocalidades = new ArrayList<Localidad>();
	private ArrayList<Marca> listaMarcas = new ArrayList<Marca>();
	private ArrayList<Modelo> listaModelos = new ArrayList<Modelo>();
	private ArrayList<AnioFabricacion> listaAnios = new ArrayList<AnioFabricacion>();
	private GestorBD gestorBD = new GestorBD();
	
	public DarAltaPoliza(Cliente cliente) {
		
		this.setTitle("Dar de alta poliza");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setSize(970,770);
		this.setResizable(false);
		Container container = getContentPane();
		container.setLayout(new GridBagLayout());
		container.setBackground(Color.lightGray);
		GridBagConstraints constraints = new GridBagConstraints();
		
		//---------------------DECLARACION DE COMPONENTES-----------------------------
		
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
		JFormattedTextField nroClienteTxt = new JFormattedTextField("_ _ - _ _ _ _ _ _ _ _");
		JFormattedTextField sumaAseguradaTxt = new JFormattedTextField("$_ _._ _ _._ _ _,_ _");
		FocusTextField motorTxt = new FocusTextField();
		FocusTextField chasisTxt = new FocusTextField();
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
		JTextField patenteTxt = new JTextField();
		JTextField sexoPopUpTxt = new JTextField();
		JTextField estadoCivilPopUpTxt = new JTextField();
		JDateChooser fechaInicioPopUpCalendar = new JDateChooser("dd/MM/yy", "##/##/##",'_');
		JDateChooser fechaNacimientoTxt = new JDateChooser("dd/MM/yy", "##/##/##",'_');
		JLabel separador = new JLabel("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		JLabel separador2 = new JLabel("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
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
		
		motorTxt.setText("ZZZZZZZZZZZ9999999");
		chasisTxt.setText("Z9999999");
		
		nroClienteTxt.setText(cliente.getId());		
		apellidoTxt.setText(cliente.getApellido());
		nombreTxt.setText(cliente.getNombre());
		tipoDocumentoTxt.setText(cliente.getTipoDni());
		nroDocumentoTxt.setText(cliente.getDni());
		paisTxt.setText(cliente.getDomicilio().getLocalidad().getProvincia().getPais().getNombrePais());
		provinciaTxt.setText(cliente.getDomicilio().getLocalidad().getProvincia().getNombreProvincia());
		localidadTxt.setText(cliente.getDomicilio().getLocalidad().getNombreLocalidad());
		calleTxt.setText(cliente.getDomicilio().getCalle());
		String aux = String.valueOf(cliente.getDomicilio().getNumero());
		numeroTxt.setText(aux);
		aux = String.valueOf(cliente.getDomicilio().getLocalidad().getCodigoPostal());
		cpTxt.setText(aux);
		
		if(cliente.getId() == null) {
			nroClienteTxt.setText("_ _ - _ _ _ _ _ _ _ _");
		}
		
		if(cliente.getDomicilio().getNumero() == 0) {
			numeroTxt.setText(" ");
		}
		
		if(cliente.getDomicilio().getLocalidad().getCodigoPostal() == 0) {
			cpTxt.setText(" ");
		}
		
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
		
		//-------------------ORDEN DE TABULACION------------------------------
		
		Vector<Component> orden = new Vector<Component>();
		
		orden.add(buscarCliente);
		orden.add(provinciaComboBox);
		orden.add(localidadComboBox);
		orden.add(marcaComboBox);
		orden.add(modeloComboBox);
		orden.add(anioComboBox);
		orden.add(motorTxt);
		orden.add(chasisTxt);
		orden.add(patenteTxt);
		orden.add(kmAnioComboBox);
		orden.add(garaje);
		orden.add(alarma);
		orden.add(rastreo);
		orden.add(tuercaAntirrobo);
		orden.add(siniestrosComboBox);
		orden.add(agregarHijo);
		orden.add(eliminarHijo);
		orden.add(confirmar);
		orden.add(cancelar);
		
		MyOwnFocusTraversalPolicy newPolicy = new MyOwnFocusTraversalPolicy(orden);
		frame.setFocusTraversalPolicy(newPolicy);
		
		//-------------------PANEL BUSCAR CLIENTE--------------------------
		
		panelBuscarCliente = new JPanel();
		panelBuscarCliente.setBackground(Color.lightGray);
		panelBuscarCliente.setVisible(true);
		panelBuscarCliente.setLayout(new FlowLayout());
		panelBuscarCliente.add(buscarCliente);
		
		buscarCliente.addActionListener(e -> {
			new BuscarCliente();
			frame.dispose();
		});
		
		buscarCliente.requestFocusInWindow();
		
		constraints.anchor = GridBagConstraints.NORTHWEST;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 2;
		
		container.add(panelBuscarCliente, constraints);
		
		//-----------------------PRIMER SEPARADOR---------------------------
		
		panelSeparador = new JPanel();
		panelSeparador.setBackground(Color.lightGray);
		panelSeparador.setVisible(true);
		panelSeparador.setLayout(new FlowLayout());
		panelSeparador.add(separador);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 2;
		
		container.add(panelSeparador, constraints);
		
		//----------------TITULO "DATOS DE CLIENTE SELECCIONADO"-------------------
		
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
		
		//------------------------PANEL DATOS CLIENTE--------------------------
		
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
		
		nroClienteTxt.setEnabled(false);
		tipoDocumentoTxt.setEnabled(false);
		nroDocumentoTxt.setEnabled(false);
		apellidoTxt.setEnabled(false);
		nombreTxt.setEnabled(false);
		paisTxt.setEnabled(false);
		provinciaTxt.setEnabled(false);
		localidadTxt.setEnabled(false);
		cpTxt.setEnabled(false);
		calleTxt.setEnabled(false);
		numeroTxt.setEnabled(false);
		
		nroClienteTxt.setBackground(Color.GRAY);
		tipoDocumentoTxt.setBackground(Color.GRAY);
		nroDocumentoTxt.setBackground(Color.GRAY);
		apellidoTxt.setBackground(Color.GRAY);
		nombreTxt.setBackground(Color.GRAY);
		paisTxt.setBackground(Color.GRAY);
		provinciaTxt.setBackground(Color.GRAY);
		localidadTxt.setBackground(Color.GRAY);
		cpTxt.setBackground(Color.GRAY);
		calleTxt.setBackground(Color.GRAY);
		numeroTxt.setBackground(Color.GRAY);
		
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
		
		//------------------------SEGUNDO SEPARADOR---------------------------
		
		panelSeparador2 = new JPanel();
		panelSeparador2.setBackground(Color.lightGray);
		panelSeparador2.setVisible(true);
		panelSeparador2.setLayout(new FlowLayout());
		panelSeparador2.add(separador2);
		
		constraints.gridx = 0;
		constraints.gridy = 4;
		constraints.gridwidth = 2;
		
		container.add(panelSeparador2, constraints);
		
		//----------------------TITULO "DATOS DE POLIZA"-------------------------
		
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
		
		//---------------------------PANEL DATOS POLIZA----------------------------
		
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
		
		localidadComboBox.setEnabled(false);
		modeloComboBox.setEnabled(false);
		anioComboBox.setEnabled(false);
		sumaAseguradaTxt.setEnabled(false);
		
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
		
		listaProvincias = gestorBD.recuperarTodasLasProvincias();
		
		provinciaComboBox.addItem("-----------------");
		
		for(int i=0; i<listaProvincias.size(); i++) {
			provinciaComboBox.addItem(listaProvincias.get(i).getNombreProvincia());
		}
		
		provinciaComboBox.addActionListener(e -> {
		if(provinciaComboBox.getSelectedIndex() > 0) {
			localidadComboBox.setEnabled(true);
			auxComboBox = provinciaComboBox.getSelectedIndex();
			int auxIdProvincia=0;
			switch((String) provinciaComboBox.getItemAt(auxComboBox)) {
			case "Santa Fe":
				localidadComboBox.addItem("-----------------");
				
				auxIdProvincia = listaProvincias.get(auxComboBox-1).getId();
				listaLocalidades = gestorBD.recuperarTodasLasLocalidades(auxIdProvincia);
				
				for(int i=0; i<listaLocalidades.size(); i++) {
					localidadComboBox.addItem(listaLocalidades.get(i).getNombreLocalidad());
				}
				break;
			case "Entre Rios":
				localidadComboBox.addItem("-----------------");
				
				auxIdProvincia = listaProvincias.get(auxComboBox-1).getId();
				listaLocalidades = gestorBD.recuperarTodasLasLocalidades(auxIdProvincia);
				
				for(int i=0; i<listaLocalidades.size(); i++) {
					localidadComboBox.addItem(listaLocalidades.get(i).getNombreLocalidad());
				}
				break;
			case "Cordoba":
				localidadComboBox.addItem("-----------------");

				auxIdProvincia = listaProvincias.get(auxComboBox-1).getId();
				listaLocalidades = gestorBD.recuperarTodasLasLocalidades(auxIdProvincia);
				
				for(int i=0; i<listaLocalidades.size(); i++) {
					localidadComboBox.addItem(listaLocalidades.get(i).getNombreLocalidad());
				}
				break;
			case "Buenos Aires":
				localidadComboBox.addItem("-----------------");

				auxIdProvincia = listaProvincias.get(auxComboBox-1).getId();
				listaLocalidades = gestorBD.recuperarTodasLasLocalidades(auxIdProvincia);
				
				for(int i=0; i<listaLocalidades.size(); i++) {
					localidadComboBox.addItem(listaLocalidades.get(i).getNombreLocalidad());
				}
				break;
			}
		}
		});
		
		listaMarcas = gestorBD.recuperarTodasLasMarcas();
		
		marcaComboBox.addItem("-----------------");
		
		for(int i=0; i<listaMarcas.size(); i++) {
			marcaComboBox.addItem(listaMarcas.get(i).getMarca());
		}
		
		marcaComboBox.addActionListener(e -> {
			if(marcaComboBox.getSelectedIndex() > 0) {
				modeloComboBox.setEnabled(true);
				auxComboBox = marcaComboBox.getSelectedIndex();
				auxModelo = marcaComboBox.getSelectedIndex();
				int auxIdMarca=0;
				switch((String) marcaComboBox.getItemAt(auxComboBox)) {
				case "Volkswagen":
					modeloComboBox.addItem("-----------------");
					
					auxIdMarca = listaMarcas.get(auxComboBox-1).getId();
					listaModelos = gestorBD.recuperarTodasListaModelo(auxIdMarca);
					
					for(int i=0; i<listaModelos.size(); i++) {
						modeloComboBox.addItem(listaModelos.get(i).getModelo());
					}
					break;
				case "Chevrolet":
					modeloComboBox.addItem("-----------------");
					
					auxIdMarca = listaMarcas.get(auxComboBox-1).getId();
					listaModelos = gestorBD.recuperarTodasListaModelo(auxIdMarca);
					
					for(int i=0; i<listaModelos.size(); i++) {
						modeloComboBox.addItem(listaModelos.get(i).getModelo());
					}
					break;
				case "Ford":
					modeloComboBox.addItem("-----------------");
					
					auxIdMarca = listaMarcas.get(auxComboBox-1).getId();
					listaModelos = gestorBD.recuperarTodasListaModelo(auxIdMarca);
					
					for(int i=0; i<listaModelos.size(); i++) {
						modeloComboBox.addItem(listaModelos.get(i).getModelo());
					}
					break;
				}
		}
		});
		
		modeloComboBox.addActionListener(e -> {
			if(modeloComboBox.getSelectedIndex() > 0) {
				anioComboBox.setEnabled(true);
				anioComboBox.addItem("-----------------");
				
				listaAnios = gestorBD.recuperarTodosLosAnios();
				
				for(int i=0; i<listaAnios.size(); i++) {
					anioComboBox.addItem(listaAnios.get(i).getAnio());
				}
		}
		});
		
		anioComboBox.addActionListener(e -> {
			if(anioComboBox.getSelectedIndex() > 0) {
				int auxAnio = anioComboBox.getSelectedIndex();
				int auxModelo = modeloComboBox.getSelectedIndex();
				
				switch((String) anioComboBox.getItemAt(auxAnio)) {
				case "2005":
					switch((String) modeloComboBox.getItemAt(auxModelo)) {
					case "Gol":
						sumaAseguradaTxt.setText(gestorBD.recuperarSumaAsegurada(auxModelo, auxAnio));	
						break;
					case "Fox":
						sumaAseguradaTxt.setText(gestorBD.recuperarSumaAsegurada(auxModelo, auxAnio));
						break;
					case "Bora":
						sumaAseguradaTxt.setText(gestorBD.recuperarSumaAsegurada(auxModelo, auxAnio));
						break;
					case "Corsa":
						sumaAseguradaTxt.setText(gestorBD.recuperarSumaAsegurada(auxModelo, auxAnio));
						break;
					case "Meriva":
						sumaAseguradaTxt.setText(gestorBD.recuperarSumaAsegurada(auxModelo, auxAnio));
						break;
					case "Astra":
						sumaAseguradaTxt.setText(gestorBD.recuperarSumaAsegurada(auxModelo, auxAnio));
						break;
					case "Fiesta":
						sumaAseguradaTxt.setText(gestorBD.recuperarSumaAsegurada(auxModelo, auxAnio));
						break;
					case "Focus":
						sumaAseguradaTxt.setText(gestorBD.recuperarSumaAsegurada(auxModelo, auxAnio));
						break;
					case "Ranger":
						sumaAseguradaTxt.setText(gestorBD.recuperarSumaAsegurada(auxModelo, auxAnio));
						break;
					}
					break;
				case "2008":
					switch((String) modeloComboBox.getItemAt(auxModelo)) {
					case "Gol":
						sumaAseguradaTxt.setText(gestorBD.recuperarSumaAsegurada(auxModelo, auxAnio));
						break;
					case "Fox":
						sumaAseguradaTxt.setText(gestorBD.recuperarSumaAsegurada(auxModelo, auxAnio));
						break;
					case "Bora":
						sumaAseguradaTxt.setText(gestorBD.recuperarSumaAsegurada(auxModelo, auxAnio));
						break;
					case "Corsa":
						sumaAseguradaTxt.setText(gestorBD.recuperarSumaAsegurada(auxModelo, auxAnio));
						break;
					case "Meriva":
						sumaAseguradaTxt.setText(gestorBD.recuperarSumaAsegurada(auxModelo, auxAnio));
						break;
					case "Astra":
						sumaAseguradaTxt.setText(gestorBD.recuperarSumaAsegurada(auxModelo, auxAnio));
						break;
					case "Fiesta":
						sumaAseguradaTxt.setText(gestorBD.recuperarSumaAsegurada(auxModelo, auxAnio));
						break;
					case "Focus":
						sumaAseguradaTxt.setText(gestorBD.recuperarSumaAsegurada(auxModelo, auxAnio));
						break;
					case "Ranger":
						sumaAseguradaTxt.setText(gestorBD.recuperarSumaAsegurada(auxModelo, auxAnio));
						break;
					}
					break;
				case "2010":
					switch((String) modeloComboBox.getItemAt(auxModelo)) {
					case "Gol":
						sumaAseguradaTxt.setText(gestorBD.recuperarSumaAsegurada(auxModelo, auxAnio));
						break;
					case "Fox":
						sumaAseguradaTxt.setText(gestorBD.recuperarSumaAsegurada(auxModelo, auxAnio));
						break;
					case "Bora":
						sumaAseguradaTxt.setText(gestorBD.recuperarSumaAsegurada(auxModelo, auxAnio));
						break;
					case "Corsa":
						sumaAseguradaTxt.setText(gestorBD.recuperarSumaAsegurada(auxModelo, auxAnio));
						break;
					case "Meriva":
						sumaAseguradaTxt.setText(gestorBD.recuperarSumaAsegurada(auxModelo, auxAnio));
						break;
					case "Astra":
						sumaAseguradaTxt.setText(gestorBD.recuperarSumaAsegurada(auxModelo, auxAnio));
						break;
					case "Fiesta":
						sumaAseguradaTxt.setText(gestorBD.recuperarSumaAsegurada(auxModelo, auxAnio));
						break;
					case "Focus":
						sumaAseguradaTxt.setText(gestorBD.recuperarSumaAsegurada(auxModelo, auxAnio));
						break;
					case "Ranger":
						sumaAseguradaTxt.setText(gestorBD.recuperarSumaAsegurada(auxModelo, auxAnio));
						break;
					}
					break;
				}
			}
		});
		
		kmAnioComboBox.addItem("0 - 10.000");
		kmAnioComboBox.addItem("10.000 - 20.000");
		kmAnioComboBox.addItem("20.000 - 30.000");
		kmAnioComboBox.addItem("30.000 - 40.000");
		kmAnioComboBox.addItem("40.000 - 50.000");
		kmAnioComboBox.addItem("50.000 - 60.000");
		kmAnioComboBox.addItem("60.000 - 70.000");
		kmAnioComboBox.addItem("70.000 - 80.000");
		kmAnioComboBox.addItem("80.000 - 90.000");
		kmAnioComboBox.addItem("90.000 - 100.000");
		kmAnioComboBox.addItem("MAS DE 100.000");
		
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 6;
		constraints.gridwidth = 2;
		container.add(panelPoliza, constraints);
		
		//----------------------PANEL MEDIDAS DE SEGURIDAD-----------------------
		
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
		
		//--------------------PANEL NUMERO DE SINIESTROS------------------------
		
		panelSiniestros = new JPanel();
		panelSiniestros.setBackground(Color.lightGray);
		panelSiniestros.setVisible(true);
		GridLayout glSiniestros = new GridLayout(1,2);
		glSiniestros.setVgap(2);
		panelSiniestros.setLayout(glSiniestros);
		
		siniestrosComboBox.addItem("NINGUNO");
		siniestrosComboBox.addItem("UNO");
		siniestrosComboBox.addItem("DOS");
		siniestrosComboBox.addItem("MAS DE DOS");

		panelSiniestros.add(siniestrosComboBoxLabel);
		panelSiniestros.add(siniestrosComboBox);
		
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 8;
		constraints.gridwidth = 2;
		container.add(panelSiniestros, constraints);
		
		//-------------------------PANEL BOTONES HIJOS---------------------------
		
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
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("N°");
		model.addColumn("Fecha de nacimiento");
		model.addColumn("Sexo");
		model.addColumn("Estado civil");
		
		agregarHijo.addActionListener(e -> {
			int respuesta = JOptionPane.showConfirmDialog(this, panelHijosPopUp, "Declarar hijo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			
			if(respuesta == 0) { //si apreta OK, respuesta==0
				String fechaAux = formato.format(fechaNacimientoTxt.getDate());
				String sexoAux = sexoPopUpTxt.getText();
				String estadoCivilAux = estadoCivilPopUpTxt.getText();
				contador++;
				Object[] hijosDeclarados = {contador, fechaAux, sexoAux, estadoCivilAux};
				
				if(hijosDeclarados != null) {
					model.addRow(hijosDeclarados);
				}
			}
		});
			
		
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 9;
		container.add(panelHijos, constraints);
		
		//-----------------------PANEL TABLA HIJOS----------------------------
		
		panelTablaHijos = new JPanel();
		panelTablaHijos.setBackground(Color.lightGray);
		panelTablaHijos.setVisible(true);
		panelTablaHijos.setLayout(new FlowLayout());
		
		tablaHijos = new JTable(4,4);
		tablaHijos.setBackground(Color.lightGray);
		tablaHijos.setModel(model);	
		tablaHijos.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(tablaHijos);
		scrollPane.setBackground(Color.lightGray);
		panelTablaHijos.add(scrollPane);
		
		constraints.anchor = GridBagConstraints.EAST;
		constraints.gridx = 1;
		constraints.gridy = 9;
		constraints.gridheight = 3;
		constraints.fill = GridBagConstraints.BOTH;
		container.add(panelTablaHijos, constraints);
		
		//-----------------PANEL BOTONES CONFIRMAR/CANCELAR----------------------
		
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
		
		tipoCoberturaPopUpComboBox.addItem("RESPONSABILIDAD CIVIL");
		tipoCoberturaPopUpComboBox.addItem("RESPONSABILIDAD CIVIL, ROBO, INCENDIO TOTAL");
		tipoCoberturaPopUpComboBox.addItem("TODO TOTAL");
		tipoCoberturaPopUpComboBox.addItem("TERCEROS COMPLETO");
		tipoCoberturaPopUpComboBox.addItem("TODO RIESGO CON FRANQUICIA");
		
		formaPagoPopUpComboBox.addItem("MENSUAL");
		formaPagoPopUpComboBox.addItem("SEMESTRAL");
		
		panelPremioDescuento.add(tipoCoberturaPopUp);
		panelPremioDescuento.add(tipoCoberturaPopUpComboBox);
		panelPremioDescuento.add(fechaInicioPopUp);
		panelPremioDescuento.add(fechaInicioPopUpCalendar);
		panelPremioDescuento.add(formaPagoPopUp);
		panelPremioDescuento.add(formaPagoPopUpComboBox);
		
		confirmar.addActionListener(e -> {
			//setea fecha del proximo dia por defecto
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.DATE, +1);
			java.util.Date auxFecha = calendar.getTime();
			fechaInicioPopUpCalendar.setDate(auxFecha);
			
			int respuesta = JOptionPane.showConfirmDialog(this, panelPremioDescuento, "Tipo de cobertura y forma de pago", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			
			if(respuesta == 0) {
				java.util.Date auxFechaHijo = null;
				String auxSexoHijo;
				String auxEstadoHijo;
				
				for(int i=0; i < tablaHijos.getRowCount(); i++) {
					try {
						auxFechaHijo = formato.parse(tablaHijos.getValueAt(i, 1).toString());
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					auxSexoHijo = tablaHijos.getValueAt(i, 2).toString();
					auxEstadoHijo = tablaHijos.getValueAt(i, 3).toString();
					Hijo hijoAux = new Hijo(auxFechaHijo, auxSexoHijo, auxEstadoHijo);
					listaHijos.add(hijoAux);
				}
				
				String fechaInicioAux = formato.format(fechaInicioPopUpCalendar.getDate());
				String coberturaAux = tipoCoberturaPopUpComboBox.getSelectedItem().toString();
				String formaPagoAux = formaPagoPopUpComboBox.getSelectedItem().toString();
				
				if(garaje.isSelected() == true) {
					seguridad.add(true);
				} else {
					seguridad.add(false);
				}
				
				if(alarma.isSelected() == true) {
					seguridad.add(true);
				} else {
					seguridad.add(false);
				}
				
				if(rastreo.isSelected() == true) {
					seguridad.add(true);
				} else {
					seguridad.add(false);
				}
				
				if(tuercaAntirrobo.isSelected() == true) {
					seguridad.add(true);
				} else {
					seguridad.add(false);
				}
				
				new PolizaGenerar(
						cliente, 
						listaHijos, 
						marcaComboBox.getSelectedItem().toString(), 
						modeloComboBox.getSelectedItem().toString(), 
						anioComboBox.getSelectedItem().toString(),
						motorTxt.getText(), 
						chasisTxt.getText(), 
						patenteTxt.getText(),
						fechaInicioAux, 
						coberturaAux, 
						formaPagoAux, 
						sumaAseguradaTxt.getText(), 
						kmAnioComboBox.getSelectedItem().toString(), 
						siniestrosComboBox.getSelectedItem().toString(), 
						provinciaComboBox.getSelectedItem().toString(), 
						localidadComboBox.getSelectedItem().toString(),
						seguridad
						);
				frame.dispose();
			}
		});
		
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 10;
		constraints.gridwidth = 2;
		container.add(panelBotones, constraints);
				
		
	}
	
}
