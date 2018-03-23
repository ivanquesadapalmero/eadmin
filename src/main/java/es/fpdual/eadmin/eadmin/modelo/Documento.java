package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public class Documento extends ModeloBaseAdministracionElectronica {

	private final EstadoDocumento estado;
	private final Boolean publico;
	
	


	public Documento(Integer codigo, String nombre, Date fechaCreacion, Date fechaModificacion, Boolean publico,  EstadoDocumento estado) {
		super(codigo, nombre, fechaCreacion, fechaModificacion);
		this.estado = estado;
		this.publico = publico;
	}

	public EstadoDocumento getEstado() {
		return estado;
	}
	
	public Boolean getPublico() {
		return publico;
	}
	

	@Override
	public String toString() {
		return "Documento con código " + getCodigo();
	}

}
