package es.fpdual.eadmin.eadmin.mapper;

import org.apache.ibatis.annotations.Param;

import es.fpdual.eadmin.eadmin.modelo.Documento;

public interface DocumentoMapper {

	int insertarDocumento(@Param("documento") Documento documento);

	int eliminarDocumento(@Param("documento") Documento documento);

	int modificarDocumento(@Param("documento") Documento documento);

	Documento seleccionarDocumento(@Param("codigo") int codigo);

}
