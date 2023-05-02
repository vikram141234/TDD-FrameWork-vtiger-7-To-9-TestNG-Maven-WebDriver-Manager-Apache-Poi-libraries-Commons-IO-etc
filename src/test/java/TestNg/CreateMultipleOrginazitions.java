package TestNg;



import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vtigerGenericUtility.BaseClass;
import vtigerGenericUtility.ExcelFileUtility;
import vtigerGenericUtility.JavaUtility;
import vtigerGenericUtility.PropertyFileUtility;
import vtigerGenericUtility.WebDriverUtility;
import vtigerObjectRepository.CreateNewOrganizationPage;
import vtigerObjectRepository.HomePage;
import vtigerObjectRepository.LoginPage;
import vtigerObjectRepository.OrganizationInfoPage;
import vtigerObjectRepository.OrganizationsPage;

public class CreateMultipleOrginazitions extends BaseClass {

	
	
	@Test(dataProvider = "getData")
	public void createMultipleOrgs(String ORG) throws IOException
	{
		
		String ORGNAME=ORG+jUtility.getRandomNum();
		
		HomePage hPage=new HomePage(driver);
		hPage.clickOnOrgLnk();
		
		OrganizationsPage oPage=new OrganizationsPage(driver);
		oPage.clickOnCreateOrgLookUpImg();
		
		CreateNewOrganizationPage cnoPage=new CreateNewOrganizationPage(driver);
		cnoPage.createNewOrg(ORGNAME);
		
		OrganizationInfoPage oiPage=new OrganizationInfoPage(driver);
		String Header=oiPage.getOrgHeader();
		
		Assert.assertTrue(Header.contains(ORGNAME));
			
	}
	
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
	   return eUtility.readMultipleDataFromExcel("DataOrgs");
	}
	
}
