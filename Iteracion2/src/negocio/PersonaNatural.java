package negocio;

import java.util.List;

public class PersonaNatural extends Operador implements VOPersonaNatural {

	/*
	 * Atributos
	 */
	
	private String correo;
	private String telefono;
	
	/*
	 * Métodos
	 */
	
	/**
	 * Constructor por defecto
	 */
	public PersonaNatural() {
		super();
		this.telefono="";
		this.correo="";
	}
	
	/**
	 * Constructor con parametros
	 * @param id
	 * @param nombrePersona
	 * @param correo
	 * @param telefono
	 */
	public PersonaNatural(long id, String nombre, String tipoOperador, String correo, String telefono) {
		super(id, nombre, tipoOperador);
		this.telefono=telefono;
		this.correo=correo;
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
	public String getCorreo() {
		// TODO Auto-generated method stub
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo=correo;
	}

	@Override
	public String getTelefono() {
		// TODO Auto-generated method stub
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono=telefono;
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
