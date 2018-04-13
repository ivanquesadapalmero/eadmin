package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import es.fpdual.eadmin.eadmin.util.AbstractoModeloBeanTest;

public class DocumentoTest extends AbstractoModeloBeanTest<Documento> {

	private static final Date FECHA_CREACION = new Date();
	private static final Date FECHA_MODIFICACION = new Date();
	private static final String NOMBRE_DOCUMENTO = "nombre";
	private static final boolean DOCUMENTO_PUBLICO = true;
	private static final Integer CODIGO_DOCUMENTO = 1;
	private Documento prueba;

	@Override
	public void before() {
		this.entityA1 = new Documento(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, FECHA_CREACION, FECHA_MODIFICACION,
				EstadoDocumento.ACTIVO, DOCUMENTO_PUBLICO);
		this.entityA2 = new Documento(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, FECHA_CREACION, FECHA_MODIFICACION,
				EstadoDocumento.ACTIVO, DOCUMENTO_PUBLICO);
		this.entityB = new Documento(CODIGO_DOCUMENTO, NOMBRE_DOCUMENTO, FECHA_CREACION, FECHA_MODIFICACION,
				EstadoDocumento.ELIMINADO, DOCUMENTO_PUBLICO);
	}

	@Override
	public void deberiaInvocarLosMetodosGetModelo() {
		assertEquals(EstadoDocumento.ACTIVO, entityA1.getEstado());

	}
}
