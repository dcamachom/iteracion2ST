package negocio;

import java.util.LinkedList;
import java.util.List;

public class Inmueble implements VOInmueble{

	/*
	 * Atributos
	 */
	private long id;
	private int costoBase;
	private long idOperador;
	private List<Object []> serviciosIncluidos;
	private List<Object[]> serviciosNoIncluidos;
	private List<Object[]> reservas;
	
	/*
	 * Métodos
	 */
	
	/**
	 * Constructor por defecto
	 */
	public Inmueble() {
		this.id=0;
		this.costoBase=0;
		this.idOperador=0;
		serviciosIncluidos= new LinkedList<Object[]>();
		serviciosNoIncluidos= new LinkedList<Object[]>();
		reservas= new LinkedList<Object[]>();
	}
	
	/**
	 * Constructor con parametros
	 * @param id
	 * @param costoBase
	 * @param disponible
	 */
	public Inmueble(long id, int costoBase, long idOperador) {
		this.id=id;
		this.costoBase=costoBase;
		this.idOperador=idOperador;
		serviciosIncluidos= new LinkedList<Object[]>();
		serviciosNoIncluidos= new LinkedList<Object[]>();
		reservas= new LinkedList<Object[]>();
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
	public int getCostoBase() {
		// TODO Auto-generated method stub
		return costoBase;
	}
	
	public void setCostoBase(int costoBase) {
		this.costoBase=costoBase;
	}
	
	public long getIdOperador() {
		return idOperador;
	}

	public void setIdOperador(long idOperador) {
		this.idOperador = idOperador;
	}

	public List<Object[]> getServiciosIncluidos() {
		return serviciosIncluidos;
	}

	public void setServiciosIncluidos(List<Object[]> serviciosIncluidos) {
		this.serviciosIncluidos = serviciosIncluidos;
	}

	public List<Object[]> getServiciosNoIncluidos() {
		return serviciosNoIncluidos;
	}

	public void setServiciosNoIncluidos(List<Object[]> serviciosNoIncluidos) {
		this.serviciosNoIncluidos = serviciosNoIncluidos;
	}

	public List<Object[]> getReservas() {
		return reservas;
	}

	public void setReservas(List<Object[]> reservas) {
		this.reservas = reservas;
	}

	public String toString() 
	{
		return "Inmueble [id=" + id + ", Costo base="+ costoBase + "]";
	}

}
