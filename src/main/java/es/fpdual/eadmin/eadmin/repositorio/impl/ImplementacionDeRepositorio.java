package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;

@Repository
public class ImplementacionDeRepositorio implements RepositorioDocumento {

	private List<Documento> documentos = new ArrayList<>();

	@Override
	public void altaDocumento(Documento documento) {
		if (documentos.contains(documento)) {
			throw new IllegalArgumentException("El documento ya existe");
		}
		documentos.add(documento);
		System.out.println("Documento dado de alta");
	}

	@Override
	public void modificarDocumento(Documento documento) {
		if (!documentos.contains(documento)) {
			throw new IllegalArgumentException("El documento no existe");
		}
		documentos.indexOf(documento);
		documentos.set(documentos.indexOf(documento), documento);
	}

	@Override
	public void eliminarDocumento(Integer codigo) {

		Optional<Documento> documentoEncontrado = documentos.stream().filter(d -> tieneIgualCodigo(d, codigo))
				.findFirst();

		if (documentoEncontrado.isPresent()) {
			documentos.remove(documentoEncontrado.get());
		}
	}

	@Override
	public List<Documento> obtenerTodosLosDocumentos() {
		return getDocumentos();
	}

	@Override
	public Documento obtenerDocumentoPorCodigo(Integer codigo) {
		Optional<Documento> documentoEncontrado = documentos.stream().filter(d -> tieneIgualCodigo(d, codigo))
				.findFirst();

		if (documentoEncontrado.isPresent()) {
			return documentoEncontrado.get();
		}
		return null;
	}

	protected boolean tieneIgualCodigo(Documento documento, Integer codigo) {
		return documento.getCodigo().equals(codigo);
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}

}
