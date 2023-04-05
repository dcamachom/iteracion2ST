package negocio;

import java.util.List;

public class Hotel extends Operador implements VOHotel{

	/*
	 * Atributos
	 */
	
	private int cantHabitaciones;
	private String registroCamaraComercio;
	private String registroSuperIntendencia;
	
	/*
	 * Métodos
	 */
	
	/**
	 * Constructor por defecto
	 */
	
	public Hotel() {
		super();
		this.cantHabitaciones=0;
		this.registroCamaraComercio="";
		this.registroSuperIntendencia="";
	}
	

	/**
	 * Método con valores
	 * @param id
	 * @param registroCamaraComercio
	 * @param registroSuperIntendencia
	 */
	public Hotel (long id, String nombre, String tipoOperador, int cantHabitaciones, String registroCamaraComercio, String registroSuperIntendencia) {
		super(id, nombre, tipoOperador);
		this.cantHabitaciones=cantHabitaciones;
		this.registroCamaraComercio=registroCamaraComercio;
		this.registroSuperIntendencia=registroSuperIntendencia;
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


	public int getCantHabitaciones() {
		return cantHabitaciones;
	}

	public void setCantHabitaciones(int cantHabitaciones) {
		this.cantHabitaciones = cantHabitaciones;
	}
	@Override
	public String getRegistroCamaraComercio() {
		// TODO Auto-generated method stub
		return registroCamaraComercio;
	}
	
	public void setRegistroCamaraComercio (String registroCamaraComercio) {
		this.registroCamaraComercio=registroCamaraComercio;
	}

	@Override
	public String getRegistroSuperIntendencia() {
		// TODO Auto-generated method stub
		return registroSuperIntendencia;
	}
	
	public void setRegistroSuperIntendencia(String registroSuperIntendencia) {
		this.registroSuperIntendencia=registroSuperIntendencia;
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


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

}
