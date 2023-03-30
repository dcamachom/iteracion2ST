package negocio;

public class ServiciosNoIncluidos implements VOServiciosNoIncluidos{
	
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
	public ServiciosNoIncluidos() {
		this.idServicio=0;
		this.idReserva=0;
	}
	
	/**
	 * Constuctor con parametros
	 * @param idServicio
	 * @param idReserva
	 */
	public ServiciosNoIncluidos(long idServicio, long idReserva) {
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
		return "Servicios no incluidos [id Reserva=" + idReserva+
				", id servicio="+idServicio+"]";
	}

}
