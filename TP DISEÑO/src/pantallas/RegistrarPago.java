package pantallas;
//
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entidades.Cuota;
import entidades.EstadoCuota;
import entidades.Poliza;

public class RegistrarPago extends JFrame{
	
	private JPanel panelBuscar;
	private JPanel panelNroCliente;
	private JPanel panelNroPoliza;
	private JPanel panelApellido;
	private JPanel panelMarca;
	private JPanel panelPatente;
	private JPanel panelVigencia;
	private JPanel panelDesde;
	private JPanel panelCuotasPendientes;
	private JPanel panelTablaCuotasPendientes;
	private JPanel panelCuotasFuturas;
	private JPanel panelTablaCuotasFuturas;
	private JPanel panelBotones;
	private JTable tablaCuotasPendientes;
	private JTable tablaCuotasFuturas;
	private DateFormat formato = new SimpleDateFormat("dd/MM/yy");
	
	
	public RegistrarPago(Poliza poliza) {
		
		this.setTitle("Registrar pago de póliza");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setSize(450,675);
		this.setResizable(false);
		Container container = getContentPane();
		container.setLayout(new GridBagLayout());
		container.setBackground(Color.lightGray);
		GridBagConstraints constraints = new GridBagConstraints();
		
//---------------- DECLARACION DE COMPONENTES ---------------------	
		JTextArea nroCliente = new JTextArea("Nro. de cliente:");
		JTextArea nroPoliza = new JTextArea("Nro. de póliza: ");
		JTextArea apellido = new JTextArea("Apellido:           ");
		JTextArea nombre = new JTextArea("Nombre:");
		JTextArea marca = new JTextArea("Marca:              ");
		JTextArea modelo = new JTextArea("Modelo:  ");
		JTextArea patente = new JTextArea("Patente:           ");
		JTextArea vigencia = new JTextArea("Vigencia:");
		JTextArea desde = new JTextArea("Desde:             ");
		JTextArea hasta = new JTextArea("Hasta:    ");
		JTextArea pendientes = new JTextArea("Cuotas pendientes:");
		JTextArea futuras = new JTextArea("Cuotas futuras:");
		
		JButton buscar = new JButton("Buscar póliza");
		JButton abonar = new JButton("Abonar");
		JButton cancelar = new JButton("Cancelar");
		
		JTextField nroClienteTxt = new JTextField();
		JTextField nroPolizaTxt = new JTextField();
		JTextField apellidoTxt = new JTextField();
		JTextField nombreTxt = new JTextField();
		JTextField marcaTxt = new JTextField();
		JTextField modeloTxt = new JTextField();
		JTextField patenteTxt = new JTextField();
		JTextField desdeTxt = new JTextField();
		JTextField hastaTxt = new JTextField();
		
		nroCliente.setBackground(Color.lightGray);
		nroPoliza.setBackground(Color.lightGray);
		apellido.setBackground(Color.lightGray);
		nombre.setBackground(Color.lightGray);
		marca.setBackground(Color.lightGray);
		modelo.setBackground(Color.lightGray);
		patente.setBackground(Color.lightGray);
		vigencia.setBackground(Color.lightGray);
		desde.setBackground(Color.lightGray);
		hasta.setBackground(Color.lightGray);
		pendientes.setBackground(Color.lightGray);
		futuras.setBackground(Color.lightGray);
		
		nroClienteTxt.setEnabled(false);
		nroPolizaTxt.setEnabled(false);
		apellidoTxt.setEnabled(false);
		nombreTxt.setEnabled(false);
		marcaTxt.setEnabled(false);
		modeloTxt.setEnabled(false);
		patenteTxt.setEnabled(false);
		desdeTxt.setEnabled(false);
		hastaTxt.setEnabled(false);
//---------------- PANEL BUSCAR ---------------------
		panelBuscar = new JPanel();
		panelBuscar.setBackground(Color.lightGray);
		panelBuscar.setVisible(true);
		panelBuscar.setLayout(new FlowLayout());
		panelBuscar.add(buscar);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		container.add(panelBuscar, constraints);	
//---------------- PANEL NRO CLIENTE ---------------------
		panelNroCliente = new JPanel();
		panelNroCliente.setBackground(Color.lightGray);
		panelNroCliente.setVisible(true);
		panelNroCliente.setLayout(new FlowLayout());
		panelNroCliente.add(nroCliente);
		panelNroCliente.add(nroClienteTxt);
		nroClienteTxt.setColumns(10);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 2;
		container.add(panelNroCliente, constraints);	
//---------------- PANEL NRO POLIZA ---------------------
		panelNroPoliza = new JPanel();
		panelNroPoliza.setBackground(Color.lightGray);
		panelNroPoliza.setVisible(true);
		panelNroPoliza.setLayout(new FlowLayout());
		panelNroPoliza.add(nroPoliza);
		panelNroPoliza.add(nroPolizaTxt);
		nroPolizaTxt.setColumns(10);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 3;
		container.add(panelNroPoliza, constraints);	
//---------------- PANEL APELLIDO ---------------------
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
		constraints.gridy = 4;
		container.add(panelApellido, constraints);	
//---------------- PANEL MARCA ---------------------
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
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 5;
		container.add(panelMarca, constraints);	
//---------------- PANEL PATENTE ---------------------
		panelPatente = new JPanel();
		panelPatente.setBackground(Color.lightGray);
		panelPatente.setVisible(true);
		panelPatente.setLayout(new FlowLayout());
		panelPatente.add(patente);
		panelPatente.add(patenteTxt);
		patenteTxt.setColumns(10);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 6;
		container.add(panelPatente, constraints);	
//---------------- PANEL VIGENCIA ---------------------
		panelVigencia = new JPanel();
		panelVigencia.setBackground(Color.lightGray);
		panelVigencia.setVisible(true);
		panelVigencia.setLayout(new FlowLayout());
		panelVigencia.add(vigencia);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 7;
		container.add(panelVigencia, constraints);	
//---------------- PANEL DESDE  ---------------------
		panelDesde = new JPanel();
		panelDesde.setBackground(Color.lightGray);
		panelDesde.setVisible(true);
		panelDesde.setLayout(new FlowLayout());
		panelDesde.add(desde);
		panelDesde.add(desdeTxt);
		desdeTxt.setColumns(10);
		panelDesde.add(hasta);
		panelDesde.add(hastaTxt);
		hastaTxt.setColumns(10);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 8;
		container.add(panelDesde, constraints);	
//---------------- PANEL CUOTAS PENDIETES ---------------------
		panelCuotasPendientes = new JPanel();
		panelCuotasPendientes.setBackground(Color.lightGray);
		panelCuotasPendientes.setVisible(true);
		panelCuotasPendientes.setLayout(new FlowLayout());
		panelCuotasPendientes.add(pendientes);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 9;
		container.add(panelCuotasPendientes, constraints);	
//---------------- PANEL TABLA CUOTAS PENDIENTES ---------------------
		DefaultTableModel modeloTablaPendientes = new DefaultTableModel();
		modeloTablaPendientes.addColumn("Fecha");
		modeloTablaPendientes.addColumn("Valor Original");
		modeloTablaPendientes.addColumn("Valor Actual");
		
		panelTablaCuotasPendientes = new JPanel();
		panelTablaCuotasPendientes.setBackground(Color.lightGray);
		panelTablaCuotasPendientes.setVisible(true);
		panelTablaCuotasPendientes.setLayout(new FlowLayout());
		
		tablaCuotasPendientes = new JTable(3,3);
		tablaCuotasPendientes.setBackground(Color.lightGray);
		tablaCuotasPendientes.setModel(modeloTablaPendientes);
		tablaCuotasPendientes.setPreferredScrollableViewportSize(new Dimension(375,100));
		tablaCuotasPendientes.setFillsViewportHeight(true);
		JScrollPane scrollPanePendientes = new JScrollPane(tablaCuotasPendientes);
		scrollPanePendientes.setBackground(Color.lightGray);
		panelTablaCuotasPendientes.add(scrollPanePendientes);
		
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 10;
		container.add(panelTablaCuotasPendientes, constraints);
//---------------- PANEL CUOTAS FUTURAS---------------------
		panelCuotasFuturas = new JPanel();
		panelCuotasFuturas.setBackground(Color.lightGray);
		panelCuotasFuturas.setVisible(true);
		panelCuotasFuturas.setLayout(new FlowLayout());
		panelCuotasFuturas.add(futuras);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 11;
		container.add(panelCuotasFuturas, constraints);	
//---------------- PANEL TABLA CUOTAS FUTURAS ---------------------
		DefaultTableModel modeloTablaFuturas = new DefaultTableModel();
		modeloTablaFuturas.addColumn("Fecha");
		modeloTablaFuturas.addColumn("Valor Original");
		modeloTablaFuturas.addColumn("Valor Actual");
		
		panelTablaCuotasFuturas = new JPanel();
		panelTablaCuotasFuturas.setBackground(Color.lightGray);
		panelTablaCuotasFuturas.setVisible(true);
		panelTablaCuotasFuturas.setLayout(new FlowLayout());
		
		tablaCuotasFuturas = new JTable(3,3);
		tablaCuotasFuturas.setBackground(Color.lightGray);
		tablaCuotasFuturas.setModel(modeloTablaFuturas);
		tablaCuotasFuturas.setPreferredScrollableViewportSize(new Dimension(375,100));	
		tablaCuotasFuturas.setFillsViewportHeight(true);
		JScrollPane scrollPaneFuturas = new JScrollPane(tablaCuotasFuturas);
		scrollPaneFuturas.setBackground(Color.lightGray);
		panelTablaCuotasFuturas.add(scrollPaneFuturas);
		
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 12;
		container.add(panelTablaCuotasFuturas, constraints);
//---------------- PANEL BOTONES --------------------
		panelBotones = new JPanel();
		panelBotones.setBackground(Color.lightGray);
		panelBotones.setVisible(true);
		panelBotones.setLayout(new FlowLayout());
		panelBotones.add(abonar);
		panelBotones.add(cancelar);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 13;
		container.add(panelBotones, constraints);
//--------------FUNCIONAMIENTO PANTALLA--------------------------
		
		if(poliza.getNroPoliza() != null) {
			nroClienteTxt.setText(poliza.getCliente().getId());
			nroPolizaTxt.setText(poliza.getNroPoliza());
			apellidoTxt.setText(poliza.getCliente().getApellido());
			nombreTxt.setText(poliza.getCliente().getNombre());
			marcaTxt.setText(poliza.getVehiculo().getMarca().getMarca());
			modeloTxt.setText(poliza.getVehiculo().getModelo().getModelo());
			patenteTxt.setText(poliza.getPatente());
			desdeTxt.setText(formato.format(poliza.getFechaInicioVigencia()));
			hastaTxt.setText(formato.format(poliza.getFechaFinVigencia()));		
			
			Date fechaHoy = new Date();
			
			for(Cuota auxCuota : poliza.getCuotas()) {
				if(fechaHoy.after(auxCuota.getFechaVencimiento())) {
					if(auxCuota.getEstado() == EstadoCuota.IMPAGA) {
						float montoAux = Float.valueOf(auxCuota.getMontoFinal().substring(1,5)+"."+auxCuota.getMontoFinal().substring(6));
						String montoFinal = String.valueOf(montoAux*1.2);
						Object [] fila = {formato.format(auxCuota.getFechaVencimiento()), auxCuota.getMontoFinal(), "$"+montoFinal};
						modeloTablaPendientes.addRow(fila);
					}
				} else {
					if(auxCuota.getEstado() == EstadoCuota.IMPAGA) {
						float montoAux = Float.valueOf(auxCuota.getMontoFinal().substring(1,5)+"."+auxCuota.getMontoFinal().substring(6));
						String montoFinal = String.valueOf(montoAux*0.9);
						Object [] fila = {formato.format(auxCuota.getFechaVencimiento()), auxCuota.getMontoFinal(), "$"+montoFinal};
						modeloTablaFuturas.addRow(fila);
					}
				}
			}
		}
		
		buscar.addActionListener(e -> {
			new BuscarPoliza();
			this.dispose();
		});
		
		abonar.addActionListener(e -> {
			//IMPLEMENTAR
		});
		
		cancelar.addActionListener(e -> {
			new Menu();
			this.dispose();
		});

	}

}
