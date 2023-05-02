package vtiger.Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vtigerGenericUtility.BaseClass;
import vtigerObjectRepository.ContactInfoPage;
import vtigerObjectRepository.ContactsPage;
import vtigerObjectRepository.CreateNewContactPage;
import vtigerObjectRepository.HomePage;

@Listeners(vtigerGenericUtility.ListnersImplementationClass.class)
public class CreateContactVerifyParallelAndListeners extends BaseClass{

	@Test
	public void createContact() throws EncryptedDocumentException, IOException
	{
		String CONTACTNAME = eUtility.readDataFromExcel("Contacts", 1, 2);
		
		HomePage hPage=new HomePage(driver);
		hPage.clickOnContactLnk();
		
		ContactsPage cPage=new ContactsPage(driver);
		cPage.ClickOnCreateContactLookUpImg();
		
	 Assert.fail();
		CreateNewContactPage cnPage=new CreateNewContactPage(driver);
		cnPage.createNewContact(CONTACTNAME);
	
	 //   Assert.fail();
		ContactInfoPage ciPage=new ContactInfoPage(driver);
		String Header = ciPage.getContactHeader();
		
		if(Header.contains(CONTACTNAME))
		{
		//	Assert.fail();
			System.out.println("---Pass---");
		}
		else 
		{
			System.out.println("---Fail---");
		}
		
		hPage.logOutOfApp(driver);
	}
}
