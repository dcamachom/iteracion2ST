package negocio;

public interface VOServicio {
	
	/*
	 * Métodos
	 */
	
	public long getId();
	
	public String getNombre();
	
	public String getDescripcion();
	
	public int getValorAdicional();
	
	@Override
	public String toString();

}
