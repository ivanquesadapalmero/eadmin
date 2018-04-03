package es.fpdual.eadmin.eadmin.servicio.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.Expediente;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioExpediente;
import es.fpdual.eadmin.eadmin.servicio.ServicioExpediente;

public class ServicioExpedienteImplTest {
	private ServicioExpediente servicioExpediente;

	private final Expediente EXPEDIENTE = mock(Expediente.class);

	private final RepositorioExpediente repositorioExpediente = mock(RepositorioExpediente.class);

	@Before
	public void antesDeIniciarTest() {

		this.servicioExpediente = new ServicioExpedienteImpl(repositorioExpediente);
	}

	@Test
	public void deberiaAlmacenarUnDocumento() {

		when(DOCUMENTO.getCodigo()).thenReturn(1);
		when(DOCUMENTO.getFechaCreacion()).thenReturn(new Date(30 / 04 / 2008));
		when(DOCUMENTO.getNombre()).thenReturn("nombre");

		final Documento resultado = this.servicioDocumento.altaDocumento(DOCUMENTO);

		verify(this.repositorioDocumento).altaDocumento(any());
		assertEquals(resultado.getCodigo(), DOCUMENTO.getCodigo());
		assertNotEquals(resultado.getFechaCreacion(), DOCUMENTO.getFechaCreacion());
		assertEquals(resultado.getNombre(), DOCUMENTO.getNombre());
	}

	@Test
	public void deberiaModificarUnDocumento() {
		this.servicioDocumento.modificarDocumento(DOCUMENTO);

		verify(this.repositorioDocumento).modificarDocumento(DOCUMENTO);
	}

	@Test
	public void deberiaElimirarUnDocumento() {

		when(DOCUMENTO.getCodigo()).thenReturn(1);
		this.servicioDocumento.eliminarDocumento(DOCUMENTO.getCodigo());
		verify(this.repositorioDocumento).eliminarDocumento(DOCUMENTO.getCodigo());
	}
}
