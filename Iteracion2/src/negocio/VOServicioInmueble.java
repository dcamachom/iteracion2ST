package negocio;

public interface VOServicioInmueble {
	
	public boolean isIncluido();
	
	public int getValorAdicional();
	
	public long getIdServicio();
	
	public long getIdInmueble();

	@Override
	String toString();

	
}
