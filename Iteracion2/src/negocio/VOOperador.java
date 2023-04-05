package negocio;

import java.util.List;

public interface VOOperador {
	
	/*
	 * Métodos
	 */
	
	public long getId();
	
	public String getTipoOperador();
	
	public String getNombre();
	
	public List<Object[]> getInmuebles();
	
	@Override
	public String toString();

}
