package pantallas;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class BuscarCliente extends JFrame{

	private JFrame frame=this;
	private JPanel panelDatos;
	private JPanel panelBuscar;
	private JPanel panelTabla;
	private JPanel panelAceptarCancelar;
	private JPanel panelBlanco1;
	private JPanel panelBlanco2;
	private JTable tablaClientes;
	
	public BuscarCliente () {
		
		this.setTitle("Buscar cliente");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(570,650);
		this.setResizable(false);
		Container container = getContentPane();
		container.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		JLabel nroCliente = new JLabel("Nro. cliente:");
		JLabel apellido = new JLabel("Apellido:");
		JLabel nombre = new JLabel("Nombre:");
		JLabel tipoDocumento = new JLabel("Tipo de documento:");
		JLabel nroDocumento = new JLabel("Numero de documento:");
		JLabel clientes = new JLabel("Clientes:");
		JTextField nroClienteTxt = new JTextField();
		JTextField nroDocumentoTxt = new JTextField();
		JTextField apellidoTxt = new JTextField();
		JTextField nombreTxt = new JTextField();
		JComboBox tipoDocumentoComboBox = new JComboBox();
		JButton buscar = new JButton("Buscar");
		JButton aceptar = new JButton("Aceptar");
		JButton cancelar = new JButton("Cancelar");
		
		panelDatos = new JPanel();
		panelDatos.setVisible(true);
		GridLayout glDatos = new GridLayout(3,4);
		glDatos.setVgap(1);
		glDatos.setHgap(1);
		panelDatos.setLayout(glDatos);

		panelBlanco1 = new JPanel();
		panelBlanco2 = new JPanel();
		
		panelDatos.add(nroCliente);
		panelDatos.add(nroClienteTxt);
		panelDatos.add(panelBlanco1);
		panelDatos.add(panelBlanco2);
		panelDatos.add(apellido);
		panelDatos.add(apellidoTxt);
		panelDatos.add(nombre);
		panelDatos.add(nombreTxt);
		panelDatos.add(tipoDocumento);
		panelDatos.add(tipoDocumentoComboBox);
		panelDatos.add(nroDocumento);
		panelDatos.add(nroDocumentoTxt);
		
		constraints.gridx = 0;
		constraints.gridy = 0;
		container.add(panelDatos, constraints);
		
		panelBuscar = new JPanel();
		panelBuscar.setVisible(true);
		panelBuscar.setLayout(new FlowLayout());
		panelBuscar.add(buscar);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.anchor = GridBagConstraints.WEST;
		container.add(panelBuscar, constraints);
		
		panelTabla = new JPanel();
		panelTabla.setVisible(true);
		panelTabla.setLayout(new BorderLayout());
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("N°");
		model.addColumn("Nro. cliente");
		model.addColumn("Apellido");
		model.addColumn("Nombre");
		model.addColumn("Tipo documento");
		model.addColumn("N° documento");
		
		Object rowData[] = null;
		
		model.addRow(rowData);
		model.addRow(rowData);
		model.addRow(rowData);
		model.addRow(rowData);
		model.addRow(rowData);
		model.addRow(rowData);
		model.addRow(rowData);
		model.addRow(rowData);
		model.addRow(rowData);
		model.addRow(rowData);
		model.addRow(rowData);
		model.addRow(rowData);
		model.addRow(rowData);
		model.addRow(rowData);
		model.addRow(rowData);
		model.addRow(rowData);
		model.addRow(rowData);
		model.addRow(rowData);
		model.addRow(rowData);
		model.addRow(rowData);
		model.addRow(rowData);
		model.addRow(rowData);
		model.addRow(rowData);
		model.addRow(rowData);
		model.addRow(rowData);
		
		tablaClientes = new JTable(4,5);
		tablaClientes.setModel(model);
		tablaClientes.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(tablaClientes);
		panelTabla.add(clientes, BorderLayout.NORTH);
		panelTabla.add(scrollPane, BorderLayout.CENTER);
		
		constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.anchor = GridBagConstraints.WEST;
		constraints.fill = GridBagConstraints.BOTH;
		container.add(panelTabla, constraints);
		
		panelAceptarCancelar = new JPanel();
		panelAceptarCancelar.setVisible(true);
		panelAceptarCancelar.setLayout(new FlowLayout());
		
		panelAceptarCancelar.add(aceptar);
		panelAceptarCancelar.add(cancelar);
		
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.anchor = GridBagConstraints.CENTER;
		
		container.add(panelAceptarCancelar, constraints);
		
	}
	
}
