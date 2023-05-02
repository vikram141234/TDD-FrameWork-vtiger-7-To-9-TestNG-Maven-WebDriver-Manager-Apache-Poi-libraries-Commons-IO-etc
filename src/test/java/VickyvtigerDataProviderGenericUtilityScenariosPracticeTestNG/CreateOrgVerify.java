package VickyvtigerDataProviderGenericUtilityScenariosPracticeTestNG;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import javax.sound.sampled.TargetDataLine;

import org.apache.poi.EncryptedDocumentException;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import vtigerGenericUtility.BaseClass;
import vtigerObjectRepository.ContactInfoPage;
import vtigerObjectRepository.CreateNewOrganizationPage;
import vtigerObjectRepository.HomePage;
import vtigerObjectRepository.OrganizationInfoPage;
import vtigerObjectRepository.OrganizationsPage;

public class CreateOrgVerify extends BaseClass {

		@Test(dataProvider = "Gvc")
		public void createMultipleOrgs(String ORGNAME) throws EncryptedDocumentException, IOException {
			
			String OORGNAME=ORGNAME+jUtility.getRandomNum();
		
			HomePage hPage=new HomePage(driver);
			hPage.clickOnOrgLnk();
			
			OrganizationsPage oPage=new OrganizationsPage(driver);
			oPage.clickOnCreateOrgLookUpImg();
			
			CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
			cnop.createNewOrg(OORGNAME);
			
			ContactInfoPage ciPage=new ContactInfoPage(driver);
			String header=ciPage.getContactHeader();
			
			Assert.assertTrue(header.contains(OORGNAME));
		
	}
		@DataProvider(name="Gvc")
		public Object[][] getData() throws EncryptedDocumentException, IOException
		{
			return eUtility.readMultipleDataFromExcel("DataOrgs");
		}
				
}
