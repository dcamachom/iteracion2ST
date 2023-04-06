package persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.ServicioInmueble;


public class SQLServicioInmueble {
	/*
	 * Constantes
	 */
	private final static String SQL = PersistenciaAlohAndes.SQL;
	
	/*
	 * Atributos
	 */
	private PersistenciaAlohAndes pa;
	
	/*
	 * Métodos
	 */
	
	public SQLServicioInmueble (PersistenciaAlohAndes pa) {
		this.pa=pa;
	}
	
	public long adicionarServicioInmueble(PersistenceManager pm, long idServicio, long idInmueble, boolean incluido, int valorAdicional) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pa.darTablaServicioInmueble () + "(Servicio,Inmueble, incluido, valorAdicional) values (?, ?, ?, ?)");
        q.setParameters(idServicio, idInmueble, incluido, valorAdicional);
        return (long) q.executeUnique();
	}
	
	public long eliminarServicioInmueblePorId (PersistenceManager pm, long idServicio, long idInmueble)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaServicioInmueble () + " WHERE Servicio = ? AND Inmueble = ?");
        q.setParameters(idServicio, idInmueble);
        return (long) q.executeUnique();            
	}
	
	public ServicioInmueble darServicioInmueblePorId (PersistenceManager pm, long idServicio, long idInmueble) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaServicioInmueble () + " WHERE Servicio = ? AND Inmueble = ?");
		q.setResultClass(ServicioInmueble.class);
		q.setParameters(idServicio, idInmueble);
		return (ServicioInmueble) q.executeUnique();
	}
	
	public List<ServicioInmueble> darServiciosInmueble (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaServicioInmueble ());
		q.setResultClass(ServicioInmueble.class);
		return (List<ServicioInmueble>) q.executeList();
	}
}
