package Formularios;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Button;
import Clases.*;
public class Empleados extends JFrame {
	
	String sValor = null;
	String sTipo = null;
	private JPanel contentPane;
	private JTextField textNumero;
	private JTextField textNombre;
	ButtonGroup g1 = new  ButtonGroup();
	ButtonGroup g2 = new  ButtonGroup();

	
	public void limpiar() {
	//	textNumero.setText("");
		textNombre.setText("");	
		g1.clearSelection();
		g2.clearSelection();
		textNumero.transferFocus();
	}
	public void llenarNumEmp() {
		textNumero.setText(Integer.toString(1));
		 //crea conexion
	       conexion conexion = new Clases.conexion();

	        //se utiliza para ejecutar proceso
	       PreparedStatement stmt = null;
	        
	        int iMax = 0;
	        String sMensaje= null;

	        try  {
	        Connection con = conexion.conectar();  
	        PreparedStatement ps = con.prepareStatement("select max(numEmpleado) from nomina.Empleados");   
	        ResultSet rs = ps.executeQuery();
	        rs.next();
	        iMax = rs.getInt(1); 
	           
	            con.close();
	            if(iMax >= 0 ) {
	           
	            int SnumEmp = Integer.parseInt(textNumero.getText());
	    		
	            int icontador = 0; 
	    		 while( iMax>= icontador) {
	    			
	    			icontador ++;
	    		 }
	    		
	    		 textNumero.setText(Integer.toString(icontador));
	            }
	    	
	           

	        } catch (Exception r) {
	        //	JOptionPane.showMessageDialog(null, "El numero de empleado ya esta registrado.");
	        //	limpiar();
	        	System.out.println(r);
	        }
	    }
	
		
		
	

		
	/*	int SnumEmp = Integer.parseInt(textNumero.getText());
		
		int icontador = 0;
		 if(SnumEmp >= icontador) {
			
			 textNumero.setText(Integer.toString(icontador));
		 }
		 icontador++;*/
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Empleados frame = new Empleados();
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
	public Empleados() {
		
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("Empleados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 374);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JPanel panelButton = new JPanel();
		panelButton.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLayeredPane layeredPane = new JLayeredPane();
		
		JPanel panelButton_1 = new JPanel();
		panelButton_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panelRol = new JPanel();
		panelRol.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JPanel panelTipo = new JPanel();
		panelTipo.setBorder(new LineBorder(new Color(0, 0, 0)));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panelButton, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panelButton_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(panelRol, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panelTipo, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(53, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelButton, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addGap(16)
					.addComponent(panelButton_1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panelTipo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panelRol, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
					.addGap(5)
					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(21))
		);
		panelTipo.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tipo:");
		lblNewLabel.setBounds(10, 11, 37, 14);
		panelTipo.add(lblNewLabel);
		
		JRadioButton rdbtnInterno = new JRadioButton("Interno");
		rdbtnInterno.setBounds(41, 7, 111, 23);
		panelTipo.add(rdbtnInterno);
		
		JRadioButton rdbtnExterno = new JRadioButton("Externo");
		rdbtnExterno.setBounds(41, 32, 111, 23);
		panelTipo.add(rdbtnExterno);
		panelRol.setLayout(null);
		
		JRadioButton rdbtnChofer = new JRadioButton("Chofer");
		rdbtnChofer.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		rdbtnChofer.setBounds(52, 7, 71, 23);
		panelRol.add(rdbtnChofer);
		
		JRadioButton rdbtnCargador = new JRadioButton("Cargador");
		rdbtnCargador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		rdbtnCargador.setBounds(52, 33, 111, 23);
		panelRol.add(rdbtnCargador);
		
		JRadioButton rdbtnAuxiliar = new JRadioButton("Auxiliar");
		rdbtnAuxiliar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		rdbtnAuxiliar.setBounds(52, 55, 111, 23);
		panelRol.add(rdbtnAuxiliar);
		
		
		JLabel lblRol = new JLabel("Rol:");
		lblRol.setBounds(10, 11, 49, 14);
		panelRol.add(lblRol);
		panelButton_1.setLayout(null);
		
		JLabel lblNumero = new JLabel("N\u00FAmero:");
		lblNumero.setBounds(10, 11, 63, 14);
		panelButton_1.add(lblNumero);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 47, 63, 14);
		panelButton_1.add(lblNombre);
		
		textNumero = new JTextField();
		textNumero.setBounds(71, 8, 80, 20);
		panelButton_1.add(textNumero);
		textNumero.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBounds(71, 44, 260, 20);
		panelButton_1.add(textNombre);
		textNombre.setColumns(10);
		panelButton.setLayout(null);
		
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(10, 11, 72, 23);
		panelButton.add(btnNuevo);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textNombre.setText("");
				String SnumEmp = null;
				SnumEmp = textNumero.getText();
				String SnomEmp = null;
				SnomEmp = textNombre.getText();
			
				 //crea conexion
		       conexion conexion = new Clases.conexion();

		        //se utiliza para ejecutar proceso
		        CallableStatement stmt = null;
		        
		        String sCodRet = null;
		    

		        try ( Connection cnx = conexion.conectar()) {
		        	String sNombre = null;
		        	String sRol = null;
		        	String sTipo = null;

		            System.out.println("Creando sentencia...");
		            //el sql de invocación utiliza la notacion call + nombre proceso + parametros requeridos pro el proceso ? separados por ,
		            String sql = "{call SpBuscarEmpleados (?, ?, ?, ?, ?, ?, ?)}";
		            stmt = cnx.prepareCall(sql);

		            //Bind IN parameter first, then bind OUT parameter
		            
		            stmt.setString(1, SnumEmp);
		            stmt.setString(2, SnomEmp);
		            stmt.registerOutParameter("codigoRet", Types.CHAR);
		            stmt.registerOutParameter("iNumeroEmpleado", Types.INTEGER);
		            stmt.registerOutParameter("sNombreEmp", Types.VARCHAR);
		            stmt.registerOutParameter("sRol", Types.CHAR);
		            stmt.registerOutParameter("sTipo", Types.CHAR);
		            
		            
		            System.out.println("Ejecutando el procedimiento almacenado getMensaje...");
		            stmt.execute();

		            //Recupera el texto del mensaje y lo imprime en la consola
		            sCodRet = stmt.getString(3);
		            
		            sNombre = stmt.getString(5);
		            sRol = stmt.getString(6);
		            sTipo = stmt.getString(7);
		            
		           
		            
		            if(sCodRet.equals("00000")){
		            	textNumero.setText(Integer.toString(stmt.getInt(4)));
		            	textNombre.setText(sNombre);
		            //	textNombre.setText(sRol);	
		            //	textNombre.setText(sTipo);	
		            	
		            	if(sRol.equals("Chofer")) {
		            		(rdbtnChofer).setSelected(true);
		            	
						}
		            	if(sRol.equals("Cargador")) {
		            		(rdbtnCargador).setSelected(true);
		            		
						}
		            	if(sRol.equals("Auxiliar")) {
		            		(rdbtnAuxiliar).setSelected(true);
		            		
						}
		            	if(sTipo.equals("Interno")) {
		            		(rdbtnInterno).setSelected(true);
		            		
						}
		            	if(sTipo.equals("Externo")) {
		            		(rdbtnExterno).setSelected(true);
		            		
						}
		            	
		            	JOptionPane.showMessageDialog(null, "consulta exitosa.");
		            	 stmt.close();
				         cnx.close();
		            	
		            }
		          

		        } catch (Exception r) {
		        	JOptionPane.showMessageDialog(null, "El numero de empleado no se encuentra registrado");
		        	textNumero.setText("");
		        	//textNumero.transferFocus();
		        	limpiar();
		        	System.out.println(r);
		        }
		    }
		
			
			
			
		});
		btnBuscar.setBounds(81, 11, 89, 23);
		panelButton.add(btnBuscar);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String SnumEmp = null;
				SnumEmp = textNumero.getText();
				String SnomEmp = null;
				SnomEmp = textNombre.getText();
				
				if(SnomEmp.equals("") || SnumEmp.equals("")) {
				
					JOptionPane.showMessageDialog(null, "Favor de llenar los campos.");
					limpiar();
					
				}
				else {

				if(rdbtnChofer.isSelected() == true) {
					
					
					sValor =rdbtnChofer.getLabel();
				}
				
				if(rdbtnAuxiliar.isSelected() == true) {
					
					sValor =rdbtnAuxiliar.getLabel();
				
				}
				if(rdbtnCargador.isSelected() == true) {
					
					sValor = rdbtnCargador.getLabel();
				
				}
			
				
				System.out.println(sValor);
				 //crea conexion
		       conexion conexion = new Clases.conexion();

		        //se utiliza para ejecutar proceso
		        CallableStatement stmt = null;
		        
		        String sCodRet = null;
		        String sMensaje= null;

		        try ( Connection cnx = conexion.conectar()) {

		            System.out.println("Creando sentencia...");
		            //el sql de invocación utiliza la notacion call + nombre proceso + parametros requeridos pro el proceso ? separados por ,
		            String sql = "{call SpActualizaEmpleados (?, ?, ?, ?, ?, ?)}";
		            stmt = cnx.prepareCall(sql);

		            //Bind IN parameter first, then bind OUT parameter
		            
		            stmt.setString(1, SnumEmp);
		            stmt.setString(2, SnomEmp);
		            stmt.setString(3, sValor);
		            stmt.setString(4, "interno");
		            stmt.registerOutParameter("codigoRet", Types.CHAR);
		            stmt.registerOutParameter("mensaje", Types.VARCHAR);

		            
		            System.out.println("Ejecutando el procedimiento almacenado getMensaje...");
		            stmt.execute();

		            //Recupera el texto del mensaje y lo imprime en la consola
		            sCodRet = stmt.getString(5);
		            sMensaje = stmt.getString(6);
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
		btnModificar.setBounds(159, 11, 89, 23);
		panelButton.add(btnModificar);
		
		g1.add(rdbtnAuxiliar);
		g1.add(rdbtnChofer);
		g1.add(rdbtnCargador);
		g2.add(rdbtnInterno);
		g2.add(rdbtnExterno);
		
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SnumEmp = null;
				SnumEmp = textNumero.getText();
				String SnomEmp = null;
				SnomEmp = textNombre.getText();
				
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
		            String sql = "{call SpEliminaEmpleados (?, ?, ?)}";
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
		            	JOptionPane.showMessageDialog(null, "Empleado se elimino correctamente.");
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
		 }
		
		);
		btnEliminar.setBounds(246, 11, 89, 23);
		panelButton.add(btnEliminar);
		
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String SnumEmp = null;
				SnumEmp = textNumero.getText();
				String SnomEmp = null;
				SnomEmp = textNombre.getText();
				
				if(SnomEmp.equals("") || SnumEmp.equals("")) {
				
					JOptionPane.showMessageDialog(null, "Favor de llenar los campos.");
					limpiar();
					
				}
				else {

				if(rdbtnChofer.isSelected() == true) {
					
					
					sValor =rdbtnChofer.getLabel();
				}
				
				if(rdbtnAuxiliar.isSelected() == true) {
					
					sValor =rdbtnAuxiliar.getLabel();
				
				}
				if(rdbtnCargador.isSelected() == true) {
					
					sValor = rdbtnCargador.getLabel();
				
				}if(rdbtnInterno.isSelected() == true) {
					
					sTipo = rdbtnInterno.getLabel();
				
				}if(rdbtnExterno.isSelected() == true) {
					
					sTipo = rdbtnExterno.getLabel();
				
				}
			
				
				System.out.println(sValor);
				 //crea conexion
		       conexion conexion = new Clases.conexion();

		        //se utiliza para ejecutar proceso
		        CallableStatement stmt = null;
		        
		        String sCodRet = null;
		        String sMensaje= null;

		        try ( Connection cnx = conexion.conectar()) {

		            System.out.println("Creando sentencia...");
		            //el sql de invocación utiliza la notacion call + nombre proceso + parametros requeridos pro el proceso ? separados por ,
		            String sql = "{call SpInsertarEmpleados (?, ?, ?, ?, ?, ?)}";
		            stmt = cnx.prepareCall(sql);

		            //Bind IN parameter first, then bind OUT parameter
		            
		            stmt.setString(1, SnumEmp);
		            stmt.setString(2, SnomEmp);
		            stmt.setString(3, sValor);
		            stmt.setString(4, sTipo);
		            stmt.registerOutParameter("codigoRet", Types.CHAR);
		            stmt.registerOutParameter("mensaje", Types.VARCHAR);

		            
		            System.out.println("Ejecutando el procedimiento almacenado getMensaje...");
		            stmt.execute();

		            //Recupera el texto del mensaje y lo imprime en la consola
		            sCodRet = stmt.getString(5);
		            sMensaje = stmt.getString(6);
		            if(sCodRet.equals("00000")){
		            	JOptionPane.showMessageDialog(null, "Empleado registrado correctamente.");
		            	llenarNumEmp();
		            	limpiar();
		            }
		            
		            System.out.println("Mensaje con el ID:"
		                    + sCodRet + " is " + sMensaje);
		            //cerrar recursos
		            stmt.close();
		            cnx.close();;

		        } catch (Exception r) {
		        	JOptionPane.showMessageDialog(null, "El numero de empleado ya esta registrado.");
		        	limpiar();
		        	System.out.println(r);
		        }
		    }
		
			}
			
		});
		contentPane.setLayout(gl_contentPane);
	}
}
