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

import com.spring.dao.IBookDAO;
import com.spring.model.Book;

import util.SystemContain;

@Repository
public class BookDAO implements IBookDAO {
	public List<Book> getAll() {
		List<Book> list = new ArrayList<Book>();
		// Get file
		InputStream inputStream;
		try {
			Resource resource = new ClassPathResource(SystemContain.URL_FILE_BOOK);

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
				Book book = new Book();
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
						book.setId((int) res);
						break;
					case 1:
						book.setTitle((String) getCellValue(cell));
						break;
					case 2:
						book.setUrlImg((String) getCellValue(cell));
						break;
					case 3:
						book.setActor((String) getCellValue(cell));
						break;
					case 4:
						res = (Double) getCellValue(cell);
						book.setNumPage((int) res);
						break;
					case 5:
						book.setReleaseDate((String) getCellValue(cell));
						break;
					default:
						break;
					}

				}
				list.add(book);
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

	public Book getOneById(int id) {
		Book model = null;
		// Get file
		InputStream inputStream;
		try {
			Resource resource = new ClassPathResource(SystemContain.URL_FILE_BOOK);

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
				Book book = new Book();
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
						if (id != (int) res) {
							isStop = true;
							break;
						}
						book.setId((int) res);
						isFind = true;
						break;
					case 1:
						book.setTitle((String) getCellValue(cell));
						break;
					case 2:
						book.setUrlImg((String) getCellValue(cell));
						break;
					case 3:
						book.setActor((String) getCellValue(cell));
						break;
					case 4:
						res = (Double) getCellValue(cell);
						book.setNumPage((int) res);
						break;
					case 5:
						book.setReleaseDate((String) getCellValue(cell));
						break;
					default:
						break;
					}

				}

				if (!isStop)
					model = book;
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

	// Get cell value
	private Object getCellValue(Cell cell) {
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

	public static void main(String[] args) {
		int arr[] = { -1,-2,-4,-5,-3,7,8};
		boolean res = false;
		for (int i = 0; i < arr.length - 4; i++) {
			int subarr[] = new int[5];
			subarr[0] = arr[i];
			subarr[1] = arr[i + 1];
			subarr[2] = arr[i + 2];
			subarr[3] = arr[i + 3];
			subarr[4] = arr[i + 4];
			boolean trung = false;
			for (int j = 0; j < subarr.length; j++) {
				for (int k = j + 1; k < subarr.length; k++) {
					if (subarr[j] == subarr[k]) {
						trung = true;
						break;
					}
				}
			}
			if (trung == false) {
				int min = subarr[0];
				int max = subarr[0];
				for (int j = 0; j < subarr.length; j++) {
					if(subarr[j] > max) max = subarr[j];
					if(subarr[j] < min) min = subarr[j];
				}
				int res1 = 0;
				for(int l = min; l < min + 5; l++) {
					res1 = res1 + l;
				}
				
				int res2 = 0;
				for(int l = min; l <= max; l++) {
					res2 = res2 + l;
				}
				if(res1 == res2) res = true;
				
			}
		}
		System.out.println(res);
	}

}
