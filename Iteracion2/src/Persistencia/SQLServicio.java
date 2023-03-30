package Persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Servicio;
import negocio.ServicioIncluido;
import negocio.ServicioNoIncluido;

public class SQLServicio {
	
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
	
	public SQLServicio (PersistenciaAlohAndes pa) {
		this.pa=pa;
	}
	
	public long adicionarServicio(PersistenceManager pm, long idServicio, long idReserva) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pa.darTablaServicio () + "(idServicio, idReserva) values (?, ?)");
        q.setParameters(idServicio, idReserva);
        return (long) q.executeUnique();
	}
	
	public long eliminarServicioPorIdServicio (PersistenceManager pm, long idServicio)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaServicio () + " WHERE idServicio = ?");
        q.setParameters(idServicio);
        return (long) q.executeUnique();            
	}
	
	public long eliminarServicioPorIdReserva (PersistenceManager pm, long idReserva)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaServicio () + " WHERE idReserva = ?");
        q.setParameters(idReserva);
        return (long) q.executeUnique();            
	}
	
	public Servicio darServicioPorIdServicio (PersistenceManager pm, long idServicio) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaServicio () + " WHERE idServicio = ?");
		q.setResultClass(Servicio.class);
		q.setParameters(idServicio);
		return (Servicio) q.executeUnique();
	}
	
	public Servicio darServicioPorIdReserva (PersistenceManager pm, long idReserva) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaServicio () + " WHERE idReserva = ?");
		q.setResultClass(Servicio.class);
		q.setParameters(idReserva);
		return (Servicio) q.executeUnique();
	}
	
	public List<Servicio> darServicios (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaServicio ());
		q.setResultClass(Servicio.class);
		return (List<Servicio>) q.executeList();
	}
	
	

}
