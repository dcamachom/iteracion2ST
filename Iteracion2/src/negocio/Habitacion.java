package negocio;

import java.util.List;

public class Habitacion  extends Inmueble implements VOHabitacion{

	/*
	 * Atributos
	 */
	
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
		super();
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
	public Habitacion(long id, int costoBase, long idOperador,int capacidad, boolean compartida, String tipo) {
		super(id, costoBase, idOperador);
		this.capacidad=capacidad;
		this.compartida=compartida;
		this.tipo=tipo;
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
