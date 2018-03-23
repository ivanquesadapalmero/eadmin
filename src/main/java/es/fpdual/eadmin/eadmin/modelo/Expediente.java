package es.fpdual.eadmin.eadmin.modelo;

import java.util.List;
import java.util.Date;

public class Expediente extends ModeloBaseAdministracionElectronica {

	private final Date fechaArchivado;
	private final EstadoExpediente estado;
	private final List<Documento> documentos;
	private final Boolean publico;

	public Expediente(Integer codigo, String nombre, Date fechaCreacion, Date fechaModificacion, Boolean publico, Date fechaArchivado,
			EstadoExpediente estado, List<Documento> documentos) {
		super(codigo, nombre, fechaCreacion, fechaModificacion);
		this.fechaArchivado = fechaArchivado;
		this.estado = estado;
		this.documentos = documentos;
		this.publico = publico;
	}

	public Date getFechaArchivado() {
		return fechaArchivado;
	}

	public EstadoExpediente getEstado() {
		return estado;
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}

	public Boolean getPublico() {
		return publico;
	}

	@Override
	public int hashCode() {
		return codigo.hashCode() + nombre.hashCode() + fechaCreacion.hashCode() + fechaArchivado.hashCode()
				+ estado.hashCode() + documentos.hashCode() + publico.hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Expediente) {
			return codigo.equals(((Expediente) obj).getFechaArchivado())
					&& nombre.equals(((Expediente) obj).getNombre())
					&& fechaCreacion.equals(((Expediente) obj).getFechaCreacion())
					&& fechaArchivado.equals(((Expediente) obj).getFechaArchivado())
					&& estado.equals(((Expediente) obj).getEstado())
					&& documentos.equals(((Expediente) obj).getDocumentos())
					&& publico.equals(((Expediente) obj).getPublico());
		}
		return false;
	}

	@Override
	public String toString() {
		return "Expediente con código " + super.getCodigo();
	}

}
