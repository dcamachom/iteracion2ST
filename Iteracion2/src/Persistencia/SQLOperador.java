package Persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Operador;
import negocio.ViviendaUniversitaria;

public class SQLOperador {
	
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
	
	public SQLOperador (PersistenciaAlohAndes pa) {
		this.pa=pa;
	}
	
	public long adicionarOperador(PersistenceManager pm, long id, String nombre, String tipoOperador) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pa.darTablaOperador () + "(id, nombre, tipoOperador) values (?, ?,?)");
        q.setParameters(id,nombre, tipoOperador);
        return (long) q.executeUnique();
	}
	
	public long eliminarOperadorPorId (PersistenceManager pm, long id)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaOperador () + " WHERE id = ?");
        q.setParameters(id);
        return (long) q.executeUnique();            
	}
	
	public Operador darViviendaUniversitariaPorId (PersistenceManager pm, long id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaOperador () + " WHERE id = ?");
		q.setResultClass(Operador.class);
		q.setParameters(id);
		return (Operador) q.executeUnique();
	}
	
	public List<Operador> darViviendasUniversitarias (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaOperador ());
		q.setResultClass(Operador.class);
		return (List<Operador>) q.executeList();
	}

}
