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

import com.spring.dao.IPageDAO;
import com.spring.model.Page;

import util.SystemContain;

@Repository
public class PageDAO implements IPageDAO{

	public List<Page> getAllByChapId(int id) {
		List<Page> list = new ArrayList<Page>();
		// Get file
		InputStream inputStream;
		try {
			Resource resource = new ClassPathResource(SystemContain.URL_FILE_PAGE);

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
				Page model = new Page();
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
						model.setIdChap((int) res);
						break;
					case 1:
						model.setUrlImg((String) getCellValue(cell));
						break;
					default:
						break;
					}

				}
				if (!stopAndNextRow)
					list.add(model);
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

}
