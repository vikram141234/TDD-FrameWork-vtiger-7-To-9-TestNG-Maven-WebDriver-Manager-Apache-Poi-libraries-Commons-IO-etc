package vtiger.Practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import vtigerGenericUtility.BaseClass;
import vtigerObjectRepository.ContactInfoPage;
import vtigerObjectRepository.ContactsPage;
import vtigerObjectRepository.CreateNewContactPage;
import vtigerObjectRepository.CreateNewOrganizationPage;
import vtigerObjectRepository.HomePage;
import vtigerObjectRepository.OrganizationInfoPage;
import vtigerObjectRepository.OrganizationsPage;

public class CreateConWithOrg extends BaseClass{

	@Test
	public void createConWithOrg() throws EncryptedDocumentException, IOException {
		
		String ORGNAME=eUtility.readDataFromExcel("Contacts", 4, 3)+jUtility.getRandomNum();
    	String CONTACTNAME = eUtility.readDataFromExcel("Contacts", 4, 2);
    	
    	HomePage hPage=new HomePage(driver);
    	hPage.clickOnOrgLnk();
    	
    	OrganizationsPage orgPage=new OrganizationsPage(driver);
    	orgPage.clickOnCreateOrgLookUpImg();
    	
    	CreateNewOrganizationPage cnoPage=new CreateNewOrganizationPage(driver);
    	cnoPage.createNewOrg(ORGNAME);
    	
    	OrganizationInfoPage oiPage=new OrganizationInfoPage(driver);
    	String ORGHEADER=oiPage.getOrgHeader();
    	if(ORGHEADER.contains(ORGNAME))
    	{
    		System.out.println("Pass");
    	}
    	else 
    	{
    		System.out.println("Fail");
		}
    	
    	hPage.clickOnContactLnk();
    	
    	ContactsPage cPage=new ContactsPage(driver);
    	cPage.ClickOnCreateContactLookUpImg();
    	
    	CreateNewContactPage cncPage=new CreateNewContactPage(driver);
    	cncPage.createNewContact(driver, CONTACTNAME, ORGNAME);
    	
    	ContactInfoPage ciP=new ContactInfoPage(driver);
    	String header=ciP.getContactHeader();
    	if(header.contains(CONTACTNAME))
    	{
    		System.out.println("---Pass---");
    	}
    	else 
    	{
			System.out.println("---Fail---");
		}
    	
    	hPage.logOutOfApp(driver);

	}
}
