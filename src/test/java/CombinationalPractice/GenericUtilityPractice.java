package CombinationalPractice;

import java.io.IOException;

import vtigerGenericUtility.ExcelFileUtility;
import vtigerGenericUtility.JavaUtility;
import vtigerGenericUtility.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws IOException {
		JavaUtility jutil=new JavaUtility();
		
		int value = jutil.getRandomNum();
		System.out.println(value);
		
		String date = jutil.getSystemDate();
		System.out.println(date);
		
		String dateinformat = jutil.getSystemDateInFormat();
		System.out.println(dateinformat);
		
		PropertyFileUtility putil=new PropertyFileUtility();
		String value1=putil.readDataFromPropertyFile("url");
		System.out.println(value1);
		
		ExcelFileUtility eutil=new ExcelFileUtility();
		String data = eutil.readDataFromExcel("Organization", 1, 1);
		System.out.println(data);
		
		eutil.writeDataIntoExcel("Contacts", 10,0 , "Gvc");
		System.out.println("Data is Added");

	}

}
