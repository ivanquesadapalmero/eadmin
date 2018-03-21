package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;

public class ImplementacionDeRepositorioTest {

	private static final Integer CODIGO = 1;
	private static final String NOMBRE = "prueba";
	private static final Date FECHA_CREACION = new Date();
	private static final boolean PUBLICO = true;
	private static final EstadoDocumento ESTADO_DOCUMENTO = EstadoDocumento.ACTIVO;
	private Documento doc;
	private List<Documento> documentos; 
	private Im
	
	@BeforeClass
	public void crearListaYDocumento() {
		doc = new Documento(CODIGO, NOMBRE, FECHA_CREACION, PUBLICO, ESTADO_DOCUMENTO);
		documentos = new ArrayList<>();
	}

	@Test
	public void testAltaDocumento() {
		ImplementacionDeRepositorio.altaDocumento(doc);
		documentos.add(doc);
	}
	
	@Test
	public void modificarDocumento() {
		
	}
	
	@Test
	public void eliminarDocumento() {
		
	}
}
