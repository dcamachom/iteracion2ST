package negocio;

import java.util.List;

public interface VOCliente {
	
	public long getId();
	
	public String getNombre();
	
	public String getCorreo();
	
	public String getTelefono();
	
	public String getTipoMiembro();
	
	public List<Object[]> getReservas();
	
	@Override
	public String toString();
	

} 
