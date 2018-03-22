package es.fpdual.eadmin.eadmin.modelo;

import java.math.BigDecimal;
import java.util.Date;

public class Documento extends ModeloBaseAdministracionElectronica {

	private EstadoDocumento estado;
	private Boolean publico;
	private BigDecimal codigoVerificacion;

	public Documento(Integer codigo, String nombre, Date fechaCreacion, Date fechaModificacion, Boolean publico,  EstadoDocumento estado, BigDecimal codigoVerificacion) {
		super(codigo, nombre, fechaCreacion, fechaModificacion);
		this.estado = estado;
		this.publico = publico;
		this.codigoVerificacion = codigoVerificacion;
	}

	public EstadoDocumento getEstado() {
		return estado;
	}
	
	public Boolean getPublico() {
		return publico;
	}
	
	public 


	@Override
	public String toString() {
		return "Documento con código " + getCodigo();
	}

}
