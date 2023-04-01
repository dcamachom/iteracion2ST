package Persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Vecino;
import negocio.ViviendaUniversitaria;

public class SQLVecino {
	
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
	
	public SQLVecino (PersistenciaAlohAndes pa) {
		this.pa=pa;
	}
	
	public long adicionarVecino(PersistenceManager pm, long id, String nombreVecino, String correo, String telefono) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pa.darTablaVecino () + "(id, nombreVecino, correo, telefono) values (?, ?, ?, ?)");
        q.setParameters(id, nombreVecino, correo, telefono);
        return (long) q.executeUnique();
	}
	
	public long eliminarVecinoPorId (PersistenceManager pm, long id)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaVecino () + " WHERE id = ?");
        q.setParameters(id);
        return (long) q.executeUnique();            
	}
	
	public Vecino darVecinoPorId (PersistenceManager pm, long id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaVecino () + " WHERE id = ?");
		q.setResultClass(Vecino.class);
		q.setParameters(id);
		return (Vecino) q.executeUnique();
	}
	
	public List<Vecino> darVecinos (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaVecino ());
		q.setResultClass(Vecino.class);
		return (List<Vecino>) q.executeList();
	}
	

}
