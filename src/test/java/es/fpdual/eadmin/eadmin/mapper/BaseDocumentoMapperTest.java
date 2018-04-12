package es.fpdual.eadmin.eadmin.mapper;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;

public abstract class BaseDocumentoMapperTest {

	Documento documento;

	@Autowired
	private DocumentoMapper mapper;

	@Before
	public void inicializarEnCadaTest() {
		documento = new Documento(1, "documento 1", new Date(), new Date(), true, EstadoDocumento.ACTIVO);
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

}
