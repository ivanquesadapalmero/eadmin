package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.Expediente;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioExpediente;

public class ImplementacionDeRepositorioExpediente implements RepositorioExpediente {
	private List<Expediente> expedientes = new ArrayList<>();
	private static Logger logger = LoggerFactory.getLogger(ImplementacionDeRepositorio.class);
	
	FileWriter file = null;
	PrintWriter pw = null;
	

	@Override
	public void almacenarExpediente(Expediente expediente) {
		if (expedientes.contains(expediente)) {
			throw new IllegalArgumentException("El expediente ya existe");
		}
		altaExpedientesTxt(expediente);
		expedientes.add(expediente);
	}

	@Override
	public void modificarExpediente(Expediente expediente) {
		if (!expedientes.contains(expediente)) {
			throw new IllegalArgumentException("El expediente no existe");
		}
		modificarExpedientesTxt(expediente);
		expedientes.indexOf(expediente);
		expedientes.set(expedientes.indexOf(expediente), expediente);
	}

	@Override
	public void eliminarExpediente(Integer codigo) {

		Optional<Expediente> expedienteEncontrado = expedientes.stream().filter(d -> tieneIgualCodigo(d, codigo))
				.findFirst();

		if (expedienteEncontrado.isPresent()) {
			expedientes.remove(expedienteEncontrado.get());
			
			eliminarExpedientesTxt(expedienteEncontrado);
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
	
	@Override
	public Expediente obtenerExpedientePorCodigo(Integer codigo) {
		Optional<Expediente> expedienteEncontrado = expedientes.stream().filter(d -> tieneIgualCodigo(d, codigo))
				.findFirst();

		if (expedienteEncontrado.isPresent()) {
			return expedienteEncontrado.get();
		}
		
		return null;
	}

	@Override
	public List<Expediente> obtenerTodosLosExpedientes(){
		return getExpedientes();
	}
	
	protected boolean tieneIgualCodigo(Expediente documento, Integer codigo) {
		return documento.getCodigo().equals(codigo);
	}

	public List<Expediente> getExpedientes() {
		return expedientes;
	}
	
	public void escribirListaEnFichero() {
		logger.info("Entro en ecribirListaEnFichero()");
		try {
		file = new FileWriter("ficheroListaExpedientes.txt", true);
		pw = new PrintWriter(file);
		
		for(Expediente exp : expedientes) {
			
			pw.println("**********Expediente "+exp.getCodigo()+"************");
			pw.println("Nombre: "+exp.getNombre());
			pw.println("Fecha Creación: "+exp.getFechaCreacion());
			pw.println("Fecha Modificación: "+exp.getFechaModificacion());
			pw.println("Fecha de archivado: "+exp.getFechaArchivado());
			pw.println("Estado: "+exp.getEstado());
			pw.println("Publico: "+exp.getPublico());
			pw.println("******************************************");
			
			
			
		}
		pw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		logger.info("Salgo de ecribirListaEnFichero()");
		
	}
	
	private void altaExpedientesTxt(Expediente expediente) {
		try {
		file = new FileWriter("AltaExpedientes.txt", true);
		pw = new PrintWriter(file);
		
		pw.println("**********Documento "+expediente.getCodigo()+"************");
		pw.println("Nombre: "+expediente.getNombre());
		pw.println("Fecha Creación: "+expediente.getFechaCreacion());
		pw.println("Fecha Modificación: "+expediente.getFechaModificacion());
		pw.println("Fecha de archivado: "+expediente.getFechaArchivado());
		pw.println("Estado: "+expediente.getEstado());
		pw.println("Publico: "+expediente.getPublico());
		pw.println("*********************************************");
		pw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void modificarExpedientesTxt(Expediente expediente) {
		try {
		file = new FileWriter("ModificarExpedientes.txt", true);
		pw = new PrintWriter(file);
		
		pw.println("**********Documento "+expediente.getCodigo()+"************");
		pw.println("Nombre: "+expediente.getNombre());
		pw.println("Fecha Creación: "+expediente.getFechaCreacion());
		pw.println("Fecha Modificación: "+expediente.getFechaModificacion());
		pw.println("Fecha de archivado: "+expediente.getFechaArchivado());
		pw.println("Estado: "+expediente.getEstado());
		pw.println("Publico: "+expediente.getPublico());
		pw.println("*********************************************");
		pw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void eliminarExpedientesTxt(Optional<Expediente> expediente) {
		try {
		file = new FileWriter("EliminarExpedientes.txt", true);
		pw = new PrintWriter(file);
		
		pw.println("**********Documento "+expediente.get().getCodigo()+"************");
		pw.println("Nombre: "+expediente.get().getNombre());
		pw.println("Fecha Creación: "+expediente.get().getFechaCreacion());
		pw.println("Fecha Modificación: "+expediente.get().getFechaModificacion());
		pw.println("Fecha de archivado: "+expediente.get().getFechaArchivado());
		pw.println("Estado: "+expediente.get().getEstado());
		pw.println("Publico: "+expediente.get().getPublico());
		pw.println("*********************************************");
		pw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	

}
