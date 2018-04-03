package es.fpdual.eadmin.eadmin.servicio.impl;

import org.junit.*;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

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
		
		doReturn(documentoModificado).when(this.servicioDocumento).obtenerDocumentoConFechaUltimaActualizacion(DOCUMENTO);
		
		final Documento resultado = this.servicioDocumento.modificarDocumento(DOCUMENTO);

		verify(this.repositorioDocumento).modificarDocumento(documentoModificado);
		assertSame(resultado, documentoModificado);
	}

	@Test
	public void deberiaEliminarUnDocumento() {

		when(DOCUMENTO.getCodigo()).thenReturn(1);
		this.servicioDocumento.eliminarDocumento(DOCUMENTO.getCodigo());
		verify(this.repositorioDocumento).eliminarDocumento(1);
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
