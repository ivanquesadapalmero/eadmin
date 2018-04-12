package es.fpdual.eadmin.eadmin.mapper;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;
import es.fpdual.eadmin.eadmin.util.Utilidades;

@Transactional("eadminTransactionManager")
public abstract class BaseDocumentoMapperTest {

	Documento documento;

	@Autowired
	private DocumentoMapper mapper;

	@Before
	public void inicializarEnCadaTest() {
		documento = new Documento(1, "documento 1", Utilidades.asDate(LocalDate.of(2015, 1, 1)),
				Utilidades.asDate(LocalDate.of(2015, 1, 2)), true, EstadoDocumento.ACTIVO);
	}

	@Test
	public void deberiaInsertarUnDocumento() throws Exception {
		// DECLARACION

		// ENTRENAMIENTO

		// EJECUCION
		int resultado = mapper.insertarDocumeto(documento);
		// VERIFICACION
		assertThat(resultado, is(1));
	}

	@Test
	public void deberiaEliminarUnDocumento() {
		this.mapper.insertarDocumeto(this.documento);

		int resultado = this.mapper.eliminarDocumento(this.documento);

		assertThat(resultado, is(1));
	}

	@Test
	public void deberiaModificarUnDocumento() {

		Documento documentoActualizado = new Documento(1, "nombre", Utilidades.asDate(LocalDate.of(2016, 1, 1)),
				Utilidades.asDate(LocalDate.of(2016, 7, 2)), true, EstadoDocumento.ACTIVO);

		mapper.insertarDocumeto(documento);

		int resultado = mapper.modificarDocumento(documentoActualizado);

		assertThat(resultado, is(1));
		final Documento documentoModificado = this.mapper.seleccionarDocumento(1);
		assertThat(documentoModificado, is(documentoActualizado));

	}

	@Test
	public void deberiaObtenerDocumentoPorCodigo() {
		mapper.insertarDocumeto(documento);
		Documento resultado = mapper.seleccionarDocumento(1);
		assertSame(resultado, documento);
	}
}
