package es.fpdual.eadmin.eadmin.servicio.impl;

import org.junit.*;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.eadmin.eadmin.servicio.ServicioDocumento;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ServicioDocumentoImplTest {

	private ServicioDocumento servicioDocumento;

	private final Documento DOCUMENTO = mock(Documento.class);
	private final Documento	DOCUMENTO2 = mock(Documento.class);

	private final RepositorioDocumento repositorioDocumento = mock(RepositorioDocumento.class);
	

	@Before
	public void antesDeIniciarTest() {

		this.servicioDocumento = new ServicioDocumentoImpl(repositorioDocumento);
	}

	@Test
	public void deberiaAlmacenarUnDocumento() {

		this.servicioDocumento.altaDocumento(DOCUMENTO);

		verify(this.repositorioDocumento).altaDocumento(DOCUMENTO);
	}

	@Test
	public void deberiaModificarUnDocumento() {
		when(DOCUMENTO.getCodigo()).thenReturn(1);
		final Documento resultado = this.servicioDocumento.modificarDocumento(DOCUMENTO);
		verify(this.repositorioDocumento).modificarDocumento(DOCUMENTO);
		assertEquals(resultado, DOCUMENTO);
	}

	@Test
	public void deberiaElimirarUnDocumento() {
		when(DOCUMENTO.getCodigo()).thenReturn(1);
		this.servicioDocumento.eliminarDocumento(DOCUMENTO.getCodigo());
		verify(this.repositorioDocumento).eliminarDocumento(DOCUMENTO.getCodigo());
	}
}
