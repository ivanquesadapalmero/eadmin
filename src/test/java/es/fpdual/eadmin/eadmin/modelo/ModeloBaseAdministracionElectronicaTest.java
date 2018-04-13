package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import es.fpdual.eadmin.eadmin.util.AbstractoModeloBeanTest;

public class ModeloBaseAdministracionElectronicaTest
		extends AbstractoModeloBeanTest<ModeloBaseAdministracionElectronica> {

	private static final Integer CODIGO = 1;
	private static final String NOMBRE = "Prueba";
	private static final Date FECHA_CREACION = new Date();
	private static final Date FECHA_MODIFICACION = new Date();
	private static final Boolean PUBLICO = true;

	class ModeloBaseAdministracionElectronicaFake extends ModeloBaseAdministracionElectronica {

		public ModeloBaseAdministracionElectronicaFake(Integer codigo, String nombre, Date fechaCreacion,
				Date fechaModificacion, Boolean publico) {
			super(codigo, nombre, fechaCreacion, fechaModificacion, publico);
		}

	}

	@Override
	public void before() {
		this.entityA1 = new ModeloBaseAdministracionElectronica(CODIGO, NOMBRE, FECHA_CREACION, FECHA_MODIFICACION,
				PUBLICO);
		this.entityA2 = new ModeloBaseAdministracionElectronica(CODIGO, NOMBRE, FECHA_CREACION, FECHA_MODIFICACION,
				PUBLICO);
		this.entityB = new ModeloBaseAdministracionElectronica(CODIGO, NOMBRE, FECHA_CREACION, FECHA_MODIFICACION,
				false);

	}

	@Override
	public void deberiaInvocarLosMetodosGetModelo() {
		assertEquals(CODIGO, this.entityA1.getCodigo());
		assertEquals(NOMBRE, this.entityA1.getNombre());
		assertEquals(FECHA_CREACION, this.entityA1.getFechaCreacion());
		assertEquals(FECHA_MODIFICACION, this.entityA1.getFechaModificacion());
		assertEquals(PUBLICO, this.entityA1.getPublico());

	}

}
