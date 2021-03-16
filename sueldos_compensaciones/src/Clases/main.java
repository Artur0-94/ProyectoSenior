package Clases;

import java.awt.event.WindowAdapter;

import Formularios.Empleados;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	conexion c = new conexion();
		if(c.conectar()!= null) {
		*/
		
		Formularios.Empleados e = new Empleados();
		e.llenarNumEmp();
	}
			
}
		



