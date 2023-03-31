package Persistencia;

import java.sql.Time;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Hostal;
import negocio.ViviendaUniversitaria;

public class SQLHostal {
	
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
	
	public SQLHostal (PersistenciaAlohAndes pa) {
		this.pa=pa;
	}
	
	public long adicionarHostal(PersistenceManager pm, long id, String registroCamaraComercio, String registroSuperIntendencia, Time horaApertura, Time horaCierre) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pa.darTablaHostal () + "(id, registroCamaraComercio, registroSuperIntendencia, horaApertura,horaCierre) values (?,?,?,?,?)");
        q.setParameters(id,registroCamaraComercio, registroSuperIntendencia,horaApertura,horaCierre);
        return (long) q.executeUnique();
	}
	
	public long eliminarHostalPorId (PersistenceManager pm, long id)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaHostal () + " WHERE id = ?");
        q.setParameters(id);
        return (long) q.executeUnique();            
	}
	
	public Hostal darHostalPorId (PersistenceManager pm, long id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaHostal () + " WHERE id = ?");
		q.setResultClass(Hostal.class);
		q.setParameters(id);
		return (Hostal) q.executeUnique();
	}
	
	public List<Hostal> darHostales (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaHostal ());
		q.setResultClass(Hostal.class);
		return (List<Hostal>) q.executeList();
	}

}
