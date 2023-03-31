package Persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Inmueble;
import negocio.ViviendaUniversitaria;

public class SQLInmueble {

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
	
	public SQLInmueble (PersistenciaAlohAndes pa) {
		this.pa=pa;
	}
	
	public long adicionarInmueble(PersistenceManager pm, long id,int costoBase, boolean disponible) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pa.darTablaInmueble () + "(id, costoBase, disponible) values (?, ?, ?)");
        q.setParameters(id, costoBase, disponible);
        return (long) q.executeUnique();
	}
	
	public long eliminarInmueblePorId (PersistenceManager pm, long id)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaInmueble () + " WHERE id = ?");
        q.setParameters(id);
        return (long) q.executeUnique();            
	}
	
	public Inmueble darInmueblePorId (PersistenceManager pm, long id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaInmueble () + " WHERE id = ?");
		q.setResultClass(Inmueble.class);
		q.setParameters(id);
		return (Inmueble) q.executeUnique();
	}
	
	public List<Inmueble> darInmuebles (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaInmueble ());
		q.setResultClass(Inmueble.class);
		return (List<Inmueble>) q.executeList();
	}
	
}
