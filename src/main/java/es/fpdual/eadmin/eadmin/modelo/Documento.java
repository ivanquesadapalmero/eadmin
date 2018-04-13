package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Documento extends ModeloBaseAdministracionElectronica {

	private EstadoDocumento estado = null;

	public Documento(Integer codigo, String nombre, Date fechaCreacion, Date fechaModificacion, EstadoDocumento estado,
			Boolean publico) {
		super(codigo, nombre, fechaCreacion, fechaModificacion, publico);
		this.estado = estado;
	}

	public EstadoDocumento getEstado() {
		return estado;
	}

	@Override
	public int hashCode() {
		HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
		hashCodeBuilder.appendSuper(super.hashCode());
		hashCodeBuilder.append(estado);
		return hashCodeBuilder.toHashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Documento) {
			final Documento param = (Documento) obj;
			EqualsBuilder equalsBuilder = new EqualsBuilder();
			equalsBuilder.appendSuper(super.equals(param));
			equalsBuilder.append(this.estado, param.estado);

			return equalsBuilder.isEquals();
		}
		return false;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
