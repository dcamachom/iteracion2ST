package negocio;

import java.util.List;

public interface VOInmueble {
	
	/*
	 * Métodos
	 */
	
	public long getId();
	
	public int getCostoBase();
	
	public long getIdOperador();
	
	public List<Object[]> getServiciosIncluidos();
	
	public List<Object[]> getServiciosNoIncluidos();
	
	public List<Object[]> getReservas();
	
	@Override
	public String toString();

}
