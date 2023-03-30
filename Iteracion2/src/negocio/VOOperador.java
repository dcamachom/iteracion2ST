package negocio;

public interface VOOperador {
	
	/*
	 * Métodos
	 */
	
	public long getId();
	
	public String getTipoOperador();
	
	public String getNombre();
	
	@Override
	public String toString();

}
