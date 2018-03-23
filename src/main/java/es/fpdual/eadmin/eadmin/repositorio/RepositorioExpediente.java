package es.fpdual.eadmin.eadmin.repositorio;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.Expediente;

public interface RepositorioExpediente {

	public abstract void almacenarExpediente(Expediente expediente);

	public abstract void modificarExpediente(Expediente expediente);
	
	public abstract void eliminarExpediente(Integer codigo);
	
	public abstract void asociarExpediente(Integer codigo, Documento documento);
	
	public abstract void desasociarExpediente(Integer codigo, Documento documento);
	
}