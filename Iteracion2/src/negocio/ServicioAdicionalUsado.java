package negocio;

public class ServicioAdicionalUsado implements VOServicioAdicionalUsado{

	//revisar el  nombre- singular
	/*
	 * Atributos
	 */
	private long idServicio;
	private long idReserva;
	
	/*
	 * Métodos
	 */
	
	/**
	 * Constructor por defecto
	 */
	public ServicioAdicionalUsado() {
		this.idServicio=0;
		this.idReserva=0;
	}
	
	/**
	 * Constuctor con parametros
	 * @param idServicio
	 * @param idReserva
	 */
	public ServicioAdicionalUsado(long idServicio, long idReserva) {
		this.idReserva=idReserva;
		this.idServicio=idServicio;
	}
	
	@Override
	public long getIdServicio() {
		// TODO Auto-generated method stub
		return idServicio;
	}
	
	public void setIdServicio(long idServicio) {
		this.idServicio=idServicio;
	}

	@Override
	public long getIdReserva() {
		// TODO Auto-generated method stub
		return idReserva;
	}
	
	public void setIdReserva(long idReserva) {
		this.idReserva=idReserva;
	}
	
	public String toString() 
	{
		return "Servicios adicionales usados [id Reserva=" + idReserva+
				", id servicio="+idServicio+"]";
	}

}