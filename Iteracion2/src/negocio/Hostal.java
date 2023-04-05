package negocio;

import java.sql.Time;
import java.util.List;

public class Hostal extends Operador implements VOHostal{
	
	/*
	 * Atributos
	 */
	
	private int cantHabitaciones;
	private String registroCamaraComercio;
	private String registroSuperIntendencia;
	private Time horaApertura;
	private Time horaCierre;
	
	/*
	 * Métodos
	 */
	
	/**
	 * Constructor por defecto
	 */
	
	public Hostal() {
		super();
		this.cantHabitaciones= 0;
		this.registroCamaraComercio="";
		this.registroSuperIntendencia="";
		this.horaApertura= new Time (0);
		this.horaCierre= new Time(0);
	}
	
	
	/**
	 * Metodo con valores
	 * @param id
	 * @param registroCamaraComercio
	 * @param registroSuperIntendencia
	 * @param horaApertura
	 * @param horaCierre
	 */
	public Hostal (long id, String nombre, String tipoOperador, int cantHabitaciones, String registroCamaraComercio, String registroSuperIntendencia,
			Time horaApertura, Time horaCierre) {
		super(id, nombre, tipoOperador);
		this.cantHabitaciones=cantHabitaciones;
		this.registroCamaraComercio=registroCamaraComercio;
		this.registroSuperIntendencia=registroSuperIntendencia;
		this.horaApertura=horaApertura;
		this.horaCierre=horaCierre;
	}

	public int getCantHabitaciones() {
		return cantHabitaciones;
	}


	public void setCantHabitaciones(int cantHabitaciones) {
		this.cantHabitaciones = cantHabitaciones;
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
	public String getRegistroCamaraComercio() {
		// TODO Auto-generated method stub
		return registroCamaraComercio;
	}
	
	public void setRegistroCamaraComercio(String registro) {
		this.registroCamaraComercio=registro;
	}

	@Override
	public String getRegistroSuperIntendencia() {
		// TODO Auto-generated method stub
		return registroSuperIntendencia;
	}
	
	public void setRegistroSuperIntendencia(String registro) {
		this.registroSuperIntendencia=registro;
	}

	@Override
	public Time getHoraApertura() {
		// TODO Auto-generated method stub
		return horaApertura;
	}
	
	public void setHoraApertura(Time horaApertura) {
		this.horaApertura=horaApertura;
	}

	@Override
	public Time getHoraCierre() {
		// TODO Auto-generated method stub
		return horaCierre;
	}
	
	public void setHoraCierre(Time horaCierre) {
		this.horaCierre=horaCierre;
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
