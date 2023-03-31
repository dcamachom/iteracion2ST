package Persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Casa;

public class SQLCasa {
private final static String SQL = PersistenciaAlohAndes.SQL;
	
	private PersistenciaAlohAndes pa;
	
	public SQLCasa(PersistenciaAlohAndes pa)
	{
		this.pa=pa;
	}
	
	public long adicionarCasa (PersistenceManager pm, long idCasa, int cantHabitaciones, String seguro) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pa.darTablaCasa () + "(id, cantHabitaciones, seguro) values (?, ?, ?)");
        q.setParameters(idCasa, cantHabitaciones, seguro);
        return (long) q.executeUnique();
	}
	
	public long eliminarCasaPorId (PersistenceManager pm, long idCasa)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaCasa () + " WHERE id = ?");
        q.setParameters(idCasa);
        return (long) q.executeUnique();
	}
	public List<Casa> darCasas (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaCasa ());
		q.setResultClass(Casa.class);
		return (List<Casa>) q.executeList();
	}
	public Casa darCasaPorId (PersistenceManager pm, long idCasa) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaCasa () + " WHERE id = ?");
		q.setResultClass(Casa.class);
		q.setParameters(idCasa);
		return (Casa) q.executeUnique();
	}

}
