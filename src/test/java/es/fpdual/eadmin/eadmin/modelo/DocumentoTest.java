package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class DocumentoTest {

	private static final Date FECHA_CREACION = new Date();
	private static final Date FECHA_MODIFICACION = new Date();
	private static final String NOMBRE_DOCUMENTO = "nombre";
	private static final boolean DOCUMENTO_PUBLICO = true;
	private static final Integer CODIGO_DOCUMENTO = 1;
	private Documento prueba;
	
	@Before
	public void inicializarCadaTest() {
		prueba = new Documento(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, FECHA_CREACION, FECHA_MODIFICACION,DOCUMENTO_PUBLICO, EstadoDocumento.ACTIVO);
	}
	
	@Test
	public void deberiaComprobarGetters() {
		assertEquals(CODIGO_DOCUMENTO, prueba.getCodigo());
		assertEquals(NOMBRE_DOCUMENTO, prueba.getNombre());
		assertEquals(FECHA_CREACION, prueba.getFechaCreacion());
		assertEquals(FECHA_MODIFICACION, prueba.getFechaModificacion());
		assertEquals(DOCUMENTO_PUBLICO, prueba.getPublico());
		assertEquals(EstadoDocumento.ACTIVO, prueba.getEstado());
	}
	
	@Test
	public void deberiaDevolverTrueSiTienenIgualCodigo() {
		final Documento prueba2 = new Documento(CODIGO_DOCUMENTO,null, null, null, null, null);
		
		Boolean resultado = prueba2.equals(prueba);
		assertTrue(resultado);
	}
	
	@Test
	public void deberiaDevolverFalseSiNoTienenIgualCodigo() {
		Documento prueba2 = new Documento(5, null, null, null, null, null);
		
		final Boolean resultado = prueba2.equals(prueba);
		assertFalse(resultado);
	}
	
	@Test
	public void deberiaDevolverFalseSiNoEsTipoDocumento() {
		
		Boolean resultado = prueba.equals(new String());
		
		assertFalse(resultado);
	}
	
	@Test
	public void deberiaDevolverHasCodeDelCodigo() {
		final int resultado = prueba.hashCode();
		
		assertEquals(CODIGO_DOCUMENTO.hashCode(), resultado);
	}
	
	@Test
	public void noDeberiaDevolverNuloToString() {
		assertNotNull(prueba.toString());
	}
}
