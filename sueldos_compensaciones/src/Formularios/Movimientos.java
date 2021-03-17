package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Clases.conexion;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowStateListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JRadioButton;


public class Movimientos extends JFrame {
	Double sSueldo = 0.00;
	private JPanel contentPane;
	private JTextField textNumeroMov;
	private JTextField textNombreMov;
	private JTextField textRolMov;
	private JTextField textTipoMov;
	private JTextField textFechaMov;
	private JTextField textDiasLaborales;
	private JTextField textEntregas;
	private JTextField texSueldo;

	
public void limpiar() {
			textNumeroMov.setText("");
			textNombreMov.setText("");	
			textRolMov.setText("");	
			textTipoMov.setText("");	
			textFechaMov.setText("");	
			textDiasLaborales.setText("");		
			textEntregas.setText("");	
			textNumeroMov.transferFocus();
	}
public void llenarNumEmp() {
	//textNumeroMov.setText(Integer.toString(1));
	 //crea conexion
       conexion conexion = new Clases.conexion();

        //se utiliza para ejecutar proceso
       PreparedStatement stmt = null;
        
        int iMax = 0;
    

        try  {
        Connection con = conexion.conectar();  
        PreparedStatement ps = con.prepareStatement("select max(numEmpleado) from nomina.Movimientos");   
        ResultSet rs = ps.executeQuery();
        rs.next();
        iMax = rs.getInt(1); 
        
            con.close();
            if(iMax >= 0 ) {
        
            int icontador = 0; 
    		 while( iMax>= icontador) {
    			
    			icontador ++;
    		 }
    		
    		 textNumeroMov.setText(Integer.toString(+icontador));
            }
    	
           

        } catch (Exception r) {
        //	JOptionPane.showMessageDialog(null, "El numero de empleado ya esta registrado.");
        //	limpiar();
        	System.out.println(r);
        }
    }

	
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
		
		addWindowStateListener(new WindowStateListener() {
			public void windowStateChanged(WindowEvent e) {
				
			}
		});
		
		this.setLocationRelativeTo(null);
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 366);
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
		btnNuevoMov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SnumEmp = null;
				SnumEmp = textNumeroMov.getText();
				String SnomEmp = null;
				SnomEmp = textNombreMov.getText();
				String SRol = null;
				SRol = textRolMov.getText();
				String STipo = null;
				STipo = textTipoMov.getText();
				String sFecha = null;
				sFecha = textFechaMov.getText();
				String sDias = null;
				sDias = textDiasLaborales.getText();
				String sEntregas = null;
				sEntregas = textEntregas.getText();
				
				
				if(SnomEmp.equals("") || SnumEmp.equals("")|| SRol.equals("") || STipo.equals("")|| (sFecha.equals("") || sDias.equals("")|| sEntregas.equals(""))) {
				
					JOptionPane.showMessageDialog(null, "Favor de llenar los campos.");
					//limpiar();
					
				}
				else {
				 //crea conexion
					if(SRol.equals("chofer")) {
						int iEntregas = (10 * Integer.parseInt(sEntregas));
						Double sSueldoIsr = 0.00;
						sSueldoIsr = (double) (320 *Integer.parseInt(sDias) +  iEntregas);
						Double isr = 0.91;
						sSueldo = sSueldoIsr * isr;
						
						
					}
					if(SRol.equals("auxiliar")) {
						int iEntregas = (5 * Integer.parseInt(sEntregas));
						Double sSueldoIsr = 0.00;
						sSueldoIsr = (double) (240 *Integer.parseInt(sDias) +  iEntregas);
						Double isr = 0.91;
						sSueldo = sSueldoIsr * isr;
						
						
					}
					if(SRol.equals("cargador")) {
						int iEntregas = (5 * Integer.parseInt(sEntregas));
						Double sSueldoIsr = 0.00;
						sSueldoIsr = (double) (280 *Integer.parseInt(sDias) +  iEntregas);
						Double isr = 0.91;
						sSueldo = sSueldoIsr * isr;
						
						
					}
					if (sSueldo > 16000.00){
						
						sSueldo = sSueldo * 0.97;
						
					}
		       conexion conexion = new Clases.conexion();

		        //se utiliza para ejecutar proceso
		        CallableStatement stmt = null;
		        
		        String sCodRet = null;
		        String sMensaje= null;
		       
		        try ( Connection cnx = conexion.conectar()) {

		            System.out.println("Creando sentencia...");
		            //el sql de invocación utiliza la notacion call + nombre proceso + parametros requeridos pro el proceso ? separados por ,
		            String sql = "{call SpInsertarMov (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
		            stmt = cnx.prepareCall(sql);

		            //Bind IN parameter first, then bind OUT parameter
		            
		            stmt.setString(1, SnumEmp);
		            stmt.setString(2, SnomEmp);
		            stmt.setString(3, SRol);
		            stmt.setString(4, STipo);
		            stmt.setString(5, sFecha);
		            stmt.setString(6, sDias);
		            stmt.setString(7, sEntregas);
		            stmt.setDouble(8, sSueldo);
		            stmt.registerOutParameter("codigoRet", Types.CHAR);
		            stmt.registerOutParameter("mensaje", Types.VARCHAR);

		            
		            System.out.println("Ejecutando el procedimiento almacenado getMensaje...");
		            stmt.execute();

		            //Recupera el texto del mensaje y lo imprime en la consola
		            sCodRet = stmt.getString(9);
		            sMensaje = stmt.getString(10);
		            if(sCodRet.equals("00000")){
		            	JOptionPane.showMessageDialog(null, "Movimiento registrado correctamente.");
		            	limpiar();
		            	llenarNumEmp();
		            	
		            }
		            
		            System.out.println("Mensaje con el ID:"
		                    + sCodRet + " is " + sMensaje);
		            //cerrar recursos
		            stmt.close();
		            cnx.close();;

		        } catch (Exception r) {
		        	JOptionPane.showMessageDialog(null, "El numero de movimiento ya esta registrado.");
		        	limpiar();
		        	llenarNumEmp();
		        	System.out.println(r);
		        }
		    }
		
			}
				
				
			
		});
		btnNuevoMov.setBounds(10, 11, 79, 23);
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
		textNumeroMov.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
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
		
		JLabel lblHrsLaborales = new JLabel("Dias Laborales");
		lblHrsLaborales.setBounds(173, 108, 83, 14);
		panelButton_1.add(lblHrsLaborales);
		
		textDiasLaborales = new JTextField();
		textDiasLaborales.setColumns(10);
		textDiasLaborales.setBounds(254, 104, 39, 20);
		panelButton_1.add(textDiasLaborales);
		
		JLabel lblHrsLaborales_1_1 = new JLabel("Entregas:");
		lblHrsLaborales_1_1.setBounds(10, 145, 71, 17);
		panelButton_1.add(lblHrsLaborales_1_1);
		
		textEntregas = new JTextField();
		textEntregas.setColumns(10);
		textEntregas.setBounds(71, 142, 39, 20);
		panelButton_1.add(textEntregas);
		
		texSueldo = new JTextField();
		texSueldo.setColumns(10);
		texSueldo.setBounds(71, 170, 53, 20);
		panelButton_1.add(texSueldo);
		
		JLabel Sueldo = new JLabel("Sueldo:");
		Sueldo.setBounds(10, 173, 71, 14);
		panelButton_1.add(Sueldo);
	}
}
