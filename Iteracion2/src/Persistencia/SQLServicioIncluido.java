package Persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.ServicioIncluido;
import negocio.ServicioNoIncluido;

public class SQLServicioIncluido {
	
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
	
	public SQLServicioIncluido (PersistenciaAlohAndes pa) {
		this.pa=pa;
	}
	
	public long adicionarServicioIncluido(PersistenceManager pm, long idServicio, long idReserva) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pa.darTablaServicioIncluido () + "(idServicio, idReserva) values (?, ?)");
        q.setParameters(idServicio, idReserva);
        return (long) q.executeUnique();
	}
	
	public long eliminarServicioIncluidoPorIdServicio (PersistenceManager pm, long idServicio)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaServicioIncluido () + " WHERE idServicio = ?");
        q.setParameters(idServicio);
        return (long) q.executeUnique();            
	}
	
	public long eliminarServicioIncluidoPorIdReserva (PersistenceManager pm, long idReserva)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaServicioIncluido () + " WHERE idReserva = ?");
        q.setParameters(idReserva);
        return (long) q.executeUnique();            
	}
	
	public ServicioIncluido darServicioIncluidoPorIdServicio (PersistenceManager pm, long idServicio) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaServicioIncluido () + " WHERE idServicio = ?");
		q.setResultClass(ServicioIncluido.class);
		q.setParameters(idServicio);
		return (ServicioIncluido) q.executeUnique();
	}
	
	public ServicioIncluido darServicioIncluidoPorIdReserva (PersistenceManager pm, long idReserva) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaServicioIncluido () + " WHERE idReserva = ?");
		q.setResultClass(ServicioIncluido.class);
		q.setParameters(idReserva);
		return (ServicioIncluido) q.executeUnique();
	}
	
	public List<ServicioIncluido> darServiciosNoIncluidos (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaServicioIncluido ());
		q.setResultClass(ServicioNoIncluido.class);
		return (List<ServicioIncluido>) q.executeList();
	}

}
