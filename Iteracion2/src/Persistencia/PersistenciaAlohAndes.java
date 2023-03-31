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
import negocio.ServicioAdicionalUsado;
import negocio.ServicioIncluido;
import negocio.ServicioNoIncluido;
import negocio.Vecino;
import negocio.ViviendaUniversitaria;

public class PersistenciaAlohAndes {
	
	private static Logger log =Logger.getLogger(PersistenciaAlohAndes.class.getName());
	
	public final static String SQL = "javax.jdo.query.SQL";
	
	private static PersistenciaAlohAndes instance;
	
	private PersistenceManagerFactory pmf;
	
	private List <String> tablas;
	
	private SQLUtil sqlUtil;
	
	private SQLApartamento sqlApartamento;
	
	private SQLCasa sqlCasa;
	
	private SQLCliente sqlCliente;
	
	private SQLHabitacion sqlHabitacion;
	
	private SQLHostal sqlHostal;
	
	private SQLHotel sqlHotel;
	
	private SQLInmueble sqlInmueble;
	
	private SQLOperador sqlOperador;
	
	private SQLPersonaNatural sqlPersonaNatural;
	
	private SQLReserva sqlReserva;
	
	private SQLServicio sqlServicio;
	
	private SQLServicioAdicionalUsado sqlServicioAdicionalUsado;
	
	private SQLServicioIncluido sqlServicioIncluido;
	
	private SQLServicioNoIncluido sqlServicioNoIncluido;
	
	private SQLVecino sqlVecino;
	
	private SQLViviendaUniversitaria sqlViviendaUniversitaria;
	
	/*
	 * Métodos del manejador de persistencia
	 */
	
	private PersistenciaAlohAndes()
	{
		pmf= JDOHelper.getPersistenceManagerFactory("AlohAndes");
		crearClasesSQL();
		
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
		tablas.add("ServicioAdicionalUsado");
		tablas.add("ServicioIncluido");
		tablas.add("ServicioNoIncluido");
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
	
	private void crearClasesSQL() {
		sqlApartamento= new SQLApartamento(this);
		sqlCasa= new SQLCasa (this);
		sqlCliente= new SQLCliente (this);
		sqlHabitacion= new SQLHabitacion (this);
		sqlHostal= new SQLHostal(this);
		sqlHotel= new SQLHotel (this);
		sqlInmueble= new SQLInmueble (this);
		sqlOperador= new SQLOperador (this);
		sqlPersonaNatural= new SQLPersonaNatural (this);
		sqlReserva= new SQLReserva (this);
		sqlServicio= new SQLServicio(this);
		sqlServicioAdicionalUsado= new SQLServicioAdicionalUsado (this);
		sqlServicioIncluido= new SQLServicioIncluido (this);
		sqlServicioNoIncluido= new SQLServicioNoIncluido (this);
		sqlVecino= new SQLVecino(this);
		sqlViviendaUniversitaria= new SQLViviendaUniversitaria (this);
	}
	
	public String darSeqAlohAndes() {
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
	
	public String darTablaServicioAdicionalUsado() {
		return tablas.get(12);
	}
	
	public String darTablaServicioIncluido() {
		return tablas.get(13);
	}
	
	public String darTablaServicioNoIncluido() {
		return tablas.get(14);
	}
	
	public String darTablaVecino() {
		return tablas.get(15);
	}
	
	public String darTablaViviendaUniversitaria() {
		return tablas.get(16);
	}
	
	private long nextval ()
	{
		long resp = sqlUtil.nextval(pmf.getPersistenceManager());
        log.trace ("Generando secuencia: " + resp);
        return resp;
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
	
	/* ********************************************************
	 * Métodos para manejar los APARTAMENTOS
	 * ********************************************************
	 */
	
	public Apartamento adicionarApartamento (boolean amoblado, int cantHabitaciones) {
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long id = nextval ();
            long tuplasInsertadas = sqlApartamento.adicionarApartamento(pm, id, amoblado, cantHabitaciones);
            tx.commit();
            
            log.trace ("Inserción del apartamento: " + id + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Apartamento (id, amoblado, cantHabitaciones);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public long eliminarApartamentoPorId(long id) {
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlApartamento.eliminarApartamento(pm, id);
            tx.commit();
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public List<Apartamento> darApartamentos ()
	{
		return sqlApartamento.darApartamentos (pmf.getPersistenceManager());
	}
	
	public Apartamento darApartamentosPorId (long id)
	{
		return sqlApartamento.darApartamentoPorId (pmf.getPersistenceManager(), id);
	}
	
	/* *******************************
	 * Métodos para manejar las CASAS
	 *********************************/
	
	public Casa adicionarCasa(int cantHabitaciones, String seguro) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();            
            long id = nextval ();
            long tuplasInsertadas = sqlCasa.adicionarCasa(pm, id, cantHabitaciones, seguro);
            tx.commit();
            
            log.trace ("Inserción casa: " + id + ": " + tuplasInsertadas + " tuplas insertadas");
            return new Casa (id, cantHabitaciones, seguro);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public long eliminarCasaPorId (long id) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlCasa.eliminarCasaPorId (pm, id);
            tx.commit();

            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public List<Casa> darCasas ()
	{
		return sqlCasa.darCasas (pmf.getPersistenceManager());
	}
	
	/* **********************************
	 * Métodos para manejar los CLIENTES
	 * *********************************/

	public Cliente adicionarTipoBebida(String nombre, String correo, String telefono, String tipoMiembro)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long id = nextval ();
            long tuplasInsertadas = sqlCliente.adicionarCliente(pm, id, nombre, correo, telefono, tipoMiembro);
            tx.commit();
            
            log.trace ("Inserción del cliente: " + nombre + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Cliente (id, nombre, correo, telefono, tipoMiembro);
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return null;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public long eliminarClientePorNombre (String nombre) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlCliente.eliminarClientePorNombre(pm, nombre);
            tx.commit();
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public long eliminarClientePorId (long id) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlCliente.eliminarClientePorId(pm, id);
            tx.commit();
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
            return -1;
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
	}
	
	public List<Cliente> darClientes ()
	{
		return sqlCliente.darClientes (pmf.getPersistenceManager());
	}
	
	public Cliente darTipoBebidaPorId (long idTipoBebida)
	{
		return sqlCliente.darClientePorId (pmf.getPersistenceManager(), idTipoBebida);
	}
	
	public Cliente darTipoBebidaPorNombre (String nombre)
	{
		return sqlCliente.darClientePorNombre (pmf.getPersistenceManager(), nombre);
	}
	
	/* *****************************
	 * Método para las HABITACIONES
	 ******************************/

}
