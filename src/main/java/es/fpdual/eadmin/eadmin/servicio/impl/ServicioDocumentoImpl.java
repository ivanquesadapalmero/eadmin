package es.fpdual.eadmin.eadmin.servicio.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.eadmin.eadmin.servicio.ServicioDocumento;

@Service
public class ServicioDocumentoImpl implements ServicioDocumento {

	RepositorioDocumento repositorioDocumento;

	@Autowired
	public ServicioDocumentoImpl(RepositorioDocumento repositorioDocumento) {
		this.repositorioDocumento = repositorioDocumento;
	}

	@Override
	public Documento altaDocumento(Documento documento) {

		repositorioDocumento.altaDocumento(documento);
		return documento;
	}

	@Override
	public Documento modificarDocumento(Documento documento) {

		final Documento documentoModificado = obtenerDocumentoConFechaCorrecta(documento);

		repositorioDocumento.modificarDocumento(documentoModificado);
		return documentoModificado;
	}
	@Override
	public void eliminarDocumento(Integer codigo) {
		repositorioDocumento.eliminarDocumento(codigo);
	}

	private Documento obtenerDocumentoConFechaCorrecta(Documento documento) {
		return new Documento(documento.getCodigo(), documento.getNombre(),
				dameFechaActual(), documento.getFechaModificacion(), documento.getPublico(), documento.getEstado());
	}

	private Date dameFechaActual() {
		return new Date();
	}

	

}
