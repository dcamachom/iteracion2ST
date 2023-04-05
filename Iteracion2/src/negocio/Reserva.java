package negocio;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Reserva implements VOReserva{
	
	/*
	 * Atributos
	 */
	
	private long id;
	private Date fechaInicio;
	private Date fechaFin;
	private long idCliente;
	private long idInmueble;
	private List<Object[]> serviciosUsados;
	
	/*
	 * Métodos
	 */
	
	/**
	 * Método constructor por defecto
	 */
	
	public Reserva() {
		this.id=0;
		this.fechaInicio= new Date(0);
		this.fechaFin= new Date(0);
		this.idCliente=0;
		this.idInmueble=0;	
		serviciosUsados= new LinkedList<Object[]>();
	}
	
	/**
	 * Método constructor con valores
	 */
	 public Reserva(long id, Date fechaInicio, Date fechaFin, long idCliente, long idInmueble) {
		 this.id=id;
		 this.fechaInicio=fechaInicio;
		 this.fechaFin=fechaFin;
		 this.idCliente=idCliente;
		 this.idInmueble=idInmueble;
		 serviciosUsados= new LinkedList<Object[]>();
	 }

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id=id;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}
	
	public void setFechaInicio( Date fechaInicio) {
		this.fechaInicio=fechaInicio;
	}

	public Date getFechaFin() {
		return this.fechaFin;
	}
	
	public void setFechaFin(Date fechaFin) {
		this.fechaFin=fechaFin;
	}

	public long getIdCliente() {
		return this.idCliente;
	}
	
	public void setIdCliente(long idCliente) {
		this.idCliente=idCliente;
	}
	
	public long getIdInmueble() {
		return this.idInmueble;
	}
	
	public void setIdInmueble(long idInmueble) {
		this.idInmueble=idInmueble;
	}

	public List<Object[]> getServiciosUsados() {
		return serviciosUsados;
	}

	public void setServiciosUsados(List<Object[]> serviciosUsados) {
		this.serviciosUsados = serviciosUsados;
	}

	public String toString() 
	{
		return "Reserva [id=" + id + ", Fecha inicio="+ fechaInicio + ", Fecha fin="+ fechaFin
				+ ", id cliente=" + idCliente+ ", id inmueble=" + idInmueble +"]";
	}
}
