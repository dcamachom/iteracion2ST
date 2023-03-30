package negocio;

public interface VOInmueble {
	
	/*
	 * Métodos
	 */
	
	public long getId();
	
	public int getCostoBase();
	
	public boolean getDisponible();
	
	@Override
	public String toString();

}
