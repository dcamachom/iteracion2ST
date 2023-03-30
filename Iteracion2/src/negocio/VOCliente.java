package negocio;

public interface VOCliente {
	
	public long getId();
	
	public String getNombre();
	
	public String getCorreo();
	
	public String getTelefono();
	
	public String getTipoMiembro();
	
	@Override
	public String toString();
	

} 
