package es.fpdual.eadmin.eadmin.modelo;

import java.util.Date;

public class ModeloBaseAdministracionElectronica {

	protected Integer codigo;
	protected String nombre;
	protected Date fechaCreacion;

	

	public ModeloBaseAdministracionElectronica(Integer codigo, String nombre, Date fechaCreacion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
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

	@Override
	public int hashCode() {
		return codigo.hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Documento) {
			return codigo.equals(((Documento) obj).getCodigo());
		}
		
		return false;
	}

}