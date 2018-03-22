package es.fpdual.eadmin.eadmin.repositorio.impl;

import static org.junit.Assert.*;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;

public class ImplementacionDeRepositorioTest {

	private static final Integer CODIGO = 1;
	private static final String NOMBRE = "prueba";
	private static final Date FECHA_CREACION = new Date();
	private static final Date FECHA_MODIFICACION = new Date();
	private static final boolean PUBLICO = true;
	private static final EstadoDocumento ESTADO_DOCUMENTO = EstadoDocumento.ACTIVO;
	private Documento documento = new Documento(CODIGO, NOMBRE, FECHA_CREACION, FECHA_MODIFICACION, PUBLICO, ESTADO_DOCUMENTO);
	private ImplementacionDeRepositorio repositorio;

	@Before
	public void inicilizarEnCadaTest() {
		repositorio = new ImplementacionDeRepositorio();
	}

	@Test
	public void testAltaDocumento() {
		repositorio.altaDocumento(documento);
		assertSame(documento, repositorio.getDocumentos().get(0));
	}

	@Test
	public void modificarDocumento() {
		repositorio.getDocumentos().add(documento);
		Documento documento2 = new Documento(CODIGO, "documento2", FECHA_CREACION, FECHA_MODIFICACION,PUBLICO, ESTADO_DOCUMENTO);
		repositorio.modificarDocumento(documento2);
		assertEquals(documento, documento2);
	}

	@Test
	public void testEliminarDocumento() {
		repositorio.getDocumentos().add(documento);
		repositorio.eliminarDocumento(documento.getCodigo());
		assertTrue(repositorio.getDocumentos().isEmpty());
	}
}
