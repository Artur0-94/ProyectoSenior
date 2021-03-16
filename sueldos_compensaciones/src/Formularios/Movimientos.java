package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Dialog.ModalExclusionType;

public class Movimientos extends JFrame {

	private JPanel contentPane;
	private JTextField textNumeroMov;
	private JTextField textNombreMov;
	private JTextField textRolMov;
	private JTextField textTipoMov;
	private JTextField textFechaMov;
	private JTextField textHrsLaborales;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Movimientos frame = new Movimientos();
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
	public Movimientos() {
		
		this.setLocationRelativeTo(null);
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelButton = new JPanel();
		panelButton.setBounds(10, 11, 370, 46);
		panelButton.setLayout(null);
		panelButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panelButton);
		
		JButton btnNuevoMov = new JButton("Nuevo");
		btnNuevoMov.setBounds(10, 11, 72, 23);
		panelButton.add(btnNuevoMov);
		
		JButton btnBuscarMov = new JButton("Buscar");
		btnBuscarMov.setBounds(81, 11, 89, 23);
		panelButton.add(btnBuscarMov);
		
		JButton btnModificarMov = new JButton("Modificar");
		btnModificarMov.setBounds(159, 11, 89, 23);
		panelButton.add(btnModificarMov);
		
		JButton btnEliminarMov = new JButton("Eliminar");
		btnEliminarMov.setBounds(246, 11, 89, 23);
		panelButton.add(btnEliminarMov);
		
		JPanel panelButton_1 = new JPanel();
		panelButton_1.setBounds(10, 70, 370, 237);
		panelButton_1.setLayout(null);
		panelButton_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panelButton_1);
		
		JLabel lblNumero = new JLabel("N\u00FAmero:");
		lblNumero.setBounds(10, 11, 63, 14);
		panelButton_1.add(lblNumero);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 47, 63, 14);
		panelButton_1.add(lblNombre);
		
		textNumeroMov = new JTextField();
		textNumeroMov.setColumns(10);
		textNumeroMov.setBounds(71, 8, 63, 20);
		panelButton_1.add(textNumeroMov);
		
		textNombreMov = new JTextField();
		textNombreMov.setColumns(10);
		textNombreMov.setBounds(71, 44, 260, 20);
		panelButton_1.add(textNombreMov);
		
		JLabel lblRol = new JLabel("Rol:");
		lblRol.setBounds(10, 76, 63, 14);
		panelButton_1.add(lblRol);
		
		textRolMov = new JTextField();
		textRolMov.setColumns(10);
		textRolMov.setBounds(71, 73, 63, 20);
		panelButton_1.add(textRolMov);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(173, 76, 63, 14);
		panelButton_1.add(lblTipo);
		
		textTipoMov = new JTextField();
		textTipoMov.setColumns(10);
		textTipoMov.setBounds(227, 73, 63, 20);
		panelButton_1.add(textTipoMov);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(10, 108, 63, 14);
		panelButton_1.add(lblFecha);
		
		textFechaMov = new JTextField();
		textFechaMov.setColumns(10);
		textFechaMov.setBounds(71, 105, 77, 20);
		panelButton_1.add(textFechaMov);
		
		JLabel lblHrsLaborales = new JLabel("Hrs laborales:");
		lblHrsLaborales.setBounds(173, 108, 83, 14);
		panelButton_1.add(lblHrsLaborales);
		
		textHrsLaborales = new JTextField();
		textHrsLaborales.setColumns(10);
		textHrsLaborales.setBounds(254, 104, 39, 20);
		panelButton_1.add(textHrsLaborales);
		
		JLabel lblHrsExtras = new JLabel("Hrs extras:");
		lblHrsExtras.setBounds(10, 145, 71, 14);
		panelButton_1.add(lblHrsExtras);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(81, 142, 39, 20);
		panelButton_1.add(textField);
		
		JLabel lblHrsLaborales_1_1 = new JLabel("Entregas:");
		lblHrsLaborales_1_1.setBounds(173, 145, 71, 14);
		panelButton_1.add(lblHrsLaborales_1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(251, 142, 39, 20);
		panelButton_1.add(textField_1);
	}
}
