package PJusto;
//
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
//
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ConfirmarPremio extends JFrame{
	
	private JPanel panelPremio;
	private JPanel panelTotal;
	private JPanel panelBotones;
	private JPanel panelBlanco;
	private JPanel panelBlanco1;
	
	public ConfirmarPremio() {
		
		this.setTitle("Confirmar premio - descuentos");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(300,250);
		this.setResizable(false);
		Container container = getContentPane();
		container.setLayout(new GridBagLayout());
		container.setBackground(Color.lightGray);
		GridBagConstraints constraints = new GridBagConstraints();	
		
//---------------- DECLARACION DE COMPONENTES ---------------------		
	
		JTextArea premio = new JTextArea("Premio:                ");
		JTextArea descuentoTotal = new JTextArea("Descuento total:");
		JButton confirmar = new JButton("Confirmar");
		JButton volver = new JButton("Volver");
			
		JFormattedTextField premioTxt =new JFormattedTextField("$ _ _ _ _, _ _");
		JFormattedTextField descuentoTotalTxt = new JFormattedTextField("$ _ _ _ _, _ _");
				
		premio.setBackground(Color.lightGray);
		descuentoTotal.setBackground(Color.lightGray);	
	
//---------------- PANEL PREMIO ---------------------
    	panelPremio = new JPanel();
		panelPremio.setBackground(Color.lightGray);
		panelPremio.setVisible(true);
		panelPremio.setLayout(new FlowLayout());
		panelPremio.add(premio);
		panelPremio.add(premioTxt);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 2;
		container.add(panelPremio, constraints);	
//---------------- PANEL DESCUENTO ---------------------
    	panelTotal = new JPanel();
		panelTotal.setBackground(Color.lightGray);
		panelTotal.setVisible(true);
		panelTotal.setLayout(new FlowLayout());
		panelTotal.add(descuentoTotal);
		panelTotal.add(descuentoTotalTxt);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 3;
		container.add(panelTotal, constraints);
//---------------- PANEL BLANCO ---------------------
    	panelBlanco = new JPanel();
		panelBlanco.setBackground(Color.lightGray);
		panelBlanco.setVisible(true);
		panelBlanco.setLayout(new FlowLayout());
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 4;
		container.add(panelBlanco, constraints);
//---------------- PANEL BLANCO ---------------------
    	panelBlanco1 = new JPanel();
		panelBlanco1.setBackground(Color.lightGray);
		panelBlanco1.setVisible(true);
		panelBlanco1.setLayout(new FlowLayout());
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 5;
		container.add(panelBlanco1, constraints);
//---------------- PANEL BOTONES ---------------------
		panelBotones = new JPanel();
		panelBotones.setBackground(Color.lightGray);
		panelBotones.setVisible(true);
		panelBotones.setLayout(new FlowLayout());
		panelBotones.add(confirmar);
		panelBotones.add(volver);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 6;
		container.add(panelBotones, constraints);
	}

}
