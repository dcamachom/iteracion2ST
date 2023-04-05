package negocio;

public class Servicio implements VOServicio {

	/*
	 * Atributos
	 */
	
	private long id;
	private String nombre;
	private String descripcion;
	
	/*
	 * Métodos
	 */
	
	/**
	 * Constructor por defecto
	 */
	public Servicio() {
		this.id=0;
		this.nombre="";
		this.descripcion="";
	}
	
	/**
	 * Constructor con valores
	 * @param id
	 * @param nombre
	 * @param descripcion
	 * @param valorAdicional
	 */
	
	public Servicio(long id, String nombre, String descripcion, int valorAdicional) {
		this.id=id;
		this.nombre=nombre;
		this.descripcion=descripcion;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id=id;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion=descripcion;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	

}
