package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;

import javax.jdo.JDODataStoreException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import negocio.AlohAndes;
import negocio.VOCliente;
import negocio.VOReserva;

@SuppressWarnings("serial")
public class InterfazCliente extends JFrame implements ActionListener{


	private static Logger log = Logger.getLogger(InterfazCliente.class.getName());
	private static final String CONFIG_INTERFAZ = "./src/config/interfaceConfigCliente.json"; 
	private static final String CONFIG_TABLAS = "./src/config/TablasBD.json";
	
	private JsonObject tableConfig;
	private AlohAndes alohAndes;
	 
	private JsonObject guiConfig;
	private PanelDatos panelDatos;
	private JMenuBar menuBar;
	
	public InterfazCliente( )
	  {
	    // Carga la configuración de la interfaz desde un archivo JSON
	    guiConfig = openConfig ("Interfaz", CONFIG_INTERFAZ);
	        
	    // Configura la apariencia del frame que contiene la interfaz gráfica
	    configurarFrame ( );
	    if (guiConfig != null) 	   
	    {
	   	crearMenu( guiConfig.getAsJsonArray("menuBar") );
	    }
	        
	    tableConfig = openConfig ("Tablas BD", CONFIG_TABLAS);
	    alohAndes = new AlohAndes (tableConfig);
	        
	    String path = guiConfig.get("bannerPath").getAsString();
	    panelDatos = new PanelDatos ( );

	    setLayout (new BorderLayout());
	    add (new JLabel (new ImageIcon (path)), BorderLayout.NORTH );          
        add( panelDatos, BorderLayout.CENTER );        
	   }
	 
	 private JsonObject openConfig (String tipo, String archConfig)
	    {
	    	JsonObject config = null;
			try 
			{
				Gson gson = new Gson( );
				FileReader file = new FileReader (archConfig);
				JsonReader reader = new JsonReader ( file );
				config = gson.fromJson(reader, JsonObject.class);
				log.info ("Se encontró un archivo de configuración válido: " + tipo);
			} 
			catch (Exception e)
			{
//				e.printStackTrace ();
				log.info ("NO se encontró un archivo de configuración válido");			
				JOptionPane.showMessageDialog(null, "No se encontró un archivo de configuración de interfaz válido: " + tipo, "Parranderos App", JOptionPane.ERROR_MESSAGE);
			}	
	        return config;
	    }
	 
	 private void configurarFrame(  )
	    {
	    	int alto = 0;
	    	int ancho = 0;
	    	String titulo = "";	
	    	
	    	if ( guiConfig == null )
	    	{
	    		log.info ( "Se aplica configuración por defecto" );			
				titulo = "Parranderos APP Default";
				alto = 300;
				ancho = 500;
	    	}
	    	else
	    	{
				log.info ( "Se aplica configuración indicada en el archivo de configuración" );
	    		titulo = guiConfig.get("title").getAsString();
				alto= guiConfig.get("frameH").getAsInt();
				ancho = guiConfig.get("frameW").getAsInt();
	    	}
	    	
	        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	        setLocation (50,50);
	        setResizable( true );
	        setBackground( Color.WHITE );

	        setTitle( titulo );
			setSize ( ancho, alto);        
	    }
	 
	 private void crearMenu(  JsonArray jsonMenu )
	    {    	
	    	// Creación de la barra de menús
	        menuBar = new JMenuBar();       
	        for (JsonElement men : jsonMenu)
	        {
	        	// Creación de cada uno de los menús
	        	JsonObject jom = men.getAsJsonObject(); 

	        	String menuTitle = jom.get("menuTitle").getAsString();        	
	        	JsonArray opciones = jom.getAsJsonArray("options");
	        	
	        	JMenu menu = new JMenu( menuTitle);
	        	
	        	for (JsonElement op : opciones)
	        	{       	
	        		// Creación de cada una de las opciones del menú
	        		JsonObject jo = op.getAsJsonObject(); 
	        		String lb =   jo.get("label").getAsString();
	        		String event = jo.get("event").getAsString();
	        		
	        		JMenuItem mItem = new JMenuItem( lb );
	        		mItem.addActionListener( this );
	        		mItem.setActionCommand(event);
	        		
	        		menu.add(mItem);
	        	}       
	        	menuBar.add( menu );
	        }        
	        setJMenuBar ( menuBar );	
	    }
	 
	 /*
	  * Métodos para los requerimientos funcionales
	  */
	 
	 public void registroCliente() {
		 
		 try {
			 
			 String nombre= JOptionPane.showInputDialog(this, "Nombre del cliente?", "Registro ciente", JOptionPane.QUESTION_MESSAGE);
			 String correo=JOptionPane.showInputDialog(this, "Correo", "Registro ciente", JOptionPane.QUESTION_MESSAGE);
			 String telefono=JOptionPane.showInputDialog(this, "Telefono?", "Registro ciente", JOptionPane.QUESTION_MESSAGE);
			 String tipoMiembro=JOptionPane.showInputDialog(this, "TipoMiembro?", "Registro ciente", JOptionPane.QUESTION_MESSAGE);
			 if (nombre!=null && correo!=null && telefono!=null && tipoMiembro!=null) {
				 VOCliente tb= alohAndes.adicionarCliente(nombre, correo, telefono, tipoMiembro);
				 if (tb == null)
	        		{
	        			throw new Exception ("No se registrar al cliente con el nombre: " + nombre);
	        	}else {
	        		String resultado = "En registroCliente\n\n";
	        		resultado += "Cliente adicionado exitosamente: " + tb;
	    			resultado += "\n Operación terminada";
	    			panelDatos.actualizarInterfaz(resultado);
	        	}
			 }
		 }
		 catch (Exception e) {
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		 }
	 }
	 
	 public void cancelarReserva() {
		 
		 try {
			 String idInput= JOptionPane.showInputDialog(this, "id de reserva?", "Cancelar reserva", JOptionPane.QUESTION_MESSAGE);
			 Long id=Long.parseLong(idInput);
			 if (id!=null) {
				 alohAndes.eliminarReservaPorId(id);
				 String resultado = "En cancelarReserva \n\n";
	     		 resultado += "reserva eliminada exitosamente";
	 			 resultado += "\n Operación terminada";
	 			 panelDatos.actualizarInterfaz(resultado);
			 }
		 }
		 catch (Exception e) {
				String resultado = generarMensajeError(e);
				panelDatos.actualizarInterfaz(resultado);
			 }
	 }
	 
	 public void registroReserva() {
		 
	 }
	 
	
	 /*
	  * Main
	  */
	 
	 public static void main( String[] args )
	    {
	        try
	        {
	        	
	            // Unifica la interfaz para Mac y para Windows.
	            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );
	            InterfazCliente interfaz = new InterfazCliente( );
	            interfaz.setVisible( true );
	        }
	        catch( Exception e )
	        {
	            e.printStackTrace( );
	        }
	    }
	 
	 private String generarMensajeError(Exception e) 
		{
			String resultado = "************ Error en la ejecución\n";
			resultado += e.getLocalizedMessage() + ", " + darDetalleException(e);
			resultado += "\n\nRevise datanucleus.log y parranderos.log para más detalles";
			return resultado;
		}
	 
	 private String darDetalleException(Exception e) 
		{
			String resp = "";
			if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
			{
				JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
				return je.getNestedExceptions() [0].getMessage();
			}
			return resp;
		}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
