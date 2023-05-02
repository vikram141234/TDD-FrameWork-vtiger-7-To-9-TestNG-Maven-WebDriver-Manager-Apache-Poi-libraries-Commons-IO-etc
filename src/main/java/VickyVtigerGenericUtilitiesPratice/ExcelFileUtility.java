package VickyVtigerGenericUtilitiesPratice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import vtigerGenericUtility.ConstantsUtility;

/**
 * This class consists of excel related generic methods
 * @author vikra
 *
 */
public class ExcelFileUtility {
	
	/**
	 * This method will read data from excel
	 * @param SheetName
	 * @param RowNo
	 * @param CellNo
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public void readDataFromExcel(String SheetName,int RowNo,int CellNo) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(ConstantsUtility.excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row rw = sh.getRow(RowNo);
		Cell ce = rw.getCell(CellNo);
		String value=ce.getStringCellValue();
		wb.close();
		System.out.println(value);
	}
	
	/**
	 * This method will write data into excel
	 * @param SheetName
	 * @param RowNum
	 * @param CellNo
	 * @param Value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public void writeDataIntoExcel(String SheetName,int RowNum,int CellNo,String Value) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis=new FileInputStream(ConstantsUtility.excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row rw = sh.getRow(RowNum);
		Cell ce = rw.getCell(CellNo);
		ce.setCellValue(Value);
		
		FileOutputStream fos=new FileOutputStream(ConstantsUtility.excelfilepath);
		wb.write(fos);
		wb.close();
		
	}
	
	public Object[][] readMultipleDataFromExcel(String SheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(ConstantsUtility.excelfilepath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell=sh.getRow(0).getLastCellNum();
		Object data[][]=new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
		

		
	}
	
}
