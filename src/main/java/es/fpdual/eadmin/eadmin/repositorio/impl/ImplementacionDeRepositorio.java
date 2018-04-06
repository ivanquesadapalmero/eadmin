package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;

@Repository
public class ImplementacionDeRepositorio implements RepositorioDocumento {

	private List<Documento> documentos = new ArrayList<>();
	private static Logger logger = LoggerFactory.getLogger(ImplementacionDeRepositorio.class);

	FileWriter file = null;
	PrintWriter pw = null;

	@Override
	public void altaDocumento(Documento documento) {
		logger.info("Entrando en método altaDocumento()");
		if (documentos.contains(documento)) {
			throw new IllegalArgumentException("El documento ya existe");
		}

		altaTxt(documento);
		exportarExcel("Alta", documento, "Documentos.xls");
		documentos.add(documento);
		logger.info(documento.toString() + " creado correctamente");
	}

	@Override
	public void modificarDocumento(Documento documento) {
		logger.info("Entro en modificarDocumento()");
		if (!documentos.contains(documento)) {
			throw new IllegalArgumentException("El documento no existe");
		}
		exportarExcel("Modificar", documento, "Documentos.xls");
		modificarTxt(documento);

		documentos.set(documentos.indexOf(documento), documento);
		logger.info("Salgo de modificarDocumento()");
	}

	@Override
	public void eliminarDocumento(Integer codigo) {

		logger.info("Entro en eliminarDocumento()");

		Optional<Documento> documentoEncontrado = documentos.stream().filter(d -> tieneIgualCodigo(d, codigo))
				.findFirst();

		if (documentoEncontrado.isPresent()) {
			documentos.remove(documentoEncontrado.get());
			exportarExcel("Eliminar", documentoEncontrado.get(), "Documentos.xls");
			eliminarTxt(documentoEncontrado);
		}

		logger.info("Salgo de eliminarDocumento()");
	}

	@Override
	public List<Documento> obtenerTodosLosDocumentos() {

		logger.info("Entro en obtenerTodosLosDocumento()");

		for (Documento doc : documentos) {
			logger.info("************");
			logger.info("Documento: " + doc.getCodigo());
			logger.info("Nombre: " + doc.getNombre());
			logger.info("Fecha Creación: " + doc.getFechaCreacion());
			logger.info("Fecha Modificación: " + doc.getFechaModificacion());
			logger.info("Estado: " + doc.getEstado());
			logger.info("Publico: " + doc.getPublico());
			logger.info("************");
		}
		logger.info("Salgo de obtenerTodosLosDocumentos()");
		return getDocumentos();
	}

	@Override
	public Documento obtenerDocumentoPorCodigo(Integer codigo) {
		logger.info("Entro en obtenerDocumentoPorCodigo()");
		Optional<Documento> documentoEncontrado = documentos.stream().filter(d -> tieneIgualCodigo(d, codigo))
				.findFirst();

		if (documentoEncontrado.isPresent()) {
			logger.info("salgo en obtenerDocumentoPorCodigo()");
			return documentoEncontrado.get();
		}
		logger.info("Salgo en obtenerDocumentoPorCodigo()");
		return null;
	}

	@Override
	public void escribirListaEnFichero() {
		logger.info("Entro en ecribirListaEnFichero()");
		try {
			file = new FileWriter("ficheroLista.txt", true);
			pw = new PrintWriter(file);

			for (Documento doc : documentos) {

				pw.println("**********Documento " + doc.getCodigo() + "************");
				pw.println("Nombre: " + doc.getNombre());
				pw.println("Fecha Creación: " + doc.getFechaCreacion());
				pw.println("Fecha Modificación: " + doc.getFechaModificacion());
				pw.println("Estado: " + doc.getEstado());
				pw.println("Publico: " + doc.getPublico());
				pw.println("******************************************");

			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("Salgo de ecribirListaEnFichero()");

	}

	protected boolean tieneIgualCodigo(Documento documento, Integer codigo) {
		return documento.getCodigo().equals(codigo);
	}

	public List<Documento> getDocumentos() {
		return documentos;
	}

	private void altaTxt(Documento documento) {
		try {
			file = new FileWriter("Alta.txt", true);
			pw = new PrintWriter(file);

			pw.println("**********Documento " + documento.getCodigo() + "************");
			pw.println("Nombre: " + documento.getNombre());
			pw.println("Fecha Creación: " + documento.getFechaCreacion());
			pw.println("Fecha Modificación: " + documento.getFechaModificacion());
			pw.println("Estado: " + documento.getEstado());
			pw.println("Publico: " + documento.getPublico());
			pw.println("*********************************************");
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void modificarTxt(Documento documento) {
		try {
			file = new FileWriter("Modificar.txt", true);
			pw = new PrintWriter(file);

			pw.println("**********Documento " + documento.getCodigo() + "************");
			pw.println("Nombre: " + documento.getNombre());
			pw.println("Fecha Creación: " + documento.getFechaCreacion());
			pw.println("Fecha Modificación: " + documento.getFechaModificacion());
			pw.println("Estado: " + documento.getEstado());
			pw.println("Publico: " + documento.getPublico());
			pw.println("*********************************************");
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void eliminarTxt(Optional<Documento> documentoEncontrado) {
		try {
			file = new FileWriter("Eliminar.txt", true);
			pw = new PrintWriter(file);

			pw.println("**********Documento " + documentoEncontrado.get().getCodigo() + "************");
			pw.println("Nombre: " + documentoEncontrado.get().getNombre());
			pw.println("Fecha Creación: " + documentoEncontrado.get().getFechaCreacion());
			pw.println("Fecha Modificación: " + documentoEncontrado.get().getFechaModificacion());
			pw.println("Estado: " + documentoEncontrado.get().getEstado());
			pw.println("Publico: " + documentoEncontrado.get().getPublico());
			pw.println("*********************************************");
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean exportarExcel(String nombreHoja, Documento documento, String fileName) {
		Integer numeroLineas = 0;
		Map<String, Object[]> documentos = new TreeMap<String, Object[]>();

		File archivoExcel = new File(fileName);
		if (!archivoExcel.exists()) {
			documentos.put("0",
					new Object[] { "Codigo", "Nombre", "Fecha Creacion", "Fecha Modificación", "Estado", "Publico" });
			numeroLineas++;
		} else {
			ArrayList<String[]> datosExcel = importarExcel(fileName, 6);
			ListIterator<String[]> it = datosExcel.listIterator();

			while (it.hasNext()) {
				numeroLineas++;
				String[] datos = it.next();
				documentos.put(numeroLineas.toString(), datos);
			}
		}
		numeroLineas++;
		documentos.put(numeroLineas.toString(),
				new Object[] { documento.getCodigo().toString(), documento.getNombre().toString(),
						documento.getFechaCreacion().toString(), documento.getFechaModificacion().toString(),
						documento.getEstado().toString(), documento.getPublico().toString() });

		// Creamos el libro de trabajo
		XSSFWorkbook libro = new XSSFWorkbook();

		// Creacion de Hoja
		XSSFSheet hoja = libro.createSheet(nombreHoja);

		// Iteramos el map e insertamos los datos
		Set<String> keyset = documentos.keySet();
		int rownum = 0;
		for (String key : keyset) {
			// cramos la fila
			Row row = hoja.createRow(rownum++);
			// obtenemos los datos de la fila
			Object[] objArr = documentos.get(key);
			int cellnum = 0;
			// iteramos cada dato de la fila
			for (Object obj : objArr) {
				// Creamos la celda
				Cell cell = row.createCell(cellnum++);
				// Setteamos el valor con el tipo de dato correspondiente
				if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Integer)
					cell.setCellValue((Integer) obj);
			}
		}
		try {
			// Escribimos en fichero
			FileOutputStream out = new FileOutputStream(new File(fileName));
			libro.write(out);
			// cerramos el fichero y el libro
			out.close();
			libro.close();
			System.out.println("Excel exportado correctamente\n");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static ArrayList<String[]> importarExcel(String fileName, int numColums) {

		// ArrayList donde guardaremos todos los datos del excel
		ArrayList<String[]> data = new ArrayList<>();

		try {
			// Acceso al fichero xlsx
			FileInputStream file = new FileInputStream(new File(fileName));

			// Creamos la referencia al libro del directorio dado
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Obtenemos la primera hoja
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Iterador de filas
			Iterator<Row> rowIterator = sheet.iterator();

			while (rowIterator.hasNext()) {
				Row row = rowIterator.next();
				// Iterador de celdas
				Iterator<Cell> cellIterator = row.cellIterator();
				// contador para el array donde guardamos los datos de cada fila
				int contador = 0;
				// Array para guardar los datos de cada fila
				// y añadirlo al ArrayList
				String[] fila = new String[numColums];
				// iteramos las celdas de la fila
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					// Guardamos los datos de la celda segun su tipo
					switch (cell.getCellType()) {
					// si es numerico
					case Cell.CELL_TYPE_NUMERIC:
						fila[contador] = (int) cell.getNumericCellValue() + "";
						break;
					// si es cadena de texto
					case Cell.CELL_TYPE_STRING:
						fila[contador] = cell.getStringCellValue() + "";
						break;
					}
					// Si hemos terminado con la ultima celda de la fila
					if ((contador + 1) % numColums == 0) {
						// Añadimos la fila al ArrayList con todos los datos
						data.add(fila);
					}
					// Incrementamos el contador
					// con cada fila terminada al redeclarar arriba el contador,
					// no obtenemos excepciones de ArrayIndexOfBounds
					contador++;
				}
			}
			// Cerramos el fichero y workbook
			file.close();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Excel importado correctamente\n");

		return data;
	}

}
