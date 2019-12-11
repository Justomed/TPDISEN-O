package pantallas;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import entidades.Cuota;
import entidades.Poliza;
import gestores.GestorPago;
import utility.FocusTextField;

public class FinalizarPago extends JFrame{
	
	private JPanel panelImporte;
	private JPanel panelMonto;
	private JPanel panelVuelto;
	private JPanel panelBotones;
	private JPanel panelBlanco;
	private JPanel panelBlanco1;
	private DecimalFormat formatoDecimal = new DecimalFormat("#.##");
	
	public FinalizarPago(ArrayList<Cuota> cuotasAbonadas, float montoTotal) {
		
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
		
		JTextArea importe = new JTextArea("Importe total:");
		JTextArea monto = new JTextArea("Monto:           ");
		JTextArea vuelto = new JTextArea("Vuelto:           ");
		JTextArea pagoEmitido = new JTextArea("PAGO EMITIDO");
		JButton emitir = new JButton("Emitir recibo de pago");
		JButton cancelar = new JButton("Cancelar");
		
		JFormattedTextField importeTxt =new JFormattedTextField("$ _ _ _. _ _ _. _ _ _, _ _ _");
		FocusTextField montoTxt = new FocusTextField();
		JFormattedTextField vueltoTxt = new JFormattedTextField("$ _ _ _. _ _ _. _ _ _, _ _ _");
		
		importe.setBackground(Color.lightGray);
		monto.setBackground(Color.lightGray);
		vuelto.setBackground(Color.lightGray);
		pagoEmitido.setBackground(Color.lightGray);
		pagoEmitido.setFont(new Font("Dialog", Font.BOLD, 14));
		montoTxt.setText("$ _ _ _. _ _ _. _ _ _, _ _ _");
		
		importeTxt.setEnabled(false);
		vueltoTxt.setEnabled(false);
//----------------PANEL IMPORTE ----------------------------------
    	panelImporte = new JPanel();
		panelImporte.setBackground(Color.lightGray);
		panelImporte.setVisible(true);
		panelImporte.setLayout(new FlowLayout());
		panelImporte.add(importe);
		panelImporte.add(importeTxt);
		importeTxt.setColumns(13);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 2;
		container.add(panelImporte, constraints);	
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
		constraints.gridy = 3;
		container.add(panelMonto, constraints);	
//----------------PANEL VUELTO ------------------------------------		
    	panelVuelto = new JPanel();
		panelVuelto.setBackground(Color.lightGray);
		panelVuelto.setVisible(true);
		panelVuelto.setLayout(new GridBagLayout());
		GridBagConstraints constraintsVuelto = new GridBagConstraints();
		
		constraintsVuelto.gridx = 0;
		constraintsVuelto.gridy = 1;
		panelVuelto.add(vuelto, constraintsVuelto);
		
		constraintsVuelto.gridx = 1;
		constraintsVuelto.gridy = 1;
		panelVuelto.add(vueltoTxt, constraintsVuelto);
		
		constraintsVuelto.gridx = 0;
		constraintsVuelto.gridy = 0;
		constraintsVuelto.gridwidth = 2;
		constraintsVuelto.anchor = GridBagConstraints.CENTER;
		panelVuelto.add(pagoEmitido, constraintsVuelto);		
		vueltoTxt.setColumns(13);
//----------------PANEL BLANCO --------------------------------------
		panelBlanco = new JPanel();
		panelBlanco.setBackground(Color.lightGray);
		panelBlanco.setVisible(true);
		panelBlanco.setLayout(new FlowLayout());
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 5;
		container.add(panelBlanco, constraints);
//----------------PANEL BLANCO 1--------------------------------------
		panelBlanco1 = new JPanel();
		panelBlanco1.setBackground(Color.lightGray);
		panelBlanco1.setVisible(true);
		panelBlanco1.setLayout(new FlowLayout());
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 6;
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
		constraints.gridy = 7;
		container.add(panelBotones, constraints);	
//------------------FUNCIONAMIENTO PANTALLA--------------------------
		
		importeTxt.setText("$"+formatoDecimal.format(montoTotal));
		
		emitir.addActionListener(e -> {
			GestorPago gestorPago = new GestorPago();
			gestorPago.guardarPago(cuotasAbonadas, montoTotal);
			
			vueltoTxt.setText("$"+formatoDecimal.format((Float.valueOf(montoTxt.getText()) - montoTotal)));
			JOptionPane.showMessageDialog(this, panelVuelto, "Pago emitido", JOptionPane.PLAIN_MESSAGE);
			
			new Menu();
			this.dispose();
		});
		
		cancelar.addActionListener(e -> {
			
			int respuesta = JOptionPane.showConfirmDialog(this, "¿Desea cancelar el pago?");
			if(respuesta == 0) {
				new RegistrarPago(new Poliza());
				this.dispose();
			}
		});

	}

}
