package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;

@Repository
public class ImplementacionDeRepositorio implements RepositorioDocumento {

	private List<Documento> documentos = new ArrayList<>();
	private static Logger logger = LoggerFactory.getLogger(ImplementacionDeRepositorio.class);

	@Override
	public void altaDocumento(Documento documento) {
		if (documentos.contains(documento)) {
			throw new IllegalArgumentException("El documento ya existe");
		}
		documentos.add(documento);
		logger.info(documento.toString() + " creado correctamente");
	}

	@Override
	public void modificarDocumento(Documento documento) {
		logger.info("Entro en modificarDocumento()");
		if (!documentos.contains(documento)) {
			throw new IllegalArgumentException("El documento no existe");
		}
		documentos.set(documentos.indexOf(documento), documento);
		logger.info("Salgo de modificarDocumento()");
	}

	@Override
	public void eliminarDocumento(Integer codigo) {

		logger.info("Entro en eliminarDocumento()");

		Optional<Documento> documentoEncontrado = documentos.stream().filter(d -> tieneIgualCodigo(d, codigo))
				.findFirst();

		if (documentoEncontrado.isPresent()) {
			documentos.remove(documentoEncontrado.get());
		}

		logger.info("Salgo de eliminarDocumento()");
	}

	@Override
	public List<Documento> obtenerTodosLosDocumentos() {

		logger.info("Entro en obtenerTodosLosDocumento()");

		for (Documento doc : documentos) {
			logger.info("************");
			logger.info("Documento: " + doc.getCodigo());
			logger.info("Nombre: " + doc.getNombre());
			logger.info("Fecha Creación: " + doc.getFechaCreacion());
			logger.info("Fecha Modificación: " + doc.getFechaModificacion());
			logger.info("Estado: " + doc.getEstado());
			logger.info("Publico: " + doc.getPublico());
			logger.info("************");
		}
		logger.info("Salgo de obtenerTodosLosDocumentos()");
		return getDocumentos();
	}

	@Override
	public Documento obtenerDocumentoPorCodigo(Integer codigo) {
		logger.info("Entro en obtenerDocumentoPorCodigo()");
		Optional<Documento> documentoEncontrado = documentos.stream().filter(d -> tieneIgualCodigo(d, codigo))
				.findFirst();

		if (documentoEncontrado.isPresent()) {
			logger.info("salgo en obtenerDocumentoPorCodigo()");
			return documentoEncontrado.get();
		}
		logger.info("Salgo en obtenerDocumentoPorCodigo()");
		return null;
	}

	protected boolean tieneIgualCodigo(Documento documento, Integer codigo) {
		return documento.getCodigo().equals(codigo);
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}

}
