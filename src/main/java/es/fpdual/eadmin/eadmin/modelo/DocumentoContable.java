package es.fpdual.eadmin.eadmin.modelo;

import java.math.BigDecimal;
import java.util.Date;

public class DocumentoContable extends Documento {

	private final BigDecimal importe;
	private final String dniInteresado;

	public DocumentoContable(Integer codigo, String nombre, Date fechaCreacion, Date fechaModificacion,
			EstadoDocumento estado, Boolean publico, BigDecimal importe, String dniInteresado) {
		super(codigo, nombre, fechaCreacion, fechaModificacion, estado, publico);
		this.importe = importe;
		this.dniInteresado = dniInteresado;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public String getDniInteresado() {
		return dniInteresado;
	}

	@Override
	public String toString() {
		return "DocumentoContable codigo=" + super.getCodigo() + ", importe=" + importe + ", dniInteresado="
				+ dniInteresado + "]";
	}

}
