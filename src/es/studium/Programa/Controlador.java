package es.studium.Programa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;


public class Controlador implements WindowListener, ActionListener, ItemListener {
	Modelo modelo = null;	
	Vista vista = null;
	
	public Controlador(Modelo modelo, Vista vista) {	
		this.modelo = modelo;		
		this.vista = vista;
		
		// Añadimos el Windowlistener a cada opción de submenú del menú Artículos
		
		vista.nuevo.addActionListener(this);		
		vista.eliminar.addActionListener(this);		
		vista.consultar.addActionListener(this);
		vista.modificar.addActionListener(this);
		
		vista.btnNuevoEmpleado.addActionListener(this);
		vista.btnCancelarNuevoEmpleado.addActionListener(this);
		
		vista.btnEliminarEmpleado.addActionListener(this);
		vista.btnCancelarEliminarEmpleado.addActionListener(this);
		
		vista.btnConsultarEmpleado.addActionListener(this);
		vista.btnSalirConsultarEmpleado.addActionListener(this);		
		
		vista.btnModificarEmpleado.addActionListener(this);
		vista.btnCancelarModificarEmpleado.addActionListener(this);
		
		vista.btnSalir.addActionListener(this);
		
		vista.choEmpleadoModificar.addItemListener(this);
		
		// Añadimos el Windowlistener a las ventanas 
		
		vista.addWindowListener(this);
		
		// Para poder cerrar el Diálogo, añadimos el listener a los cuadro de diálogo
		
		vista.dialogoNuevoEmpleado.addWindowListener(this);
		vista.dialogoEliminarEmpleado.addWindowListener(this);
		vista.dialogoConsultarEmpleado.addWindowListener(this);
		vista.dialogoModificarEmpleado.addWindowListener(this);
		vista.dialogoInformarEmpleado.addWindowListener(this);
	
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		Object a;
		
		a = ae.getSource();
		
		if (a.equals(vista.nuevo)) {
			//añade la etiqueta la cuadro de diálogo y la hace visible
			
			vista.dialogoNuevoEmpleado.add(vista.lblNombreEmpleado);
			vista.dialogoNuevoEmpleado.add(vista.txtNombreEmpleado);
			vista.dialogoNuevoEmpleado.add(vista.btnNuevoEmpleado);
			vista.dialogoNuevoEmpleado.add(vista.btnCancelarNuevoEmpleado);
			vista.dialogoNuevoEmpleado.setVisible(true);		
		}
		else if (a.equals(vista.btnCancelarNuevoEmpleado)) {
			vista.dialogoNuevoEmpleado.setVisible(false);
		}
		else if (a.equals(vista.btnNuevoEmpleado)) {
			// Conectamos con la base de datos
			Connection con = modelo.conectar("empresa","root","Studium2019;");
			
			// Hacer el insert
			int respuesta = modelo.insertar(con, "empleados", vista.txtNombreEmpleado.getText());
			
			// Mostramos resultado obtenido
			if(respuesta == 0) {
			
				System.out.println("ALTA de empleado correcta");
				vista.dialogoInformarEmpleado.add(vista.lblEtiqueta1);
				vista.lblEtiqueta1.setText(modelo.rellenarLabel("ALTA de empleado correcta"));
				vista.dialogoInformarEmpleado.add(vista.btnSalir);
				vista.dialogoInformarEmpleado.setVisible(true);				
			}
			else {
				System.out.println("Error en ALTA de empleado");
				vista.dialogoInformarEmpleado.add(vista.lblEtiqueta1);
				vista.lblEtiqueta1.setText(modelo.rellenarLabel("Error en ALTA de empleado"));
				vista.dialogoInformarEmpleado.add(vista.btnSalir);
				vista.dialogoInformarEmpleado.setVisible(true);	
			}
			
			vista.txtNombreEmpleado.selectAll();
			vista.txtNombreEmpleado.setText("");
			
			// Desconectamos de la base de datos
			modelo.desconectar(con);
		}
		else if (a.equals(vista.eliminar)) {
			vista.dialogoEliminarEmpleado.add(vista.lblEliminarEmpleado);
			vista.dialogoEliminarEmpleado.add(vista.choEmpleado);
			modelo.rellenarChoice(vista.choEmpleado);
			vista.dialogoEliminarEmpleado.add(vista.btnEliminarEmpleado);
			vista.dialogoEliminarEmpleado.add(vista.btnCancelarEliminarEmpleado);
			vista.dialogoEliminarEmpleado.setVisible(true);
		}
		else if (a.equals(vista.btnCancelarEliminarEmpleado)) {
			vista.dialogoEliminarEmpleado.setVisible(false);
		}
		else if (a.equals(vista.btnEliminarEmpleado)) {
			// Conectar a BD
			Connection con = modelo.conectar("empresa","root","Studium2019;"); 
			
			// Borrar
			String[] Empleado=vista.choEmpleado.getSelectedItem().split("-");
			int respuesta = modelo.borrar(con, "empleados","idEmpleado",Integer.parseInt(Empleado[0]));
			
			// Desconectar de la base de datos
			modelo.desconectar(con);
			
			// Mostramos el resultado obtenido
			if(respuesta == 0) {
				System.out.println("BAJA de empleado correcta");
				vista.dialogoInformarEmpleado.add(vista.lblEtiqueta1);
				vista.lblEtiqueta1.setText(modelo.rellenarLabel("BAJA de empleado correcta"));
				vista.dialogoInformarEmpleado.add(vista.btnSalir);
				vista.dialogoInformarEmpleado.setVisible(true);				
			}
			else {
				System.out.println("Error en BAJA de empleado");
				vista.dialogoInformarEmpleado.add(vista.lblEtiqueta1);
				vista.lblEtiqueta1.setText(modelo.rellenarLabel("Error en BAJA de empleado"));
				vista.dialogoInformarEmpleado.add(vista.btnSalir);
				vista.dialogoInformarEmpleado.setVisible(true);	
			}
			vista.choEmpleado.removeAll();
			modelo.rellenarChoice(vista.choEmpleado);			
		}
		else if (a.equals(vista.modificar)) {
			vista.dialogoModificarEmpleado.add(vista.lblModificarEmpleado);
			vista.dialogoModificarEmpleado.add(vista.choEmpleadoModificar);
			modelo.rellenarChoice(vista.choEmpleadoModificar);			
			vista.dialogoModificarEmpleado.add(vista.lblNombreEmpleadoModificar);
			vista.dialogoModificarEmpleado.add(vista.txtNombreEmpleado);
			vista.dialogoModificarEmpleado.add(vista.btnModificarEmpleado);
			vista.dialogoModificarEmpleado.add(vista.btnCancelarModificarEmpleado);
			vista.dialogoModificarEmpleado.setVisible(true);
		}
		else if (a.equals(vista.btnCancelarModificarEmpleado)) {
			vista.dialogoModificarEmpleado.setVisible(false);
		}		
		else if (a.equals(vista.btnModificarEmpleado)) {
			// Conectar a BD
			Connection con = modelo.conectar("empresa","root","Studium2019;"); 
			
			// Borrar
			String[] Empleado=vista.choEmpleadoModificar.getSelectedItem().split("-");
			
			int respuesta = modelo.modificar(con,vista.txtNombreEmpleado.getText(),Integer.parseInt(Empleado[0]));
			
			// Desconectar de la base
			modelo.desconectar(con);
			
			// Mostramos resultado
			if(respuesta == 0) {
				System.out.println("MODIFICACIÓN de empleado correcta");
				vista.dialogoInformarEmpleado.add(vista.lblEtiqueta1);
				vista.lblEtiqueta1.setText(modelo.rellenarLabel("MODIFICACIÓN empleado correcta"));
				vista.dialogoInformarEmpleado.add(vista.btnSalir);
				vista.dialogoInformarEmpleado.setVisible(true);				
			}
			else {
				System.out.println("Error en MODIFICACIÓN de empleado");
				vista.dialogoInformarEmpleado.add(vista.lblEtiqueta1);
				vista.lblEtiqueta1.setText(modelo.rellenarLabel("Error MODIFICACIÓN empleado"));
				vista.dialogoInformarEmpleado.add(vista.btnSalir);
				vista.dialogoInformarEmpleado.setVisible(true);	
			}
			vista.txtNombreEmpleado.selectAll();
			vista.txtNombreEmpleado.setText("");
			vista.choEmpleadoModificar.removeAll();
			modelo.rellenarChoice(vista.choEmpleadoModificar);			
						
		}		
		else if(a.equals(vista.consultar)) {
			vista.dialogoConsultarEmpleado.add(vista.panel1);
			vista.panel1.add(vista.lblIdEmpleado);
			vista.panel1.add(vista.txtIdEmpleado);
			vista.dialogoConsultarEmpleado.add(vista.panel2);
			vista.panel2.add(vista.btnConsultarEmpleado);
			vista.dialogoConsultarEmpleado.add(vista.panel3);
			vista.panel3.add(vista.txtIdEmpleado2);
			vista.txtIdEmpleado2.setEnabled(false);
			vista.panel3.add(vista.txtNombreEmpleado2);
			vista.txtNombreEmpleado2.setEnabled(false);
			vista.dialogoConsultarEmpleado.add(vista.btnSalirConsultarEmpleado);
			vista.dialogoConsultarEmpleado.setVisible(true);
		}
		else if (a.equals(vista.btnSalirConsultarEmpleado)) {
		
			vista.dialogoConsultarEmpleado.setVisible(false);
		}
		else if (a.equals(vista.btnConsultarEmpleado)) {
			// Conectar a la base de datos
			Connection con = modelo.conectar("empresa","root","Beatty44*5"); 
			
			modelo.mostrarDatos(con, Integer.parseInt(vista.txtIdEmpleado.getText()), vista.txtIdEmpleado2, vista.txtNombreEmpleado2);
			
			// Desconectar de la base
			modelo.desconectar(con);
		}
		else {
			vista.dialogoInformarEmpleado.setVisible(false);
		}
		
	}
	
	public void itemStateChanged(ItemEvent arg0) {
		String[] Empleado=vista.choEmpleadoModificar.getSelectedItem().split("-");
		vista.txtNombreEmpleado.setText(Empleado[1]);
	}
	
	public void windowActivated(WindowEvent arg0) {}	
	public void windowClosed(WindowEvent arg0) {}		
	public void windowClosing(WindowEvent we) {
	
		if (vista.dialogoNuevoEmpleado.isActive())
		{		
			vista.dialogoNuevoEmpleado.setVisible(false);		
		} 
		else if (vista.dialogoEliminarEmpleado.isActive())
		{		
			vista.dialogoEliminarEmpleado.setVisible(false);		
		}
		else if (vista.dialogoConsultarEmpleado.isActive())
		{		
			vista.dialogoConsultarEmpleado.setVisible(false);		
		} 
		else if (vista.dialogoModificarEmpleado.isActive())
		{		
			vista.dialogoModificarEmpleado.setVisible(false);		
		}
		else if (vista.dialogoInformarEmpleado.isActive())
		{		
			vista.dialogoInformarEmpleado.setVisible(false);		
		} 
		else
		{		
			System.exit(0);		
		}
	}	
	public void windowDeactivated(WindowEvent arg0) {}	
	public void windowDeiconified(WindowEvent arg0) {}		
	public void windowIconified(WindowEvent arg0) {	}
	public void windowOpened(WindowEvent arg0) {}
}