package negocio;

public class Inmueble implements VOInmueble{

	/*
	 * Atributos
	 */
	private long id;
	private int costoBase;
	private boolean disponible;
	
	/*
	 * Métodos
	 */
	
	/**
	 * Constructor por defecto
	 */
	public Inmueble() {
		this.id=0;
		this.costoBase=0;
		this.disponible=false;
	}
	
	/**
	 * Constructor con parametros
	 * @param id
	 * @param costoBase
	 * @param disponible
	 */
	public Inmueble(long id, int costoBase, boolean disponible) {
		this.id=id;
		this.costoBase=costoBase;
		this.disponible=disponible;
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

	@Override
	public boolean getDisponible() {
		// TODO Auto-generated method stub
		return disponible;
	}
	
	public void setDisponible(boolean disponible) {
		this.disponible=disponible;
	}
	
	public String toString() 
	{
		return "Inmueble [id=" + id + ", Costo base="+ costoBase + ", Disponible="+ disponible+ "]";
	}

}
