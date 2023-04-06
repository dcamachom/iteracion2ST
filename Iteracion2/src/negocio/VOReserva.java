package negocio;

import java.util.Date;
import java.util.List;

public interface VOReserva {

	/*
	 * Métodos
	 */
	public long getId();	
	
	public Date getFechaInicio();
	
	public Date getFechaFin();
	
	public int getCostoTotal();
	
	public long getIdCliente();
	
	public long getIdInmueble();
	
	public List<Object[]> getServiciosUsados();
	
	public String toString();
}
