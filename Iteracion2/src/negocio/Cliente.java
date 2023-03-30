package negocio;

public class Cliente implements VOCliente{
	
	/*
	 * Atributos
	 */
	
	public long id;
	
	public String nombre;
	
	public String correo;
	
	public String telefono;
	
	public String tipoMiembro;
	
	/*
	 * Métodos
	 */
	
	/***
	 * Método por defecto
	 */
	
	public Cliente() {
		this.id=0;
		this.nombre="";
		this.correo="";
		this.telefono="";
		this.tipoMiembro="";
	}
	
	/**
	 *Constructor con valores
	 * @param id
	 * @param nombre
	 * @param correo
	 * @param telefono
	 * @param tipoMiembro
	 */
	public Cliente(long id, String nombre, String correo, String telefono, String tipoMiembro) {
		
		this.id=id;
		this.nombre=nombre;
		this.correo=correo;
		this.telefono=telefono;
		this.tipoMiembro=tipoMiembro;
		
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

	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo=correo;
	}

	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono=telefono;
	}

	public String getTipoMiembro() {
		return tipoMiembro;
	}
	
	public void setTipoMiembro (String tipoMiembro) {
		this.tipoMiembro=tipoMiembro;
	}
	
	public String toString() 
	{
		return "Ciudad [id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", telefono=" + telefono
				+ ", tipo de miembro=" + tipoMiembro + "]";
	}

}
