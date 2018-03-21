package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class DocumentoRegistroTest {

	private static final Date FECHA_CREACION = new Date();
	private static final String NOMBRE_DOCUMENTO = "nombre";
	private static final boolean DOCUMENTO_PUBLICO = true;
	private static final Integer CODIGO_DOCUMENTO = 1;
	private static final String DNI_INTERESADO = "00000000A";
	private static final String CODIGO_REGISTRO = "000";
	private DocumentoRegistro docRegistro;

	@Before
	public void inicializarCadaTest() {
		docRegistro = new DocumentoRegistro(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, FECHA_CREACION, DOCUMENTO_PUBLICO,
				EstadoDocumento.ACTIVO, DNI_INTERESADO, CODIGO_REGISTRO);
	}

	@Test
	public void deberiaComprobarGetters() {
		assertEquals(CODIGO_REGISTRO, docRegistro.getCodigoRegistro());
		assertEquals(DNI_INTERESADO, docRegistro.getDniInteresado());
	}

}
