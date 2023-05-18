package CombinationalPractice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import vtigerGenericUtility.ExcelFileUtility;
import vtigerGenericUtility.JavaUtility;
import vtigerGenericUtility.PropertyFileUtility;

public class VickyPracticeGenericUtilities {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		ExcelFileUtility eutil=new ExcelFileUtility();
		eutil.writeDataIntoExcel("Contacts", 10, 1, "Nani");
		System.out.println("Data Added Successfully");
		
		String value=eutil.readDataFromExcel("Contacts", 10, 1);
		System.out.println(value);
		
		JavaUtility jutil=new JavaUtility();
		int Ran=jutil.getRandomNum();		
		System.out.println(Ran);
		
		String date=jutil.getSystemDate();
		System.out.println(date);
		
		String dateinformat=jutil.getSystemDateInFormat();
		System.out.println(dateinformat);
		
		PropertyFileUtility prop=new PropertyFileUtility();
		String value1=prop.readDataFromPropertyFile("url");
		System.out.println(value1);
		

	}

}
