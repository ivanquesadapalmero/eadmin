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
	private static List<Documento> lista;

	private Expediente expediente = new Expediente(CODIGO, NOMBRE, FECHA_CREACION, FECHA_MODIFICACION, PUBLICO,
			FECHA_ARCHIVADO, ESTADO_EXPEDIENTE, lista);
	private ImplementacionDeRepositorioExpediente repositorio;

	@Before
	public void inicilizarEnCadaTest() {
		lista = new ArrayList<Documento>();
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
				FECHA_ARCHIVADO, ESTADO_EXPEDIENTE, lista);
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
		Documento documento = new Documento(1, "NombreDoc", new Date(), new Date(), true, EstadoDocumento.ACTIVO);
		repositorio.getExpedientes().add(expediente);
		repositorio.asociarExpediente(expediente.getCodigo(), documento);
		assertFalse(expediente.getDocumentos().isEmpty());
		assertEquals(1, expediente.getDocumentos().size());
	}

	@Test
	public void testDesasociarDocumentoAExpediente() {
		Documento documento = new Documento(1, "NombreDoc", new Date(), new Date(), true, EstadoDocumento.ACTIVO);
		expediente.getDocumentos().add(documento);
		repositorio.getExpedientes().add(expediente);
		repositorio.desasociarExpediente(expediente.getCodigo(), documento);
		assertTrue(expediente.getDocumentos().isEmpty());
		assertEquals(0, expediente.getDocumentos().size());

	}

	@Test
	public void testObtenerExpedientePorCodigo() {
		this.repositorio.getExpedientes().add(expediente);
		final Expediente expedienteResultado = repositorio.obtenerExpedientePorCodigo(CODIGO);
		final Expediente expedienteResultado2 = repositorio.obtenerExpedientePorCodigo(2);

		assertEquals(expedienteResultado, expediente);
		assertEquals(expedienteResultado2, null);
	}

	@Test
	public void testObtenerTodosLosExpedientes() {

		assertEquals(this.repositorio.obtenerTodosLosExpedientes(), this.repositorio.getExpedientes());

	}

}
