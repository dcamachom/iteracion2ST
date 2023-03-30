package negocio;

public interface VOPersonaNatural {
	
	/*
	 * Métodos
	 */
	
	public long getId();
	
	public String getNombrePersona();
	
	public String getCorreo();
	
	public String getTelefono();

	@Override
	public String toString();
}
