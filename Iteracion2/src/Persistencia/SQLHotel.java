package Persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Hotel;

public class SQLHotel {
	
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
	
	public SQLHotel (PersistenciaAlohAndes pa) {
		this.pa=pa;
	}
	
	public long adicionarHotel(PersistenceManager pm, long id, String registroCamaraComercio, String registroSuperIntendencia) {
		Query q = pm.newQuery(SQL, "INSERT INTO " + pa.darTablaHotel () + "(id, registroCamaraComercio, registroSuperIntendencia) values (?, ?, ?)");
        q.setParameters(id, registroCamaraComercio, registroSuperIntendencia);
        return (long) q.executeUnique();
	}
	
	public long eliminarHotelPorId (PersistenceManager pm, long id)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaHotel () + " WHERE id = ?");
        q.setParameters(id);
        return (long) q.executeUnique();            
	}
	
	public Hotel darHotelPorId (PersistenceManager pm, long id) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaHotel () + " WHERE id = ?");
		q.setResultClass(Hotel.class);
		q.setParameters(id);
		return (Hotel) q.executeUnique();
	}
	
	public List<Hotel> darHoteles (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaHotel ());
		q.setResultClass(Hotel.class);
		return (List<Hotel>) q.executeList();
	}

}
