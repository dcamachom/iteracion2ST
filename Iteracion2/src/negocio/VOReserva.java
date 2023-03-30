package negocio;

import java.util.Date;

public interface VOReserva {

	/*
	 * Métodos
	 */
	public long getId();	
	
	public Date getFechaInicio();
	
	public Date getFechaFin();
	
	public long getIdCliente();
	
	public long getIdInmueble();
	
	public String toString();
}
