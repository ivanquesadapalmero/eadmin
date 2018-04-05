package es.fpdual.eadmin.eadmin;

import java.util.Date;

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

	@Autowired
	public CargaDatosIniciales(RepositorioDocumento repositorioDocumento) {
		this.repositorioDocumento = repositorioDocumento;
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		this.repositorioDocumento
				.altaDocumento(new Documento(1, "documento1", FECHA, FECHA, true, EstadoDocumento.ACTIVO));
		this.repositorioDocumento
				.altaDocumento(new Documento(2, "documento2", FECHA, FECHA, false, EstadoDocumento.APROBADO));
		this.repositorioDocumento
				.altaDocumento(new Documento(3, "documento3", FECHA, FECHA, true, EstadoDocumento.ELIMINADO));
		this.repositorioDocumento
				.altaDocumento(new Documento(4, "documento4", FECHA, FECHA, true, EstadoDocumento.ACTIVO));
		this.repositorioDocumento
				.altaDocumento(new Documento(5, "documento5", FECHA, FECHA, false, EstadoDocumento.ELIMINADO));

		this.repositorioDocumento.escribirListaEnFichero();
		
		this.repositorioDocumento.modificarDocumento(new Documento(2, "nombre2", FECHA, FECHA, true, EstadoDocumento.ACTIVO));
		this.repositorioDocumento.modificarDocumento(new Documento(4, "nombre4", FECHA, FECHA, true, EstadoDocumento.ELIMINADO));
		
		this.repositorioDocumento.escribirListaEnFichero();
		
		this.repositorioDocumento.eliminarDocumento(1);
		this.repositorioDocumento.eliminarDocumento(3);
		this.repositorioDocumento.eliminarDocumento(5);
		
		this.repositorioDocumento.escribirListaEnFichero();
	}

}
