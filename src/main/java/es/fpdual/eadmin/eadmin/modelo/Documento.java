package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public class Documento extends ModeloBaseAdministracionElectronica {

	private EstadoDocumento estado;
	private Boolean publico;

	public Documento(Integer codigo, String nombre, Date fechaCreacion, Boolean publico,  EstadoDocumento estado) {
		super(codigo, nombre, fechaCreacion);
		this.estado = estado;
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
