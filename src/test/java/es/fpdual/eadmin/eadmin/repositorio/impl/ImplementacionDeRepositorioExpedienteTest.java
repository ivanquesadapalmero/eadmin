package es.fpdual.eadmin.eadmin.repositorio.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;
import es.fpdual.eadmin.eadmin.modelo.EstadoExpediente;
import es.fpdual.eadmin.eadmin.modelo.Expediente;

public class ImplementacionDeRepositorioExpedienteTest {
	private static final Integer CODIGO = 1;
	private static final String NOMBRE = "prueba";
	private static final Date FECHA_CREACION = new Date();
	private static final Date FECHA_MODIFICACION = new Date();
	private static final boolean PUBLICO = true;
	private static final EstadoExpediente ESTADO_EXPEDIENTE = EstadoExpediente.INICIADO;
	private static final Date FECHA_ARCHIVADO = new Date();
	private static final List<Documento> LISTA = new ArrayList<Documento>();

	private Expediente expediente = new Expediente(CODIGO, NOMBRE, FECHA_CREACION, FECHA_MODIFICACION, PUBLICO,
			FECHA_ARCHIVADO, ESTADO_EXPEDIENTE, LISTA);
	private ImplementacionDeRepositorioExpediente repositorio;

	@Before
	public void inicilizarEnCadaTest() {
		repositorio = new ImplementacionDeRepositorioExpediente();
	}

	@Test
	public void testAlmacenarExpediente() {
		repositorio.almacenarExpediente(expediente);
		assertSame(expediente, repositorio.getExpedientes().get(0));
	}

	@Test
	public void modificarExpediente() {
		repositorio.getExpedientes().add(expediente);
		Expediente expediente2 = new Expediente(CODIGO, NOMBRE, FECHA_CREACION, FECHA_MODIFICACION, PUBLICO,
				FECHA_ARCHIVADO, ESTADO_EXPEDIENTE, LISTA);
		repositorio.modificarExpediente(expediente2);
		assertEquals(expediente, expediente2);
	}

	@Test
	public void testEliminarExpediente() {
		repositorio.getExpedientes().remove(expediente);
		repositorio.eliminarExpediente(expediente.getCodigo());
		assertTrue(repositorio.getExpedientes().isEmpty());
	}
	
	@Test
	public void testAsociarDocumentoAExpediente() {
		Documento documento = new Documento(1, "NombreDoc", new Date(), new Date(), true, EstadoDocumento.ACTIVO );
		repositorio.asociarExpediente(expediente.getCodigo(), documento);
		assertFalse(expediente.getDocumentos().isEmpty());
	}
	
	@Test
	public void testDesasociarDocumentoAExpediente() {
		Documento documento = new Documento(1, "NombreDoc", new Date(), new Date(), true, EstadoDocumento.ACTIVO );
		repositorio.desasociarExpediente(expediente.getCodigo(), documento);
		assertTrue(expediente.getDocumentos().isEmpty());
	}
	
	
}
