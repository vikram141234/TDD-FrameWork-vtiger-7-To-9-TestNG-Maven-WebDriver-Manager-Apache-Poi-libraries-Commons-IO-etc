package vtigerScenariosPractice;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtigerGenericUtility.BaseClass;
import vtigerObjectRepository.ContactInfoPage;
import vtigerObjectRepository.ContactsPage;
import vtigerObjectRepository.CreateNewContactPage;
import vtigerObjectRepository.HomePage;
@Listeners(vtigerGenericUtility.ListnersImplementationClass.class)
public class CreateContactSaveVerifyTest extends BaseClass {

	    @Test
	    public void createContact() throws EncryptedDocumentException, IOException 
	    {
		
	    	String Contact= eUtility.readDataFromExcel("DataContacts", 1, 0);
	    	HomePage hPage=new HomePage(driver);
	    	hPage.clickOnContactLnk();
	    	
	        ContactsPage cPage=new ContactsPage(driver);
	        cPage.ClickOnCreateContactLookUpImg();
	        
	        CreateNewContactPage cncPage=new CreateNewContactPage(driver);
	        cncPage.createNewContact(Contact);
	    	
	        ContactInfoPage ciPage=new ContactInfoPage(driver);
	        String header=ciPage.getContactHeader();
	    	
	        Assert.assertTrue(header.contains(Contact));
		
	    }
	    @Test
	    public void createOrg() {
	    	HomePage hPage=new HomePage(driver);
	    	hPage.clickOnOrgLnk();
	    }


}
