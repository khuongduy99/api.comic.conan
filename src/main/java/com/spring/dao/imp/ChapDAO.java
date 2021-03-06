package com.spring.dao.imp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import com.spring.dao.IChapDAO;
import com.spring.model.Chap;

import util.SystemContain;

@Repository
public class ChapDAO implements IChapDAO {
	public List<Chap> getAll() {
		List<Chap> list = new ArrayList<Chap>();
		// Get file
		InputStream inputStream;
		try {
			Resource resource = new ClassPathResource(SystemContain.URL_FILE_CHAP);

			inputStream = resource.getInputStream();
			Workbook workbook = new HSSFWorkbook(inputStream);
			// Get workbook

			// Get sheet
			Sheet sheet = workbook.getSheetAt(0);

			// Get all rows
			Iterator<Row> iterator = sheet.iterator();
			while (iterator.hasNext()) {
				Row nextRow = iterator.next();
				if (nextRow.getRowNum() == 0) {
					// Ignore header
					continue;
				}

				// Get all cells
				Iterator<Cell> cellIterator = nextRow.cellIterator();

				// Read cells and set value for book object
				Chap chap = new Chap();
				while (cellIterator.hasNext()) {
					// Read cell
					Cell cell = cellIterator.next();
					Object cellValue = getCellValue(cell);
					if (cellValue == null || cellValue.toString().isEmpty()) {
						continue;
					}
					// Set value for book object
					int columnIndex = cell.getColumnIndex();
					switch (columnIndex) {
					case 0:
						double res = (Double) getCellValue(cell);
						chap.setIdBook((int) res);
						break;
					case 1:
						chap.setTitle((String) getCellValue(cell));
						break;
					case 2:
						chap.setAlias((String) getCellValue(cell));
						break;
					case 3:
						chap.setUrlChap((String) getCellValue(cell));
						break;
					case 4:
						 res = (Double) getCellValue(cell);
						chap.setId((int) res);
						break;
					default:
						break;
					}

				}
				list.add(chap);
			}

			workbook.close();
			inputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public List<Chap> getAllByBookId(int id) {
		List<Chap> list = new ArrayList<Chap>();
		// Get file
		InputStream inputStream;
		try {
			Resource resource = new ClassPathResource(SystemContain.URL_FILE_CHAP);

			inputStream = resource.getInputStream();
			Workbook workbook = new HSSFWorkbook(inputStream);
			// Get workbook

			// Get sheet
			Sheet sheet = workbook.getSheetAt(0);

			// Get all rows
			Iterator<Row> iterator = sheet.iterator();
			while (iterator.hasNext()) {
				Row nextRow = iterator.next();
				if (nextRow.getRowNum() == 0) {
					// Ignore header
					continue;
				}
				boolean stopAndNextRow = false;

				// Get all cells
				Iterator<Cell> cellIterator = nextRow.cellIterator();

				// Read cells and set value for book object
				Chap chap = new Chap();
				while (cellIterator.hasNext()) {
					if (stopAndNextRow)
						break;
					// Read cell
					Cell cell = cellIterator.next();
					Object cellValue = getCellValue(cell);
					if (cellValue == null || cellValue.toString().isEmpty()) {
						continue;
					}
					// Set value for book object
					int columnIndex = cell.getColumnIndex();
					switch (columnIndex) {
					case 0:
						double res = (Double) getCellValue(cell);
						if (id != (int) res) {
							stopAndNextRow = true;
							break;
						}
						chap.setIdBook((int) res);
						break;
					case 1:
						chap.setTitle((String) getCellValue(cell));
						break;
					case 2:
						chap.setAlias((String) getCellValue(cell));
						break;
					case 3:
						chap.setUrlChap((String) getCellValue(cell));
						break;
					case 4:
						 res = (Double) getCellValue(cell);
						chap.setId((int) res);
						break;
					default:
						break;
					}

				}
				if (!stopAndNextRow)
					list.add(chap);
			}

			workbook.close();
			inputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	// Get cell value
	private static Object getCellValue(Cell cell) {
		CellType cellType = cell.getCellTypeEnum();
		Object cellValue = null;
		switch (cellType) {
		case BOOLEAN:
			cellValue = cell.getBooleanCellValue();
			break;
		case FORMULA:
			Workbook workbook = cell.getSheet().getWorkbook();
			FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
			cellValue = evaluator.evaluate(cell).getNumberValue();
			break;
		case NUMERIC:
			cellValue = cell.getNumericCellValue();
			break;
		case STRING:
			cellValue = cell.getStringCellValue();
			break;
		case _NONE:
		case BLANK:
		case ERROR:
			break;
		default:
			break;
		}

		return cellValue;
	}

	public Chap getOneById(int id) {
		Chap model = null;
		// Get file
		InputStream inputStream;
		try {
			Resource resource = new ClassPathResource(SystemContain.URL_FILE_CHAP);

			inputStream = resource.getInputStream();
			Workbook workbook = new HSSFWorkbook(inputStream);
			// Get workbook

			// Get sheet
			Sheet sheet = workbook.getSheetAt(0);
			boolean isFind = false;
			// Get all rows
			Iterator<Row> iterator = sheet.iterator();
			while (iterator.hasNext()) {
				Row nextRow = iterator.next();
				if (nextRow.getRowNum() == 0) {
					// Ignore header
					continue;
				}
				if (isFind)
					break;
				boolean isStop = false;
				// Get all cells
				Iterator<Cell> cellIterator = nextRow.cellIterator();

				// Read cells and set value for book object
				Chap chap = new Chap();
				while (cellIterator.hasNext()) {
					if (isStop)
						break;
					// Read cell
					Cell cell = cellIterator.next();
					Object cellValue = getCellValue(cell);
					if (cellValue == null || cellValue.toString().isEmpty()) {
						continue;
					}
					// Set value for book object
					int columnIndex = cell.getColumnIndex();
					switch (columnIndex) {
					case 0:
						double res = (Double) getCellValue(cell);
						chap.setIdBook((int) res);
						break;
					case 1:
						chap.setTitle((String) getCellValue(cell));
						break;
					case 2:
						chap.setAlias((String) getCellValue(cell));
						break;
					case 3:
						chap.setUrlChap((String) getCellValue(cell));
						break;
					case 4:
						 res = (Double) getCellValue(cell);
						if (id != (int) res) {
							isStop = true;
							break;
						}
						chap.setId((int) res);
						isFind = true;
						break;
					default:
						break;
					}

				}

				if (!isStop)
					model = chap;
			}

			workbook.close();
			inputStream.close();
		} catch (FileNotFoundException e) {
			return null;
		} catch (IOException e) {
			return null;
		}

		return model;
	}
	
}
