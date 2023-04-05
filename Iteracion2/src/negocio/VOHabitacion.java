package negocio;

public interface VOHabitacion {
	
	/*
	 * Métodos
	 */
	
	public boolean getCompartida();
	
	public String getTipo ();
	
	public int getCapacidad();
	
	@Override
	public String toString();
	
}
