package CombinationalPractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\vtigerExcel.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet("Contacts").getRow(9).getCell(1).getStringCellValue();
//		Sheet sh = wb.getSheet("Contacts");
//		Row rw = sh.getRow(9);
//		Cell ce = rw.getCell(1);
//		String value=ce.getStringCellValue();
		System.out.println(value);
	}

}
