package persistencia;

import java.util.Date;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Reserva;
import negocio.ViviendaUniversitaria;

public class SQLReserva {
	
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
	
	public SQLReserva (PersistenciaAlohAndes pa) {
		this.pa=pa;
	}
	
	public long adicionarReserva(PersistenceManager pm, long id, Date fechaInicio, Date fechaFin, int costoTotal, long idCliente, long idInmueble) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pa.darTablaReserva () + "(id, fechaInicio, fechaFin, costoTotal, idCliente, idInmueble) values (?, ?, ?, ?, ?, ?)");
        q.setParameters(id, fechaInicio, fechaFin, costoTotal, idCliente, idInmueble);
        return (long) q.executeUnique();
	}
	
	public long eliminarReservaPorId(PersistenceManager pm, long id)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaReserva () + " WHERE id = ?");
        q.setParameters(id);
        return (long) q.executeUnique();            
	}
	
	public Reserva darReservaPorId (PersistenceManager pm, long id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaReserva () + " WHERE id = ?");
		q.setResultClass(Reserva.class);
		q.setParameters(id);
		return (Reserva) q.executeUnique();
	}
	
	public List<Reserva> darReservas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaReserva ());
		q.setResultClass(Reserva.class);
		return (List<Reserva>) q.executeList();
	}

}
