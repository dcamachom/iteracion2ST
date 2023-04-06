package negocio;

public class ServicioUsado implements VOServicioUsado{

	/*
	 * Atributos
	 */
	private long idServicio;
	private long idReserva;
	private long idInmueble;
	
	/*
	 * Métodos
	 */
	
	/**
	 * Constructor por defecto
	 */
	public ServicioUsado() {
		this.idServicio=0;
		this.idReserva=0;
		this.idInmueble=0;
	}
	
	/**
	 * Constuctor con parametros
	 * @param idServicio
	 * @param idReserva
	 */
	public ServicioUsado(long idServicio, long idReserva, long idInmueble) {
		this.idReserva=idReserva;
		this.idServicio=idServicio;
		this.idInmueble=idInmueble;
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
	
	public long getIdInmueble() {
		return idInmueble;
	}

	public void setIdInmueble(long idInmueble) {
		this.idInmueble = idInmueble;
	}

	public String toString() 
	{
		return "Servicios adicionales usados [id Reserva=" + idReserva+
				", id servicio="+idServicio+"]";
	}

}
