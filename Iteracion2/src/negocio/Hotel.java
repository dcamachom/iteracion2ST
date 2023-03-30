package negocio;

public class Hotel implements VOHotel{

	/*
	 * Atributos
	 */
	
	private long id;
	private String registroCamaraComercio;
	private String registroSuperIntendencia;
	
	/*
	 * Métodos
	 */
	
	/**
	 * Constructor por defecto
	 */
	
	public Hotel() {
		this.id=0;
		this.registroCamaraComercio="";
		this.registroSuperIntendencia="";
	}
	
	/**
	 * Método con valores
	 * @param id
	 * @param registroCamaraComercio
	 * @param registroSuperIntendencia
	 */
	public Hotel (long id, String registroCamaraComercio, String registroSuperIntendencia) {
		this.id=id;
		this.registroCamaraComercio=registroCamaraComercio;
		this.registroSuperIntendencia=registroSuperIntendencia;
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
	public String getRegistroCamaraComercio() {
		// TODO Auto-generated method stub
		return registroCamaraComercio;
	}
	
	public void setRegistroCamaraComercio (String registroCamaraComercio) {
		this.registroCamaraComercio=registroCamaraComercio;
	}

	@Override
	public String getRegistroSuperIntendencia() {
		// TODO Auto-generated method stub
		return registroSuperIntendencia;
	}
	
	public void setRegistroSuperIntendencia(String registroSuperIntendencia) {
		this.registroSuperIntendencia=registroSuperIntendencia;
	}
	
	public String toString() {
		return "Hotel [id=" + id +", registro camara comercio=" +registroCamaraComercio
				+ ", registro superIntendencia" +registroSuperIntendencia+"]";
	}

}
