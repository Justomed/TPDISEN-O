package pantallas;
//
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import gestores.GestorBD;
import gestores.GestorPoliza;

public class GenerarInforme extends JFrame {

	private JPanel panelTitulo;
	private JPanel panelMes;
	private JPanel panelConfirmar;
	private JPanel panelTotalMora;
	private JPanel panelMontoMora;
	private JPanel panelTotalDia;
	private JPanel panelMontoAtrasadas;
	private JPanel panelMontoAdelantadas;
	private JPanel panelMontoDia;
	private JPanel panelBotones;
	private int mesAux=0;
	
	public GenerarInforme() {
		
		this.setTitle("Generar informe mensual");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setSize(450,400);
		this.setResizable(false);
		Container container = getContentPane();
		container.setLayout(new GridBagLayout());
		container.setBackground(Color.lightGray);
		GridBagConstraints constraints = new GridBagConstraints();
		
//---------------- DECLARACION DE COMPONENTES ---------------------	
		
		JTextArea mes = new JTextArea("Mes:");
		JTextArea anio = new JTextArea("Año:");
		JTextArea totalMora = new JTextArea("Total de clientes en mora:                               ");
		JTextArea montoMora = new JTextArea("Monto total de la mora:                                    ");
		JTextArea totalDia = new JTextArea("Total de clientes al día:                                    ");
		JTextArea montoAtrasadas = new JTextArea("Monto recaudado en cuotas atrasadas:          ");
		JTextArea montoAdelantadas = new JTextArea("Monto recaudado en cuotas adelantadas:      ");
		JTextArea montoDia = new JTextArea("Monto recaudado en cuotas al día:                  ");
		JTextArea titulo = new JTextArea("Seleccione mes y año:");
		
		JButton confirmar = new JButton("Confirmar");
		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");
		
		JComboBox mesComboBox = new JComboBox();
		JComboBox anioComboBox = new JComboBox();
		
		JTextField totalMoraTxt = new JTextField();
		JTextField montoMoraTxt = new JTextField();
		JTextField totalDiaTxt = new JTextField();
		JTextField montoAtrasadasTxt = new JTextField();
		JTextField montoAdelantadasTxt = new JTextField();
		JTextField montoDiaTxt = new JTextField();
		
		mes.setBackground(Color.lightGray);
		anio.setBackground(Color.lightGray);
		totalMora.setBackground(Color.lightGray);
		montoMora.setBackground(Color.lightGray);
		totalDia.setBackground(Color.lightGray);
		montoAtrasadas.setBackground(Color.lightGray);
		montoAdelantadas.setBackground(Color.lightGray);
		montoDia.setBackground(Color.lightGray);
		titulo.setFont(new Font("Dialog", Font.BOLD, 15));
		titulo.setBackground(Color.lightGray);
		
		totalMoraTxt.setEnabled(false);
		montoMoraTxt.setEnabled(false);
		totalDiaTxt.setEnabled(false);
		montoAtrasadasTxt.setEnabled(false);
		montoAdelantadasTxt.setEnabled(false);
		montoDiaTxt.setEnabled(false);
//---------------- PANEL TITULO ---------------------
		panelTitulo = new JPanel();
		panelTitulo.setBackground(Color.lightGray);
		panelTitulo.setVisible(true);
		panelTitulo.setLayout(new FlowLayout());
		panelTitulo.add(titulo);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 2;
		container.add(panelTitulo, constraints);	
//---------------- PANEL MES ---------------------
		panelMes = new JPanel();
		panelMes.setBackground(Color.lightGray);
		panelMes.setVisible(true);
		panelMes.setLayout(new FlowLayout());
		panelMes.add(mes);
		
		mesComboBox.addItem("ENERO");
		mesComboBox.addItem("FEBRERO");
		mesComboBox.addItem("MARZO");
		mesComboBox.addItem("ABRIL");
		mesComboBox.addItem("MAYO");
		mesComboBox.addItem("JUNIO");
		mesComboBox.addItem("JULIO");
		mesComboBox.addItem("AGOSTO");
		mesComboBox.addItem("SEPTIEMBRE");
		mesComboBox.addItem("OCTUBRE");
		mesComboBox.addItem("NOVIEMBRE");
		mesComboBox.addItem("DICIEMBRE");
		
		Date dateAux = new Date();
		LocalDate fechaHoyAux = dateAux.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		
		switch(fechaHoyAux.getMonthValue()) {
		case 1:
			mesComboBox.setSelectedIndex(11);
			break;
		case 2:
			mesComboBox.setSelectedIndex(0);
			break;
		case 3:
			mesComboBox.setSelectedIndex(1);
			break;
		case 4:
			mesComboBox.setSelectedIndex(2);
			break;
		case 5:
			mesComboBox.setSelectedIndex(3);
			break;
		case 6:
			mesComboBox.setSelectedIndex(4);
			break;
		case 7:
			mesComboBox.setSelectedIndex(5);
			break;
		case 8:
			mesComboBox.setSelectedIndex(6);
			break;
		case 9:
			mesComboBox.setSelectedIndex(7);
			break;
		case 10:
			mesComboBox.setSelectedIndex(8);
			break;
		case 11:
			mesComboBox.setSelectedIndex(9);
			break;
		case 12:
			mesComboBox.setSelectedIndex(10);
			break;
		}
		
		panelMes.add(mesComboBox);
		panelMes.add(anio);
		
		anioComboBox.addItem("2020");
		anioComboBox.addItem("2019");
		anioComboBox.addItem("2018");
		
		switch(fechaHoyAux.getMonthValue()) {
		case 1:
			switch(fechaHoyAux.getYear()) {
			case 2019:
				anioComboBox.setSelectedIndex(2);
				break;
			case 2020:
				anioComboBox.setSelectedIndex(1);
				break;
			}
			break;
		default:
			switch(fechaHoyAux.getYear()) {
			case 2018:
				anioComboBox.setSelectedIndex(0);
				break;
			case 2019:
				anioComboBox.setSelectedIndex(1);
				break;
			case 2020:
				anioComboBox.setSelectedIndex(2);
				break;
			}
			break;
		}
		
		panelMes.add(anioComboBox);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 4;
		container.add(panelMes, constraints);
//---------------- PANEL CONFIRMAR ---------------------	
		panelConfirmar = new JPanel();
		panelConfirmar.setBackground(Color.lightGray);
		panelConfirmar.setVisible(true);
		panelConfirmar.setLayout(new FlowLayout());
		panelConfirmar.add(confirmar);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 5;
		container.add(panelConfirmar, constraints);
//---------------- PANEL TOTAL MORA ---------------------	
		panelTotalMora = new JPanel();
		panelTotalMora.setBackground(Color.lightGray);
		panelTotalMora.setVisible(true);
		panelTotalMora.setLayout(new FlowLayout());
		panelTotalMora.add(totalMora);
		panelTotalMora.add(totalMoraTxt);
		totalMoraTxt.setColumns(10);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 6;
		container.add(panelTotalMora, constraints);
//---------------- PANEL MONTO MORA ---------------------	
		panelMontoMora = new JPanel();
		panelMontoMora.setBackground(Color.lightGray);
		panelMontoMora.setVisible(true);
		panelMontoMora.setLayout(new FlowLayout());
		panelMontoMora.add(montoMora);
		panelMontoMora.add(montoMoraTxt);
		montoMoraTxt.setColumns(10);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 7;
		container.add(panelMontoMora, constraints);
//---------------- PANEL TOTAL DIA ---------------------	
		panelTotalDia = new JPanel();
		panelTotalDia.setBackground(Color.lightGray);
		panelTotalDia.setVisible(true);
		panelTotalDia.setLayout(new FlowLayout());
		panelTotalDia.add(totalDia);
		panelTotalDia.add(totalDiaTxt);
		totalDiaTxt.setColumns(10);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 8;
		container.add(panelTotalDia, constraints);
//---------------- PANEL MONTO ATRASADAS ---------------------
		panelMontoAtrasadas = new JPanel();
		panelMontoAtrasadas.setBackground(Color.lightGray);
		panelMontoAtrasadas.setVisible(true);
		panelMontoAtrasadas.setLayout(new FlowLayout());
		panelMontoAtrasadas.add(montoAtrasadas);
		panelMontoAtrasadas.add(montoAtrasadasTxt);
		montoAtrasadasTxt.setColumns(10);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 9;
		container.add(panelMontoAtrasadas, constraints);
//---------------- PANEL MONTO ADELANTADAS ---------------------	
		panelMontoAdelantadas = new JPanel();
		panelMontoAdelantadas.setBackground(Color.lightGray);
		panelMontoAdelantadas.setVisible(true);
		panelMontoAdelantadas.setLayout(new FlowLayout());
		panelMontoAdelantadas.add(montoAdelantadas);
		panelMontoAdelantadas.add(montoAdelantadasTxt);
		montoAdelantadasTxt.setColumns(10);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 10;
		container.add(panelMontoAdelantadas, constraints);
//---------------- PANEL MONTO DIA ---------------------	
		panelMontoDia = new JPanel();
		panelMontoDia.setBackground(Color.lightGray);
		panelMontoDia.setVisible(true);
		panelMontoDia.setLayout(new FlowLayout());
		panelMontoDia.add(montoDia);
		panelMontoDia.add(montoDiaTxt);
		montoDiaTxt.setColumns(10);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 11;
		container.add(panelMontoDia, constraints);
//---------------- PANEL BOTONES ---------------------	
		panelBotones = new JPanel();
		panelBotones.setBackground(Color.lightGray);
		panelBotones.setVisible(true);
		panelBotones.setLayout(new FlowLayout());
		panelBotones.add(aceptar);
		panelBotones.add(cancelar);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 12;
		container.add(panelBotones, constraints);
//--------------FUNCIONAMIENTO PANTALLA------------------
		confirmar.addActionListener(e -> {
			GestorPoliza gestorPoliza = new GestorPoliza();
			
			ArrayList<String> informe = gestorPoliza.generarInformeMensual((String) mesComboBox.getSelectedItem(), (String) anioComboBox.getSelectedItem());
			
			totalMoraTxt.setText(informe.get(0));
			montoMoraTxt.setText(informe.get(1));
			totalDiaTxt.setText(informe.get(2));
			montoAtrasadasTxt.setText(informe.get(3));
			montoAdelantadasTxt.setText(informe.get(4));
			montoDiaTxt.setText(informe.get(5));
		});
		
		aceptar.addActionListener(e -> {
			JOptionPane.showMessageDialog(this, "SE IMPRIMIO EL INFORME");
		});
		
		cancelar.addActionListener(e -> {
			new Menu();
			this.dispose();
		});
	}
	

}
