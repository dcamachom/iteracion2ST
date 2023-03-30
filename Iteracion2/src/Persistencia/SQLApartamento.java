package Persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Apartamento;


public class SQLApartamento {
	
	private final static String SQL = PersistenciaAlohAndes.SQL;
	
	private PersistenciaAlohAndes pa;
	
	public SQLApartamento(PersistenciaAlohAndes pa)
	{
		this.pa=pa;
	}
	
	public long adicionarApartamento (PersistenceManager pm, long idApartamento, boolean amoblado, int cantHabitaciones) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pa.darTablaApartamento () + "(id, amoblado, cantHabitaciones) values (?, ?, ?)");
        q.setParameters(idApartamento, amoblado, cantHabitaciones);
        return (long) q.executeUnique();
	}
	
	public long eliminarApartamento (PersistenceManager pm, long idApartamento)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaApartamento () + " WHERE id = ?");
        q.setParameters(idApartamento);
        return (long) q.executeUnique();
	}
	public List<Apartamento> darApartamentos (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaApartamento ());
		q.setResultClass(Apartamento.class);
		return (List<Apartamento>) q.executeList();
	}
	public Apartamento darApartamentoPorId (PersistenceManager pm, long idApartamento) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaApartamento () + " WHERE id = ?");
		q.setResultClass(Apartamento.class);
		q.setParameters(idApartamento);
		return (Apartamento) q.executeUnique();
	}

}