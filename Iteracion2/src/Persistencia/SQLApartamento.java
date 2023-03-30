package Persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;


public class SQLApartamento {
	
	private final static String SQL = PersistenciaAlohAndes.SQL;
	
	private PersistenciaAlohAndes pa;
	
	public SQLApartamento(PersistenciaAlohAndes pa)
	{
		this.pa=pa;
	}
	
	public long adicionarApartamento (PersistenceManager pm, long idBar, String nombre, String ciudad, String presupuesto, int sedes) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pa.darTablaApartamento () + "(id, nombre, ciudad, presupuesto, cantsedes) values (?, ?, ?, ?, ?)");
        q.setParameters(idBar, nombre, ciudad, presupuesto, sedes);
        return (long) q.executeUnique();
	}

}