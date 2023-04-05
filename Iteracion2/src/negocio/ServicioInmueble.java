package negocio;

public class ServicioInmueble implements VOServicioInmueble{
	/*
	 * Atributos
	 */
	private boolean incluido;
	private int valorAdicional;
	private long idServicio;
	private long idInmueble;
	
	/*
	 * Métodos
	 */
	
	/**
	 * Constructor por defecto
	 */
	public ServicioInmueble() {
		this.incluido=false;
		this.valorAdicional=0;
		this.idServicio=0;
		this.idInmueble=0;
	}
	
	/**
	 * Constuctor con parametros
	 * @param idServicio
	 * @param idReserva
	 */
	public ServicioInmueble(boolean incluido, int valorAdicional, long idServicio, long idInmueble) {
		this.incluido=incluido;
		this.valorAdicional=valorAdicional;
		this.idServicio=idServicio;
		this.idInmueble=idInmueble;
	}

	public boolean isIncluido() {
		return incluido;
	}

	public void setIncluido(boolean incluido) {
		this.incluido = incluido;
	}

	public int getValorAdicional() {
		return valorAdicional;
	}

	public void setValorAdicional(int valorAdicional) {
		this.valorAdicional = valorAdicional;
	}

	public long getIdServicio() {
		return idServicio;
	}

	public void setIdServicio(long idServicio) {
		this.idServicio = idServicio;
	}

	public long getIdInmueble() {
		return idInmueble;
	}

	public void setIdInmueble(long idInmueble) {
		this.idInmueble = idInmueble;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
