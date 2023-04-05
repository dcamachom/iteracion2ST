package persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Habitacion;

public class SQLHabitacion {
	
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
	
	public SQLHabitacion (PersistenciaAlohAndes pa) {
		this.pa=pa;
	}
	
	public long adicionarHabitacion(PersistenceManager pm, long id, int capacidad, boolean compartida, String tipo) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pa.darTablaHabitacion () + "(id, capacidad, compartida, tipo) values (?)");
        q.setParameters(id, capacidad, compartida,tipo);
        return (long) q.executeUnique();
	}
	
	public long eliminarHabitacionPorId (PersistenceManager pm, long id)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaHabitacion () + " WHERE id = ?");
        q.setParameters(id);
        return (long) q.executeUnique();            
	}
	
	public Habitacion darHabitacionPorId (PersistenceManager pm, long id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaHabitacion () + " WHERE id = ?");
		q.setResultClass(Habitacion.class);
		q.setParameters(id);
		return (Habitacion) q.executeUnique();
	}
	
	public List<Habitacion> darHabitaciones (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaHabitacion ());
		q.setResultClass(Habitacion.class);
		return (List<Habitacion>) q.executeList();
	}

}
