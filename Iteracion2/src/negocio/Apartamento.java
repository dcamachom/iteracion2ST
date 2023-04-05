package negocio;

import java.util.List;

public class Apartamento extends Inmueble implements VOApartamento{

	/*
	 * Atributos
	 */
	
	private boolean amoblado;
	private int cantHabitaciones;
	
	/*
	 * Métodos
	 */
	
	/**
	 * Constructor por defecto
	 */
	public Apartamento() {
		super();
		this.amoblado=false;
		this.cantHabitaciones=0;
	}
	
	/**
	 * Método con valores
	 * @param id
	 * @param amoblado
	 * @param cantHabitaciones
	 */
	public Apartamento (long id, int costoBase, long idOperador, boolean amoblado, int cantHabitaciones) {
		super(id, costoBase,idOperador);
		this.amoblado=amoblado;
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
	
	@Override
	public int getCostoBase() {
		// TODO Auto-generated method stub
		return super.getCostoBase();
	}

	@Override
	public void setCostoBase(int costoBase) {
		// TODO Auto-generated method stub
		super.setCostoBase(costoBase);
	}

	@Override
	public long getIdOperador() {
		// TODO Auto-generated method stub
		return super.getIdOperador();
	}

	@Override
	public void setIdOperador(long idOperador) {
		// TODO Auto-generated method stub
		super.setIdOperador(idOperador);
	}

	@Override
	public List<Object[]> getServiciosIncluidos() {
		// TODO Auto-generated method stub
		return super.getServiciosIncluidos();
	}

	@Override
	public void setServiciosIncluidos(List<Object[]> serviciosIncluidos) {
		// TODO Auto-generated method stub
		super.setServiciosIncluidos(serviciosIncluidos);
	}

	@Override
	public List<Object[]> getServiciosNoIncluidos() {
		// TODO Auto-generated method stub
		return super.getServiciosNoIncluidos();
	}

	@Override
	public void setServiciosNoIncluidos(List<Object[]> serviciosNoIncluidos) {
		// TODO Auto-generated method stub
		super.setServiciosNoIncluidos(serviciosNoIncluidos);
	}

	@Override
	public List<Object[]> getReservas() {
		// TODO Auto-generated method stub
		return super.getReservas();
	}

	@Override
	public void setReservas(List<Object[]> reservas) {
		// TODO Auto-generated method stub
		super.setReservas(reservas);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	

}
