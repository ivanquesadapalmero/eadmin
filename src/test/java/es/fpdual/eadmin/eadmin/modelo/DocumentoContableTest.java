package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class DocumentoContableTest {

	private static final Date FECHA_CREACION = new Date();
	private static final Date FECHA_MODIFICACION = new Date();
	private static final String NOMBRE_DOCUMENTO = "nombre";
	private static final boolean DOCUMENTO_PUBLICO = true;
	private static final Integer CODIGO_DOCUMENTO = 1;
	private static final BigDecimal IMPORTE = new BigDecimal(0);
	private static final String DNI_INTERESADO = "00000000A";
	private DocumentoContable docContable;

	@Before
	public void inicializarCadaTest() {
		docContable = new DocumentoContable(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, FECHA_CREACION, FECHA_MODIFICACION, EstadoDocumento.ACTIVO,
				DOCUMENTO_PUBLICO, IMPORTE, DNI_INTERESADO);
	}

	@Test
	public void deberiaComprobarGetters() {
		assertEquals(IMPORTE, docContable.getImporte());
		assertEquals(DNI_INTERESADO, docContable.getDniInteresado());
	}

}
