package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.Expediente;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioExpediente;

public class ImplementacionDeRepositorioExpediente implements RepositorioExpediente {
	private List<Expediente> expedientes = new ArrayList<>();

	@Override
	public void almacenarExpediente(Expediente expediente) {
		if (expedientes.contains(expediente)) {
			throw new IllegalArgumentException("El expediente ya existe");
		}
		expedientes.add(expediente);
	}

	@Override
	public void modificarExpediente(Expediente expediente) {
		if (!expedientes.contains(expediente)) {
			throw new IllegalArgumentException("El expediente no existe");
		}
		expedientes.indexOf(expediente);
		expedientes.set(expedientes.indexOf(expediente), expediente);
	}

	@Override
	public void eliminarExpediente(Integer codigo) {

		Optional<Expediente> documentoEncontrado = expedientes.stream().filter(d -> tieneIgualCodigo(d, codigo))
				.findFirst();

		if (documentoEncontrado.isPresent()) {
			expedientes.remove(documentoEncontrado.get());
		}
	}

	@Override
	public Expediente asociarExpediente(Integer codigo, Documento documento) {
		Optional<Expediente> expedienteEncontrado = expedientes.stream().filter(e -> tieneIgualCodigo(e, codigo))
				.findFirst();
		if (expedienteEncontrado.isPresent()) {

			expedienteEncontrado.get().getDocumentos().add(documento);
			return expedienteEncontrado.get();
		}
		return null;

	}

	@Override
	public Expediente desasociarExpediente(Integer codigo, Documento documento) {
		Optional<Expediente> expedienteEncontrado = expedientes.stream().filter(e -> tieneIgualCodigo(e, codigo))
				.findFirst();
		if (expedienteEncontrado.isPresent()) {

			expedienteEncontrado.get().getDocumentos().remove(documento);
			return expedienteEncontrado.get();
		}
		return null;
	}

	protected boolean tieneIgualCodigo(Expediente documento, Integer codigo) {
		return documento.getCodigo().equals(codigo);
	}

	public List<Expediente> getExpedientes() {
		return expedientes;
	}

}
