package Persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.PersonaNatural;

public class SQLPersonaNatural {
	
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
	
	public SQLPersonaNatural (PersistenciaAlohAndes pa) {
		this.pa=pa;
	}
	
	public long adicionarPersonaNatural(PersistenceManager pm, long id, String nombre, String correo, String telefono) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pa.darTablaPersonaNatural () + "(id, nombre persona, correo, telefono) values (?, ?, ?, ?)");
        q.setParameters(id, nombre,correo,telefono);
        return (long) q.executeUnique();
	}
	
	public long eliminarPersonaNaturalPorId (PersistenceManager pm, long id)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaPersonaNatural () + " WHERE id = ?");
        q.setParameters(id);
        return (long) q.executeUnique();            
	}
	
	public PersonaNatural darPersonaNaturalPorId (PersistenceManager pm, long id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaPersonaNatural () + " WHERE id = ?");
		q.setResultClass(PersonaNatural.class);
		q.setParameters(id);
		return (PersonaNatural) q.executeUnique();
	}
	
	public List<PersonaNatural> darPersonasNaturales (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaPersonaNatural ());
		q.setResultClass(PersonaNatural.class);
		return (List<PersonaNatural>) q.executeList();
	}

}
