package es.fpdual.eadmin.eadmin.servicio.impl;

import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;

public class ServicioDocumentoImplTest {

	private ServicioDocumentoImpl servicioDocumento;
	private final Documento DOCUMENTO = mock(Documento.class);
	private final RepositorioDocumento repositorioDocumento = mock(RepositorioDocumento.class);

	@Before
	public void antesDeIniciarTest() {

		this.servicioDocumento = spy(new ServicioDocumentoImpl(repositorioDocumento));
	}

	@Test
	public void deberiaDarDeAltaUnDocumento() {

		final Documento documentoModificado = mock(Documento.class);
		doReturn(documentoModificado).when(this.servicioDocumento).obtenerDocumentoConFechaCreacion(DOCUMENTO);
		final Documento resultado = this.servicioDocumento.altaDocumento(DOCUMENTO);

		verify(this.repositorioDocumento).altaDocumento(documentoModificado);
		assertSame(resultado, documentoModificado);
	}

	@Test
	public void deberiaModificarUnDocumento() {
		final Documento documentoModificado = mock(Documento.class);

		doReturn(documentoModificado).when(this.servicioDocumento)
				.obtenerDocumentoConFechaUltimaActualizacion(DOCUMENTO);

		final Documento resultado = this.servicioDocumento.modificarDocumento(DOCUMENTO);

		verify(this.repositorioDocumento).modificarDocumento(documentoModificado);
		assertSame(resultado, documentoModificado);
	}

	@Test
	public void deberiaEliminarUnDocumento() {

		when(DOCUMENTO.getCodigo()).thenReturn(1);
		this.servicioDocumento.eliminarDocumento(DOCUMENTO.getCodigo());
		verify(this.repositorioDocumento).eliminarDocumento(DOCUMENTO.getCodigo());
	}

	@Test
	public void testObtenerDocumentoPorCodigo() {
		when(DOCUMENTO.getCodigo()).thenReturn(1);
		when(repositorioDocumento.obtenerDocumentoPorCodigo(1)).thenReturn(DOCUMENTO);
		final Documento resultado = servicioDocumento.obtenerDocumentoPorCodigo(1);
		assertSame(resultado, DOCUMENTO);
	}

	@Test
	public void testObtenerTodosLosDocumentos() {
		List<Documento> lista = new ArrayList<>();
		when(repositorioDocumento.obtenerTodosLosDocumentos()).thenReturn(lista);
		final List<Documento> resultado = servicioDocumento.obtenerTodosLosDocumentos();

		assertSame(repositorioDocumento.obtenerTodosLosDocumentos(), resultado);
	}
}
