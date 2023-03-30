package negocio;

import java.sql.Time;

public interface VOHostal {

	/*
	 * Métodos
	 */
	
	public long getId();
	
	public String getRegistroCamaraComercio();
	
	public String getRegistroSuperIntendencia();
	
	public Time getHoraApertura();
	
	public Time getHoraCierre();
	
	@Override
	public String toString();
	
}
