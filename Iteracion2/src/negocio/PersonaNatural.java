package negocio;

public class PersonaNatural implements VOPersonaNatural{

	/*
	 * Atributos
	 */
	
	private long id;
	private String nombrePersona;
	private String correo;
	private String telefono;
	
	/*
	 * Métodos
	 */
	
	/**
	 * Constructor por defecto
	 */
	public PersonaNatural() {
		this.id=0;
		this.nombrePersona="";
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
	public PersonaNatural(long id, String nombrePersona, String correo, String telefono) {
		this.id=id;
		this.nombrePersona=nombrePersona;
		this.telefono=telefono;
		this.correo=correo;
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
	public String getNombrePersona() {
		// TODO Auto-generated method stub
		return nombrePersona;
	}
	
	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona=nombrePersona;
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
	
	public String toString() 
	{
		return "Persona natural [id=" + id + ", Nombre=" + nombrePersona 
				+ ", Telefono=" +telefono+", Correo="+correo+"]";
	}

}
