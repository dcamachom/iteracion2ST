package negocio;

import java.util.LinkedList;
import java.util.List;

public class Operador implements VOOperador{

	/*
	 * Atributos
	 */
	
	private long id;
	private String nombre;
	private String tipoOperador;
	private List<Object[]> inmuebles;
	
	/*
	 * Métodos
	 */
	
	/**
	 * Constructor por defecto
	 */
	
	public Operador() {
		this.id=0;
		this.nombre="";
		this.tipoOperador="";
		inmuebles= new LinkedList<Object[]>();
	}
	
	/**
	 * Constructor con valores
	 * @param id
	 * @param nombre
	 * @param tipoOperador
	 */
	public Operador(long id, String nombre, String tipoOperador) {
		this.id=id;
		this.nombre=nombre;
		this.tipoOperador=tipoOperador;
		inmuebles= new LinkedList<Object[]>();
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id=id;
	}

	public String getTipoOperador() {
		return tipoOperador;
	}

	public void setTipoOperador(String tipoOperador) {
		this.tipoOperador=tipoOperador;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public List<Object[]> getInmuebles() {
		return inmuebles;
	}

	public void setInmuebles(List<Object[]> inmuebles) {
		this.inmuebles = inmuebles;
	}

	public String toString() 
	{
		return "Operador [id=" + id + ", Nombre=" + nombre + ", Tipo Operador=" + tipoOperador +"]";
	}
	
}
