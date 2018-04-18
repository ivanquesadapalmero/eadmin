package es.fpdual.eadmin.eadmin.repositorio.impl;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.fpdual.eadmin.eadmin.mapper.DocumentoMapper;
import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;

public class ImplementacionDeRepositorioTest {

	private static final Integer CODIGO = 1;
	private static final String NOMBRE = "prueba";
	private static final Date FECHA_CREACION = new Date();
	private static final Date FECHA_MODIFICACION = new Date();
	private static final boolean PUBLICO = true;
	private static final EstadoDocumento ESTADO_DOCUMENTO = EstadoDocumento.ACTIVO;
	private Documento documento = new Documento(CODIGO, NOMBRE, FECHA_CREACION, FECHA_MODIFICACION, ESTADO_DOCUMENTO,
			PUBLICO);
	private ImplementacionDeRepositorio repositorio;

	private DocumentoMapper mapper;

	@Before
	public void inicilizarEnCadaTest() {

		this.mapper = mock(DocumentoMapper.class);

		repositorio = new ImplementacionDeRepositorio(this.mapper);
	}

	@Test
	public void testAltaDocumento() {
		this.repositorio.altaDocumento(this.documento);

		verify(this.mapper).insertarDocumento(this.documento);
	}

	@Test
	public void deberiaModificarDocumento() {

		when(mapper.modificarDocumento(this.documento)).thenReturn(1);

		this.repositorio.modificarDocumento(this.documento);

		verify(this.mapper).modificarDocumento(this.documento);
	}

	@Test(expected = IllegalArgumentException.class)
	public void deberiaLanzarExcepcionSiIntentamosModificarUnDocumentoQueNoExiste() {

		when(mapper.modificarDocumento(this.documento)).thenReturn(0);

		this.repositorio.modificarDocumento(this.documento);
	}

	@Test
	public void testEliminarDocumento() {
		this.repositorio.eliminarDocumento(this.documento.getCodigo());

		verify(this.mapper).eliminarDocumento(this.documento.getCodigo());
	}

	@Test
	public void testObtenerDocumentoPorCodigo() {

		when(mapper.seleccionarDocumento(this.documento.getCodigo())).thenReturn(this.documento);

		final Documento resultado = this.repositorio.obtenerDocumentoPorCodigo(CODIGO);

		assertThat(resultado, is(this.documento));
	}

	@Test
	public void deberiaObtenerTodosLosDocumentos() {
		final List<Documento> todosLosDocumentos = Arrays.asList(documento);

		when(mapper.obtenerTodosLosDocumentos()).thenReturn(todosLosDocumentos);

		final List<Documento> resultado = this.repositorio.obtenerTodosLosDocumentos();

		assertThat(resultado, hasSize(1));
		assertThat(resultado, hasItem(this.documento));

	}
}
