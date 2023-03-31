package Persistencia;

import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import negocio.Cliente;

public class SQLCliente {
	
	private final static String SQL = PersistenciaAlohAndes.SQL;
	
	private PersistenciaAlohAndes pa;
	
	public SQLCliente(PersistenciaAlohAndes pa)
	{
		this.pa=pa;
	}
	
	public long adicionarCliente (PersistenceManager pm, long idCliente, String nombre, String correo, String telefono, String tipoMiembro) 
	{
        Query q = pm.newQuery(SQL, "INSERT INTO " + pa.darTablaCliente () + "(id, nombre, correo, telefono, tipoMiembro) values (?, ?, ?, ?, ?)");
        q.setParameters(idCliente, nombre, correo, telefono, tipoMiembro);
        return (long) q.executeUnique();
	}
	
	public long eliminarClientePorId (PersistenceManager pm, long idCliente)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaCliente () + " WHERE id = ?");
        q.setParameters(idCliente);
        return (long) q.executeUnique();
	}
	
	public long eliminarClientePorNombre (PersistenceManager pm, String nombre)
	{
        Query q = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaCliente () + " WHERE nombre = ?");
        q.setParameters(nombre);
        return (long) q.executeUnique();
	}
	
	public List<Cliente> darClientes (PersistenceManager pm)
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaCliente ());
		q.setResultClass(Cliente.class);
		return (List<Cliente>) q.executeList();
	}
	
	public Cliente darClientePorId (PersistenceManager pm, long idCliente) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaCliente () + " WHERE id = ?");
		q.setResultClass(Cliente.class);
		q.setParameters(idCliente);
		return (Cliente) q.executeUnique();
	}
	
	public Cliente darClientePorNombre (PersistenceManager pm, String nombre) 
	{
		Query q = pm.newQuery(SQL, "SELECT * FROM " + pa.darTablaCliente () + " WHERE nombre = ?");
		q.setResultClass(Cliente.class);
		q.setParameters(nombre);
		return (Cliente) q.executeUnique();
	}

}
