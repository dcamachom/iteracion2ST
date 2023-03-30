package negocio;

public interface VOVecino {
	
	/*
	 * Métodos
	 */
	
	public long getId();
	
	public String getNombreVecino();
	
	public String getCorreo();
	
	public String getTelefono();

	@Override
	public String toString();

}
