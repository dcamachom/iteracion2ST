package Persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.ServicioNoIncluido;

public class SQLServicioNoIncluido {

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
	
	public SQLServicioNoIncluido (PersistenciaAlohAndes pa) {
		this.pa=pa;
	}
	
	public long adicionarServicioNoIncluido(PersistenceManager pm, long idServicio, long idReserva) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pa.darTablaServicioNoIncluido () + "(idServicio, idReserva) values (?, ?)");
        q.setParameters(idServicio, idReserva);
        return (long) q.executeUnique();
	}
	
	public long eliminarServicioNoIncluidoPorIdServicio (PersistenceManager pm, long idServicio)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaServicioNoIncluido () + " WHERE idServicio = ?");
        q.setParameters(idServicio);
        return (long) q.executeUnique();            
	}
	
	public long eliminarServicioNoIncluidoPorIdReserva (PersistenceManager pm, long idReserva)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaServicioNoIncluido () + " WHERE idReserva = ?");
        q.setParameters(idReserva);
        return (long) q.executeUnique();            
	}
	
	public ServicioNoIncluido darViviendaUniversitariaPorIdServicio (PersistenceManager pm, long idServicio) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaServicioNoIncluido () + " WHERE idServicio = ?");
		q.setResultClass(ServicioNoIncluido.class);
		q.setParameters(idServicio);
		return (ServicioNoIncluido) q.executeUnique();
	}
	
	public ServicioNoIncluido darViviendaUniversitariaPorIdReserva (PersistenceManager pm, long idReserva) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaServicioNoIncluido () + " WHERE idReserva = ?");
		q.setResultClass(ServicioNoIncluido.class);
		q.setParameters(idReserva);
		return (ServicioNoIncluido) q.executeUnique();
	}
	
	public List<ServicioNoIncluido> darServiciosNoIncluidos (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaServicioNoIncluido ());
		q.setResultClass(ServicioNoIncluido.class);
		return (List<ServicioNoIncluido>) q.executeList();
	}
	
}
