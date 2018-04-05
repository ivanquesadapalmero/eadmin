package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
import java.io.PrintWriter;
@Repository
public class ImplementacionDeRepositorio implements RepositorioDocumento {

	private List<Documento> documentos = new ArrayList<>();
	private static Logger logger = LoggerFactory.getLogger(ImplementacionDeRepositorio.class);
	
	
	FileWriter file = null;
	PrintWriter pw = null;

	@Override
	public void altaDocumento(Documento documento) {
		if (documentos.contains(documento)) {
			throw new IllegalArgumentException("El documento ya existe");
		}
		
		altaTxt(documento);
		documentos.add(documento);
		logger.info(documento.toString() + " creado correctamente");
	}

	

	@Override
	public void modificarDocumento(Documento documento) {
		logger.info("Entro en modificarDocumento()");
		if (!documentos.contains(documento)) {
			throw new IllegalArgumentException("El documento no existe");
		}
		
		modificarTxt(documento);
		
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
			
			eliminarTxt(documentoEncontrado);
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
	
	public void escribirListaEnFichero() {
		logger.info("Entro en ecribirListaEnFichero()");
		try {
		file = new FileWriter("ficheroLista.txt", true);
		pw = new PrintWriter(file);
		
		for(Documento doc : documentos) {
			
			pw.println("**********Documento "+doc.getCodigo()+"************");
			pw.println("Nombre: "+doc.getNombre());
			pw.println("Fecha Creación: "+doc.getFechaCreacion());
			pw.println("Fecha Modificación: "+doc.getFechaModificacion());
			pw.println("Estado: "+doc.getEstado());
			pw.println("Publico: "+doc.getPublico());
			pw.println("******************************************");
			
			
			
		}
		pw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		logger.info("Salgo de ecribirListaEnFichero()");
		
	}
	

	protected boolean tieneIgualCodigo(Documento documento, Integer codigo) {
		return documento.getCodigo().equals(codigo);
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}
	
	private void altaTxt(Documento documento) {
		try {
		file = new FileWriter("Alta.txt", true);
		pw = new PrintWriter(file);
		
		pw.println("**********Documento "+documento.getCodigo()+"************");
		pw.println("Nombre: "+documento.getNombre());
		pw.println("Fecha Creación: "+documento.getFechaCreacion());
		pw.println("Fecha Modificación: "+documento.getFechaModificacion());
		pw.println("Estado: "+documento.getEstado());
		pw.println("Publico: "+documento.getPublico());
		pw.println("*********************************************");
		pw.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	private void modificarTxt(Documento documento) {
		try {
			file = new FileWriter("Modificar.txt", true);
			pw = new PrintWriter(file);
			
			pw.println("**********Documento "+documento.getCodigo()+"************");
			pw.println("Nombre: "+documento.getNombre());
			pw.println("Fecha Creación: "+documento.getFechaCreacion());
			pw.println("Fecha Modificación: "+documento.getFechaModificacion());
			pw.println("Estado: "+documento.getEstado());
			pw.println("Publico: "+documento.getPublico());
			pw.println("*********************************************");
			pw.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
	}
	private void eliminarTxt(Optional<Documento> documentoEncontrado) {
		try {
			file = new FileWriter("Eliminar.txt", true);
			pw = new PrintWriter(file);
			
			pw.println("**********Documento "+documentoEncontrado.get().getCodigo()+"************");
			pw.println("Nombre: "+documentoEncontrado.get().getNombre());
			pw.println("Fecha Creación: "+documentoEncontrado.get().getFechaCreacion());
			pw.println("Fecha Modificación: "+documentoEncontrado.get().getFechaModificacion());
			pw.println("Estado: "+documentoEncontrado.get().getEstado());
			pw.println("Publico: "+documentoEncontrado.get().getPublico());
			pw.println("*********************************************");
			pw.close();
			} catch(IOException e) {
				e.printStackTrace();
			}
	}
	

}
