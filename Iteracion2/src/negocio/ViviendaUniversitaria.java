package negocio;

import java.util.List;

public class ViviendaUniversitaria extends Operador implements VOViviendaUniversitaria{

	/*
	 * Atributos
	 */
	private int cantHabitaciones;
	
	/*
	 * Métodos
	 */
	
	/**
	 * Constructor por defecto
	 */
	public ViviendaUniversitaria() {
		super();
		this.cantHabitaciones=0;
	}
	
	/**
	 * Metodo con parametos
	 * @param id
	 */
	public ViviendaUniversitaria(long id, String nombre, String tipoOperador, int cantHabitaciones) {
		super(id, nombre, tipoOperador);
		this.cantHabitaciones=cantHabitaciones;
	}
	
	
	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}

	@Override
	public void setId(long id) {
		// TODO Auto-generated method stub
		super.setId(id);
	}

	@Override
	public String getTipoOperador() {
		// TODO Auto-generated method stub
		return super.getTipoOperador();
	}

	@Override
	public void setTipoOperador(String tipoOperador) {
		// TODO Auto-generated method stub
		super.setTipoOperador(tipoOperador);
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return super.getNombre();
	}

	@Override
	public void setNombre(String nombre) {
		// TODO Auto-generated method stub
		super.setNombre(nombre);
	}

	@Override
	public List<Object[]> getInmuebles() {
		// TODO Auto-generated method stub
		return super.getInmuebles();
	}

	@Override
	public void setInmuebles(List<Object[]> inmuebles) {
		// TODO Auto-generated method stub
		super.setInmuebles(inmuebles);
	}

	public int getCantHabitaciones() {
		return cantHabitaciones;
	}

	public void setCantHabitaciones(int cantHabitaciones) {
		this.cantHabitaciones = cantHabitaciones;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	
	

}
