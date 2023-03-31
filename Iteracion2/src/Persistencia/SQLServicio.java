package Persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Servicio;
import negocio.ServicioIncluido;
import negocio.ServicioNoIncluido;

public class SQLServicio {
	
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
	
	public SQLServicio (PersistenciaAlohAndes pa) {
		this.pa=pa;
	}
	
	public long adicionarServicio(PersistenceManager pm, long id, String nombre,String descripcion, int valorAdicional ) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pa.darTablaServicio () + "(id, nombre, descripcion, valor adicional) values (?, ?, ?, ?)");
        q.setParameters(id, nombre, descripcion, valorAdicional);
        return (long) q.executeUnique();
	}
	
	public long eliminarServicioPorId (PersistenceManager pm, long id)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaServicio () + " WHERE id = ?");
        q.setParameters(id);
        return (long) q.executeUnique();            
	}
	
	
	public Servicio darServicioPorId (PersistenceManager pm, long id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaServicio () + " WHERE id = ?");
		q.setResultClass(Servicio.class);
		q.setParameters(id);
		return (Servicio) q.executeUnique();
	}
	
	
	public List<Servicio> darServicios (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaServicio ());
		q.setResultClass(Servicio.class);
		return (List<Servicio>) q.executeList();
	}
	
	

}
