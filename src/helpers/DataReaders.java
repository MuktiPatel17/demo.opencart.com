package helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import au.com.bytecode.opencsv.CSVReader;

public class DataReaders {
	public static Object[][] excelReader(String filePath, String fileName, String sheetName) throws IOException {
		Object[][] data = null;
		FileInputStream inStream = new FileInputStream(new File(filePath + "/" + fileName));
		XSSFWorkbook workBook = new XSSFWorkbook(inStream);
		Sheet sheet = workBook.getSheet(sheetName);
		data = new Object[sheet.getLastRowNum()][];

		Object[] rowArray;
		for (int r = 1; r <= sheet.getLastRowNum(); r++) {
			Row row = sheet.getRow(r);
			rowArray = new Object[row.getLastCellNum()];
			for (int c = 0; c < row.getLastCellNum(); c++) {
				rowArray[c] = row.getCell(c);
			}
			data[r - 1] = rowArray;
		}
		workBook.close();
		return data;
	}

	public static String[][] csvReader(String filePath, String fileName) throws IOException {
		String[][] data = null;
		FileReader inStream = new FileReader(new File(filePath + "/" + fileName));
		CSVReader reader = new CSVReader(inStream);
		List<String[]> fileData = reader.readAll();

		data = new String[fileData.size() - 1][];
		for (int r = 1; r < fileData.size(); r++) {
			data[r - 1] = fileData.get(r);
		}
		reader.close();
		return data;
	}

	public static Document xmlReader(String filePath, String fileName) throws FileNotFoundException, DocumentException {
		FileInputStream in = new FileInputStream(new File(filePath + "/" + fileName));
		SAXReader obj = new SAXReader();
		return obj.read(in);
	}

	public static String propertyReader(String filePath, String fileName, String propName) {
		Properties obj = new Properties();
		FileInputStream inStream;
		try {
			inStream = new FileInputStream(new File(filePath + "/" + fileName));
			obj.load(inStream);
		} catch (IOException e) {
			e.getMessage();
		}
		return obj.getProperty(propName);
	}

	public static String projectProperty(String propName) {
		String filePath = ".";
		String fileName = "project.properties";
		return propertyReader(filePath, fileName, propName);
	}

	public static void propertyWriter(String filePath, String fileName, String propName, String propValue) {

		Properties prop = new Properties();
		OutputStream output = null;
		try {

			output = new FileOutputStream(filePath + "/" + fileName);

			// set the properties value
			prop.setProperty(propName, propValue);
			// save properties to project root folder
			prop.store(output, null);

		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void projectProperty(String propName, String propValue) {
		String filePath = ".";
		String fileName = "project.properties";
		propertyWriter(filePath, fileName, propName, propValue);
	}
}
