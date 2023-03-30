package negocio;

public class Casa implements VOCasa{

	/*
	 * Atributos
	 */
	
	private long id;
	private int cantHabitaciones;
	private String seguro;
	
	/*
	 * Métodos
	 */
	
	/**
	 * Metodo por defecto
	 */
	
	public Casa() {
		this.id=0;
		this.cantHabitaciones=0;
		this.seguro="";
	}
	
	/**
	 * Método con valores
	 * @param id
	 * @param cantHabitaciones
	 * @param seguro
	 */
	public Casa(long id, int cantHabitaciones, String seguro) {
		this.id=id;
		this.cantHabitaciones=cantHabitaciones;
		this.seguro=seguro;
	}
	
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public void setId(long id) {
		this.id=id;
	}

	public int getCantHabitaciones() {
		// TODO Auto-generated method stub
		return cantHabitaciones;
	}
	
	public void setCantHabitaciones(int cantHabitaciones) {
		this.cantHabitaciones=cantHabitaciones;
	}

	public String getSeguro() {
		// TODO Auto-generated method stub
		return seguro;
	}
	
	public void setSeguro(String seguro) {
		this.seguro=seguro;
	}
	
	public String toString() {
		return "Reserva [id=" + id + ", Cantidad de habitaciones="
				+ cantHabitaciones+ ", Seguro=" + seguro +"]";
	}

}
