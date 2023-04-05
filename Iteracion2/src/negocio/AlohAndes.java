package negocio;

import java.util.List;

import org.apache.log4j.Logger;

import com.google.gson.JsonObject;

import persistencia.PersistenciaAlohAndes;


public class AlohAndes {
	/* ****************************************************************
	 * 			Constantes
	 *****************************************************************/
	/**
	 * Logger para escribir la traza de la ejecución
	 */
	private static Logger log = Logger.getLogger(AlohAndes.class.getName());
	
	/* ****************************************************************
	 * 			Atributos
	 *****************************************************************/
	/**
	 * El manejador de persistencia
	 */
	private PersistenciaAlohAndes pa;
	
	/* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
	/**
	 * El constructor por defecto
	 */
	public AlohAndes ()
	{
		pa = PersistenciaAlohAndes.getInstance ();
	}
	
	/**
	 * El constructor qye recibe los nombres de las tablas en tableConfig
	 * @param tableConfig - Objeto Json con los nombres de las tablas y de la unidad de persistencia
	 */
	public AlohAndes (JsonObject tableConfig)
	{
		pa = PersistenciaAlohAndes.getInstance (tableConfig);
	}
	
	/**
	 * Cierra la conexión con la base de datos (Unidad de persistencia)
	 */
	public void cerrarUnidadPersistencia ()
	{
		pa.cerrarUnidadPersistencia ();
	}
	/**
	 * Métodos para manejar los Apartamentos
	 */
	public Apartamento adicionarApartamento (int costoBase, long idOperador, boolean amoblado, int cantHabitaciones)
	{
        log.info ("Adicionando Apartamento" );
        Apartamento apartamento = pa.adicionarApartamento(costoBase, idOperador, amoblado, cantHabitaciones);		
        log.info ("Adicionando Apartamento: " + apartamento);
        return apartamento;
	}
	public long eliminarApartamentoPorId (long idApartamento)
	{
		log.info ("Eliminando Apartamento por id: " + idApartamento);
        long resp = pa.eliminarApartamentoPorId(idApartamento);		
        log.info ("Eliminando Apartamento por id: " + resp + " tuplas eliminadas");
        return resp;
	}
	public List<Apartamento> darApartamentos ()
	{
		log.info ("Consultando Apartamentos");
        List<Apartamento> apartamentos = pa.darApartamentos ();	
        log.info ("Consultando Apartamentos: " + apartamentos.size() + " existentes");
        return apartamentos;
	}
	public Apartamento darApartamentoPorId (long id)
	{
		log.info ("Buscando Apartamento por id: " + id);
		Apartamento apto = pa.darApartamentosPorId(id);
		return apto;
	}
	
}
