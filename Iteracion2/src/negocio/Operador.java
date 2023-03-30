package negocio;

public class Operador implements VOOperador{

	/*
	 * Atributos
	 */
	
	private long id;
	private String nombre;
	private String tipoOperador;
	
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
	
	public String toString() 
	{
		return "Operador [id=" + id + ", Nombre=" + nombre + ", Tipo Operador=" + tipoOperador +"]";
	}
	
}
