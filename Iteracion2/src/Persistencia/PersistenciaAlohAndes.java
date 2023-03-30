package Persistencia;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import org.apache.log4j.Logger;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import negocio.Apartamento;
import negocio.Casa;
import negocio.Cliente;
import negocio.Habitacion;
import negocio.Hostal;
import negocio.Hotel;
import negocio.Inmueble;
import negocio.Operador;
import negocio.PersonaNatural;
import negocio.Reserva;
import negocio.Servicio;
import negocio.ServiciosAdicionalesUsados;
import negocio.ServiciosIncluidos;
import negocio.ServiciosNoIncluidos;
import negocio.Vecino;
import negocio.ViviendaUniversitaria;
import oracle.sql.SQLUtil;

public class PersistenciaAlohAndes {
	
	private static Logger log =Logger.getLogger(PersistenciaAlohAndes.class.getName());
	
	public final static String SQL = "javax.jdo.query.SQL";
	
	private static PersistenciaAlohAndes instance;
	
	private PersistenceManagerFactory pmf;
	
	private List <String> tablas;
	
	private SQLUtil sqlUtil;
	
	/*
	 * Métodos del manejador de persistencia
	 */
	
	private PersistenciaAlohAndes()
	{
		pmf= JDOHelper.getPersistenceManagerFactory("AlohAndes");
		//crearClasesSQL()
		
		tablas= new LinkedList<String>();
		tablas.add("AlohAndes_sequence");
		tablas.add("Apartamento");
		tablas.add("Casa");
		tablas.add("Cliente");
		tablas.add("Habitación");
		tablas.add("Hostal");
		tablas.add("Hotel");
		tablas.add("Inmueble");
		tablas.add("Operador");
		tablas.add("PersonaNatural");
		tablas.add("Reserva");
		tablas.add("Servicio");
		tablas.add("ServiciosAdicionalesUsados");
		tablas.add("ServiciosIncluidos");
		tablas.add("ServiciosNoIncluidos");
		tablas.add("Vecino");
		tablas.add("ViviendaUniversitaria");
		
	}
	
	private PersistenciaAlohAndes (JsonObject tableConfig)
	{
		//crearClasesSQL();
		tablas= leerNombresTablas(tableConfig);
		
		String unidadPersistencia= tableConfig.get("unidadPersistencia").getAsString();
		log.trace("Accediendo unidad de persistencia: "+unidadPersistencia);
		pmf= JDOHelper.getPersistenceManagerFactory(unidadPersistencia);
	}
	
	public static PersistenciaAlohAndes getInstance()
	{
		if(instance==null)
		{
			instance=new PersistenciaAlohAndes();
		}
		return instance;
	}
	
	public static PersistenciaAlohAndes getInstance(JsonObject tableConfig)
	{
		if(instance==null)
		{
			instance=new PersistenciaAlohAndes(tableConfig);
		}
		return instance;
	}
	
	public void cerrarUnidadPersistencia()
	{
		pmf.close();
		instance=null;
	}
	
	private List<String> leerNombresTablas(JsonObject tableConfig)
	{
		JsonArray nombres= tableConfig.getAsJsonArray("tablas");
		List<String> resp= new LinkedList<String> ();
		for(JsonElement nom:nombres)
		{
			resp.add(nom.getAsString());
		}
		return resp;
	}
	
	public String darSequAlohAndes() {
		return tablas.get(0);
	}
	
	public String darTablaApartamento() {
		return tablas.get(1);
	}
	
	public String darTablaCasa() {
		return tablas.get(2);
	}
	
	public String darTablaCliente() {
		return tablas.get(3);
	}
	
	public String darTablaHabitacion() {
		return tablas.get(4);
	}
	
	public String darTablaHostal() {
		return tablas.get(5);
	}
	
	public String darTablaHotel() {
		return tablas.get(6);
	}
	
	public String darTablaInmueble() {
		return tablas.get(7);
	}
	
	public String darTablaOperador() {
		return tablas.get(8);
	}
	
	public String darTablaPersonaNatural() {
		return tablas.get(9);
	}
	
	public String darTablaReserva() {
		return tablas.get(10);
	}
	
	public String darTablaServicio() {
		return tablas.get(11);
	}
	
	public String darTablaServiciosAdicionalesUsados() {
		return tablas.get(12);
	}
	
	public String darTablaServiciosIncluidos() {
		return tablas.get(13);
	}
	
	public String darTablaServiciosNoIncluidos() {
		return tablas.get(14);
	}
	
	public String darTablaVecino() {
		return tablas.get(15);
	}
	
	public String darTablaViviendaUniversitaria() {
		return tablas.get(16);
	}
}
