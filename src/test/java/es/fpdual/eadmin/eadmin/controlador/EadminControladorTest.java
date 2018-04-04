package es.fpdual.eadmin.eadmin.controlador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;
import es.fpdual.eadmin.eadmin.servicio.ServicioDocumento;

public class EadminControladorTest {

	private EadminControlador controlador;
	private ServicioDocumento servicioDocumento = mock(ServicioDocumento.class);
	private final Documento DOCUMENTO = new Documento(1, "nombre", new Date(), new Date(), true,
			EstadoDocumento.ACTIVO);

	@Before
	public void antesDeIniciarElTest() {
		this.controlador = new EadminControlador(servicioDocumento);
	}

	@Test
	public void testControladorMostrarTodosLosDocumentos() {
		List<Documento> lista = new ArrayList<Documento>();

		when(servicioDocumento.obtenerTodosLosDocumentos()).thenReturn(lista);

		assertSame(controlador.getTodosDocumentos().getBody(), lista);

	}

	@Test
	public void testControladorMostrarDocumentoPorCodigo() {

		when(servicioDocumento.obtenerDocumentoPorCodigo(1)).thenReturn(DOCUMENTO);

		assertSame(controlador.getDocumentoPorCodigo(1).getBody(), DOCUMENTO);

	}

	@Test
	public void testControladorEliminarDocumento() {

		assertEquals(controlador.eliminarDocumento(1).getStatusCode(), HttpStatus.OK);
		verify(servicioDocumento).eliminarDocumento(1);
	}
}
