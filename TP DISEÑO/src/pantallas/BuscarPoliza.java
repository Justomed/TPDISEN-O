package pantallas;
//
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BuscarPoliza extends JFrame {
	
	private JPanel panelNroPoliza;
	private JPanel panelBuscar;
	private JPanel panelNroCliente;
	private JPanel panelPoliza;
	private JPanel panelApellido;
	private JPanel panelTipoDoc;
	private JPanel panelUltimo;
	private JPanel panelFecha;
	private JPanel panelMonto;
	private JPanel panelBoton;
	
	public BuscarPoliza() {
		
		this.setTitle("Buscar póliza");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		this.setSize(600,450);
		this.setResizable(false);
		Container container = getContentPane();
		container.setLayout(new GridBagLayout());
		container.setBackground(Color.lightGray);
		GridBagConstraints constraints = new GridBagConstraints();
//---------------- DECLARACION DE COMPONENTES ---------------------			
		JTextField nroPolizaTxt = new JTextField();
		JTextField nroClienteTxt = new JTextField();
		JTextField nroPolizaaTxt = new JTextField();
		JTextField apellidoTxt = new JTextField();
		JTextField nombreTxt = new JTextField();
		JTextField tipoDocTxt = new JTextField();
		JTextField nroDocTxt = new JTextField();
		JTextField montoTxt = new JTextField();
		
		JTextArea nroPoliza = new JTextArea("Nro. de póliza:");
		JTextArea nroCliente = new JTextArea("Nro. de cliente:");
		JTextArea nroPolizaa = new JTextArea("Nro. de póliza: ");
		JTextArea apellido = new JTextArea("Apellido:           ");
		JTextArea nombre = new JTextArea("Nombre:");
		JTextArea tipoDoc = new JTextArea("Tipo de documento:");
		JTextArea nroDoc = new JTextArea("Nro. de documento:");
		JTextArea monto = new JTextArea("Monto:");
		JTextArea diaPago = new JTextArea("Ultimo dia de pago:");
		JTextArea fecha = new JTextArea("Fecha de pago:");
		
		JButton buscar = new JButton("Buscar");
		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");
		
		nroPoliza.setBackground(Color.lightGray);
		nroCliente.setBackground(Color.lightGray);
		nroPolizaa.setBackground(Color.lightGray);
		apellido.setBackground(Color.lightGray);
		nombre.setBackground(Color.lightGray);
		tipoDoc.setBackground(Color.lightGray);
		nroDoc.setBackground(Color.lightGray);
		monto.setBackground(Color.lightGray);
		diaPago.setBackground(Color.lightGray);
		fecha.setBackground(Color.lightGray);
		
		nroClienteTxt.setEnabled(false);
		nroPolizaaTxt.setEnabled(false);
		apellidoTxt.setEnabled(false);
		nombreTxt.setEnabled(false);
		tipoDocTxt.setEnabled(false);
		nroDocTxt.setEnabled(false);
		montoTxt.setEnabled(false);
		
//----------------PANEL NRO POLIZA ------------------------------------		
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
		constraints.gridy = 2;
		container.add(panelNroPoliza, constraints);		
//----------------PANEL BUSCAR ------------------------------------	
		panelBuscar = new JPanel();
		panelBuscar.setBackground(Color.lightGray);
		panelBuscar.setVisible(true);
		panelBuscar.setLayout(new FlowLayout());
		panelBuscar.add(buscar);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 3;
		container.add(panelBuscar, constraints);	
//----------------PANEL NRO CLIENTE ------------------------------------	
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
		constraints.gridy = 4;
		container.add(panelNroCliente, constraints);	
//----------------PANEL POLIZA ------------------------------------
		panelPoliza = new JPanel();
		panelPoliza.setBackground(Color.lightGray);
		panelPoliza.setVisible(true);
		panelPoliza.setLayout(new FlowLayout());
		panelPoliza.add(nroPolizaa);
		panelPoliza.add(nroPolizaaTxt);
		nroPolizaaTxt.setColumns(10);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 5;
		container.add(panelPoliza, constraints);	
//----------------PANEL APELLIDO ------------------------------------	
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
		constraints.gridy = 6;
		container.add(panelApellido, constraints);	
//----------------PANEL TIPO DOC ------------------------------------
		panelTipoDoc = new JPanel();
		panelTipoDoc.setBackground(Color.lightGray);
		panelTipoDoc.setVisible(true);
		panelTipoDoc.setLayout(new FlowLayout());
		panelTipoDoc.add(tipoDoc);
		panelTipoDoc.add(tipoDocTxt);
		tipoDocTxt.setColumns(10);
		panelTipoDoc.add(nroDoc);
		panelTipoDoc.add(nroDocTxt);
		nroDocTxt.setColumns(10);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 7;
		container.add(panelTipoDoc, constraints);	
//----------------PANEL ULTIMO ------------------------------------	
		panelUltimo = new JPanel();
		panelUltimo.setBackground(Color.lightGray);
		panelUltimo.setVisible(true);
		panelUltimo.setLayout(new FlowLayout());
		panelUltimo.add(diaPago);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 8;
		container.add(panelUltimo, constraints);
//----------------PANEL FECHA ------------------------------------
		panelFecha = new JPanel();
		panelFecha.setBackground(Color.lightGray);
		panelFecha.setVisible(true);
		panelFecha.setLayout(new FlowLayout());
		panelFecha.add(fecha);
		//AGREGAR DATE CHOOSER ACA
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 9;
		container.add(panelFecha, constraints);
//----------------PANEL MONTO ------------------------------------	
		panelMonto = new JPanel();
		panelMonto.setBackground(Color.lightGray);
		panelMonto.setVisible(true);
		panelMonto.setLayout(new FlowLayout());
		panelMonto.add(monto);
		panelMonto.add(montoTxt);
		montoTxt.setColumns(10);
		constraints.anchor = GridBagConstraints.WEST;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 10;
		container.add(panelMonto, constraints);
//----------------PANEL BOTONES ------------------------------------
		panelBoton = new JPanel();
		panelBoton.setBackground(Color.lightGray);
		panelBoton.setVisible(true);
		panelBoton.setLayout(new FlowLayout());
		panelBoton.add(aceptar);
		panelBoton.add(cancelar);
		constraints.anchor = GridBagConstraints.CENTER;
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridy = 11;
		container.add(panelBoton, constraints);
//------------------FUNCIONAMIENTO PANTALLA-------------------------
		buscar.addActionListener(e -> {
			//UTILIZAR GESTORBD PARA RECUPERAR LA POLIZA
			//RELLENAR LOS CAMPOS INACTIVOS CON LOS DATOS
		});
		
		aceptar.addActionListener(e -> {
			new RegistrarPago();
			this.dispose();
		});
		
		cancelar.addActionListener(e -> {
			new RegistrarPago();
			this.dispose();
		});
	}
}
