package es.studium.Programa;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextField;

	public class Vista extends Frame {
	private static final long serialVersionUID = 1L;

	MenuBar barraMenu = new MenuBar();

	// Ponemos las opciones del menu de la barra de menu

	Menu empleados = new Menu("Empleados");
	Menu usuarios = new Menu("Usuarios");
	
	// Declaramos las opciones que tendrá el menú desplegable de empleado

	MenuItem nuevo = new MenuItem("Nuevo Empleado");
	MenuItem eliminar = new MenuItem("Eliminar Empleado");
	MenuItem consultar = new MenuItem("Consultar Empleado");
	MenuItem modificar = new MenuItem("Modificar Empleado");

	// Continuamos creando el cuadro de dialogo de nuevo empleado

	Dialog dialogoNuevoEmpleado = new Dialog(this, "Nuevo Empleado", true);	
	Label lblNombreEmpleado = new Label("Nombre:");
	TextField txtNombreEmpleado = new TextField(20);
	Button btnNuevoEmpleado = new Button("Acepta");
	Button btnCancelarNuevoEmpleado = new Button("Cancelar");

	// Ahora creamos el cuadro de dialogo de Eliminar empleado

	Dialog dialogoEliminarEmpleado = new Dialog(this, "Eliminar Empleado", true);
	Label lblEliminarEmpleado = new Label("Empleado a borrar:");
	Choice choEmpleado = new Choice();
	Button btnEliminarEmpleado = new Button("Borrar");
	Button btnCancelarEliminarEmpleado = new Button("Cancelar");

	// Se Crea el cuadro de diálogo Consultar Empleado

	Panel panel1 = new Panel();
	Panel panel2 = new Panel();
	Panel panel3 = new Panel();
	
	Dialog dialogoConsultarEmpleado = new Dialog(this, "Consultar Empleado", true);
	Label lblIdEmpleado = new Label("Introducir número de empleado:");
	TextField txtIdEmpleado = new TextField(5);
	TextField txtIdEmpleado2 = new TextField(5);
	TextField txtNombreEmpleado2 = new TextField(20);
	Button btnConsultarEmpleado = new Button("Consultar");
	Button btnSalirConsultarEmpleado = new Button("Salir");

	// Creamos el cuadro de diálogo Modificar Empleado

	Dialog dialogoModificarEmpleado = new Dialog(this, "Modificar Empleado", true);
	Label lblModificarEmpleado = new Label("Empleado a modificar:");
	Choice choEmpleadoModificar = new Choice();
	Label lblNombreEmpleadoModificar = new Label("Nombre empreado a MODIFICAR:");
	Button btnModificarEmpleado = new Button("Modificar");
	Button btnCancelarModificarEmpleado = new Button("Cancelar");

	// Creamos el cuadro de diálogo Informar Resultado

	Dialog dialogoInformarEmpleado = new Dialog(this,"Información", true);
	Label lblEtiqueta1 = new Label();	
	Button btnSalir = new Button("Salir");		

	//ponemos el constructor
	public Vista() {
		setLayout(new FlowLayout());	
		setTitle("Menú");
		setMenuBar(barraMenu);		

		//Añadimos al menú Artículo las opciones de submenú, no olvidando las separaciones entre ellas con el addSeparator
		empleados.add(nuevo);	
		empleados.addSeparator();	
		empleados.add(eliminar);	
		empleados.addSeparator();	
		empleados.add(consultar);
		empleados.addSeparator();	
		empleados.add(modificar);
		barraMenu.add(empleados);

		setSize(300,200);
		setLocationRelativeTo(null);
		setVisible(true);

		//Establecemos el layout del cuadro de diálogo Nuevo Empleado y su tamaño

		dialogoNuevoEmpleado.setLayout(new FlowLayout());	
		dialogoNuevoEmpleado.setSize(300,150);
		dialogoNuevoEmpleado.setLocationRelativeTo(null);

		//Establecemos el layout del cuadro de diálogo Eliminar Empleado y su tamaño

		dialogoEliminarEmpleado.setLayout(new FlowLayout());	
		dialogoEliminarEmpleado.setSize(250,150);
		dialogoEliminarEmpleado.setLocationRelativeTo(null);

		//Establecemos el layout del cuadro de diálogo Consultar Empleado y su tamaño

		dialogoConsultarEmpleado.setLayout(new FlowLayout());	
		dialogoConsultarEmpleado.setSize(300,150);
		dialogoConsultarEmpleado.setLocationRelativeTo(null);

		//Establecemos el layout del cuadro de diálogo Modificar Empleado y su tamaño

		dialogoModificarEmpleado.setLayout(new FlowLayout());	
		dialogoModificarEmpleado.setSize(300,150);
		dialogoModificarEmpleado.setLocationRelativeTo(null);

		//Creamos el layout del cuadro de diálogo Modificar Empleado y su tamaño
		dialogoInformarEmpleado.setLayout(new FlowLayout());	
		dialogoInformarEmpleado.setSize(250,150);
		dialogoInformarEmpleado.setLocationRelativeTo(null);
	}	

}
