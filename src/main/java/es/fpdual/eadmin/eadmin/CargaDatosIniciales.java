package es.fpdual.eadmin.eadmin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.EstadoDocumento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;

@Component
public class CargaDatosIniciales implements ApplicationRunner {
	private final RepositorioDocumento repositorioDocumento;

	private static final Date FECHA = new Date();
	private List<Documento> documentos = new ArrayList<>();

	@Autowired
	public CargaDatosIniciales(RepositorioDocumento repositorioDocumento) {
		this.repositorioDocumento = repositorioDocumento;

	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// this.repositorioDocumento.escribeLista();
		//
		this.repositorioDocumento
				.altaDocumento(new Documento(1, "documento1", FECHA, FECHA, true, EstadoDocumento.ACTIVO));
		this.repositorioDocumento
				.altaDocumento(new Documento(2, "documento2", FECHA, FECHA, false, EstadoDocumento.APROBADO));
		this.repositorioDocumento
				.altaDocumento(new Documento(3, "documento3", FECHA, FECHA, true, EstadoDocumento.ELIMINADO));
		this.repositorioDocumento
				.altaDocumento(new Documento(4, "documento4", FECHA, FECHA, false, EstadoDocumento.ACTIVO));
		this.repositorioDocumento
				.altaDocumento(new Documento(5, "documento5", FECHA, FECHA, true, EstadoDocumento.ELIMINADO));

		//
		// this.repositorioDocumento.escribeLista();

		this.repositorioDocumento.modificarDocumento(new Documento(2, "documento7", new Date(23 / 6 / 2012),
				new Date(12 / 7 / 2010), true, EstadoDocumento.APROBADO));
		this.repositorioDocumento.modificarDocumento(new Documento(4, "documento9", new Date(13 / 1 / 2013),
				new Date(2 / 9 / 2015), true, EstadoDocumento.ELIMINADO));

		// this.repositorioDocumento.escribeLista();
		//
		this.repositorioDocumento.eliminarDocumento(1);
		this.repositorioDocumento.eliminarDocumento(3);
		this.repositorioDocumento.eliminarDocumento(5);
		//
		// this.repositorioDocumento.escribeLista();

		// this.repositorioExpediente.escribirListaEnFichero();
		//
		//
		// this.repositorioExpediente.almacenarExpediente(
		// new Expediente(1, "Expediente 1", FECHA, FECHA, true, FECHA,
		// EstadoExpediente.ARCHIVADO, documentos));
		// this.repositorioExpediente.almacenarExpediente(
		// new Expediente(2, "Expediente 2", FECHA, FECHA, false, FECHA,
		// EstadoExpediente.EN_TRAMITE, documentos));
		// this.repositorioExpediente.almacenarExpediente(
		// new Expediente(3, "Expediente 3", FECHA, FECHA, true, FECHA,
		// EstadoExpediente.INICIADO, documentos));
		// this.repositorioExpediente.almacenarExpediente(
		// new Expediente(4, "Expediente 4", FECHA, FECHA, false, FECHA,
		// EstadoExpediente.EN_TRAMITE, documentos));
		// this.repositorioExpediente.almacenarExpediente(
		// new Expediente(5, "Expediente 5", FECHA, FECHA, true, FECHA,
		// EstadoExpediente.EN_TRAMITE, documentos));
		//
		// this.repositorioExpediente.escribirListaEnFichero();
		//
		//
		// this.repositorioExpediente.modificarExpediente(
		// new Expediente(2, "Expediente 9", FECHA, FECHA, false, FECHA,
		// EstadoExpediente.INICIADO, documentos));
		// this.repositorioExpediente.modificarExpediente(
		// new Expediente(4, "Expediente 15", FECHA, FECHA, true, FECHA,
		// EstadoExpediente.EN_TRAMITE, documentos));
		//
		// this.repositorioExpediente.escribirListaEnFichero();
		//
		//
		// this.repositorioExpediente.eliminarExpediente(1);
		// this.repositorioExpediente.eliminarExpediente(2);
		// this.repositorioExpediente.eliminarExpediente(3);
		//
		// this.repositorioExpediente.escribirListaEnFichero();

	}

}
