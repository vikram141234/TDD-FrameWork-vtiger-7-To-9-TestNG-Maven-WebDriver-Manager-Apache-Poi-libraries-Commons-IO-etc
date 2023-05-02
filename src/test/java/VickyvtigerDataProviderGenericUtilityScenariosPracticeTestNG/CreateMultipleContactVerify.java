package VickyvtigerDataProviderGenericUtilityScenariosPracticeTestNG;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

//import java.time.Duration;

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
import vtigerGenericUtility.WebDriverUtility;
import vtigerObjectRepository.ContactInfoPage;
import vtigerObjectRepository.ContactsPage;
import vtigerObjectRepository.CreateNewContactPage;
import vtigerObjectRepository.HomePage;

public class CreateMultipleContactVerify extends BaseClass{

	@Test(dataProvider = "getData")
	public void createContactSaveVerify (String CONTACT)
	 {
		String CONTACTNAME=CONTACT+jUtility.getRandomNum();
		
		HomePage hPage=new HomePage(driver);
		hPage.clickOnContactLnk();
		
		ContactsPage cPage=new ContactsPage(driver);
		cPage.ClickOnCreateContactLookUpImg();
		
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createNewContact(CONTACTNAME);
		
		ContactInfoPage cif=new ContactInfoPage(driver);
		String header=cif.getContactHeader();
		
		Assert.assertTrue(header.contains(CONTACTNAME));
		
		
		
	}
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		return eUtility.readMultipleDataFromExcel("DataContacts");
	}

}
