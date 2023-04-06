package persistencia;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class SQLUtil {
	
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
	
	public SQLUtil (PersistenciaAlohAndes pa)
	{
		this.pa = pa;
	}
	
	public long nextval (PersistenceManager pm)
	{
        Query q = pm.newQuery(SQL, "SELECT "+ pa.darSeqAlohAndes () + ".nextval FROM DUAL");
        q.setResultClass(Long.class);
        long resp = (long) q.executeUnique();
        return resp;
	}
	
	public long [] limpiarAlohAndes (PersistenceManager pm)
	{
        Query qApartamento = pm.newQuery(SQL, "DELETE FROM " + pa.darTablaApartamento());
        Query qCasa= pm.newQuery(SQL, "DELETE FROM "+ pa.darTablaCasa());
        Query qCliente= pm.newQuery(SQL, "DELETE FROM "+ pa.darTablaCliente());
        Query qHabitacion= pm.newQuery(SQL, "DELETE FROM "+ pa.darTablaHabitacion());
        Query qHostal= pm.newQuery(SQL, "DELETE FROM "+ pa.darTablaHostal());
        Query qHotel= pm.newQuery(SQL, "DELETE FROM "+ pa.darTablaHotel());
        Query qInmueble= pm.newQuery(SQL, "DELETE FROM "+ pa.darTablaInmueble());
        Query qOperador= pm.newQuery(SQL, "DELETE FROM "+ pa.darTablaOperador());
        Query qPersonaNatural = pm.newQuery(SQL, "DELETE FROM "+ pa.darTablaPersonaNatural());
        Query qReserva= pm.newQuery(SQL, "DELETE FROM "+ pa.darTablaReserva());
        Query qServicio= pm.newQuery(SQL, "DELETE FROM "+ pa.darTablaServicio());
        Query qServicioInmueble= pm.newQuery(SQL, "DELETE FROM "+ pa.darTablaServicioInmueble());
        Query qServicioUsado= pm.newQuery(SQL, "DELETE FROM "+ pa.darTablaServicioUsado());
        Query qViviendaUniversitaria = pm.newQuery(SQL, "DELETE FROM "+ pa.darTablaViviendaUniversitaria());
        
        long apartamentoEliminados = (long) qApartamento.executeUnique ();
        long casaEliminados = (long) qCasa.executeUnique ();
        long clienteEliminados = (long) qCliente.executeUnique ();
        long habitacionEliminados = (long) qHabitacion.executeUnique ();
        long hostalEliminados= (long) qHostal.executeUnique ();
        long hotelEliminados= (long) qHotel.executeUnique ();
        long inmuebleEliminados= (long) qInmueble.executeUnique ();
        long operadorEliminados= (long) qOperador.executeUnique ();
        long personaNaturalEliminados= (long) qPersonaNatural.executeUnique ();
        long reservaEliminados= (long) qReserva.executeUnique ();
        long servicioEliminados= (long) qServicio.executeUnique ();
        long servicioInmuebleEliminados= (long) qServicioInmueble.executeUnique ();
        long servicioUsadoEliminados= (long) qServicioUsado.executeUnique ();
        long viviendaUniversitariaEliminados= (long) qViviendaUniversitaria.executeUnique ();
        return new long [] {apartamentoEliminados, casaEliminados, clienteEliminados, habitacionEliminados,
        		hostalEliminados, hotelEliminados, inmuebleEliminados, operadorEliminados, 
        		personaNaturalEliminados, reservaEliminados, servicioEliminados, servicioInmuebleEliminados,
        		servicioUsadoEliminados,viviendaUniversitariaEliminados};
	}
}
