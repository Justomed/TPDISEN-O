package PJusto;
//
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Menu extends JFrame{
	
	private JPanel panelTituloMenu;
	private JPanel panelGestionPoliza;
	private JPanel panelDarAlta;
	private JPanel panelConsultar;
	private JPanel panelRegistrarPago;
	private JPanel panelGenerarListado;
	private JPanel panelGenerarInforme;
	private JPanel panelGestionCliente;
	private JPanel panelBuscar;
	private JPanel panelBoton;
	private JPanel panelBlanco1;
	
	public Menu() {
		
		this.setTitle("El asegurado");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setSize(600,450);
		this.setResizable(false);
		Container container = getContentPane();
		container.setLayout(new GridBagLayout());
		container.setBackground(Color.lightGray);
		GridBagConstraints constraints = new GridBagConstraints();
		
//---------------- DECLARACION DE COMPONENTES ---------------------			
		JTextArea menuTitulo = new JTextArea("Menú");
		
		JTextArea gestionPoliza = new JTextArea("Gestión de polizas --------------------------------------------");
		JTextArea gestionCliente = new JTextArea("Gestion de clientes -------------------------------------------");
		
		JButton darAlta = new JButton("                         Dar de alta póliza                         ");
		JButton consultar = new JButton("                          Consultar póliza                          ");
		JButton registrar = new JButton("                  Registrar pago de póliza                   ");
		JButton generar = new JButton("Generar listado de propuesta de renovacion");
		JButton generarInfo = new JButton("     Generar informe de resultado mensual     ");
		JButton buscar = new JButton("                           Buscar cliente                             ");
		JButton salir = new JButton("Salir"); 
		
		menuTitulo.setFont(new Font("Dialog", Font.BOLD, 25));
		menuTitulo.setBackground(Color.lightGray);
		gestionPoliza.setBackground(Color.lightGray);
		gestionCliente.setBackground(Color.lightGray);
		
//----------------PANEL TITULO MENU ------------------------------------		
		panelTituloMenu = new JPanel();
		panelTituloMenu.setBackground(Color.lightGray);
		panelTituloMenu.setVisible(true);
		panelTituloMenu.setLayout(new FlowLayout());
		panelTituloMenu.add(menuTitulo);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 2;
		container.add(panelTituloMenu, constraints);	
//----------------PANEL GESTION POLIZA ------------------------------------		
		panelGestionPoliza = new JPanel();
		panelGestionPoliza.setBackground(Color.lightGray);
		panelGestionPoliza.setVisible(true);
		panelGestionPoliza.setLayout(new FlowLayout());
		panelGestionPoliza.add(gestionPoliza);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 3;
		container.add(panelGestionPoliza, constraints);	
//----------------PANEL DAR ALTA ------------------------------------		
		panelDarAlta = new JPanel();
		panelDarAlta.setBackground(Color.lightGray);
		panelDarAlta.setVisible(true);
		panelDarAlta.setLayout(new FlowLayout());
		panelDarAlta.add(darAlta);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 4;
		container.add(panelDarAlta, constraints);	
//----------------PANEL CONSULTAR ------------------------------------		
		panelConsultar = new JPanel();
		panelConsultar.setBackground(Color.lightGray);
		panelConsultar.setVisible(true);
		panelConsultar.setLayout(new FlowLayout());
		panelConsultar.add(consultar);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 5;
		container.add(panelConsultar, constraints);	
//----------------PANEL REGISTRAR PAGO ------------------------------------		
		panelRegistrarPago = new JPanel();
		panelRegistrarPago.setBackground(Color.lightGray);
		panelRegistrarPago.setVisible(true);
		panelRegistrarPago.setLayout(new FlowLayout());
		panelRegistrarPago.add(registrar);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 6;
		container.add(panelRegistrarPago, constraints);	
//----------------PANEL GENERAR LISTADO ------------------------------------		
		panelGenerarListado = new JPanel();
		panelGenerarListado.setBackground(Color.lightGray);
		panelGenerarListado.setVisible(true);
		panelGenerarListado.setLayout(new FlowLayout());
		panelGenerarListado.add(generar);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 7;
		container.add(panelGenerarListado, constraints);	
//----------------PANEL GENERAR INFORME ------------------------------------		
		panelGenerarInforme = new JPanel();
		panelGenerarInforme.setBackground(Color.lightGray);
		panelGenerarInforme.setVisible(true);
		panelGenerarInforme.setLayout(new FlowLayout());
		panelGenerarInforme.add(generarInfo);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 8;
		container.add(panelGenerarInforme, constraints);	
//----------------PANEL GESTION CLIENTE ------------------------------------		
		panelGestionCliente = new JPanel();
		panelGestionCliente.setBackground(Color.lightGray);
		panelGestionCliente.setVisible(true);
		panelGestionCliente.setLayout(new FlowLayout());
		panelGestionCliente.add(gestionCliente);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 9;
		container.add(panelGestionCliente, constraints);	
//----------------PANEL BUSCAR ------------------------------------		
		panelBuscar = new JPanel();
		panelBuscar.setBackground(Color.lightGray);
		panelBuscar.setVisible(true);
		panelBuscar.setLayout(new FlowLayout());
		panelBuscar.add(buscar);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 10;
		container.add(panelBuscar, constraints);
//----------------PANEL BLANCO 1 ------------------------------------		
		panelBlanco1 = new JPanel();
		panelBlanco1.setBackground(Color.lightGray);
		panelBlanco1.setVisible(true);
		panelBlanco1.setLayout(new FlowLayout());
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 11;
		container.add(panelBlanco1, constraints);
//----------------PANEL BLANCO 2 ------------------------------------		
		panelBlanco1 = new JPanel();
		panelBlanco1.setBackground(Color.lightGray);
		panelBlanco1.setVisible(true);
		panelBlanco1.setLayout(new FlowLayout());
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 12;
		container.add(panelBlanco1, constraints);
//----------------PANEL BOTON ------------------------------------		
		panelBoton = new JPanel();
		panelBoton.setBackground(Color.lightGray);
		panelBoton.setVisible(true);
		panelBoton.setLayout(new FlowLayout());
		panelBoton.add(salir);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 13;
		container.add(panelBoton, constraints);
		
//---------------FUNCIONAMIENTO DE LA PANTALLA--------------------------
		darAlta.addActionListener(e -> {
			//FALTA INVOCAR LA PANTALLA
		});
		
		consultar.addActionListener(e -> {
			new BuscarPoliza("menu");
			this.dispose();
		});
		
		registrar.addActionListener(e -> {
			new RegistrarPago();
			this.dispose();
		});
		
		generar.setEnabled(false);
		
		generarInfo.addActionListener(e -> {
			new GenerarInforme();
			this.dispose();
		});
		
		buscar.addActionListener(e -> {
			//FALTA INVOCAR PANTALLA
		});
		
		salir.addActionListener(e -> {
			new RegistroSistema();
			this.dispose();
		});
	}
}
