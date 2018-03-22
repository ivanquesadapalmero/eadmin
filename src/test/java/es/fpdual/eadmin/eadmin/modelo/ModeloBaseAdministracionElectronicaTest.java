package es.fpdual.eadmin.eadmin.modelo;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class ModeloBaseAdministracionElectronicaTest {

	private static final Integer CODIGO = 1;
	private static final String NOMBRE = "Prueba";
	private static final Date FECHA_CREACION = new Date();
	private static final Date FECHA_MODIFICACION = new Date();
	private ModeloBaseAdministracionElectronicaFake documento;

	@BeforeClass
	public void crearObjeto() {
		documento = new ModeloBaseAdministracionElectronicaFake(CODIGO, NOMBRE, FECHA_CREACION, FECHA_MODIFICACION);
	}

	@Test
	public void comprobarGetters() {
		assertEquals(CODIGO, documento.getCodigo());
		assertEquals(NOMBRE, documento.getNombre());
	}

	class ModeloBaseAdministracionElectronicaFake extends ModeloBaseAdministracionElectronica {

		public ModeloBaseAdministracionElectronicaFake(Integer codigo, String nombre, Date fechaCreacion, Date fechaModificacion) {
			super(codigo, nombre, fechaCreacion, fechaModificacion);
		}

	}

}
