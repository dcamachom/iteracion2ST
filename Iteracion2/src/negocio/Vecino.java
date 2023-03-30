package negocio;

public class Vecino implements VOVecino{
	
	/*
	 * Atributos
	 */
	
	private long id;
	private String nombreVecino;
	private String correo;
	private String telefono;
	
	/*
	 * Métodos
	 */
	
	/**
	 * Constructor por defecto
	 */
	public Vecino() {
		this.id=0;
		this.nombreVecino="";
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
	public Vecino(long id, String nombreVecino, String correo, String telefono) {
		this.id=id;
		this.nombreVecino=nombreVecino;
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
	public String getNombreVecino() {
		// TODO Auto-generated method stub
		return nombreVecino;
	}
	
	public void setNombrePersona(String nombrePersona) {
		this.nombreVecino=nombrePersona;
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
		return "Vecino [id=" + id + ", Nombre=" + nombreVecino 
				+ ", Telefono=" +telefono+", Correo="+correo+"]";
	}


}
