package pantallas;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PolizaGenerar extends JFrame{
	
	private JPanel panelDatos;
	private JPanel panelBotones;
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
	private JPanel panelBlanco31;
	private JPanel panelBlanco32;
	private JPanel panelBlanco33;
	private JPanel panelBlanco34;
	private JPanel panelBlanco35;
	private JPanel panelBlanco36;
	private JPanel panelBlanco37;
	private JPanel panelBlanco38;
	private JPanel panelBlanco39;
	private JPanel panelBlanco40;
	private JPanel panelBlanco41;
	private JPanel panelBlanco42;
	private JPanel panelBlanco43;
	private JPanel panelBlanco44;
	private JPanel panelBlanco45;
	private JPanel panelBlanco46;
	private JPanel panelBlanco47;
	private JPanel panelBlanco48;
	private JPanel panelBlanco49;
	private JPanel panelBlanco50;
	private JPanel panelBlanco51;
	private JPanel panelBlanco52;
	private JPanel panelBlanco53;
	private JPanel panelBlanco54;
	private JPanel panelBlanco55;
	private JPanel panelBlanco56;
	private JFrame frame=this;
	
	public PolizaGenerar() {
		
		this.setTitle("Poliza a generar");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setSize(1500,600);
		this.setResizable(false);
		Container container = getContentPane();
		container.setLayout(new GridBagLayout());
		container.setBackground(Color.lightGray);
		GridBagConstraints constraints = new GridBagConstraints();
			
		JTextField apellidoTxt = new JTextField();
		JTextField nombreTxt = new JTextField();
		JTextField marcaTxt = new JTextField();
		JTextField modeloTxt = new JTextField();
		JTextField motorTxt = new JTextField();
		JTextField chasisTxt = new JTextField();
		JTextField patenteTxt = new JTextField();
		JTextField inicioTxt = new JTextField();
		JTextField finTxt = new JTextField();
		JTextField sumaAseguradaTxt = new JTextField();
		JTextField premioTxt = new JTextField();
		JTextField importeDescuentoTxt = new JTextField();
		JTextField diaPagoTxt = new JTextField();
		JTextField montoTotalTxt = new JTextField();
		JTextField importeCuotaTxt = new JTextField();
		
		JTextArea apellido = new JTextArea("Apellido:");
		JTextArea nombre = new JTextArea("Nombre:");
		JTextArea marca = new JTextArea("Marca:");
		JTextArea modelo = new JTextArea("Modelo:");
		JTextArea motor = new JTextArea("Motor:");
		JTextArea chasis = new JTextArea("Chasis:");
		JTextArea patente = new JTextArea("Patente:");
		JTextArea inicio = new JTextArea("Inicio:");
		JTextArea fin = new JTextArea("Fin:");
		JTextArea sumaAsegurada = new JTextArea("Suma asegurada:");
		JTextArea premio = new JTextArea("Premio:");
		JTextArea importeDescuento = new JTextArea("Importe por descuentos:");
		JTextArea diaPago = new JTextArea("Ultimo dia de pago:");
		JTextArea montoTotal = new JTextArea("Monto total a abonar:");
		JTextArea importeCuota = new JTextArea("Importe de cuotas:");
		
		JTextArea titular = new JTextArea("Titular del seguro:");
		JTextArea datosVehiculo = new JTextArea("Datos del vehiculo:");
		JTextArea vigencia = new JTextArea("Vigencia:");
		
		
		apellido.setBackground(Color.lightGray);
		nombre.setBackground(Color.lightGray);
		marca.setBackground(Color.lightGray);
		modelo.setBackground(Color.lightGray);
		motor.setBackground(Color.lightGray);
		chasis.setBackground(Color.lightGray);
		patente.setBackground(Color.lightGray);
		titular.setBackground(Color.lightGray);
		datosVehiculo.setBackground(Color.lightGray);
		vigencia.setBackground(Color.lightGray);
		inicio.setBackground(Color.lightGray);
		fin.setBackground(Color.lightGray);
		sumaAsegurada.setBackground(Color.lightGray);
		premio.setBackground(Color.lightGray);
		importeDescuento.setBackground(Color.lightGray);
		diaPago.setBackground(Color.lightGray);
		montoTotal.setBackground(Color.lightGray);
		importeCuota.setBackground(Color.lightGray);	
		
		JButton emisionPoliza = new JButton("Realizar emision de poliza");
		JButton cancelar = new JButton("Cancelar");

		panelDatos = new JPanel();
		panelDatos.setBackground(Color.lightGray);
		panelDatos.setVisible(true);		
		GridLayout glDatos = new GridLayout(9, 11);
		glDatos.setVgap(1);
		glDatos.setHgap(2);
		glDatos.setColumns(10);
		glDatos.setRows(9);
		panelDatos.setLayout(glDatos);		
		panelBlanco = new JPanel();
		panelBlanco1 = new JPanel();
		panelBlanco2 = new JPanel();
		panelBlanco3 = new JPanel();
		panelBlanco4 = new JPanel();
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
		panelBlanco31 = new JPanel();
		panelBlanco32 = new JPanel();
		panelBlanco33 = new JPanel();
		panelBlanco34 = new JPanel();
		panelBlanco35 = new JPanel();
		panelBlanco36 = new JPanel();
		panelBlanco37 = new JPanel();
		panelBlanco38 = new JPanel();
		panelBlanco39 = new JPanel();
		panelBlanco40 = new JPanel();
		panelBlanco41 = new JPanel();
		panelBlanco42 = new JPanel();
		panelBlanco43 = new JPanel();
		panelBlanco44 = new JPanel();
		panelBlanco45 = new JPanel();
		panelBlanco46 = new JPanel();
		panelBlanco47 = new JPanel();
		panelBlanco48 = new JPanel();
		panelBlanco49 = new JPanel();
		panelBlanco50 = new JPanel();
		panelBlanco51 = new JPanel();
		panelBlanco52 = new JPanel();
		panelBlanco53 = new JPanel();
		panelBlanco54 = new JPanel();
		panelBlanco55 = new JPanel();
		panelBlanco56 = new JPanel();
		panelBlanco.setBackground(Color.lightGray);
		panelBlanco1.setBackground(Color.lightGray);
		panelBlanco2.setBackground(Color.lightGray);
		panelBlanco3.setBackground(Color.lightGray);
		panelBlanco4.setBackground(Color.lightGray);
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
		panelBlanco31.setBackground(Color.lightGray);
		panelBlanco32.setBackground(Color.lightGray);
		panelBlanco33.setBackground(Color.lightGray);
		panelBlanco34.setBackground(Color.lightGray);
		panelBlanco35.setBackground(Color.lightGray);
		panelBlanco36.setBackground(Color.lightGray);
		panelBlanco37.setBackground(Color.lightGray);
		panelBlanco38.setBackground(Color.lightGray);
		panelBlanco39.setBackground(Color.lightGray);
		panelBlanco40.setBackground(Color.lightGray);
		panelBlanco41.setBackground(Color.lightGray);
		panelBlanco42.setBackground(Color.lightGray);
		panelBlanco43.setBackground(Color.lightGray);
		panelBlanco44.setBackground(Color.lightGray);
		panelBlanco45.setBackground(Color.lightGray);
		panelBlanco46.setBackground(Color.lightGray);
		panelBlanco47.setBackground(Color.lightGray);
		panelBlanco48.setBackground(Color.lightGray);
		panelBlanco49.setBackground(Color.lightGray);
		panelBlanco50.setBackground(Color.lightGray);
		panelBlanco51.setBackground(Color.lightGray);
		panelBlanco52.setBackground(Color.lightGray);
		panelBlanco53.setBackground(Color.lightGray);
		panelBlanco54.setBackground(Color.lightGray);
		panelBlanco55.setBackground(Color.lightGray);
		panelBlanco56.setBackground(Color.lightGray);

		
//----------------------------------------------------		
		panelDatos.add(titular);
//----------------------------------------------------
        panelDatos.add(panelBlanco);
        panelDatos.add(panelBlanco8);
        panelDatos.add(panelBlanco16);
        panelDatos.add(panelBlanco21);
        panelDatos.add(panelBlanco25);
        panelDatos.add(panelBlanco26);
        panelDatos.add(panelBlanco31);
        panelDatos.add(panelBlanco40);

//----------------------------------------------------		
		panelDatos.add(apellido);
		panelDatos.add(apellidoTxt);
		panelDatos.add(nombre);
		panelDatos.add(nombreTxt);
//----------------------------------------------------
        panelDatos.add(panelBlanco1);        
        panelDatos.add(panelBlanco9);
        panelDatos.add(panelBlanco17);
        panelDatos.add(panelBlanco32);
        panelDatos.add(panelBlanco49);
//----------------------------------------------------
		panelDatos.add(datosVehiculo);
//----------------------------------------------------
        panelDatos.add(panelBlanco2);
        panelDatos.add(panelBlanco10);
        panelDatos.add(panelBlanco18);
        panelDatos.add(panelBlanco23);
        panelDatos.add(panelBlanco22);
        panelDatos.add(panelBlanco51);
        panelDatos.add(panelBlanco41);
        panelDatos.add(panelBlanco3);
//----------------------------------------------------		
		panelDatos.add(marca);
		panelDatos.add(marcaTxt);
		panelDatos.add(modelo);
		panelDatos.add(modeloTxt);
		panelDatos.add(motor);
		panelDatos.add(motorTxt);
		panelDatos.add(chasis);
		panelDatos.add(chasisTxt);
		panelDatos.add(patente);
		panelDatos.add(patenteTxt);
//----------------------------------------------------

        panelDatos.add(panelBlanco11);
        panelDatos.add(panelBlanco19);
        panelDatos.add(panelBlanco24);
        panelDatos.add(panelBlanco36);
        panelDatos.add(panelBlanco43);
        panelDatos.add(panelBlanco44);
        panelDatos.add(panelBlanco35);
      panelDatos.add(panelBlanco42);
//--------------------------------------------------		
		panelDatos.add(vigencia);
//----------------------------------------------------		
        panelDatos.add(panelBlanco4);
        panelDatos.add(panelBlanco12);
        panelDatos.add(panelBlanco20);
        panelDatos.add(panelBlanco27);
        panelDatos.add(panelBlanco33);
        panelDatos.add(panelBlanco45);
        panelDatos.add(panelBlanco30);
        panelDatos.add(panelBlanco28); 
//        panelDatos.add(panelBlanco34);


//----------------------------------------------------		
		panelDatos.add(inicio);
		panelDatos.add(inicioTxt);
		panelDatos.add(fin);
		panelDatos.add(finTxt);
//-------------------------------------------------		
        panelDatos.add(panelBlanco50);
        panelDatos.add(panelBlanco37); 
        panelDatos.add(panelBlanco29);
        panelDatos.add(panelBlanco14);
//----------------------------------------------------		
		panelDatos.add(sumaAsegurada);
		panelDatos.add(sumaAseguradaTxt);
		panelDatos.add(premio);
		panelDatos.add(premioTxt);
//--------------------------------------------------
        panelDatos.add(panelBlanco46);
        panelDatos.add(panelBlanco38);
        panelDatos.add(panelBlanco13);

//----------------------------------------------------		
		panelDatos.add(importeDescuento);
		panelDatos.add(importeDescuentoTxt);
//----------------------------------------------------		
        panelDatos.add(panelBlanco7);
        panelDatos.add(panelBlanco15);
        panelDatos.add(panelBlanco47);
        panelDatos.add(panelBlanco48);
        panelDatos.add(panelBlanco39);
        panelDatos.add(panelBlanco14);
        panelDatos.add(panelBlanco5);
        panelDatos.add(panelBlanco6);
//----------------------------------------------------
		panelDatos.add(diaPago);
		panelDatos.add(diaPagoTxt);
		panelDatos.add(montoTotal);
		panelDatos.add(montoTotalTxt);
		panelDatos.add(importeCuota);
		panelDatos.add(importeCuotaTxt);
//----------------------------------------------------


		
		constraints.anchor = GridBagConstraints.LINE_START;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 2;
		container.add(panelDatos, constraints);
			
		panelBotones = new JPanel();
		panelBotones.setBackground(Color.lightGray);
		panelBotones.setVisible(true);
		panelBotones.setLayout(new FlowLayout());
		panelBotones.add(emisionPoliza);
		panelBotones.add(cancelar);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 10;
		constraints.gridwidth = 2;
		container.add(panelBotones, constraints);
	}
	
}