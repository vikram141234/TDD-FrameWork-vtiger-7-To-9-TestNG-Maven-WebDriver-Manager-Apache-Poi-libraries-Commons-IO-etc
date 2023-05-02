package VickyVtigerGenericUtilitiesPratice;

import java.util.Date;
import java.util.Random;

/**
 * This class contains only java specific generic methods
 * @author vikra
 *
 */
public class JavaUtility {
	/**
	 * This method will generate random number after every run
	 * @return
	 */
	public int getRandomNumber() 
	{
		Random r=new Random();
		int num= r.nextInt(1000);
		return num;
	}
	/**
	 * This method will get the current systems date
	 * @return
	 */
	public String getSystemDate()
	{
		Date d=new Date();
		String date=d.toString();
		return date;
	}
	
	public String getSystemDateInFormat()
	{
		Date d=new Date();
		String[]dArr=d.toString().split(" ");
		String day=dArr[2];
		String month=dArr[1];
		String year=dArr[5];
		String time=dArr[3].replaceAll(":","-");
		String date=day+"-"+month+"-"+year+"-"+time;
		return date;
	}
	

}
