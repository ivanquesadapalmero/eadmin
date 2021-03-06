package es.fpdual.eadmin.eadmin.repositorio.impl;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.fpdual.eadmin.eadmin.mapper.DocumentoMapper;
import es.fpdual.eadmin.eadmin.modelo.Documento;
import es.fpdual.eadmin.eadmin.modelo.builder.DocumentoBuilder;
import es.fpdual.eadmin.eadmin.repositorio.RepositorioDocumento;

@Repository
public class ImplementacionDeRepositorio implements RepositorioDocumento {

	private DocumentoMapper mapper;

	private static Logger logger = LoggerFactory.getLogger(ImplementacionDeRepositorio.class);

	FileWriter file = null;
	PrintWriter pw = null;

	@Autowired
	public ImplementacionDeRepositorio(DocumentoMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public void altaDocumento(Documento documento) {
		logger.info("Entrando en método altaDocumento()");

		int maximo = mapper.maximoCodigo();

		Documento documento2 = new DocumentoBuilder().clonar(documento).conCodigo(maximo).construir();

		this.mapper.insertarDocumento(documento2);
		logger.info(documento.toString() + " creado correctamente");
	}

	@Override
	public void modificarDocumento(Documento documento) {
		logger.info("Entro en modificarDocumento()");

		int modificado = this.mapper.modificarDocumento(documento);

		if (modificado == 0) {
			throw new IllegalArgumentException("No se encuentra el documento");
		}

		logger.info("Salgo de modificarDocumento()");
	}

	@Override
	public void eliminarDocumento(Integer codigo) {

		logger.info("Entro en eliminarDocumento()");

		this.mapper.eliminarDocumento(codigo);

		logger.info("Salgo de eliminarDocumento()");
	}

	@Override
	public Documento obtenerDocumentoPorCodigo(Integer codigo) {
		logger.info("Entro en obtenerDocumentoPorCodigo()");

		return mapper.seleccionarDocumento(codigo);

	}

	@Override
	public List<Documento> obtenerTodosLosDocumentos() {
		// TODO Auto-generated method stub
		return this.mapper.obtenerTodosLosDocumentos();
	}

}

// @Override
// public List<Documento> obtenerTodosLosDocumentos() {
//
// logger.info("Entro en obtenerTodosLosDocumento()");
//
// for (Documento doc : documentos) {
// logger.info("************");
// logger.info("Documento: " + doc.getCodigo());
// logger.info("Nombre: " + doc.getNombre());
// logger.info("Fecha Creación: " + doc.getFechaCreacion());
// logger.info("Fecha Modificación: " + doc.getFechaModificacion());
// logger.info("Estado: " + doc.getEstado());
// logger.info("Publico: " + doc.getPublico());
// logger.info("************");
// }
// logger.info("Salgo de obtenerTodosLosDocumentos()");
// return getDocumentos();
// }

// @Override
// public void escribirListaEnFichero() {
// logger.info("Entro en ecribirListaEnFichero()");
// try {
// file = new FileWriter("ficheroLista.txt", true);
// pw = new PrintWriter(file);
//
// for (Documento doc : documentos) {
//
// pw.println("**********Documento " + doc.getCodigo() + "************");
// pw.println("Nombre: " + doc.getNombre());
// pw.println("Fecha Creación: " + doc.getFechaCreacion());
// pw.println("Fecha Modificación: " + doc.getFechaModificacion());
// pw.println("Estado: " + doc.getEstado());
// pw.println("Publico: " + doc.getPublico());
// pw.println("******************************************");
//
// }
// pw.close();
// } catch (IOException e) {
// e.printStackTrace();
// }
// logger.info("Salgo de ecribirListaEnFichero()");
//
// }
//

// private void altaTxt(Documento documento) {
// try {
// file = new FileWriter("Alta.txt", true);
// pw = new PrintWriter(file);
//
// pw.println("**********Documento " + documento.getCodigo() + "************");
// pw.println("Nombre: " + documento.getNombre());
// pw.println("Fecha Creación: " + documento.getFechaCreacion());
// pw.println("Fecha Modificación: " + documento.getFechaModificacion());
// pw.println("Estado: " + documento.getEstado());
// pw.println("Publico: " + documento.getPublico());
// pw.println("*********************************************");
// pw.close();
// } catch (IOException e) {
// e.printStackTrace();
// }
// }
//
// private void modificarTxt(Documento documento) {
// try {
// file = new FileWriter("Modificar.txt", true);
// pw = new PrintWriter(file);
//
// pw.println("**********Documento " + documento.getCodigo() + "************");
// pw.println("Nombre: " + documento.getNombre());
// pw.println("Fecha Creación: " + documento.getFechaCreacion());
// pw.println("Fecha Modificación: " + documento.getFechaModificacion());
// pw.println("Estado: " + documento.getEstado());
// pw.println("Publico: " + documento.getPublico());
// pw.println("*********************************************");
// pw.close();
// } catch (IOException e) {
// e.printStackTrace();
// }
// }
//
// private void eliminarTxt(Optional<Documento> documentoEncontrado) {
// try {
// file = new FileWriter("Eliminar.txt", true);
// pw = new PrintWriter(file);
//
// pw.println("**********Documento " + documentoEncontrado.get().getCodigo() +
// "************");
// pw.println("Nombre: " + documentoEncontrado.get().getNombre());
// pw.println("Fecha Creación: " +
// documentoEncontrado.get().getFechaCreacion());
// pw.println("Fecha Modificación: " +
// documentoEncontrado.get().getFechaModificacion());
// pw.println("Estado: " + documentoEncontrado.get().getEstado());
// pw.println("Publico: " + documentoEncontrado.get().getPublico());
// pw.println("*********************************************");
// pw.close();
// } catch (IOException e) {
// e.printStackTrace();
// }
// }

// public static void exportarExcel(String nombreHoja, Documento documento,
// String fileName) {
//
// logger.info("Entrado en método expotarExcel()");
//
// try {
//
// FileInputStream inputStream = new FileInputStream(new File(fileName));
//
// Workbook workbook = WorkbookFactory.create(inputStream);
//
// int numeroHoja;
//
// if (nombreHoja.equals("Documentos")) {
// numeroHoja = 0;
// }
//
// else if (nombreHoja.equals("Alta")) {
//
// numeroHoja = 1;
//
// } else if (nombreHoja.equals("Modificar")) {
//
// numeroHoja = 2;
//
// } else {
//
// numeroHoja = 3;
//
// }
//
// Sheet sheet = workbook.getSheetAt(numeroHoja);
//
// Object[] bookData = { documento.getCodigo(), documento.getNombre(),
// documento.getFechaCreacion().toString(),
//
// documento.getEstado().toString() };
//
// int rowCount = sheet.getLastRowNum();
//
// Row row = sheet.createRow(++rowCount);
//
// int columnCount = 0;
//
// Cell cell = row.createCell(columnCount);
//
// cell.setCellValue(rowCount);
//
// for (Object field : bookData) {
//
// cell = row.createCell(++columnCount);
//
// if (field instanceof String) {
//
// cell.setCellValue((String) field);
//
// } else if (field instanceof Integer) {
//
// cell.setCellValue((Integer) field);
//
// }
//
// }
//
// inputStream.close();
//
// FileOutputStream outputStream = new FileOutputStream(fileName);
//
// workbook.write(outputStream);
//
// workbook.close();
//
// outputStream.close();
//
// } catch (IOException | EncryptedDocumentException | InvalidFormatException
// ex) {
//
// ex.printStackTrace();
//
// }
//
// }
//
// public static ArrayList<String[]> importarExcel(String fileName, int
// numColums) {
//
// // ArrayList donde guardaremos todos los datos del excel
// ArrayList<String[]> data = new ArrayList<>();
//
// try {
// // Acceso al fichero xlsx
// FileInputStream file = new FileInputStream(new File(fileName));
//
// // Creamos la referencia al libro del directorio dado
// XSSFWorkbook workbook = new XSSFWorkbook(file);
//
// // Obtenemos la primera hoja
// XSSFSheet sheet = workbook.getSheetAt(0);
//
// // Iterador de filas
// Iterator<Row> rowIterator = sheet.iterator();
//
// while (rowIterator.hasNext()) {
// Row row = rowIterator.next();
// // Iterador de celdas
// Iterator<Cell> cellIterator = row.cellIterator();
// // contador para el array donde guardamos los datos de cada fila
// int contador = 0;
// // Array para guardar los datos de cada fila
// // y añadirlo al ArrayList
// String[] fila = new String[numColums];
// // iteramos las celdas de la fila
// while (cellIterator.hasNext()) {
// Cell cell = cellIterator.next();
//
// // Guardamos los datos de la celda segun su tipo
// switch (cell.getCellType()) {
// // si es numerico
// case Cell.CELL_TYPE_NUMERIC:
// fila[contador] = (int) cell.getNumericCellValue() + "";
// break;
// // si es cadena de texto
// case Cell.CELL_TYPE_STRING:
// fila[contador] = cell.getStringCellValue() + "";
// break;
// }
// // Si hemos terminado con la ultima celda de la fila
// if ((contador + 1) % numColums == 0) {
// // Añadimos la fila al ArrayList con todos los datos
// data.add(fila);
// }
// // Incrementamos el contador
// // con cada fila terminada al redeclarar arriba el contador,
// // no obtenemos excepciones de ArrayIndexOfBounds
// contador++;
// }
// }
// // Cerramos el fichero y workbook
// file.close();
// workbook.close();
// } catch (Exception e) {
// e.printStackTrace();
// }
//
// System.out.println("Excel importado correctamente\n");
//
// return data;
// }
//
// }
