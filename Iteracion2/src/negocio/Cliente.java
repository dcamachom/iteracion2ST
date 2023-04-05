package negocio;

import java.util.LinkedList;
import java.util.List;

public class Cliente implements VOCliente{
	
	/*
	 * Atributos
	 */
	
	private long id;
	private String nombre;
	private String correo;
	private String telefono;
	private String tipoMiembro;
	private List<Object[]> reservas;
	
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
		reservas = new LinkedList<Object []> ();
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
		reservas = new LinkedList<Object []> ();
		
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
	
	public List<Object[]> getReservas() {
		return reservas;
	}

	public void setReservas(List<Object[]> reservas) {
		this.reservas = reservas;
	}

	
	public String toString() 
	{
		return "Ciudad [id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", telefono=" + telefono
				+ ", tipo de miembro=" + tipoMiembro + "]";
	}

}
