package persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.ServicioUsado;

public class SQLServicioUsado {
	
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
	
	public SQLServicioUsado (PersistenciaAlohAndes pa) {
		this.pa=pa;
	}
	
	public long adicionarServicioAdicionalUsado(PersistenceManager pm, long idServicio, long idReserva, long idInmueble) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pa.darTablaServicioUsado () + "(Servicio, Reserva, Inmueble) values (?, ?)");
        q.setParameters(idServicio, idReserva);
        return (long) q.executeUnique();
	}
	
	public long eliminarServicioAdicionalUsadoPorIdServicio (PersistenceManager pm, long idServicio)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaServicioUsado () + " WHERE idServicio = ?");
        q.setParameters(idServicio);
        return (long) q.executeUnique();            
	}
	
	public long eliminarServicioAdicionalUsadoPorIdReserva (PersistenceManager pm, long idReserva)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaServicioUsado () + " WHERE idReserva = ?");
        q.setParameters(idReserva);
        return (long) q.executeUnique();            
	}
	
	public ServicioUsado darServicioAdicionalUsadoPorIdServicio (PersistenceManager pm, long idServicio) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaServicioUsado () + " WHERE idServicio = ?");
		q.setResultClass(ServicioUsado.class);
		q.setParameters(idServicio);
		return (ServicioUsado) q.executeUnique();
	}
	
	public ServicioUsado darServicioAdicionalUsadoPorIdReserva (PersistenceManager pm, long idReserva) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaServicioUsado () + " WHERE idReserva = ?");
		q.setResultClass(ServicioUsado.class);
		q.setParameters(idReserva);
		return (ServicioUsado) q.executeUnique();
	}
	
	public List<ServicioUsado> darServiciosAdicionalesUsados (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaServicioUsado ());
		q.setResultClass(ServicioUsado.class);
		return (List<ServicioUsado>) q.executeList();
	}
}
