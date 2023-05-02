package VickyvtigerDataProviderGenericUtilityScenariosPracticeTestNG;

import java.awt.peer.LabelPeer;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import vtigerGenericUtility.BaseClass;
import vtigerObjectRepository.ContactInfoPage;
import vtigerObjectRepository.ContactsPage;
import vtigerObjectRepository.CreateNewContactPage;
import vtigerObjectRepository.HomePage;

public class CreateMultipleContacts extends BaseClass {
	
		@Test(dataProvider ="getData")
		public void createMultipleContacts(String CONTACT) throws IOException
		{
			
			String CONTACTNAME=CONTACT+jUtility.getRandomNum();
			
			
			
			HomePage hPage=new HomePage(driver);
			hPage.clickOnContactLnk();
			
			ContactsPage cPage=new ContactsPage(driver);
			cPage.ClickOnCreateContactLookUpImg();
			
			CreateNewContactPage cnPage=new CreateNewContactPage(driver);
			cnPage.createNewContact(CONTACTNAME);
			
			ContactInfoPage ciPage=new ContactInfoPage(driver);
			String Header=ciPage.getContactHeader();
			
			Assert.assertTrue(Header.contains(CONTACTNAME));
			
			
		}
		
		@DataProvider
		public Object[][] getData() throws EncryptedDocumentException, IOException
		{
			return eUtility.readMultipleDataFromExcel("DataContacts");
		}


}
