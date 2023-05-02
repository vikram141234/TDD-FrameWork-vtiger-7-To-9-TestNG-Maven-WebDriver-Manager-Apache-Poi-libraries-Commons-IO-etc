package TestNg;

import org.apache.commons.codec.language.bm.Rule.Phoneme;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExampleProgram {

	@Test(dataProvider = "getData")
	public void sampleDataProviderTest(String phonename,String brand,int price)
	{
		System.out.println(phonename+"--->"+brand+"--->"+price);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] dataObjects=new Object[3][3];
		
		dataObjects[0][0]="Iphone";
		dataObjects[0][1]="14 pro";
		dataObjects[0][2]=150000;
		
		dataObjects[1][0]="Samsung";
		dataObjects[1][1]="M 11";
		dataObjects[1][2]=12000;
		
		dataObjects[2][0]="1+";
		dataObjects[2][1]="Nord ce 3";
		dataObjects[2][2]=25000;
		
		return dataObjects;
	}
}
