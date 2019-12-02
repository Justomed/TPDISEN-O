package PJusto;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ConfirmarPago extends JFrame{
	
	private JPanel panelImporte;
	private JPanel panelBotones;
	private JPanel panelTablaCuotas;
	private JTable tablaCuotas;
	private JPanel panelBlanco;
	private JPanel panelBlanco1;
	
	
	public ConfirmarPago() {
		
		this.setTitle("Confirmar pago de póliza");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(500,300);
		this.setResizable(false);
		Container container = getContentPane();
		container.setLayout(new GridBagLayout());
		container.setBackground(Color.lightGray);
		GridBagConstraints constraints = new GridBagConstraints();
		
//---------------- DECLARACION DE COMPONENTES ---------------------		

		JFormattedTextField importeTxt = new JFormattedTextField("$ _ _. _ _ _, _ _ _");
		
		JTextArea importe = new JTextArea("Importe total:");

		JButton continuar = new JButton("Continuar");
		JButton editar = new JButton("Editar");
		JButton salir = new JButton("Salir");
		
		importe.setBackground(Color.lightGray);
//----------------PANEL TABLA ------------------------------------		
		DefaultTableModel modeloTablaFuturas = new DefaultTableModel();
		
		modeloTablaFuturas.addColumn("Fecha");
		modeloTablaFuturas.addColumn("Importe parcial");

		panelTablaCuotas = new JPanel();
		panelTablaCuotas.setBackground(Color.lightGray);
		panelTablaCuotas.setVisible(true);
		panelTablaCuotas.setLayout(new FlowLayout());
		
		tablaCuotas = new JTable(2,2);
		tablaCuotas.setBackground(Color.lightGray);
		tablaCuotas.setModel(modeloTablaFuturas);
		tablaCuotas.setPreferredScrollableViewportSize(new Dimension(375,100));	
		tablaCuotas.setFillsViewportHeight(true);
		JScrollPane scrollPaneFuturas = new JScrollPane(tablaCuotas);
		scrollPaneFuturas.setBackground(Color.lightGray);
		panelTablaCuotas.add(scrollPaneFuturas);
		
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		container.add(panelTablaCuotas, constraints);
//----------------PANEL BLANCO --------------------------------------
		panelBlanco = new JPanel();
		panelBlanco.setBackground(Color.lightGray);
		panelBlanco.setVisible(true);
		panelBlanco.setLayout(new FlowLayout());
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 2;
		container.add(panelBlanco, constraints);

//----------------PANEL IMPORTE ------------------------------------		
		panelImporte = new JPanel();
		panelImporte.setBackground(Color.lightGray);
		panelImporte.setVisible(true);
		panelImporte.setLayout(new FlowLayout());
		panelImporte.add(importe);
		panelImporte.add(importeTxt);
		importeTxt.setColumns(9);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 3;
		container.add(panelImporte, constraints);	

	
//----------------PANEL BLANCO 1--------------------------------------
		panelBlanco1 = new JPanel();
		panelBlanco1.setBackground(Color.lightGray);
		panelBlanco1.setVisible(true);
		panelBlanco1.setLayout(new FlowLayout());
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 5;
		container.add(panelBlanco1, constraints);
//----------------PANEL BOTONES ------------------------------------
		panelBotones = new JPanel();
		panelBotones.setBackground(Color.lightGray);
		panelBotones.setVisible(true);
		panelBotones.setLayout(new FlowLayout());
		panelBotones.add(continuar);
		panelBotones.add(editar);
		panelBotones.add(salir);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 6;
		container.add(panelBotones, constraints);		
		
	}
	
}
