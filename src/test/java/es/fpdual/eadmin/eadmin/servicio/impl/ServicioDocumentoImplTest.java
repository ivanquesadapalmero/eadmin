package es.fpdual.eadmin.eadmin.servicio.impl;

import org.junit.*;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;
import es.fpdual.eadmin.eadmin.servicio.ServicioDocumento;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.Date;

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
		when(DOCUMENTO.getFechaCreacion()).thenReturn(new Date(1/1/2000));
		when(DOCUMENTO.getNombre()).thenReturn("nombre");
		final Documento resultado = this.servicioDocumento.modificarDocumento(DOCUMENTO);
		verify(this.repositorioDocumento).modificarDocumento(any());
		assertEquals(Integer.valueOf(1), resultado.getCodigo());
		assertEquals("nombre", resultado.getNombre());
		assertNotEquals(resultado.getFechaCreacion(), DOCUMENTO.getFechaCreacion());
	}

	@Test
	public void deberiaElimirarUnDocumento() {
		
		this.servicioDocumento.eliminarDocumento(DOCUMENTO.getCodigo());
		verify(this.repositorioDocumento).eliminarDocumento(DOCUMENTO.getCodigo());
	}
}
