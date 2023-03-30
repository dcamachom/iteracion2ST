package negocio;

public class ViviendaUniversitaria implements VOViviendaUniversitaria{

	/*
	 * Atributos
	 */
	private long id;
	
	/*
	 * Métodos
	 */
	
	/**
	 * Constructor por defecto
	 */
	public ViviendaUniversitaria() {
		this.id=0;
	}
	
	/**
	 * Metodo con parametos
	 * @param id
	 */
	public ViviendaUniversitaria(long id) {
		this.id=id;
	}
	
	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
