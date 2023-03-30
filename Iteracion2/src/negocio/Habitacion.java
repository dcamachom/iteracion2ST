package negocio;

public class Habitacion  implements VOHabitacion{

	/*
	 * Atributos
	 */
	
	private long id;
	private int capacidad;
	private boolean compartida;
	private String tipo;
	
	/*
	 * Métodos
	 */
	
	/**
	 * Constructor por defecto
	 */
	public Habitacion() {
		this.capacidad=0;
		this.compartida=false;
		this.tipo="";
	}
	
	/**
	 * Metodo con valores
	 * @param capacidad
	 * @param compartida
	 * @param tipo
	 */
	public Habitacion(int capacidad, boolean compartida, String tipo) {
		this.capacidad=capacidad;
		this.compartida=compartida;
		this.tipo=tipo;
	}
	
	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}
	
	public void setId(long id) {
		this.id=id;
	}

	@Override
	public boolean getCompartida() {
		// TODO Auto-generated method stub
		return compartida;
	}
	
	public void setCompartida(boolean compartida) {
		this.compartida=compartida;
	}

	@Override
	public String getTipo() {
		// TODO Auto-generated method stub
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo=tipo;
	}

	@Override
	public int getCapacidad() {
		// TODO Auto-generated method stub
		return capacidad;
	}
	
	public void setCapacidad(int capacidad) {
		this.capacidad=capacidad;
	}
	
	public String toString() {
		return "Habitacion [id=" + id +", compartida=" +compartida+ ", Tipo=" +tipo+ 
				", capacidad=" +capacidad +"]";
	}

}
