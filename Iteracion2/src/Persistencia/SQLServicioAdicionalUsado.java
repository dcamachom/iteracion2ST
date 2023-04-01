package Persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.ServicioAdicionalUsado;
import negocio.ServicioNoIncluido;

public class SQLServicioAdicionalUsado {
	
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
	
	public SQLServicioAdicionalUsado (PersistenciaAlohAndes pa) {
		this.pa=pa;
	}
	
	public long adicionarServicioAdicionalUsado(PersistenceManager pm, long idServicio, long idReserva) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pa.darTablaServicioAdicionalUsado () + "(idServicio, idReserva) values (?, ?)");
        q.setParameters(idServicio, idReserva);
        return (long) q.executeUnique();
	}
	
	public long eliminarServicioAdicionalUsadoPorIdServicio (PersistenceManager pm, long idServicio)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaServicioAdicionalUsado () + " WHERE idServicio = ?");
        q.setParameters(idServicio);
        return (long) q.executeUnique();            
	}
	
	public long eliminarServicioAdicionalUsadoPorIdReserva (PersistenceManager pm, long idReserva)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaServicioAdicionalUsado () + " WHERE idReserva = ?");
        q.setParameters(idReserva);
        return (long) q.executeUnique();            
	}
	
	public ServicioAdicionalUsado darServicioAdicionalUsadoPorIdServicio (PersistenceManager pm, long idServicio) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaServicioAdicionalUsado () + " WHERE idServicio = ?");
		q.setResultClass(ServicioAdicionalUsado.class);
		q.setParameters(idServicio);
		return (ServicioAdicionalUsado) q.executeUnique();
	}
	
	public ServicioAdicionalUsado darServicioAdicionalUsadoPorIdReserva (PersistenceManager pm, long idReserva) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaServicioAdicionalUsado () + " WHERE idReserva = ?");
		q.setResultClass(ServicioAdicionalUsado.class);
		q.setParameters(idReserva);
		return (ServicioAdicionalUsado) q.executeUnique();
	}
	
	public List<ServicioAdicionalUsado> darServiciosAdicionalesUsados (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaServicioAdicionalUsado ());
		q.setResultClass(ServicioNoIncluido.class);
		return (List<ServicioAdicionalUsado>) q.executeList();
	}


}
