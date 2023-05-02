package CombinationalPractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelWriteData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//Open the file in java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\vtigerExcel.xlsx");
		//Create an Workbook
		Workbook wb = WorkbookFactory.create(fis);
		//Get sheet control
		Sheet sh = wb.getSheet("Contacts");
		//Get row control
		Row rw = sh.createRow(9);
		//Get cell control
		Cell ce = rw.createCell(0);
		//Set cell value
		ce.setCellValue("Gvc");
		//Open the file in java writable format
		FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\vtigerExcel.xlsx");
		//Use write method
		wb.write(fos);
		//Confirmation with print statement
		System.out.println("Data Added");
		//close the workbook
		wb.close();
		

	}

}
