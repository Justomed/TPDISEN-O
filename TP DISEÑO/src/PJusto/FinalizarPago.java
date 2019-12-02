package PJusto;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class FinalizarPago extends JFrame{
	
	private JPanel panelMonto;
	private JPanel panelVuelto;
	private JPanel panelBotones;
	private JPanel panelBlanco;
	private JPanel panelBlanco1;
	
	public FinalizarPago() {
		
		this.setTitle("Finalizar pago de póliza");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(500,300);
		this.setResizable(false);
		Container container = getContentPane();
		container.setLayout(new GridBagLayout());
		container.setBackground(Color.lightGray);
		GridBagConstraints constraints = new GridBagConstraints();	
//---------------- DECLARACION DE COMPONENTES ---------------------		
		
		JTextArea monto = new JTextArea("Monto:");
		JTextArea vuelto = new JTextArea("Vuelto:");
		JButton emitir = new JButton("Emitir recibo de pago");
		JButton cancelar = new JButton("Cancelar");
		
		JFormattedTextField montoTxt = new JFormattedTextField("$ _ _ _. _ _ _. _ _ _, _ _ _");
		JFormattedTextField vueltoTxt = new JFormattedTextField("$ _ _ _. _ _ _. _ _ _, _ _ _");
		
		monto.setBackground(Color.lightGray);	
		vuelto.setBackground(Color.lightGray);	
//----------------PANEL MONTO ------------------------------------		
    	panelMonto = new JPanel();
		panelMonto.setBackground(Color.lightGray);
		panelMonto.setVisible(true);
		panelMonto.setLayout(new FlowLayout());
		panelMonto.add(monto);
		panelMonto.add(montoTxt);
		montoTxt.setColumns(13);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 2;
		container.add(panelMonto, constraints);	
//----------------PANEL MONTO ------------------------------------		
    	panelVuelto = new JPanel();
		panelVuelto.setBackground(Color.lightGray);
		panelVuelto.setVisible(true);
		panelVuelto.setLayout(new FlowLayout());
		panelVuelto.add(vuelto);
		panelVuelto.add(vueltoTxt);
		vueltoTxt.setColumns(13);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 3;
		container.add(panelVuelto, constraints);
//----------------PANEL BLANCO --------------------------------------
		panelBlanco = new JPanel();
		panelBlanco.setBackground(Color.lightGray);
		panelBlanco.setVisible(true);
		panelBlanco.setLayout(new FlowLayout());
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 4;
		container.add(panelBlanco, constraints);
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
    	panelBotones.add(emitir);
		panelBotones.add(cancelar);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 6;
		container.add(panelBotones, constraints);				
	}

}
