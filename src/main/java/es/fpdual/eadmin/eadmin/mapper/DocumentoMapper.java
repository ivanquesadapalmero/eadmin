package es.fpdual.eadmin.eadmin.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import es.fpdual.eadmin.eadmin.modelo.Documento;

public interface DocumentoMapper {

	int insertarDocumento(@Param("documento") Documento documento);

	int eliminarDocumento(@Param("codigo") Integer codigo);

	int modificarDocumento(@Param("documento") Documento documento);

	Documento seleccionarDocumento(@Param("codigo") int codigo);

	List<Documento> obtenerTodosLosDocumentos();

	int maximoCodigo();
}
