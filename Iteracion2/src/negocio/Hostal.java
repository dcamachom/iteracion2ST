package negocio;

import java.sql.Time;

public class Hostal implements VOHostal{
	
	/*
	 * Atributos
	 */
	
	private long id;
	private String registroCamaraComercio;
	private String registroSuperIntendencia;
	private Time horaApertura;
	private Time horaCierre;
	
	/*
	 * Métodos
	 */
	
	/**
	 * Constructor por defecto
	 */
	
	public Hostal() {
		this.id=0;
		this.registroCamaraComercio="";
		this.registroSuperIntendencia="";
		this.horaApertura= new Time (0);
		this.horaCierre= new Time(0);
	}
	
	
	/**
	 * Metodo con valores
	 * @param id
	 * @param registroCamaraComercio
	 * @param registroSuperIntendencia
	 * @param horaApertura
	 * @param horaCierre
	 */
	public Hostal (long id, String registroCamaraComercio, String registroSuperIntendencia,
			Time horaApertura, Time horaCierre) {
		this.id=id;
		this.registroCamaraComercio=registroCamaraComercio;
		this.registroSuperIntendencia=registroSuperIntendencia;
		this.horaApertura=horaApertura;
		this.horaCierre=horaCierre;
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
	
	public void setRegistroCamaraComercio(String registro) {
		this.registroCamaraComercio=registro;
	}

	@Override
	public String getRegistroSuperIntendencia() {
		// TODO Auto-generated method stub
		return registroSuperIntendencia;
	}
	
	public void setRegistroSuperIntendencia(String registro) {
		this.registroSuperIntendencia=registro;
	}

	@Override
	public Time getHoraApertura() {
		// TODO Auto-generated method stub
		return horaApertura;
	}
	
	public void setHoraApertura(Time horaApertura) {
		this.horaApertura=horaApertura;
	}

	@Override
	public Time getHoraCierre() {
		// TODO Auto-generated method stub
		return horaCierre;
	}
	
	public void setHoraCierre(Time horaCierre) {
		this.horaCierre=horaCierre;
	}
	
	public String toString() {
		return "Hotel [id=" + id +", registro camara comercio=" +registroCamaraComercio
				+ ", registro superIntendencia" +registroSuperIntendencia+ ", hora apertura="
				+horaApertura +", hora cierre="+horaCierre+"]";
	}

}
