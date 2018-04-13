package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class ModeloBaseAdministracionElectronica {

	protected final Integer codigo;
	protected final String nombre;
	protected final Date fechaCreacion;
	protected final Date fechaModificacion;
	private final Boolean publico;

	public ModeloBaseAdministracionElectronica(Integer codigo, String nombre, Date fechaCreacion,
			Date fechaModificacion, Boolean publico) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.publico = publico;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public Date getFechaModificacion() {
		return fechaModificacion;
	}

	public Boolean getPublico() {
		return publico;
	}

	@Override
	public int hashCode() {
		HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();

		hashCodeBuilder.append(codigo);
		hashCodeBuilder.append(nombre);
		hashCodeBuilder.append(fechaCreacion);
		hashCodeBuilder.append(fechaModificacion);
		hashCodeBuilder.append(publico);

		return hashCodeBuilder.toHashCode();

	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof ModeloBaseAdministracionElectronica) {
			final ModeloBaseAdministracionElectronica param = (ModeloBaseAdministracionElectronica) obj;
			EqualsBuilder equalsBuilder = new EqualsBuilder();

			equalsBuilder.append(this.codigo, param.codigo);
			equalsBuilder.append(this.nombre, param.nombre);
			equalsBuilder.append(this.fechaCreacion, param.fechaCreacion);
			equalsBuilder.append(this.fechaModificacion, param.fechaModificacion);
			equalsBuilder.append(this.publico, param.publico);

			return equalsBuilder.isEquals();
		}

		return false;
	}

}
