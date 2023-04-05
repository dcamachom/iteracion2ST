package persistencia;

import java.math.BigDecimal;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.ViviendaUniversitaria;

public class SQLViviendaUniversitaria {
	
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
	
	public SQLViviendaUniversitaria (PersistenciaAlohAndes pa) {
		this.pa=pa;
	}
	
	public long adicionarViviendaUniversitaria(PersistenceManager pm, long id) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pa.darTablaViviendaUniversitaria () + "(id) values (?)");
        q.setParameters(id);
        return (long) q.executeUnique();
	}
	
	public long eliminarViviendaUniversitariaPorId (PersistenceManager pm, long id)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaViviendaUniversitaria () + " WHERE id = ?");
        q.setParameters(id);
        return (long) q.executeUnique();            
	}
	
	public ViviendaUniversitaria darViviendaUniversitariaPorId (PersistenceManager pm, long id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaViviendaUniversitaria () + " WHERE id = ?");
		q.setResultClass(ViviendaUniversitaria.class);
		q.setParameters(id);
		return (ViviendaUniversitaria) q.executeUnique();
	}
	
	public List<ViviendaUniversitaria> darViviendasUniversitarias (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaViviendaUniversitaria ());
		q.setResultClass(ViviendaUniversitaria.class);
		return (List<ViviendaUniversitaria>) q.executeList();
	}

}
