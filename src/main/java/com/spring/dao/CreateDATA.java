package com.spring.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.spring.dao.imp.ChapDAO;
import com.spring.model.Book;
import com.spring.model.Chap;
import com.spring.model.Page;

import util.SystemContain;

public class CreateDATA {
	
	public List<Book> getAllBookFromTo(int from, int to){
		List<Book> list = new ArrayList<Book>();
		
		for(int i = from; i < to + 1; i++) {
			Document document = null;
			String img = null;
			String title = null;
			String actor = null;
			int numPage = 0;
			String releaseDate = null;
			try {
				document = Jsoup.connect("https://nxbkimdong.com.vn/tham-tu-lung-danh-conan-tap-" + i + "-0").get();
				
			} catch (IOException e) {
				try {
					document = Jsoup.connect("https://nxbkimdong.com.vn/tham-tu-lung-danh-conan-tap-" + i).get();
				} catch (IOException e1) {
					document = null;
				}
			}
			if(document != null) {
				// get Image
				Elements div = null;
				Elements subDiv = null;
				
				 div = document.getElementsByClass("main-product-image");
				 subDiv = div.get(0).getElementsByClass("img-responsive");
				 img = subDiv.get(0).absUrl("data-src");
				
				// get Title
				 div = document.getElementsByClass("field-name-field-product-tensach");
				 subDiv = div.get(0).getElementsByClass("field-item even");
				 title = subDiv.get(0).html();
				
				//get Actor
				 div = document.getElementsByClass("field-name-field-product-tacgia");
				 subDiv = div.get(0).getElementsByTag("a");
				 actor = subDiv.get(0).html();
				
				// get num page
				 try {
					 div = document.getElementsByClass("field-name-field-product-sotrang");
					 subDiv = div.get(0).getElementsByClass("field-item");
					 numPage = Integer.parseInt(subDiv.get(0).html());
				} catch (Exception e) {
					numPage = 0;
				}
				 
				
				// get relase date
				 div = document.getElementsByClass("field-name-field-product-phathanh");
				 subDiv = div.get(0).getElementsByClass("date-display-single");
				 releaseDate = subDiv.get(0).html();
				 
				 
				 list.add(new Book(i, title, img, actor, numPage, releaseDate));
			}
			
		}
		return list;
	}
	
	public List<Book> getAllBook(){
		List<Book> list = new ArrayList<Book>();
		int i = 1;
		while(true) {
			Document document = null;
			String img = null;
			String title = null;
			String actor = null;
			int numPage = 0;
			String releaseDate = null;
			try {
				document = Jsoup.connect("https://nxbkimdong.com.vn/tham-tu-lung-danh-conan-tap-" + i + "-0").get();
				
			} catch (IOException e) {
				try {
					document = Jsoup.connect("https://nxbkimdong.com.vn/tham-tu-lung-danh-conan-tap-" + i).get();
				} catch (IOException e1) {
					break;
				}
			}
			if(document != null) {
				// get Image
				Elements div = null;
				Elements subDiv = null;
				
				 div = document.getElementsByClass("main-product-image");
				 subDiv = div.get(0).getElementsByClass("img-responsive");
				 img = subDiv.get(0).absUrl("data-src");
				
				// get Title
				 div = document.getElementsByClass("field-name-field-product-tensach");
				 subDiv = div.get(0).getElementsByClass("field-item even");
				 title = subDiv.get(0).html();
				
				//get Actor
				 div = document.getElementsByClass("field-name-field-product-tacgia");
				 subDiv = div.get(0).getElementsByTag("a");
				 actor = subDiv.get(0).html();
				
				// get num page
				
				 try {
					 div = document.getElementsByClass("field-name-field-product-sotrang");
					 subDiv = div.get(0).getElementsByClass("field-item");
					 numPage = Integer.parseInt(subDiv.get(0).html());
				} catch (Exception e) {
					numPage = 0;
				}
				 
				
				
				// get relase date
				 div = document.getElementsByClass("field-name-field-product-phathanh");
				 subDiv = div.get(0).getElementsByClass("date-display-single");
				 releaseDate = subDiv.get(0).html();
				 
				 
				 list.add(new Book(i, title, img, actor, numPage, releaseDate));
			}
			System.out.println(i);
			i++;
		}
		return list;
	}
	
	public static List<Chap> getAllChap(){
		List<Chap> list = new ArrayList<Chap>();
		Document document;
		try {
			document = Jsoup.connect("https://truyenonline.info/conan").get();
			Elements div = document.getElementsByClass("pgntn-page-pagination-intro");
			int max = Integer.parseInt(div.get(0).html().split(" of ")[1]);
			
			div = document.getElementsByClass("post-wrapper");
			Elements tagA = null;
			int idBook = 1;
			int id = 1;
			int nextBook = 0;
			for(Element d : div) {
				tagA = d.getElementsByTag("a");
				String title = tagA.get(0).html().replace("Tập", "Chap");
				Chap chap = new Chap(id, idBook, title, title.split(":")[0].replace("Chap ", "chap-"), tagA.get(0).absUrl("href"));
				list.add(chap);
				id++;
				nextBook++;
				if(nextBook == 10) {
					nextBook = 0;
					idBook++;
				}
			}
			
			for(int i = 2; i < max + 1; i++) {
				document = Jsoup.connect("https://truyenonline.info/conan/page/" + i).get();
				div = document.getElementsByClass("post-wrapper");
				
				for(Element d : div) {
					tagA = d.getElementsByTag("a");String title = tagA.get(0).html().replace("Tập", "Chap");
					Chap chap = new Chap(id, idBook, title, title.split(":")[0].replace("Chap ", "chap-"), tagA.get(0).absUrl("href"));
					list.add(chap);
					id++;
					nextBook++;
					if(nextBook == 10) {
						nextBook = 0;
						idBook++;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static List<Page> getAllPage(){
		List<Page> list = new ArrayList<Page>();
		
		ChapDAO dao = new ChapDAO();
		List<Chap>  listChap = dao.getAll();
		double percent = (double) listChap.size() / 100;
		int nowPercent = 0;
		for(int i = 0; i < listChap.size(); i++) {
			Document document;
			try {
				document = Jsoup.connect(listChap.get(i).getUrlChap()).get();
				Elements div = document.getElementsByClass("truyen-tranh");
				
				
				for(Element d : div) {
					Page page = new Page(listChap.get(i).getId(), d.absUrl("src"));
					list.add(page);
				}
				
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			int check = i + 1;
			if( check >= (nowPercent + 1) * percent) {
				nowPercent = (int) (check / percent);
				System.out.println(nowPercent + " %");
			}
			
		}
		
		
		return list;
	}
	
	
	private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }
	
	public  static void downloadChapToExcel() {
		HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Chap sheet");
        List<Chap> list = getAllChap();
 
        int rownum = 0;
        Cell cell;
        Row row;
        //
        HSSFCellStyle style = createStyleForTitle(workbook);
 
        row = sheet.createRow(rownum);
 
        // ID book
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Id Book");
        cell.setCellStyle(style);
        // Title
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Title");
        cell.setCellStyle(style);
        // Alias
        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Alias");
        cell.setCellStyle(style);
        // URL CHap
        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Url chap");
        cell.setCellStyle(style);
        
        // URL CHap
        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("Id");
        cell.setCellStyle(style);
 
        // Data
        for (Chap model : list) {
            rownum++;
            row = sheet.createRow(rownum);
 
            // EmpNo (A)
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue(model.getIdBook());
            // EmpName (B)
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(model.getTitle());
            // Salary (C)
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue(model.getAlias());
            // Grade (D)
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue(model.getUrlChap());
            // Grade (E)
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue(model.getId());
        }
        Resource resource = new ClassPathResource(SystemContain.URL_FILE_CHAP);
        File file = null;
		try {
			file = resource.getFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        file.getParentFile().mkdirs();
 
        FileOutputStream outFile;
		try {
			outFile = new FileOutputStream(file);
			workbook.write(outFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println("Created file: " + file.getAbsolutePath());
	}
	
	public  static void downloadPageToExcel() {
		HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Page sheet");
        List<Page> list = getAllPage();
 
        int rownum = 0;
        Cell cell;
        Row row;
        //
        HSSFCellStyle style = createStyleForTitle(workbook);
 
        row = sheet.createRow(rownum);
 
        // ID chap
        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("Id Chap");
        cell.setCellStyle(style);
        
        // URL page
        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Url image");
        cell.setCellStyle(style);
 
        // Data
        for (Page model : list) {
            rownum++;
            row = sheet.createRow(rownum);
 
            // EmpNo (A)
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue(model.getIdChap());
            // EmpName (B)
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(model.getUrlImg());
        }
        Resource resource = new ClassPathResource(SystemContain.URL_FILE_BOOK);
        File file = null;
		try {
			file = new File(resource.getFile().getParentFile() + "/" + SystemContain.URL_FILE_PAGE);
			if(!file.exists()) file.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
 
        FileOutputStream outFile;
		try {
			outFile = new FileOutputStream(file);
			workbook.write(outFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println("Created file: " + file.getAbsolutePath());
	}
	
	public static void main(String[] args) throws IOException {
		
		
		//downloadChapToExcel();
//		ChapDAO cha = new ChapDAO();
//		System.out.println(cha.getAll().get(5).getTitle());
//		
//		BookDAO bok = new BookDAO();
//		System.out.println(bok.getAll().get(5).getTitle());
		downloadPageToExcel();
	}
}
