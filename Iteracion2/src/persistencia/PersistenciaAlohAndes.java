package persistencia;

import java.sql.Date;
import java.sql.Time;
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
import negocio.ServicioUsado;
import negocio.ViviendaUniversitaria;

public class PersistenciaAlohAndes {
	
	private static Logger log =Logger.getLogger(PersistenciaAlohAndes.class.getName());
	
	public final static String SQL = "javax.jdo.query.SQL";
	
	private static PersistenciaAlohAndes instance;
	
	private List <String> tablas;
	
	private SQLUtil sqlUtil;
	
	private PersistenceManagerFactory pmf;

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
	
	private SQLServicioUsado sqlServicioUsado;
	
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
		tablas.add("ServicioUsado");
		tablas.add("ServicioInmueble");
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
		sqlServicioUsado= new SQLServicioUsado (this);
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
	
	public Apartamento adicionarApartamento (int costoBase, long idOperador, boolean amoblado, int cantHabitaciones) {
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long id = nextval ();
            long tuplasInsertadas = sqlApartamento.adicionarApartamento(pm, id, amoblado, cantHabitaciones);
            tx.commit();
            
            log.trace ("Inserción del apartamento: " + id + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Apartamento (id, costoBase, idOperador, amoblado, cantHabitaciones);
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
	
	public Casa adicionarCasa(int costoBase, long idOperador, int cantHabitaciones, String seguro) 
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
            return new Casa (id, costoBase, idOperador, cantHabitaciones, seguro);
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

	public Cliente adicionarClientes(String nombre, String correo, String telefono, String tipoMiembro)
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
	
	public Cliente darClientePorId (long idTipoBebida)
	{
		return sqlCliente.darClientePorId (pmf.getPersistenceManager(), idTipoBebida);
	}
	
	public Cliente darClientePorNombre (String nombre)
	{
		return sqlCliente.darClientePorNombre (pmf.getPersistenceManager(), nombre);
	}
	
	/* *****************************
	 * Método para las HABITACIONES
	 ******************************/

	public Habitacion adicionarHabitacion(int costoBase, long idOperador, int capacidad, boolean compartida, String tipo)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long id = nextval ();
            long tuplasInsertadas = sqlHabitacion.adicionarHabitacion(pm, id, capacidad, compartida,tipo);
            tx.commit();
            
            log.trace ("Inserción de la habitacion: " + id + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Habitacion (id, costoBase, idOperador, capacidad, compartida,tipo);
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
	
	public long eliminarHabitacionPorId (long id) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlHabitacion.eliminarHabitacionPorId(pm, id);
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
	
	public List<Habitacion> darHabitaciones ()
	{
		return sqlHabitacion.darHabitaciones (pmf.getPersistenceManager());
	}
	
	public Habitacion datHabitacionPorId (long id)
	{
		return sqlHabitacion.darHabitacionPorId (pmf.getPersistenceManager(), id);
	}
	
	/* *************************
	 * Método para los HOSTALES
	 ***************************/
	
	public Hostal adicionarHostal(String nombre, String tipoOperador, int cantHabitaciones, String registroCamaraComercio, String registroSuperIntendencia, Time horaApertura, Time horaCierre)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long id = nextval ();
            long tuplasInsertadas = sqlHostal.adicionarHostal(pm, id, registroCamaraComercio, registroSuperIntendencia, horaApertura, horaCierre);
            tx.commit();
            
            log.trace ("Inserción del hostal: " + id + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Hostal (id, nombre, tipoOperador, cantHabitaciones, registroCamaraComercio, registroSuperIntendencia, horaApertura, horaCierre);
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
	
	public long eliminarHostalPorId (long id) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlHostal.eliminarHostalPorId(pm, id);
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
	
	public List<Hostal> darHostales ()
	{
		return sqlHostal.darHostales (pmf.getPersistenceManager());
	}
	
	public Hostal darHostalPorId (long id)
	{
		return sqlHostal.darHostalPorId (pmf.getPersistenceManager(), id);
	}
	
	/* **************************
	 * Métodos para los HOTELES
	 *****************************/
	
	public Hotel adicionarHotel(String nombre, String tipoOperador, int cantHabitaciones, String registroCamaraComercio, String registroSuperIntendencia)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long id = nextval ();
            long tuplasInsertadas = sqlHotel.adicionarHotel(pm, id, registroCamaraComercio, registroSuperIntendencia);
            tx.commit();
            
            log.trace ("Inserción del hotel: " + id + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Hotel (id, nombre, tipoOperador, cantHabitaciones, registroCamaraComercio, registroSuperIntendencia);
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
	
	public long eliminarHotelPorId (long id) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlHotel.eliminarHotelPorId(pm, id);
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
	
	public List<Hotel> darHoteles ()
	{
		return sqlHotel.darHoteles (pmf.getPersistenceManager());
	}
	
	public Hotel darHotelPorId (long id)
	{
		return sqlHotel.darHotelPorId (pmf.getPersistenceManager(), id);
	}
	
	/* ***************************
	 * Métodos para los inmuebles
	 *****************************/
	
	public Inmueble adicionarInmueble(int costoBase, long idOperador)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long id = nextval ();
            long tuplasInsertadas = sqlInmueble.adicionarInmueble(pm, id, costoBase, idOperador);
            tx.commit();
            
            log.trace ("Inserción del Inmueble: " + id + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Inmueble (id, costoBase, idOperador);
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
	
	public long eliminarInmueblePorId (long id) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlInmueble.eliminarInmueblePorId(pm, id);
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
	
	public List<Inmueble> darInmueble ()
	{
		return sqlInmueble.darInmuebles (pmf.getPersistenceManager());
	}
	
	public Inmueble darInmueblePorId (long id)
	{
		return sqlInmueble.darInmueblePorId (pmf.getPersistenceManager(), id);
	}
	
	/* **************************
	 * Métodos de los OPERADORES
	 ****************************/
	
	public Operador adicionarOperador(String nombre, String tipoOperador)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long id = nextval ();
            long tuplasInsertadas = sqlOperador.adicionarOperador(pm, id, nombre, tipoOperador);
            tx.commit();
            
            log.trace ("Inserción del operador: " + id + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Operador (id,nombre, tipoOperador);
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
	
	public long eliminarOperadorPorId (long id) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlOperador.eliminarOperadorPorId(pm, id);
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
	
	public List<Operador> darOperador ()
	{
		return sqlOperador.darOperadores (pmf.getPersistenceManager());
	}
	
	public Operador darOperadorPorId (long id)
	{
		return sqlOperador.darOperadorPorId (pmf.getPersistenceManager(), id);
	}
	
	/*
	 * Métodos de las PERSONAS NATURALES
	 */
	
	public PersonaNatural adicionarPersonaNatural(String nombre, String tipoOperador, String correo, String telefono)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long id = nextval ();
            long tuplasInsertadas = sqlPersonaNatural.adicionarPersonaNatural(pm, id, correo, telefono);
            tx.commit();
            
            log.trace ("Inserción de persona natural: " + id + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new PersonaNatural (id,nombre, tipoOperador, correo, telefono);
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
	
	public long eliminarPersonaNaturalPorId (long id) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlPersonaNatural.eliminarPersonaNaturalPorId(pm, id);
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
	
	public List<PersonaNatural> darPersonaNatural ()
	{
		return sqlPersonaNatural.darPersonasNaturales (pmf.getPersistenceManager());
	}
	
	public PersonaNatural darPersonaNaturalPorId (long id)
	{
		return sqlPersonaNatural.darPersonaNaturalPorId (pmf.getPersistenceManager(), id);
	}
	
	/* ***************************
	 * Método para las RESERVAS
	 ****************************/
	
	public Reserva adicionarReserva(Date fechaInicio, Date fechaFin, long idCliente, long idInmueble)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long id = nextval ();
            long tuplasInsertadas = sqlReserva.adicionarReserva(pm, id, fechaInicio, fechaFin, idCliente, idInmueble);
            tx.commit();
            
            log.trace ("Inserción del reserva: " + id + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Reserva (id,fechaInicio, fechaFin, idCliente, idInmueble);
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
	
	public long eliminarReservaPorId (long id) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlReserva.eliminarReservaPorId(pm, id);
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
	
	public List<Reserva> darReserva ()
	{
		return sqlReserva.darReservas (pmf.getPersistenceManager());
	}
	
	public Reserva darReservaPorId (long id)
	{
		return sqlReserva.darReservaPorId (pmf.getPersistenceManager(), id);
	}
	
	/* *************************
	 * Método para los SERVICIOS
	 **************************/
	
	public Servicio adicionarServicio(String nombre, String descripcion, int valorAdicional)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long id = nextval ();
            long tuplasInsertadas = sqlServicio.adicionarServicio(pm, id, nombre, descripcion, valorAdicional);
            tx.commit();
            
            log.trace ("Inserción del reserva: " + id + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new Servicio (id,nombre, descripcion, valorAdicional);
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
	
	public long eliminarServicioPorId (long id) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlServicio.eliminarServicioPorId(pm, id);
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
	
	public List<Servicio> darServicio()
	{
		return sqlServicio.darServicios (pmf.getPersistenceManager());
	}
	
	public Servicio darServicioPorId (long id)
	{
		return sqlServicio.darServicioPorId (pmf.getPersistenceManager(), id);
	}
	
	/* *****************************************
	 * Métodos para SERVICIOS ADICIONALES USADOS
	 *******************************************/
	
	public ServicioUsado adicionarServicioUsado (long idServicio, long idReserva)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            //long id = nextval ();
            long tuplasInsertadas = sqlServicioUsado.adicionarServicioAdicionalUsado(pm, idServicio, idReserva);
            tx.commit();
            
            log.trace ("Inserción del servicio adicional usado: " + idServicio + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new ServicioUsado (idServicio, idReserva);
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
	
	public long eliminarServicioUsadoPorIdServicio (long id) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlServicioUsado.eliminarServicioAdicionalUsadoPorIdServicio(pm, id);
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
	
	public long eliminarServicioUsadoPorIdReserva (long id) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlServicioUsado.eliminarServicioAdicionalUsadoPorIdReserva(pm, id);
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
	
	public List<ServicioUsado> darServiciosUsados()
	{
		return sqlServicioUsado.darServiciosAdicionalesUsados (pmf.getPersistenceManager());
	}
	
	public ServicioUsado darServicioUsadosPorIdReserva (long id)
	{
		return sqlServicioUsado.darServicioAdicionalUsadoPorIdReserva (pmf.getPersistenceManager(), id);
	}
	
	public ServicioUsado darServicioUsadosPorIdServicio (long id)
	{
		return sqlServicioUsado.darServicioAdicionalUsadoPorIdServicio (pmf.getPersistenceManager(), id);
	}
	
	/* *********************************
	 * Métodos para SERVICIOS INCLUIDOS
	 ***********************************/
	
	
	
	/* ********************************************
	 * Métodos para las VIVIENDAS UNIVERSITARIAS
	 *********************************************/

	public ViviendaUniversitaria adicionarViviendaUniversitaria (String nombre, String tipoOperador, int cantHabitaciones)
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long id = nextval ();
            long tuplasInsertadas = sqlViviendaUniversitaria.adicionarViviendaUniversitaria(pm,id);
            tx.commit();
            
            log.trace ("Inserción de la ViviendaUniversitaria: " + id + ": " + tuplasInsertadas + " tuplas insertadas");
            
            return new ViviendaUniversitaria (id, nombre, tipoOperador, cantHabitaciones);
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
	
	public long eliminarViviendaUniversitariaPorId (long id) 
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long resp = sqlViviendaUniversitaria.eliminarViviendaUniversitariaPorId(pm, id);
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
	
	public List<ViviendaUniversitaria> darViviendaUniversitaria()
	{
		return sqlViviendaUniversitaria.darViviendasUniversitarias (pmf.getPersistenceManager());
	}
	
	public ViviendaUniversitaria darViviendaUniversitariaPorID (long id)
	{
		return sqlViviendaUniversitaria.darViviendaUniversitariaPorId (pmf.getPersistenceManager(), id);
	}
	
	public long [] limpiarAlohAndes ()
	{
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx=pm.currentTransaction();
        try
        {
            tx.begin();
            long [] resp = sqlUtil.limpiarAlohAndes (pm);
            tx.commit ();
            log.info ("Borrada la base de datos");
            return resp;
        }
        catch (Exception e)
        {
//        	e.printStackTrace();
        	log.error ("Exception : " + e.getMessage() + "\n" + darDetalleException(e));
        	return new long[] {-1, -1, -1, -1, -1, -1, -1};
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
	
}
