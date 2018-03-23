package es.fpdual.eadmin.eadmin.servicio.impl;

import java.util.Date;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.Expediente;
import es.fpdual.eadmin.eadmin.modelo.builder.ExpedienteBuilder;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioExpediente;
import es.fpdual.eadmin.eadmin.servicio.ServicioExpediente;

public class ServicioExpedienteImpl implements ServicioExpediente{

	RepositorioExpediente repositorioExpediente;
	
	@Override
	public Expediente almacenarExpediente(Expediente expediente) {
		repositorioExpediente.almacenarExpediente(expediente);
		return expediente;
	}

	@Override
	public Expediente modificarExpediente(Expediente expediente) {
		final Expediente expedienteModificado = obtenerExpedienteConFechaCorrecta(expediente);

		repositorioExpediente.modificarExpediente(expedienteModificado);
		return expedienteModificado;
	}

	@Override
	public void eliminarExpediente(Integer codigo) {
		repositorioExpediente.eliminarExpediente(codigo);
	}

	@Override
	public Expediente asociarExpediente(Integer codigo, Documento documento) {
		return repositorioExpediente.asociarExpediente(codigo, documento);
	}

	@Override
	public Expediente desasociarExpediente(Integer codigo, Documento documento) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Date dameFechaActual() {
		return new Date();
	}
	
	private Expediente obtenerExpedienteConFechaCorrecta(Expediente expediente) {

		return new ExpedienteBuilder().clonar(expediente).conFechaCreacion(dameFechaActual()).construir();

	}
	

}
