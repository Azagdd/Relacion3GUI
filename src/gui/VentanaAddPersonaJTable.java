package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import clases.Persona;
import net.miginfocom.swing.MigLayout;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentanaAddPersonaJTable extends JFrame {

	private JPanel contentPane;
	private JTextField txtDNI;
	private JTextField txtDia;
	private JTextField txtMes;
	private JTextField txtAnio;
	private JTextField txtApellidos;
	private JTextField txtNombre;
	
	private ArrayList<Persona> listaPersonas;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAddPersonaJTable frame = new VentanaAddPersonaJTable();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaAddPersonaJTable() {
		
		this.listaPersonas = new ArrayList<Persona>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 489, 337);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow][][grow][][][][][]", "[][][][][][grow]"));
		
		JLabel lblNewLabel = new JLabel("Introducir Personas:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblNewLabel, "cell 0 0 8 1");
		
		JLabel lblNewLabel_1 = new JLabel("DNI*:");
		contentPane.add(lblNewLabel_1, "cell 0 1,alignx trailing");
		
		txtDNI = new JTextField();
		contentPane.add(txtDNI, "cell 1 1 5 1,growx");
		txtDNI.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre*:");
		contentPane.add(lblNewLabel_2, "cell 6 1,alignx trailing");
		
		txtNombre = new JTextField();
		contentPane.add(txtNombre, "cell 7 1 2 1,growx");
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Apellidos*:");
		contentPane.add(lblNewLabel_3, "cell 0 2,alignx trailing");
		
		txtApellidos = new JTextField();
		contentPane.add(txtApellidos, "cell 1 2 8 1,growx");
		txtApellidos.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha Nacimiento:");
		contentPane.add(lblNewLabel_4, "cell 0 3,alignx trailing,growy");
		
		txtDia = new JTextField();
		txtDia.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				limpiarHint(e);
			}
		});
		txtDia.setForeground(SystemColor.activeCaption);
		txtDia.setText("Día");
		contentPane.add(txtDia, "cell 1 3,growx");
		txtDia.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("/");
		contentPane.add(lblNewLabel_5, "cell 2 3,alignx trailing");
		
		txtMes = new JTextField();
		txtMes.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				limpiarHint(e);
			}
		});
		txtMes.setForeground(SystemColor.activeCaption);
		txtMes.setText("Mes");
		contentPane.add(txtMes, "cell 3 3,growx");
		txtMes.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("/");
		contentPane.add(lblNewLabel_6, "cell 4 3,alignx trailing");
		
		txtAnio = new JTextField();
		txtAnio.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				limpiarHint(e);
			}
		});
		txtAnio.setForeground(SystemColor.inactiveCaption);
		txtAnio.setText("Año");
		contentPane.add(txtAnio, "cell 5 3 2 1,growx");
		txtAnio.setColumns(10);
		
		JButton btnNewButton = new JButton("Insertar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recogerDatos();
			}
		});
		contentPane.add(btnNewButton, "cell 1 4,alignx center");
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
			}
		});
		contentPane.add(btnLimpiar, "cell 3 4");
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		contentPane.add(btnBuscar, "cell 5 4 2 1");
		
		JButton btnNewButton_1 = new JButton("Mostrar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				muestraPersonas();
			}
		});
		contentPane.add(btnNewButton_1, "cell 7 4");
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		contentPane.add(btnEliminar, "cell 8 4");
		
		JLabel lblNewLabel_7 = new JLabel("Persona:");
		contentPane.add(lblNewLabel_7, "cell 0 5");
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 1 5 8 1,grow");
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"DNI", "Nombre", "Apellidos", "Fecha de Nacimiento"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(3).setPreferredWidth(124);
	}

	protected void eliminar() {
		// tomamos el numero de fila seleccionada
		int seleccionada = table.getSelectedRow();
		
		if (seleccionada==-1) {
			// no hay ninguna seleccionada
			JOptionPane.showMessageDialog(contentPane, 
					"Debe seleccionar una persona a borrar");
			return;
		}
		
		//recojo el modelo
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		Persona p = new Persona();
		//tomamos el dni de la tabla, de la fila seleccionada y la columna 0 que es el dni
		p.setDni((String) modelo.getValueAt(seleccionada, 0));
		
		
		if (!this.listaPersonas.contains(p) ) {
			JOptionPane.showMessageDialog(contentPane, 
					"No existe ninguna persona con ese DNI",
					"Dni no encontrado", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		this.listaPersonas.remove(p);
		muestraPersonas();
		
	}

	protected void buscar() {
		String dni = JOptionPane.showInputDialog(contentPane, 
				"Introduzca DNI", "Buscar por DNI", JOptionPane.QUESTION_MESSAGE);
		
		Persona p = new Persona();
		p.setDni(dni);
		
		int indice= this.listaPersonas.indexOf(p);
		if (indice ==-1) {
			JOptionPane.showMessageDialog(contentPane, 
					"No existe ninguna persona con ese DNI",
					"Dni no encontrado", JOptionPane.ERROR_MESSAGE);
			return;
		}
		p = this.listaPersonas.get(indice);
		
		//textArea.setText("Persona encontrada: \n"+p);
		
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		modelo.setRowCount(0);
		
		Object fila [] = {
				p.getDni(), p.getNombre(),
				p.getApellidos(), p.getFechaNac()
			};
			
		// añade la fila al modelo
		modelo.addRow(fila);
		
	}

	protected void limpiarFormulario() {
		txtDNI.setText("");
		txtNombre.setText("");
		txtApellidos.setText("");
		txtDia.setText("Día:");txtDia.setForeground(SystemColor.activeCaption);
		txtMes.setText("Mes");txtMes.setForeground(SystemColor.activeCaption);
		txtAnio.setText("Año");txtAnio.setForeground(SystemColor.activeCaption);
	}

	protected void limpiarHint(FocusEvent e) {
		JTextField caja = (JTextField) e.getSource();
		if (caja.getText().equals("Día")||caja.getText().equals("Mes")
				|| caja.getText().equals("Año")) {
			caja.setText("");
			caja.setForeground(Color.black);
		}
		
	}

	protected void recogerDatos() {
		try {
			String dni = txtDNI.getText();
			String nombre = txtNombre.getText();
			String apellidos = txtApellidos.getText();
			
			int dia = Integer.parseInt(txtDia.getText());
			int mes = Integer.parseInt(txtMes.getText());
			int anyo = Integer.parseInt(txtAnio.getText());
			
			if (dni==null || dni.isBlank() ||
				nombre==null || nombre.isBlank() ||
				apellidos==null || apellidos.isBlank()) {
				JOptionPane.showMessageDialog(contentPane, 
						"Debe introducir el dni, el nombre y los apellidos"
						, "Datos requeridos",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			Persona p1 = new Persona(dni, nombre, apellidos, dia, mes, anyo);
			
			insertarPersona(p1);
			limpiarFormulario();
			
			muestraPersonas();
			
			
			
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(contentPane, 
					"El día, el mes y el año deben ser números válidos"
					, "Datos requeridos",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	private void muestraPersonas() {
		// REcoge el modelo de la tabla con sus filas y columnas
		DefaultTableModel modelo = (DefaultTableModel) table.getModel();
		// vacía la JTable
		modelo.setRowCount(0);
		
		// recorremos la lista de personas
		for (Persona persona : listaPersonas) {
			// componemos una fila de la tabla
			Object fila [] = {
				persona.getDni(), persona.getNombre(),
				persona.getApellidos(), persona.getFechaNac()
			};
			
			// añade la fila al modelo
			modelo.addRow(fila);
		}
	}

	private void insertarPersona(Persona p1) {
		if(this.listaPersonas.contains(p1) ) {
			JOptionPane.showMessageDialog(contentPane, 
					"Ya existe una persona con ese DNI", "DNI ya existe", 
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		this.listaPersonas.add(p1);
		
	}

}
