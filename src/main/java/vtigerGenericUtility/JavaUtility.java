 package vtigerGenericUtility;

import java.util.Date;
import java.util.Random;

/**
 * This class contains java specific methods
 * @param args
 */
public class JavaUtility {
	    /**
	     * This method will generate random number for every run
	     * @return
	     */
		public int getRandomNum()
		{
			Random r=new Random();
			return r.nextInt();
		}
		/**
		 * This method will generate System date
		 * @return
		 */
		public String getSystemDate()
		{
		    Date d=new Date();
			return d.toString();
		}
		
		public String getSystemDateInFormat()
		{
			Date d=new Date();
			String dArr []=d.toString().split(" ");
			String day=dArr[2];
			String month=dArr[1];
			String year=dArr[5];
			String time=dArr[3].replaceAll(":","-");
			String date=day+"-"+month+"-"+year+"-"+time;
			return date;
			
		}

	

}
