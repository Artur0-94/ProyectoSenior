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
import java.awt.Window.Type;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


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
			texSueldo.setText("");
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
		setType(Type.POPUP);
		setTitle("Movimientos");
		
		addWindowStateListener(new WindowStateListener() {
			public void windowStateChanged(WindowEvent e) {
				
			}
		});
		
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 410, 361);
		contentPane = new JPanel();
		contentPane.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelButton = new JPanel();
		panelButton.setBounds(10, 11, 370, 46);
		panelButton.setLayout(null);
		panelButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panelButton);
		setLocationRelativeTo(null);
		
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
		btnBuscarMov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				texSueldo.enable();
				String SnumEmp = null;
				SnumEmp = textNumeroMov.getText();
		
			
				 //crea conexion
		       conexion conexion = new Clases.conexion();

		        //se utiliza para ejecutar proceso
		        CallableStatement stmt = null;
		        
		        String sCodRet = null;
		        String sNombre = null;
	        	String sRol = null;
	        	String sTipo = null;
	        	String sFecha = null;
	        	String sDiasTrabajados = null;
	        	String sEntregas = null;
	        	Double sSueldo = 0.00;

		        try ( Connection cnx = conexion.conectar()) {
		        	
		        	

		            System.out.println("Creando sentencia...");
		            //el sql de invocación utiliza la notacion call + nombre proceso + parametros requeridos pro el proceso ? separados por ,
		            String sql = "{call SpBuscarMov ( ?, ?, ?, ?, ?, ?, ? ,?, ?, ?)}";
		            stmt = cnx.prepareCall(sql);

		            //Bind IN parameter first, then bind OUT parameter
		            
		            stmt.setString(1, SnumEmp);
		            stmt.registerOutParameter("codigoRet", Types.CHAR);
		            stmt.registerOutParameter("iNumeroEmpleado", Types.INTEGER);
		            stmt.registerOutParameter("sNombreEmp", Types.VARCHAR);
		            stmt.registerOutParameter("sRol", Types.CHAR);
		            stmt.registerOutParameter("sTipo", Types.CHAR);
		            stmt.registerOutParameter("sFecha", Types.CHAR);
		            stmt.registerOutParameter("sDiasTrabajados", Types.VARCHAR);
		            stmt.registerOutParameter("sEntregas", Types.CHAR);
		            stmt.registerOutParameter("sSueldo", Types.DOUBLE);
		            System.out.println("Ejecutando el procedimiento almacenado getMensaje...");
		            stmt.execute();

		            //Recupera el texto del mensaje y lo imprime en la consola
		            sCodRet = stmt.getString(2);
		            
		            sNombre = stmt.getString(4);
		            sRol = stmt.getString(5);
		            sTipo = stmt.getString(6);
		            sFecha = stmt.getString(7);
		        	sDiasTrabajados = stmt.getString(8);
		        	sEntregas =stmt.getString(9);
		        	 sSueldo = stmt.getDouble(10);
		            
		           
		            
		            if(sCodRet.equals("00000")){
		            	//textNumero.setText(Integer.toString(stmt.getInt(4)));
		            	textNombreMov.setText(sNombre);
		            	textRolMov.setText(sRol);
		            	textTipoMov.setText(sTipo);
		            	textFechaMov.setText(sFecha);
		            	textDiasLaborales.setText(sDiasTrabajados);
		            	textEntregas.setText(sEntregas);
		            	texSueldo.setText(Double.toString(sSueldo));
		            //	textNombre.setText(sTipo);	
		            	
		            	
		            	
		            	JOptionPane.showMessageDialog(null, "consulta exitosa.");
		            	 stmt.close();
				         cnx.close();
		            	
		            }
		          

		        } catch (Exception r) {
		        	JOptionPane.showMessageDialog(null, "El numero de empleado no se encuentra registrado");
		        	limpiar();
		        	System.out.println(r);
		        }
		    }
			
		});
		btnBuscarMov.setBounds(81, 11, 89, 23);
		panelButton.add(btnBuscarMov);
		
		JButton btnModificarMov = new JButton("Modificar");
		btnModificarMov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String iNumEmp = null;
				iNumEmp = textNumeroMov.getText();
				String sNombre = null;
				sNombre = textNumeroMov.getText();
	        	String sRol = null;
	        	sRol = textRolMov.getText();
	        	String sTipo = null;
	        	sTipo = textTipoMov.getText();
	        	String sFecha = null;
	        	sFecha = textFechaMov.getText();
	        	String sDiasTrabajados = null;
	        	sDiasTrabajados = textDiasLaborales.getText();
	        	String sEntregas = null;
	        	sEntregas = textEntregas.getText();
	        	Double sSueldo = 0.00;
				
				if(sNombre.equals("") || iNumEmp.equals("") || sRol.equals("") || sTipo.equals("") |sFecha.equals("") || sDiasTrabajados.equals("") || sEntregas.equals("") || sSueldo.equals("")) {
				
					JOptionPane.showMessageDialog(null, "Favor de llenar los campos.");
					limpiar();
					
				}
				else {

				
		       conexion conexion = new Clases.conexion();

		        //se utiliza para ejecutar proceso
		        CallableStatement stmt = null;
		        
		        String sCodRet = null;
		        String sMensaje= null;

		        try ( Connection cnx = conexion.conectar()) {

		            System.out.println("Creando sentencia...");
		            //el sql de invocación utiliza la notacion call + nombre proceso + parametros requeridos pro el proceso ? separados por ,
		            String sql = "{call SpActualizaMov (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
		            stmt = cnx.prepareCall(sql);

		            //Bind IN parameter first, then bind OUT parameter
		            
		            stmt.setString(1, iNumEmp);
		            stmt.setString(2, sNombre);
		            stmt.setString(3, sRol);
		            stmt.setString(4, sTipo);
		            stmt.setString(5, sFecha);
		            stmt.setString(6, sDiasTrabajados);
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
		            	JOptionPane.showMessageDialog(null, "Empleado actualizado correctamente.");
		            	llenarNumEmp();
		            	limpiar();
		            }
		            
		            System.out.println("Mensaje con el ID:"
		                    + sCodRet + " is " + sMensaje);
		            //cerrar recursos
		            stmt.close();
		            cnx.close();;

		        } catch (Exception r) {
		        	JOptionPane.showMessageDialog(null, "El numero de empleado no existe.");
		        	limpiar();
		        	System.out.println(r);
		        }
		    }
			
		}
		});
		btnModificarMov.setBounds(159, 11, 89, 23);
		panelButton.add(btnModificarMov);
		
		JButton btnEliminarMov = new JButton("Eliminar");
		btnEliminarMov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SnumEmp = null;
				SnumEmp = textNumeroMov.getText();
				
				if(SnumEmp.equals("")) {
				
					JOptionPane.showMessageDialog(null, "Favor de llenar los campos.");
					limpiar();
					
				}
				
				 //crea conexion
		       conexion conexion = new Clases.conexion();

		        //se utiliza para ejecutar proceso
		        CallableStatement stmt = null;
		        
		        String sCodRet = null;
		        String sMensaje= null;

		        try ( Connection cnx = conexion.conectar()) {

		            System.out.println("Creando sentencia...");
		            //el sql de invocación utiliza la notacion call + nombre proceso + parametros requeridos pro el proceso ? separados por ,
		            String sql = "{call SpEliminaMov (?, ?, ?)}";
		            stmt = cnx.prepareCall(sql);

		            //Bind IN parameter first, then bind OUT parameter
		            
		            stmt.setString(1, SnumEmp);
		            stmt.registerOutParameter("codigoRet", Types.CHAR);
		            stmt.registerOutParameter("mensaje", Types.VARCHAR);

		            
		            System.out.println("Ejecutando el procedimiento almacenado getMensaje...");
		            stmt.execute();

		            //Recupera el texto del mensaje y lo imprime en la consola
		            sCodRet = stmt.getString(2);
		            sMensaje = stmt.getString(3);
		            if(sCodRet.equals("00000")){
		            	JOptionPane.showMessageDialog(null, "Movimiento eliminado correctamente.");
		            	//llenarNumEmp();
		            	limpiar();
		            }
		            
		            System.out.println("Mensaje con el ID:"
		                    + sCodRet + " is " + sMensaje);
		            //cerrar recursos
		            stmt.close();
		            cnx.close();;

		        } catch (Exception r) {
		        	JOptionPane.showMessageDialog(null, "El numero de empleado no existe.");
		        	limpiar();
		        	System.out.println(r);
		        }
			}
		 
		});
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
		lblHrsLaborales.setBounds(173, 108, 103, 14);
		panelButton_1.add(lblHrsLaborales);
		
		textDiasLaborales = new JTextField();
		textDiasLaborales.setColumns(10);
		textDiasLaborales.setBounds(263, 104, 39, 20);
		panelButton_1.add(textDiasLaborales);
		
		JLabel lblHrsLaborales_1_1 = new JLabel("Entregas:");
		lblHrsLaborales_1_1.setBounds(10, 145, 71, 17);
		panelButton_1.add(lblHrsLaborales_1_1);
		
		textEntregas = new JTextField();
		textEntregas.setColumns(10);
		textEntregas.setBounds(71, 142, 39, 20);
		panelButton_1.add(textEntregas);
		
		texSueldo = new JTextField();
		texSueldo.setEnabled(false);
		texSueldo.setColumns(10);
		texSueldo.setBounds(249, 143, 53, 20);
		panelButton_1.add(texSueldo);
		
		JLabel vSueldo = new JLabel("Sueldo:");
		vSueldo.setBounds(173, 146, 71, 14);
		panelButton_1.add(vSueldo);
	}
}
