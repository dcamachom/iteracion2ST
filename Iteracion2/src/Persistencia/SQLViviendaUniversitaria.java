package Persistencia;

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
	
	

}
