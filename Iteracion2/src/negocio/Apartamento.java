package negocio;

public class Apartamento implements VOApartamento{

	/*
	 * Atributos
	 */
	
	private long id;
	private boolean amoblado;
	private int cantHabitaciones;
	
	/*
	 * Métodos
	 */
	
	/**
	 * Constructor por defecto
	 */
	public Apartamento() {
		this.id=0;
		this.amoblado=false;
		this.cantHabitaciones=0;
	}
	
	/**
	 * Método con valores
	 * @param id
	 * @param amoblado
	 * @param cantHabitaciones
	 */
	public Apartamento (long id, boolean amoblado, int cantHabitaciones) {
		this.id=id;
		this.amoblado=amoblado;
		this.cantHabitaciones=cantHabitaciones;
	}
	
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public void setId (long id) {
		this.id=id;
	}

	public boolean isAmoblado() {
		// TODO Auto-generated method stub
		return amoblado;
	}

	public void setAmoblado (boolean amoblado) {
		this.amoblado=amoblado;
	}
	
	public int getCantHabitaciones() {
		// TODO Auto-generated method stub
		return cantHabitaciones;
	}
	
	public void setCantHabitaciones(int cantHabitaciones) {
		this.cantHabitaciones=cantHabitaciones;
	}
	
	public String toString() 
	{
		return "Reserva [id=" + id + ", Amoblado=" +amoblado+ ", Cantidad de habitaciones="
				+ cantHabitaciones+"]";
	}

}
