package PJusto;

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
import javax.swing.JTextField;

public class RegistroSistema extends JFrame{
	
	private JPanel panelAsegurado;
	private JPanel panelIngreso;
	private JPanel panelUser;
	private JPanel panelPass;
	private JPanel panelBotones;
	private JPanel panelBlanco1;
	private JPanel panelBlanco2;
	private JPanel panelBlanco3;

	
	public RegistroSistema() {
		
		this.setTitle("Empresa aseguradora");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setSize(600,400);
		this.setResizable(false);
		Container container = getContentPane();
		container.setLayout(new GridBagLayout());
		container.setBackground(Color.lightGray);
		GridBagConstraints constraints = new GridBagConstraints();
		
//---------------- DECLARACION DE COMPONENTES ---------------------		
		JTextField userTxt = new JTextField();
		JTextField passTxt = new JTextField();
		
		JTextArea empresaTitulo = new JTextArea("EL ASEGURADO");
		JTextArea ingresoTitulo = new JTextArea("Ingresar al sistema:");	
		JTextArea user = new JTextArea("Usuario:       ");
		JTextArea pass = new JTextArea("Contraseña:");
		
		JButton ingresar = new JButton("Ingresar");
		JButton salir = new JButton("Salir");
		
		empresaTitulo.setFont(new Font("Dialog", Font.BOLD, 50));
		empresaTitulo.setBackground(Color.lightGray);
		ingresoTitulo.setFont(new Font("Dialog", Font.BOLD, 20));
		ingresoTitulo.setBackground(Color.lightGray);
		user.setBackground(Color.lightGray);
		pass.setBackground(Color.lightGray);
//----------------PANEL ASEGURADO ------------------------------------		
		panelAsegurado = new JPanel();
		panelAsegurado.setBackground(Color.lightGray);
		panelAsegurado.setVisible(true);
		panelAsegurado.setLayout(new FlowLayout());
		panelAsegurado.add(empresaTitulo);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 2;
		container.add(panelAsegurado, constraints);
//----------------PANEL BLANCO 1------------------------------------		
		panelBlanco1 = new JPanel();
		panelBlanco1.setBackground(Color.lightGray);
		panelBlanco1.setVisible(true);
		panelBlanco1.setLayout(new FlowLayout());
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 3;
		container.add(panelBlanco1, constraints);
//----------------PANEL BLANCO 2------------------------------------		
		panelBlanco2 = new JPanel();
		panelBlanco2.setBackground(Color.lightGray);
		panelBlanco2.setVisible(true);
		panelBlanco2.setLayout(new FlowLayout());
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 4;
		container.add(panelBlanco2, constraints);	
//----------------PANEL INGRESO ------------------------------------		
		panelIngreso = new JPanel();
		panelIngreso.setBackground(Color.lightGray);
		panelIngreso.setVisible(true);
		panelIngreso.setLayout(new FlowLayout());
		panelIngreso.add(ingresoTitulo);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 5;
		container.add(panelIngreso, constraints);		
//----------------PANEL USER ------------------------------------		
		panelUser = new JPanel();
		panelUser.setBackground(Color.lightGray);
		panelUser.setVisible(true);
		panelUser.setLayout(new FlowLayout());
		panelUser.add(user);
		panelUser.add(userTxt);
		userTxt.setColumns(10);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 6;
		container.add(panelUser, constraints);	
//----------------PANEL PASS ------------------------------------		
		panelPass = new JPanel();
		panelPass.setBackground(Color.lightGray);
		panelPass.setVisible(true);
		panelPass.setLayout(new FlowLayout());
		panelPass.add(pass);
		panelPass.add(passTxt);
		passTxt.setColumns(10);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 7;
		container.add(panelPass, constraints);	
//----------------PANEL BLANCO 3------------------------------------		
		panelBlanco3 = new JPanel();
		panelBlanco3.setBackground(Color.lightGray);
		panelBlanco3.setVisible(true);
		panelBlanco3.setLayout(new FlowLayout());
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 8;
		container.add(panelBlanco3, constraints);			
//----------------PANEL BOTONES ------------------------------------		
		panelBotones = new JPanel();
		panelBotones.setBackground(Color.lightGray);
		panelBotones.setVisible(true);
		panelBotones.setLayout(new FlowLayout());
		panelBotones.add(ingresar);
		panelBotones.add(salir);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 9;
		container.add(panelBotones, constraints);	
	}

}
	